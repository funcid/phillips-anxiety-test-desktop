package me.reidj.anxietydiagnostic;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import me.reidj.anxietydiagnostic.controller.PrimaryStage;
import me.reidj.anxietydiagnostic.controller.authorization.AuthorizationController;
import me.reidj.anxietydiagnostic.controller.question.QuestionController;
import me.reidj.anxietydiagnostic.controller.result.ResultController;
import me.reidj.anxietydiagnostic.manager.FileManager;
import me.reidj.anxietydiagnostic.service.MailSenderService;
import me.reidj.anxietydiagnostic.user.User;

@Getter
public class App extends Application {

    @Getter
    private static App app;

    @Setter
    private User user;

    private PrimaryStage primaryStage;
    private AuthorizationController authorizationController;
    private QuestionController questionController;
    private ResultController resultController;
    private MailSenderService mailSenderService;
    private FileManager fileManager;

    @Override
    public void start(Stage stage) {
        app = this;

        primaryStage = new PrimaryStage(stage);
        authorizationController = new AuthorizationController();
        questionController = new QuestionController();
        resultController = new ResultController();
        mailSenderService = new MailSenderService();
        fileManager = new FileManager();

        primaryStage.setScene(authorizationController.getScene());
    }

    public static void main(String[] args) {
        launch();
    }
}