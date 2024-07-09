package results_competition.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import results_competition.Model.DriversResult;
import results_competition.Model.RepositoryDriversResult;

public class tablaConductoresViewController implements Initializable{


    @FXML
    private TableColumn<DriversResult, String> ColumnConstructorName;

    @FXML
    private TableColumn<DriversResult, Integer> ColumnRank;

    @FXML
    private TableColumn<DriversResult, Integer> ColumnTotalPoints;

    @FXML
    private TableColumn<DriversResult, Integer> ColumnWins;

    @FXML
    private ComboBox<Integer> selectionYear;

    @FXML
    private TableView<DriversResult> tableDrivers;

    private RepositoryDriversResult repositoryDriversResult = new RepositoryDriversResult();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

         // Agregando Opciones
        for (int year = 1950; year <= 2019; year++) {
            selectionYear.getItems().add(year);
        }

        // Valor default
        selectionYear.setValue(2004);
        // Añadir manejador de eventos para el ComboBox
        selectionYear.setOnAction(this::selectionMethod);

        ColumnConstructorName.setCellValueFactory(new PropertyValueFactory<>("forename"));
		ColumnRank.setCellValueFactory(new PropertyValueFactory<>("season_rank"));
		ColumnTotalPoints.setCellValueFactory(new PropertyValueFactory<>("total_points"));
		ColumnWins.setCellValueFactory(new PropertyValueFactory<>("wins"));
    }

    @FXML
    void selectionMethod(ActionEvent event) {
        int selectedYear = selectionYear.getValue();
        System.out.println("Year selected: " + selectedYear);
        // Limpiar la tabla antes de cargar nuevos datos
        tableDrivers.getItems().clear();
        cargarDrivers(selectedYear);
    }

    private void cargarDrivers(int year) {
		List<DriversResult> ls_d = repositoryDriversResult.getDriversResult(year);
        tableDrivers.getItems().addAll(ls_d);
    }
}
