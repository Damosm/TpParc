package fr.damien.main;

import java.io.IOException;
import java.util.Observable;

import org.apache.log4j.PropertyConfigurator;

import fr.damien.dao.BatimentDAO;
import fr.damien.dao.CentreDAO;
import fr.damien.dao.DAO;
import fr.damien.dao.DAOConnection;
import fr.damien.javafx.BatimentEditDialogController;
import fr.damien.javafx.CentreEditDialogController;
import fr.damien.javafx.CentreOverviewController;
import fr.damien.metier.Batiment;
import fr.damien.metier.Centre;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainFX extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	ObservableList<Centre> centreData = FXCollections.observableArrayList();
	
	DAO<Centre> cd1 = new CentreDAO();
	
	

	public MainFX() {

		centreData.addAll(cd1.liste());
		

	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("TP Parc");

		initRootLayout();

		showCentreOverview();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFX.class.getResource("../javafx/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void showCentreOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFX.class.getResource("../javafx/CentreOverview.fxml"));
			AnchorPane centreOverview = (AnchorPane) loader.load();

			rootLayout.setCenter(centreOverview);

			CentreOverviewController Controller = loader.getController();
			Controller.setMainFX(this);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {

		return primaryStage;
	}

	public ObservableList<Centre> getCentreData() {

		return centreData;
	}
	
	

	public boolean showCentreEditDialog(Centre centre) {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFX.class.getResource("../javafx/CentreEditDialog.fxml"));
			AnchorPane centreEditDialog = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer centre");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(centreEditDialog);
			dialogStage.setScene(scene);

			CentreEditDialogController controller = loader.getController();
			controller.setDialogstage(dialogStage);
			controller.setCentre(centre);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
	public boolean showBatimentEditDialog (Batiment batiment) {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFX.class.getResource("../javafx/BatimentEditDialog.fxml"));
			AnchorPane centreEditDialog = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer batiment");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(centreEditDialog);
			dialogStage.setScene(scene);

			BatimentEditDialogController controller = loader.getController();
			controller.setDialogstage(dialogStage);
			controller.setBatiment(batiment);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		
		launch(args);
	}
}
