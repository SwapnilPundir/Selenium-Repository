package Automation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClinicalPlus {
	
	static WebDriver driver;
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32(version80)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://portal.clinical.plus");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='clr-form-control-2']")).sendKeys("tstadmin@tst.ca");
		driver.findElement(By.xpath("//*[@id='clr-form-control-3']")).sendKeys("test123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div/button")).click();
			
		driver.findElement(By.xpath("//a[contains(text(),('Users'))]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test_firstname9");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Test_lastname9");
		driver.findElement(By.xpath("//input[@formcontrolname= 'dateOfBirth']")).sendKeys("10/07/1993");
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.xpath("//input[@formcontrolname= 'accessValidTill']")).sendKeys("04/01/2021");
		driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys("testEmail9@gmail.com");
		driver.findElement(By.xpath("//input[@id='backupEmail']")).sendKeys("testEmail10@gmail.com");
		
		Select phone = new Select(driver.findElement(By.xpath("//select[@class='select-margin-top clr-select ng-untouched ng-pristine ng-valid']")));
		phone.selectByVisibleText("Main");
		
		driver.findElement(By.xpath("//input[@formcontrolname='number']")).sendKeys("7888210046");
		
		driver.findElement(By.xpath("//input[@id='institutionUserId']")).sendKeys("55555");		
		driver.findElement(By.xpath("//ng-select[@formcontrolname='roles']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(text(),'Student')]")).click();

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//select[@formcontrolname='enrolledInTerm']")));

		
		driver.findElement(By.xpath("//input[@formcontrolname='address1']")).sendKeys("100 City Centre Dr, Mississauga, ON L5B 2C9, Canada");
		driver.findElement(By.xpath("//input[@formcontrolname='city']")).sendKeys("Mississauga");
		driver.findElement(By.xpath("//input[@formcontrolname='country']")).sendKeys("Canada");
		
		Select province = new Select(driver.findElement(By.xpath("//select[@formcontrolname='state']")));
		province.selectByVisibleText("British Columbia");
		
		driver.findElement(By.xpath("//input[@formcontrolname='zip']")).sendKeys("L5B 2C9");
						
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//ng-select[@formcontrolname='programId']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ng-option ng-star-inserted'][1]")).click();
		
		Select term = new Select(driver.findElement(By.xpath("//select[@formcontrolname='enrolledInTerm']")));
		term.selectByVisibleText("Winter");
		
		Select year = new Select(driver.findElement(By.xpath("//select[@formcontrolname='enrolledInYear']")));
		year.selectByVisibleText("2019");		
		
		driver.findElement(By.xpath("//div[@class='clr-row ng-star-inserted']//div[@class='clr-form-control ng-star-inserted']//input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted']")).click();
				
		driver.findElement(By.xpath("//div[@class='width-limiter fixed-footer aligned right']//button[2]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),('Users'))]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-landing[1]/clr-main-container[1]/div[2]/app-users-listing[1]/div[1]/clr-datagrid[1]/div[1]/div[1]/div[1]/div[1]/div[1]/clr-dg-row[1]/div[1]/div[2]/div[1]/clr-dg-cell[5]/button[1]")).click();
				
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test_firstname10");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='width-limiter fixed-footer aligned right']//button[2]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),('Users'))]")).click();
		
		driver.quit();
				
		
	}

}
