package me.func.anxietydiagnostic.controller.result;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import me.func.anxietydiagnostic.controller.AbstractScene;
import me.func.anxietydiagnostic.exception.Errors;
import me.func.anxietydiagnostic.App;
import me.func.anxietydiagnostic.factor.Factors;
import me.func.anxietydiagnostic.user.User;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultController extends AbstractScene {

    @FXML
    private Label resultLabel;
    @FXML
    private TextField teacherEmailTextField;

    private final DirectoryChooser directoryChooser = new DirectoryChooser();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

    public ResultController() {
        super("result/resultScene.fxml");
    }

    private final int[] sums = new int[Factors.values().length];

    @FXML
    private void initialize() {
        for (Factors factor : Factors.values()) {
            factor.getIndexes().forEach(index -> acceptFactor(factor, index));
        }
    }

    @FXML
    void sendEmail() {
        String teacherEmailText = teacherEmailTextField.getText();

        if (Errors.FIELD_EMPTY.check(teacherEmailText))
            return;

        User user = App.getApp().getUser();

        App.getApp().getMailSenderService().send(
                teacherEmailText,
                "Результат прохождения теста",
                getText(resultLabel.getText(), user)
        );

        App.getApp().getPrimaryStage().showAlert(
                Alert.AlertType.CONFIRMATION,
                "Сообщение успешно доставлено",
                "Успешно!"
        );
    }

    private static String getText(String resultText, User user) {
        return Errors.FIELD_EMPTY.check(resultText) ? "Факторов выявлено не было." : "Выявлен фактор: " + resultText + "\n" +
                "Класс: " + user.getSurname() + "\n" +
                "Ученик: " + user.getName() + " " + user.getSurname() + " " + user.getPatronymic() + "\n" +
                "Время прохождения: " + App.getApp().getQuestionController().formatTime();
    }

    @FXML
    void saveResult() {
        String resultText = resultLabel.getText();
        User user = App.getApp().getUser();

        createWordDocument();

        onWrite(new StringBuilder("Результат прохождения теста\n" + getText(resultText, user)));

        App.getApp().getPrimaryStage().showAlert(
                Alert.AlertType.CONFIRMATION,
                "Файл успешно сохранён",
                "Успешно!"
        );
    }

    private void acceptFactor(Factors factor, int index) {
        App.getApp().getUser().getQuestions().forEach((question, s) -> {
            if (index == question.index && !question.answer.equals(s)) {
                sums[factor.ordinal()]++;
                if (sums[factor.ordinal()] == factor.getSum()) {
                    resultLabel.setText(factor.getTitle());
                }
            }
        });
    }

    public void createWordDocument() {
        File selectedDirectory = directoryChooser.showDialog(App.getApp().getPrimaryStage().stage());
        User user = App.getApp().getUser();
        try {
            App.getApp().getFileManager().createFileByPath(
                    selectedDirectory.getAbsolutePath() + File.separator
                            + dateTimeFormatter.format(LocalDateTime.now()) + "_"
                            + user.getName() + "_" + user.getSurname() + ".txt"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onWrite(StringBuilder stringBuilder) {
        App.getApp().getFileManager().onWrite(stringBuilder.toString().getBytes());
    }
}
