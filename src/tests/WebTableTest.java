package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.w3c.dom.Text;

import common.TestBase;

public class WebTableTest {
// TC1---NOK
	public void testTC1() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"item-3\"]")).click();

		// Input value
		String inputSearch = "ci";
		testBase.dr.findElement(By.xpath("//*[@id=\"searchBox\"]")).sendKeys(inputSearch);
		testBase.dr.findElement(By.xpath("//*[@id=\"basic-addon2\"]/span/svg")).click();
		String[] actual;
//		for(int i=0;i<=)
//				testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div["+i+"]/div")).getText();
//*[@id="app"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div
//*[@id="app"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[2]/div
		boolean keyWordSearch = testBase.dr.findElement(By.xpath("//*[text()='" + inputSearch + "']")).isDisplayed();
		if (keyWordSearch) {
			System.out.println("WebTable TC1 Passed");
		} else {
			System.out.println("WebTable TC1 Fail");
		}
	}

// TC2---NOK
	public void testTC2() {
		TestBase testBase = new TestBase();
		testBase.openWebBrowser();
		testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")).click();
		testBase.dr.findElement(By.xpath("//*[@id=\"item-3\"]")).click();

		// Add records
		testBase.dr.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).click();
		// Insert values
		String[] inputValue = { "N", "Nh", "a@gmail.com", "19", "1000", "ABC" };
//		for(int i=0;i<insertValue.length;i++) {
//			testBase.dr.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/form/div["+i+"]/div[2]/input")).sendKeys(insertValue[i]);}
		testBase.dr.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(inputValue[0]);
		testBase.dr.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(inputValue[1]);
		testBase.dr.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(inputValue[2]);
		testBase.dr.findElement(By.xpath("//*[@id=\"age\"]")).sendKeys(inputValue[3]);
		testBase.dr.findElement(By.xpath("//*[@id=\"salary\"]")).sendKeys(inputValue[4]);
		testBase.dr.findElement(By.xpath("//*[@id=\"department\"]")).sendKeys(inputValue[5]);
		testBase.dr.findElement(By.xpath("//*[@id=\"submit\"]")).click();

//			for(int i=0;i<=)
//					testBase.dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div["+i+"]/div")).getText();
//		if (keyWordSearch) {
//			System.out.println("WebTable TC1 Passed");
//		} else {
//			System.out.println("WebTable TC1 Fail");
//		}

	}
}
