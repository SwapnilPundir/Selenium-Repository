package Automation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Carwale {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32(version80)\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://www.carwale.com");
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			
			FileOutputStream file= new FileOutputStream("D:\\Selenium\\Selenium automation data\\Carwale\\Carwale Data.xlsx");
			XSSFWorkbook wb =new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("Hyundai Creta");
			XSSFRow header = sheet.createRow(0);
			header.createCell(0).setCellValue("Variant");
			header.createCell(1).setCellValue("Vehicle's Price");
			
			XSSFSheet sheet1 = wb.createSheet("MS Brezza");
			XSSFRow header1 = sheet1.createRow(0);
			header1.createCell(0).setCellValue("Variant");
			header1.createCell(1).setCellValue("Vehicle's Price");

			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//div[@class='top-nav-label js-main-nav-label']"))).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='js-main-nav-submenu'][contains(text(),'Find New Cars')]")).click();
			
			
			driver.findElement(By.xpath("//h3[contains(text(),'Body Type')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Best SUV')]")).click();
			driver.findElement(By.xpath("//span[@class='hatchback-make hatchback-model'][contains(text(),'Hyundai Creta')]")).click();
			
			String Xpath1 = "//*[@id='divModelDesc']/div[2]/div[1]/div/div[2]/ul/li[";
			String Xpath2 = "]/div";
			
			for(int i=1; i <= 14; i++)
			{
				driver.findElement(By.xpath("//*[@id=\"divModelDesc\"]/div[2]/div[1]/div/div[1]/div")).click();
				Thread.sleep(2000);
				String finalXpath = Xpath1+i+Xpath2;
				
				String ModelVariant = driver.findElement(By.xpath(finalXpath)).getText();							
				XSSFRow variants = sheet.createRow(i);				
				variants.createCell(0).setCellValue(ModelVariant);
				driver.findElement(By.xpath(finalXpath)).click();
				String VariantAmout = driver.findElement(By.xpath("//span[@class='font24 text-black margin-right5 selected-version__price']")).getText();
				variants.createCell(1).setCellValue(VariantAmout);
				
			}
			
			driver.navigate().back();
			driver.findElement(By.xpath("//span[contains(text(),'Maruti Suzuki Vitara Brezza')]")).click();
			
			String Xpath3 = "//*[@id='divModelDesc']/div[2]/div[1]/div/div[2]/ul/li[";
			String Xpath4 = "]/div";
			
			for(int i=1; i <= 9; i++)
			{
				driver.findElement(By.xpath("//*[@id='divModelDesc']/div[2]/div[1]/div/div[1]")).click();
				Thread.sleep(2000);
				String finalXpath1 = Xpath3+i+Xpath4;
				String ModelVariant1 = driver.findElement(By.xpath(finalXpath1)).getText();
				XSSFRow variants1 = sheet1.createRow(i);				
				variants1.createCell(0).setCellValue(ModelVariant1);
				driver.findElement(By.xpath(finalXpath1)).click();			
				String VariantAmout1 = driver.findElement(By.xpath("//span[@class='font24 text-black margin-right5 selected-version__price']")).getText();
				variants1.createCell(1).setCellValue(VariantAmout1);
			}
			
			driver.navigate().to("https://www.carwale.com");
			Thread.sleep(2000);
			
			wb.write(file);
			file.close();
			driver.quit();
			System.out.println("Exectuion completed");

	}
}
