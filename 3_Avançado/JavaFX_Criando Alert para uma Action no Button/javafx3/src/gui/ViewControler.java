package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class ViewControler {
	
	@FXML
	private Button btTest;
	
	@FXML
	public void onBtTestAction() {
		Alerts.showAlert("Alert title", null, "Hello World", AlertType.INFORMATION);
	}

}
