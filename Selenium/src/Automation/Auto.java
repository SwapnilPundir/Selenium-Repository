package Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Auto {
	
static WebDriver driver;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapn\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains (text(),'Sign Up')]"))).click();
		System.out.println("Clicked");
		FileInputStream file = new FileInputStream("D:\\Selenium\\Selenium automation data\\Automation data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int lastrow = sheet.getLastRowNum();
		lastrow--;
		int cellcount = sheet.getRow(0).getLastCellNum();
		//System.out.println("Row = "+lastrow);
		//System.out.println("Cells = "+cellcount);
		
		for(int i=1; i<=lastrow; i++)
		{
			XSSFRow currentrow = sheet.getRow(i);
			
			int firstname = (int) currentrow.getCell(0).getNumericCellValue();
			String lastname = currentrow.getCell(1).toString();
			String email = currentrow.getCell(2).toString();
			String password = currentrow.getCell(3).toString();
		
			/*for(int j=0; j<cellcount; j++)
			{
				String value = currentrow.getCell(j).toString();
				System.out.print("  "+value);								
			}
			
			System.out.println();*/
		
		
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys(String.valueOf(firstname));
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys(email);
		driver.findElement(By.id("u_0_z")).sendKeys(password);
		
		System.out.println("Row finished - " + i);
		
		driver.navigate().refresh();
		}
		System.out.println("Execution is complete.");
		driver.quit();
	}
}
