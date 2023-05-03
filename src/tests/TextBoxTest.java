package tests;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import common.TestBase;

public class TextBoxTest {
//TC1---OK
	public void testTC1() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"item-0\"]")).click();

		// Input value
		String[] inputValue = {"Nhung","abc@gmail.com","123 ABC","321 CBA"};
		testBase.dr.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(inputValue[0]);
		testBase.dr.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(inputValue[1]);
		testBase.dr.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys(inputValue[2]);
		//	Check if not find Permanent Address Textbox => action scroll to last page
		WebElement permanentAddressTextbox = testBase.dr.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
		if(permanentAddressTextbox.isDisplayed()) {
			//scroll to end of page
			((JavascriptExecutor) testBase.dr).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		testBase.dr.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys(inputValue[3]);
		testBase.dr.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		//	get actual result Text
		String[] actual = {testBase.dr.findElement(By.xpath("//*[@id=\"name\"]")).getText(),
				testBase.dr.findElement(By.xpath("//*[@id=\"email\"]")).getText(),
				testBase.dr.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")).getText(),
				testBase.dr.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")).getText()};
		String[] actualResult = new String[actual.length];
		for (int i=0;i<actual.length;i++) {
			actualResult[i] = actual[i].substring(actual[i].indexOf(":")+1,actual[i].length());
		}
		if(Arrays.deepEquals(actualResult, inputValue)) {
			System.out.println("TextBox TC1 Passed");
		} else {
			System.out.println("TextBox TC1 Fail");
		}
	}

//TC2---OK
	public void testTC2() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"item-0\"]")).click();

		// Input value
		String inputName = "Nhung";
		testBase.dr.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(inputName);
		testBase.dr.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("Ngmail.com");
		testBase.dr.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("N123");
		((JavascriptExecutor) testBase.dr).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		testBase.dr.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys("N321");
		testBase.dr.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		boolean checkTC2 = testBase.dr.findElement(By.cssSelector(".mr-sm-2.field-error.form-control")).isDisplayed();
		if (checkTC2) {
			System.out.println("TextBox TC2 Passed");
		} else {
			System.out.println("TextBox TC2 Fail");
		}

	}

}
