package me.reidj.anxietydiagnostic.controller.result;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import me.reidj.anxietydiagnostic.App;
import me.reidj.anxietydiagnostic.controller.AbstractScene;
import me.reidj.anxietydiagnostic.exception.Errors;
import me.reidj.anxietydiagnostic.factor.Factors;
import me.reidj.anxietydiagnostic.user.User;

public class ResultController extends AbstractScene {

    @FXML
    private Label resultLabel;

    @FXML
    private TextField teachetEmailTextField;

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
        String resultText = resultLabel.getText();

        if (Errors.FIELD_EMPTY.check(resultText))
            return;

        User user = App.getApp().getUser();

        App.getApp().getMailSenderService().send(
                teachetEmailTextField.getText(),
                "Результат прохождения теста",
                (Errors.FIELD_EMPTY.check(resultText) ? "Факторов выявлено не было." : "Выявлен фактор: " + resultText + "\n" +
                        "Класс: " + user.getSurname() + "\n" +
                        "Ученик: " + user.getName() + " " + user.getSurname() + " " + user.getPatronymic() + "\n" +
                        "Время прохождения: " + App.getApp().getQuestionController().formatTime())
        );

        App.getApp().getPrimaryStage().showAlert(
                Alert.AlertType.CONFIRMATION,
                "Сообщение успешно доставлено",
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
}
