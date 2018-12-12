package pkgApp.controller;

import javafx.scene.control.*;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
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

	private ArrayList<TextField> listOfNumericTextfields = new ArrayList<TextField>();
	private ArrayList<TextField> listOfIntegerTextfields = new ArrayList<TextField>();
	
	
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
	
		this.listOfNumericTextfields.clear();
		this.listOfIntegerTextfields.clear();
		
		
		lblSaveEachMonth.setText("");
		lblTotalToSave.setText("");
		
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtMonthlyIncome.setText("");
		txtMonthlySSI.setText("");
		
	}
	 
	private boolean workingTextFields() {	
		for(TextField txtfield: this.listOfNumericTextfields) {
			if ( txtfield.getText() == null || txtfield.getText() == "" 
					|| txtfield.getText().isEmpty() || isNumeric(txtfield.getText()) == false){
				return false;
			}
				
		}
		
		for(TextField txtfield: this.listOfIntegerTextfields) {
			if (isInteger(txtfield.getText()) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	
	private static boolean isInteger(String str) {
		
	    for(int i = 0; i < str.length(); i++) {
	        if(i == 0 && str.charAt(i) == '-') {
	            if(str.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(str.charAt(i),10) < 0) return false;
	    }
	    return true;
		
	}
	
	private  static boolean isNumeric(String str)
	{
		int decimalPointCounter = 0;
		for (char c : str.toCharArray())
	    {
			if(c == '.') {
				decimalPointCounter++;
				if (decimalPointCounter > 1) {
					return false;
				}
				continue;
			}
	        if (!Character.isDigit(c)) 
	        	return false;
	        else
	        	continue;
	    }
	    return true;
	}
	
	
	private void clearBothListsOfTextfields()  {
		this.listOfNumericTextfields.clear();
		this.listOfIntegerTextfields.clear();
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		setBothListsOfTextfields();
		
		if (workingTextFields() == true) {
			int iYearsToWork = Integer.parseInt(txtYearsToWork.getText());
			double dAnnualWorking = Double.parseDouble(txtAnnualReturnWorking.getText());
			int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
			double dAnnualRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
			double dMonthlyIncome = Double.parseDouble(txtMonthlyIncome.getText());
			double dMonthlySSI =  Double.parseDouble(txtMonthlySSI.getText());
			
			Retirement rtm = new Retirement(iYearsToWork, dAnnualWorking, iYearsRetired, dAnnualRetired,
					dMonthlyIncome, dMonthlySSI);
			
			
			String pmt = String.format("%,.2f", Math.abs(rtm.AmountToSave()));
			lblSaveEachMonth.setText("$" + pmt);
			
			String totalToSave = String.format("%,.2f", Math.abs(rtm.TotalAmountSaved()));
			lblTotalToSave.setText("$" + totalToSave);
			//	TODO: Call AmountToSave and TotalAmountSaved and populate 
			
			
			
		}
		
		else {
			lblSaveEachMonth.setText(null);
			lblTotalToSave.setText(null);
			
			//Keep text for textfields so that doesn't clear and have to redo inputs
			
//			txtYearsToWork.setText(null);
//			txtAnnualReturnWorking.setText(null);
//			txtYearsRetired.setText(null);
//			txtAnnualReturnRetired.setText(null);
//			txtMonthlyIncome.setText(null);
//			txtMonthlySSI.setText(null);
		}
		
		clearBothListsOfTextfields();
	}
	
	private void setBothListsOfTextfields() {
		this.listOfNumericTextfields.add(this.txtAnnualReturnRetired);
		this.listOfNumericTextfields.add(this.txtAnnualReturnWorking);
		this.listOfNumericTextfields.add(this.txtMonthlyIncome);
		this.listOfNumericTextfields.add(this.txtMonthlySSI);
		this.listOfNumericTextfields.add(this.txtYearsToWork);
		this.listOfNumericTextfields.add(this.txtYearsRetired);
		
		
		this.listOfIntegerTextfields.add(this.txtYearsToWork);
		this.listOfIntegerTextfields.add(this.txtYearsRetired);
	}
	
	
	
}
