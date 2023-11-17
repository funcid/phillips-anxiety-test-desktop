package me.reidj.anxietydiagnostic.controller.question;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import me.reidj.anxietydiagnostic.App;
import me.reidj.anxietydiagnostic.controller.AbstractScene;
import me.reidj.anxietydiagnostic.question.Question;
import me.reidj.anxietydiagnostic.question.QuestionList;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class QuestionController extends AbstractScene {

    private static final String JSON_FILE_PATH = "/questions.json";

    @FXML
    private Label questionLabel;
    private Iterator<Question> questionIterator;
    private final Gson gson = new Gson();

    public QuestionController() {
        super("questions/questionsScene.fxml");
    }

    @FXML
    private void initialize() {
        QuestionList questions = loadQuestionsFromJson();

        if (questions != null)
            questionIterator = questions.questions.iterator();

        displayNextQuestion();
    }

    private Question displayNextQuestion() {
        if (questionIterator.hasNext()) {
            Question currentQuestion = questionIterator.next();

            questionLabel.setText("#" + currentQuestion.index + ". " + currentQuestion.text);

            return currentQuestion;
        } else {
            App.getApp().getPrimaryStage().showScene(App.getApp().getResultController().getScene());
        }
        return null;
    }

    @FXML
    void onNoHandler() {
        extracted("Нет");
    }

    @FXML
    void onYesHandler() {
        extracted("Да");
    }

    private void extracted(String answer) {
        questionLabel.setText("");
        App.getApp()
                .getUser()
                .questions()
                .put(displayNextQuestion(), answer);
    }

    private QuestionList loadQuestionsFromJson() {
        try (InputStream inputStream = getClass().getResourceAsStream(JSON_FILE_PATH);
             InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, QuestionList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
