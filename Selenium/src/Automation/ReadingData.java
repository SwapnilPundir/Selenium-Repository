package Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadingData {

static WebDriver driver; 
	
//static WebDriver driver1;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32(version80)\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver1.get("https://www.guru99.com/testng-execute-multiple-test-suites.html");
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FileInputStream file = new FileInputStream("D:\\Selenium\\Selenium automation data\\ReadingData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int lastrow = sheet.getLastRowNum();
		System.out.println("Last row ="+lastrow);
		int lastcell = sheet.getRow(1).getLastCellNum();
		for(int i=1; i<=lastrow; i++)
		{
			int principal = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
			int interest = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			int period = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
			String tenure = sheet.getRow(i).getCell(3).toString();
			driver.findElement(By.name("principal")).sendKeys(String.valueOf(principal));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(interest));
			driver.findElement(By.name("tenure")).sendKeys(String.valueOf(period));
	
			Select s1 = new Select(driver.findElement(By.id("tenurePeriod")));
			s1.selectByVisibleText(tenure);
			double expected = (double) sheet.getRow(i).getCell(4).getNumericCellValue();
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
			String actual = driver.findElement(By.id("resp_matval")).getText();
			
			if
			(Double.parseDouble(actual)==expected)
				
			{
				System.out.println("Test passed for row no. "+ i);
			}
			else 
			{
				System.out.println("Test failed for row no. "+i);
			}
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click();
			
		}
		driver.quit();

	}

}
