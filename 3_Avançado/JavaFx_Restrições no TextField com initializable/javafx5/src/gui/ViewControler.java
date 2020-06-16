package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewControler implements Initializable {
	
	@FXML
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;
	
	@FXML
	private Button btSum;
	
	@FXML
	public void onBtSumAction() {
		try {
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());
			double sum = number1 + number2;
			
			labelResult.setText(String.format("%.2f", sum));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Erro", null, e.getMessage(), AlertType.ERROR);
		}

		
	}
	
	//Método para Limitar números de caracteres ou pra TextField aceitar apenas Números

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 10);
		Constraints.setTextFieldMaxLength(txtNumber2, 10);
		
	}

}
