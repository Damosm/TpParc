package fr.damien.javafx;

import fr.damien.metier.Batiment;
import fr.damien.metier.Centre;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BatimentEditDialogController {

	
	@FXML
	private TextField nomBatiment;

	

	private Stage dialogStage;
	private Batiment batiment;
	private boolean okClicked = false;

	@FXML
	private void initialize() {

	}

	public void setDialogstage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;

		nomBatiment.setText(batiment.getNomBat());
		
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {

		if (isInputValid()) {

			batiment.setNomBat(nomBatiment.getText());
			

			okClicked = true;
			dialogStage.close();
		}

	}

	@FXML
	private void handleCancel() {

		dialogStage.close();
	}

	private boolean isInputValid() {

		String errorMessage = "";

		if (nomBatiment.getText() == null || nomBatiment.getText().length() == 0) {
			errorMessage += "Nom centre non valide\n";
		}
		

		if (errorMessage.length() == 0) {

			return true;
		} else {

			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Attribut non valide");
			alert.setHeaderText("Veuillez saisir un attribut valide");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;

		}

	}
	
}
