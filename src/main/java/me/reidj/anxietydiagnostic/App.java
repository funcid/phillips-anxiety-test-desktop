package me.reidj.anxietydiagnostic;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import me.reidj.anxietydiagnostic.controller.PrimaryStage;
import me.reidj.anxietydiagnostic.controller.authorization.AuthorizationController;
import me.reidj.anxietydiagnostic.controller.question.QuestionController;
import me.reidj.anxietydiagnostic.controller.result.ResultController;
import me.reidj.anxietydiagnostic.user.User;

@Getter
public class App extends Application {

    @Getter
    private static App app;

    @Getter
    @Setter
    private User user;

    private PrimaryStage primaryStage;
    private AuthorizationController authorizationController;
    private QuestionController questionController;
    private ResultController resultController;

    @Override
    public void start(Stage stage) {
        app = this;

        primaryStage = new PrimaryStage(stage);
        authorizationController = new AuthorizationController();
        questionController = new QuestionController();
        resultController = new ResultController();

        primaryStage.setScene(authorizationController.getScene());
    }

    public static void main(String[] args) {
        launch();
    }
}