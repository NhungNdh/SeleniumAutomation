package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import common.TestBase;

public class CheckBoxTest {
//TC1---OK
	public void testTC1() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"item-1\"]")).click();

		// Initial checkbox
		boolean checkTC1 = testBase.dr.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck")).isDisplayed();
		if (checkTC1) {
			System.out.println("CheckBox TC1 Passed");
		} else {
			System.out.println("CheckBox TC1 Fail");
		}
	}

//TC2---OK
	public void testTC2() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		String expectedResult = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"item-1\"]")).click();

		// Checked checkbox => show msg
		testBase.dr.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label")).click();
		String actual = testBase.dr.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]")).getText();
		String actualResult = actual.replace("\n", " ");
		if(actualResult.equals(expectedResult)) {
			System.out.println("CheckBox TC2 Passed");
		} else {
			System.out.println("CheckBox TC2 Fail");
		}
	}

//TC3---OK
	public void testTC3() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"item-1\"]")).click();

		// Check checkboxes display all
		testBase.dr.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg")).click();
		boolean actualResult1 = testBase.dr.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span"))
				.isDisplayed();
		boolean actualResult2 = testBase.dr.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span"))
				.isDisplayed();
		boolean actualResult3 = testBase.dr.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span"))
				.isDisplayed();
		if ((actualResult1) && (actualResult2) && (actualResult3)) {
			System.out.println("CheckBox TC3 Passed");
		} else {
			System.out.println("CheckBox TC3 Fail");
		}
	}
}
