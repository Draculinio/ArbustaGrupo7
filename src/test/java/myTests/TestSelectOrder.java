package myTests;

import org.testng.annotations.Test;

import base.Commons;
import helpers.Waiters;

public class TestSelectOrder extends Commons{
	
	@Test(description="Selects by visible text")
	public void selectByVisibleText() {
		pIndex.clickWomen();
		Waiters.waitForTime(4);
		pItems.searchElementByVisibleText("Price: Lowest first");
		Waiters.waitForTime(3);
		pItems.searchElementByValue("quantity:desc");
		Waiters.waitForTime(3);
		pItems.searchElementByIndex(4);
		Waiters.waitForTime(3);
	}
}
