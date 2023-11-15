package me.reidj.anxietydiagnostic.controller;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public record PrimaryStage(Stage stage) {

    public void setScene(Scene scene) {
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setOnHidden(event -> Platform.exit());
        stage.sizeToScene();
        stage.setTitle("Диагностика Уровня Тревожности");
        stage.setResizable(false);
        show();
    }

    public void showScene(Scene scene) {
        stage.setScene(scene);
        show();
    }

    public void show() {
        stage.show();
    }
}
