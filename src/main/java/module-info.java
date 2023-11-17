module me.reidj.anxietydiagnostic {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.google.gson;
    requires java.mail;
    requires static activation;

    opens me.reidj.anxietydiagnostic to javafx.fxml;
    opens me.reidj.anxietydiagnostic.controller.authorization to javafx.fxml;
    opens me.reidj.anxietydiagnostic.controller.question to javafx.fxml;
    opens me.reidj.anxietydiagnostic.controller.result to javafx.fxml;
    opens me.reidj.anxietydiagnostic.controller to javafx.fxml;
    opens me.reidj.anxietydiagnostic.question to com.google.gson;

    exports me.reidj.anxietydiagnostic;
    exports me.reidj.anxietydiagnostic.controller.authorization;
    exports me.reidj.anxietydiagnostic.controller.question;
    exports me.reidj.anxietydiagnostic.controller.result;
    exports me.reidj.anxietydiagnostic.controller;
}