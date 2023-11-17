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
import java.util.List;

public class QuestionController extends AbstractScene {

    private static final String JSON_FILE_PATH = "/questions.json";

    @FXML
    private Label questionLabel;
    private Iterator<Question> questionIterator;

    public QuestionController() {
        super("questions/questionsScene.fxml");
    }

    @FXML
    private void initialize() {
        List<Question> questions = loadQuestionsFromJson();

        if (questions != null)
            questionIterator = questions.iterator();

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
        questionLabel.setText("");

        // Отображение следующего вопроса
        Question currentQuestion = displayNextQuestion();

        App.getApp().getUser().questions().put(currentQuestion, "Нет");
    }

    @FXML
    void onYesHandler() {
        questionLabel.setText("");

        // Отображение следующего вопроса
        Question currentQuestion = displayNextQuestion();

        App.getApp().getUser().questions().put(currentQuestion, "Да");
    }

    private List<Question> loadQuestionsFromJson() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(JSON_FILE_PATH);
            InputStreamReader reader = null;

            if (inputStream != null) reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            Gson gson = new Gson();

            QuestionList questionList = null;

            if (reader != null) questionList = gson.fromJson(reader, QuestionList.class);

            if (questionList != null) return questionList.questions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
