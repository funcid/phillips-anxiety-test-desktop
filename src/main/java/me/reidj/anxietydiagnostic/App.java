package me.reidj.anxietydiagnostic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import me.reidj.anxietydiagnostic.controller.PrimaryStage;
import me.reidj.anxietydiagnostic.controller.authorization.AuthorizationController;
import me.reidj.anxietydiagnostic.controller.question.QuestionController;
import me.reidj.anxietydiagnostic.user.User;

import java.io.IOException;

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

    @Override
    public void start(Stage stage) {
        app = this;

        primaryStage = new PrimaryStage(stage);
        authorizationController = new AuthorizationController();
        questionController = new QuestionController();

        primaryStage.setScene(authorizationController.getScene());
    }

    public static void main(String[] args) {
        launch();
    }
}