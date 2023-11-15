package me.reidj.anxietydiagnostic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import me.reidj.anxietydiagnostic.controller.PrimaryStage;
import me.reidj.anxietydiagnostic.controller.authorization.AuthorizationController;

import java.io.IOException;

@Getter
public class App extends Application {

    @Getter
    private static App app;

    private PrimaryStage primaryStage;
    private AuthorizationController authorizationController;

    @Override
    public void start(Stage stage) throws IOException {
        app = this;

        primaryStage = new PrimaryStage(stage);
        authorizationController = new AuthorizationController();

//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/authorization/authorizationScene.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        primaryStage.setScene(authorizationController.getScene());
    }

    public static void main(String[] args) {
        launch();
    }
}