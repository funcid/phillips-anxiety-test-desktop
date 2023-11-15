package me.reidj.anxietydiagnostic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;

@Getter
public class App extends Application {

    @Getter
    private static App app;

    @Override
    public void start(Stage stage) throws IOException {
        app = this;

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/authorization/authorizationScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}