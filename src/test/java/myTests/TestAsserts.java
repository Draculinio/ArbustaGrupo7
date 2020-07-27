package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAsserts {
	private String a;
	@Test
	public void isEqual() {
		a = "b";
		Assert.assertEquals(a, "b","Expected to have a b\n");//SI ESTO FALLA LO DEMAS NO SE EJECUTA
		System.out.println("Paso esto\n Y esto");
	}
	
	@Test
	public void isEqualN() {
		Assert.assertEquals(1, 2-1);
	}
	
	@Test
	public void isNotEqual() {
		Assert.assertNotEquals(1,2,"Expected to be different");
	}
	
	@Test
	public void isTrue() {
		Assert.assertTrue(8/2==4,"Expected to be true");
	}
	
	@Test
	public void isFalse() {
		Assert.assertFalse(2==1);
	}
	
	@Test
	public void isNull() {
		String b = null;
		Assert.assertNull(b);
	}
	
	@Test
	public void isNotNull() {
		String b="Pepe";
		Assert.assertNotNull(b);
	}
	
	@Test
	public void softAsserts() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2,"Need to see this");
		System.out.println("The test continues...");
		Assert.assertEquals(2, 2);
		sa.assertAll();
	}
}
