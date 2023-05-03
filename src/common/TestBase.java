package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestBase {
	public ChromeDriver dr = new ChromeDriver();

	public void openWebBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\00AutomationTesting\\02Projects\\01Git\\SeleniumAutomation\\SeleniumWithJavaBasic\\src\\drivers\\chromedriver.exe");
		// Open website
		dr.get("https://demoqa.com/");
	}

	public void inputYear(String year) {
		// Find element containt dropdownbox
		WebElement dropBoxElement = dr.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select years = new Select(dropBoxElement);
		years.selectByValue(year);

	}
	public void inputMonth(String month) {
		// Find element containt dropdownbox
		WebElement dropBoxElement = dr.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select months = new Select(dropBoxElement);
		months.selectByValue(month);

	}
	public void inputMonthDay(String day) {
		// If get xpath = //div[@role='option' and not(contains(@class,'outside-month'))]
		// Only have to e.click()
		// Find list elements (day)
		List<WebElement> visibleDays = dr.findElements(By.xpath("//div[contains(@class,'react-datepicker__day')and@role='option']"));
		//Foreach, scan each element of list
		for(WebElement e : visibleDays) {
			//Get full attritude <Class> of each element
			String valueOfClass = e.getAttribute("class");
			if((valueOfClass.contains(day))
					&& (!valueOfClass.contains("outside-month"))) {
				e.click();
			}
		}
	}

}
