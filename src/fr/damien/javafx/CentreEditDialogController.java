package fr.damien.javafx;

import fr.damien.metier.Centre;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CentreEditDialogController {

	@FXML
	private TextField nomCentre;

	@FXML
	private TextField lieuCentre;

	private Stage dialogStage;
	private Centre centre;
	private boolean okClicked = false;

	@FXML
	private void initialize() {

	}

	public void setDialogstage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	public void setCentre(Centre centre) {
		this.centre = centre;

		nomCentre.setText(centre.getNomCentre());
		lieuCentre.setText(centre.getLieuCentre());

	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {

		if (isInputValid()) {

			centre.setNomCentre(nomCentre.getText());
			centre.setLieuCentre(lieuCentre.getText());

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

		if (nomCentre.getText() == null || nomCentre.getText().length() == 0) {
			errorMessage += "Nom centre non valide\n";
		}
		if (lieuCentre.getText() == null || lieuCentre.getText().length() == 0) {
			errorMessage += "Lieu non valide\n";

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
