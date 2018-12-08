package pkgCore;

import org.apache.poi.ss.formula.functions.*;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	private double dTotalRetirement;
	
	//TODO: Build the contructor, getters and setters for the attributes above.
	
	
	public Retirement(int yearsToWork, double annualReturnWorking, int yearsRetired, double annualReturnRetired, 
			double requiredIncome, double monthlySSI) {
		this.iYearsToWork = yearsToWork;
		this.dAnnualReturnWorking = annualReturnWorking;
		this.iYearsRetired = yearsRetired;
		this.dAnnualReturnRetired = annualReturnRetired;
		this.dRequiredIncome = requiredIncome;
		this.dMonthlySSI = monthlySSI;
		this.dTotalRetirement = requiredIncome - monthlySSI;
	}
	
	public int getiYearsToWork() {
		return iYearsToWork;
	}

	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}

	public double getdTotalRetirement() {
		return dTotalRetirement;
	}

	public void setdTotalRetirement(double dTotalRetirement) {
		this.dTotalRetirement = dTotalRetirement;
	}

	public double AmountToSave()
	{
		//TODO: Determine the amount to save each month based on TotalAmountSaved, YearsToWork
		//		and Annual return while working
		
		double pmt = FinanceLib.pmt(this.dAnnualReturnWorking/12,this.iYearsToWork*12,0,TotalAmountSaved(),false);
		return pmt;
	}
	
	public double TotalAmountSaved()
	{
		//	TODO: Determine amount to be saved based on Monthly SSI, Required Income, Annual return during retirement
		//		and number of years retired.
		//
		//return FinanceLib.pv(this.dAnnualReturnRetired/12, this.iYearsRetired*12, this.dTotalRetirement, 0, false);
		double pv = FinanceLib.pv(this.dAnnualReturnRetired/12, this.iYearsRetired*12,this.dTotalRetirement,0,false);
		return pv;
	}
}
