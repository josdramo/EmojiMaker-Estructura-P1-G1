module com.pooespol.emojimakerg1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pooespol.emojimakerg1 to javafx.fxml;
    exports com.pooespol.emojimakerg1;
    
    
    opens Controllers to javafx.fxml;
    exports Controllers;
    
    opens Components to javafx.fxml;
    exports Components;
}
