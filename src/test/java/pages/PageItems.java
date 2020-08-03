package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageItems {
	
	private WebDriver driver;
	private By titleBanner;
	private By titleNotFound;
	private By orderSelect;
	private By checkBoxes;
	
	public PageItems(WebDriver driver) {
		this.driver = driver;
		titleBanner = By.className("lighter");
		titleNotFound = By.xpath("//*[@id=\"center_column\"]/p");
		orderSelect = By.id("selectProductSort");
		checkBoxes = By.className("checkbox");
	}
	
	public void check() {
		//driver.findElement(checkBoxes);
		List<WebElement> elements = driver.findElements(checkBoxes);
		System.out.println(elements.size());
		for(WebElement element: elements) {
			element.click();
		}
	}
	
	public void checkNelement(int elementToClick) {
		List<WebElement> elements = driver.findElements(checkBoxes);
		elements.get(elementToClick).click();
	}
	
	public String getTitleText() {
		return driver.findElement(titleBanner).getText();
	}
	
	public String getNotFoundText() {
		return driver.findElement(titleNotFound).getText();
	}
	
	public void searchElementByVisibleText(String text) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByVisibleText(text);
	}
	
	public void searchElementByValue(String text) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByValue(text);
	}
	
	public void searchElementByIndex(int num) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByIndex(num);
	}
	
	
}
