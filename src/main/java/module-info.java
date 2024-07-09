module results_competition {

    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;


    opens results_competition.Controller;
    opens results_competition.Model;
    opens results_competition.App to javafx.fxml;
    
    exports results_competition.App;
}
