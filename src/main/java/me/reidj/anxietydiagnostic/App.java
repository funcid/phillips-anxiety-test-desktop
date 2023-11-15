package me.reidj.anxietydiagnostic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import me.reidj.anxietydiagnostic.controller.PrimaryStage;
import me.reidj.anxietydiagnostic.controller.authorization.AuthorizationController;
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

    @Override
    public void start(Stage stage) throws IOException {
        app = this;

        primaryStage = new PrimaryStage(stage);
        authorizationController = new AuthorizationController();

        primaryStage.setScene(authorizationController.getScene());
    }

    public static void main(String[] args) {
        launch();
    }
}