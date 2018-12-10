/**
 * 
 */
/**
 * @author Dad
 *
 */
package pkgEmpty;

import static org.junit.Assert.assertEquals;

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
		
		
		double expectedPMT = 554.13;
		assertEquals(expectedPMT, Math.abs(rtm.AmountToSave()),0.01);
		
	}
	
	
	@Test
	public void test2() {
		int yearsWork = 40;
		double annualReturnWork = 0.07;
		int yearsRetired = 20;
		double annualReturnRetired = 0.02;
		double requiredIncome = 10000;
		double monthlySSI = 2642;
		Retirement rtm = new Retirement(yearsWork, annualReturnWork, yearsRetired, annualReturnRetired, requiredIncome,
				monthlySSI);
		
		
		double expectedToSave = 1454485.55;
		assertEquals(expectedToSave, Math.abs(rtm.TotalAmountSaved()),0.01);
		
	}
	
	@Test
	public void test3() {
		int yearsWork = 40;
		double annualReturnWork = 0.07;
		int yearsRetired = 20;
		double annualReturnRetired = 0.02;
		double requiredIncome = 0;
		double monthlySSI = 0;
		
		//No money needed for retirement
		
		Retirement rtm = new Retirement(yearsWork, annualReturnWork, yearsRetired, annualReturnRetired, requiredIncome,
				monthlySSI);
		
		
		double expectedToSave = 0;
		assertEquals(expectedToSave, Math.abs(rtm.TotalAmountSaved()),0.01);
	}
	
	@Test
	public void test4() {
		int yearsWork = 40;
		double annualReturnWork = 0.07;
		int yearsRetired = 20;
		double annualReturnRetired = 0.02;
		double requiredIncome = 0;
		double monthlySSI = 0;
		//No money needed for retirement
		
		Retirement rtm = new Retirement(yearsWork, annualReturnWork, yearsRetired, annualReturnRetired, requiredIncome,
				monthlySSI);
		
		
		double expectedToSave = 0;
		assertEquals(expectedToSave, Math.abs(rtm.TotalAmountSaved()),0.01);
	}
	
}