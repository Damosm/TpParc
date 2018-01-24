package fr.damien.javafx;

import java.sql.SQLException;

import fr.damien.dao.BatimentDAO;
import fr.damien.dao.CentreDAO;
import fr.damien.dao.DAO;
import fr.damien.main.MainFX;
import fr.damien.metier.Batiment;
import fr.damien.metier.Centre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CentreOverviewController {

	ObservableList<Batiment> batimentData = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Centre> centresTable;

	@FXML
	private TableColumn<Centre, String> colonneNom;

	@FXML
	private TableColumn<Centre, String> colonneLieu;

	@FXML
	private TableView<Batiment> batimentsTable;

	@FXML
	private TableColumn<Batiment, String> colonneNomBat;

	@FXML
	private Button btn_creer;

	@FXML
	private Button btn_editer;

	@FXML
	private Button btn_effacer;

	@FXML
	private Button btn_creerBat;

	@FXML
	private Button btn_editerBat;

	@FXML
	private Button btn_effacerBat;

	@FXML
	private Label idCentre;

	@FXML
	private Label nomCentre;

	@FXML
	private Label idBatiment;

	@FXML
	private Label nomBatiment;

	@FXML
	private Label lieuCentre;

	private MainFX mainFX;

	public CentreOverviewController() {

	}

	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.

		colonneNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
		colonneLieu.setCellValueFactory(cellData -> cellData.getValue().lieuProperty());
		colonneNomBat.setCellValueFactory(cellData -> cellData.getValue().nomBatProperty());

		showCentreDetails(null);
		showBatimentDetails(null);

		centresTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldvalue, newValue) -> showCentreDetails(newValue));

		batimentsTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldvalue, newValue) -> showBatimentDetails(newValue));
	}

	private void showCentreDetails(Centre centre) {

		if (centre != null) {

			idCentre.setText(String.valueOf(centre.getIdCentre()));
			nomCentre.setText(centre.getNomCentre());
			lieuCentre.setText(centre.getLieuCentre());
			
			batimentsTable.getItems().removeAll(batimentData);
			BatimentDAO b1 = new BatimentDAO();
			batimentData.addAll(b1.afficherBatCentre(centre));
			batimentsTable.setItems(batimentData);
			
		} else {

			idCentre.setText("");
			nomCentre.setText("");
			lieuCentre.setText("");
		}

	}
	
	private void showBatimentDetails(Batiment batiment) {

		if (batiment != null) {

			idBatiment.setText(String.valueOf(batiment.getIdBatiment()));
			nomBatiment.setText(batiment.getNomBat());
			
		} else {

			idCentre.setText("");
			nomCentre.setText("");
			
		}

	}

	@FXML
	public void handleEffacer() {

		int selectedIndex = centresTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {

			DAO<Centre> cd1 = new CentreDAO();

			// CentreDAO cd1 = new CentreDAO(DAOConnection.getInstance());
			try {
				cd1.delete(centresTable.getSelectionModel().getSelectedItem().idProperty().get());
				centresTable.getItems().remove(selectedIndex);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainFX.getPrimaryStage());
			alert.setTitle("Pas de selection");
			alert.setHeaderText("Aucun centre selectionné");
			alert.setContentText("Veuillez selectionnner un centre");

			alert.showAndWait();

		}

	}
	
	@FXML
	public void handleBatEffacer() {

		int selectedIndex = batimentsTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {

			DAO<Batiment> b1 = new BatimentDAO();

			
			try {
				b1.delete(batimentsTable.getSelectionModel().getSelectedItem().getIdBatiment());
				batimentsTable.getItems().remove(selectedIndex);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainFX.getPrimaryStage());
			alert.setTitle("Pas de selection");
			alert.setHeaderText("Aucun centre selectionné");
			alert.setContentText("Veuillez selectionnner un centre");

			alert.showAndWait();

		}

	}

	public void setMainFX(MainFX mainFX) {
		this.mainFX = mainFX;

		
		centresTable.setItems(mainFX.getCentreData());
		
	}

	@FXML
	private void handleNewCentre() {

		Centre tempCentre = new Centre();

		boolean okClicked = mainFX.showCentreEditDialog(tempCentre);

		if (okClicked) {

			
			DAO<Centre> cd1 = new CentreDAO();
			
			try {
				cd1.create(tempCentre);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			mainFX.getCentreData().add(tempCentre);

		}

	}

	@FXML
	private void handleNewBatiment() {

		Batiment tempBatiment = new Batiment();

		boolean okClicked = mainFX.showBatimentEditDialog(tempBatiment);

		if (okClicked) {

			
			DAO<Batiment> b1 = new BatimentDAO();
			
			try {
				tempBatiment.setIdCentre(centresTable.getSelectionModel().getSelectedItem().getIdCentre());
				b1.create(tempBatiment);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			batimentData.add(tempBatiment);
			batimentsTable.setItems(batimentData);

		}

	}

	
	
	@FXML
	private void handleEditCentre() throws SQLException {

		Centre selectCentre = centresTable.getSelectionModel().getSelectedItem();

		if (selectCentre != null) {
			boolean okClicked = mainFX.showCentreEditDialog(selectCentre);
			if (okClicked) {
				DAO<Centre> cd1 = new CentreDAO();
				
				cd1.update(selectCentre);
				showCentreDetails(selectCentre);

			}

		} else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainFX.getPrimaryStage());
			alert.setTitle("Probleme selection");
			alert.setHeaderText("aucun centre selectionné");
			alert.setContentText("Veuillez selectionner un centre");

			alert.showAndWait();

		}
	}
	
	
	@FXML
	private void handleEditBatiment() throws SQLException {

		Batiment selectBatiment = batimentsTable.getSelectionModel().getSelectedItem();

		if (selectBatiment != null) {
			boolean okClicked = mainFX.showBatimentEditDialog(selectBatiment);
			if (okClicked) {
				DAO<Batiment> b1 = new BatimentDAO();
				//selectBatiment.setIdCentre(centresTable.getSelectionModel().getSelectedItem().getIdCentre());
				b1.update(selectBatiment);
				showBatimentDetails(selectBatiment);

			}

		} else {

			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainFX.getPrimaryStage());
			alert.setTitle("Probleme selection");
			alert.setHeaderText("aucun centre selectionné");
			alert.setContentText("Veuillez selectionner un centre");

			alert.showAndWait();

		}
	}
	
	
	
	

}
