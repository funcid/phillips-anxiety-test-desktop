module me.func.anxietydiagnostic {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.google.gson;
    requires java.mail;
    requires static activation;

    opens me.func.anxietydiagnostic to javafx.fxml;
    opens me.func.anxietydiagnostic.controller.authorization to javafx.fxml;
    opens me.func.anxietydiagnostic.controller.question to javafx.fxml;
    opens me.func.anxietydiagnostic.controller.result to javafx.fxml;
    opens me.func.anxietydiagnostic.controller to javafx.fxml;
    opens me.func.anxietydiagnostic.question to com.google.gson;

    exports me.func.anxietydiagnostic;
    exports me.func.anxietydiagnostic.controller.authorization;
    exports me.func.anxietydiagnostic.controller.question;
    exports me.func.anxietydiagnostic.controller.result;
    exports me.func.anxietydiagnostic.controller;
}