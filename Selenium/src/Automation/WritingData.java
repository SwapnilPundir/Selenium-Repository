package Automation;

import java.io.*;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WritingData {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String actual = driver.findElement(By.id("resp_matval")).getText();
		driver.findElement(By.name("principal")).sendKeys("12345");
		driver.findElement(By.id("interest")).sendKeys("8");
		driver.findElement(By.name("tenure")).sendKeys("12345");

		Select s1 = new Select(driver.findElement(By.id("tenurePeriod")));
		s1.selectByVisibleText("year(s)");
		driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();*/
		
		FileOutputStream file= new FileOutputStream("D:\\Selenium\\Selenium automation data\\WritingData.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("WritingData");
		int lastrow = sheet.getLastRowNum();
		for(int i=1; i<5; i++)
		{
		XSSFRow row = sheet.createRow(i);
		row.createCell(1).setCellValue("ABC");
		
		}
		wb.write(file);
		file.close();
		System.out.println("Last row = "+ lastrow);
		System.out.println("Execution completed");
	}

}
