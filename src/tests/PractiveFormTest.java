package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.TestBase;

public class PractiveFormTest {
// TC1---NOK
	public void testTC1() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li")).click();

		// Input all valid value
		String[] inputValue = {"First Name","Last Name","email@gmail.com",null,"0987654321"};
		testBase.dr.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(inputValue[0]);
		testBase.dr.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(inputValue[1]);
		testBase.dr.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(inputValue[2]);
		testBase.dr.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(inputValue[4]);
//		testBase.dr.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).clear();
//		testBase.dr.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).sendKeys("01 Jan 2023");
		inputYear();
		((JavascriptExecutor) testBase.dr).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement el = testBase.dr.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));
		Select s = new Select(el);
		s.selectByValue("Math");

		testBase.dr.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("ABC");
		Select city = new Select(testBase.dr.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]")));
		city.selectByVisibleText("NCR");
		Select state = new Select(testBase.dr.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]")));
		state.selectByVisibleText("Delhi");
		testBase.dr.findElement(By.xpath("//*[@id=\"submit\"]")).click();

//		boolean checkTC1 = testBase.dr.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck")).isDisplayed();
//		if (checkTC1) {
//			System.out.println("PractiveForm TC1 Passed");
//		} else {
//			System.out.println("PractiveForm TC1 Fail");
//		}
	}
}
