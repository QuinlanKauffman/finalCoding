package pkgApp.controller;

import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturnWorking;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetired;
	
	@FXML
	private TextField txtMonthlyIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
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
	
		lblSaveEachMonth.setText("");
		lblTotalToSave.setText("");
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtMonthlyIncome.setText("");
		txtMonthlySSI.setText("");
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		int iYearsToWork = Integer.parseInt(txtYearsToWork.getText());
		double dAnnualWorking = Double.parseDouble(txtAnnualReturnWorking.getText());
		int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
		double dAnnualRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
		double dMonthlyIncome = Double.parseDouble(txtMonthlyIncome.getText());
		double dMonthlySSI =  Double.parseDouble(txtMonthlySSI.getText());
		
		System.out.println("Clear pressed");
		Retirement rtm = new Retirement(iYearsToWork, dAnnualWorking, iYearsRetired, dAnnualRetired,
				dMonthlyIncome, dMonthlySSI);
		
		
		String pmt = String.format("%,.2f", Math.abs(rtm.AmountToSave()));
		lblSaveEachMonth.setText("$"+pmt);
		
		String totalToSave = String.format("%,.2f", Math.abs(rtm.TotalAmountSaved()));
		lblTotalToSave.setText("$" + totalToSave);
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
		
	}
	
}
