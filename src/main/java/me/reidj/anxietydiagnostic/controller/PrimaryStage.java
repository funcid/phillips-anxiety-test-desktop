package me.reidj.anxietydiagnostic.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public record PrimaryStage(Stage stage) {

    public void setScene(Scene scene) {
        showScene(scene);
        stage.setOnHidden(event -> Platform.exit());
        stage.sizeToScene();
        stage.setTitle("Диагностика Уровня Тревожности");
        stage.setResizable(false);
    }

    public void showScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public void showAlert(Alert.AlertType alertType, String contextText, String headerText) {
        Alert alert = new Alert(alertType, contextText);
        alert.setTitle(alertType == Alert.AlertType.ERROR ? "Ошибка!" : "Успешно!");
        alert.setHeaderText(headerText);
        alert.show();
    }
}
