/**
 * 
 */
/**
 * @author Dad
 *
 */
package pkgEmpty;

import org.junit.Test;

import pkgCore.Retirement;

public class TestClass {
	
	@Test
	public void test1() {
		int yearsWork = 40;
		double annualReturnWork = 0.07;
		int yearsRetired = 20;
		double annualReturnRetired = 0.02;
		double requiredIncome = 10000;
		double monthlySSI = 2642;
		Retirement rtm = new Retirement(yearsWork, annualReturnWork, yearsRetired, annualReturnRetired, requiredIncome,
				monthlySSI);
		System.out.println(rtm.getiYearsToWork());
		System.out.println(rtm.getdAnnualReturnWorking());
		System.out.println(rtm.AmountToSave());
		System.out.println(rtm.TotalAmountSaved());
	}
}