module me.reidj.anxietydiagnostic {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens me.reidj.anxietydiagnostic to javafx.fxml;
    opens me.reidj.anxietydiagnostic.controller.authorization to javafx.fxml;

    exports me.reidj.anxietydiagnostic;
    exports me.reidj.anxietydiagnostic.controller.authorization;
    exports me.reidj.anxietydiagnostic.controller;
    opens me.reidj.anxietydiagnostic.controller to javafx.fxml;
}