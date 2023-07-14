module com.pooespol.emojimakerg1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.app to javafx.fxml;
    exports com.app;
    
    
    opens Controllers to javafx.fxml;
    exports Controllers;
    
    opens Components to javafx.fxml;
    exports Components;
}
