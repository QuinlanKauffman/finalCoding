package pkgApp.controller;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private Label lblTotalToSave;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		Double = 
		
		System.out.println("Clear pressed");
		//Retirement rmt = new Retirement();
		//lblSaveEachMonth.setText(rtm.AmoutToSave());
		
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		lblSaveEachMonth.setText("100");
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
		
	}
	
}
