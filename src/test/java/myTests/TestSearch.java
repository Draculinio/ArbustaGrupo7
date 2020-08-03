package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Commons;
import helpers.Waiters;

public class TestSearch extends Commons{
	
	//Antes de que se ejecute el search deberia popular la base de datos
	//Despues borramos los datos de la base
	@Test(description="Search by Dresses")
	public void searchDresses() {
		pIndex.search("DRESSES");
		Assert.assertEquals(pItems.getTitleText(),"\"DRESSES\"");
	}
	
	@Test(description = "Search by TShirts")
	public void searchTSHIRTS() {
		pIndex.search("T-SHIRTS");
		Assert.assertEquals(pItems.getTitleText(),"\"El Payaso Plim Plim\"" );
	}
	
	@Test(enabled=false, description = "Search with no results")
	public void searchNoResult() {
		pIndex.search("hello world");
		Assert.assertEquals(pItems.getNotFoundText(),"No results were found for your search \"hello world\"");
	}
	
	@Test(description="checkboxes")
	public void clickCheckBoxes() {
		pIndex.clickDresses();
		pItems.check();
		Waiters.waitForTime(3);
	}
}