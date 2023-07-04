package Hackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locators extends Driver{
		public static WebElement carLoan() {
			return driver.findElement(By.xpath("//a[text()='Car Loan']"));
		}
		
		public static WebElement loanAmount( ) {
			return driver.findElement(By.id("loanamount"));
		}
		
		public static WebElement loanInterest() {
			return driver.findElement(By.id("loaninterest"));
		}
		
		public static WebElement loanTerm() {
			return driver.findElement(By.id("loanterm"));
		}

		public static List<WebElement> emiAmount( ) {
			return driver.findElements(By.id("emiamount"));
		}
		
		public static List<WebElement> emitotalInterest() {
			return driver.findElements(By.id("emitotalinterest"));
		}
		
		public static List<WebElement> emitotalAmount() {
			return driver.findElements(By.id("emitotalamount"));
		}
		
		public static WebElement emipaymentSummary() {
			return driver.findElement(By.id("emipaymentsummary"));
		}
		
		public static WebElement currentYear() {
			return driver.findElement(By.xpath("//td[@id='year2023']"));
		}
		
		public static List<WebElement> rownoMargin() {
			return driver.findElements(By.xpath("(//tr[@class='row no-margin'])[2]"));
		}
		
		public static WebElement calculators() {
			return driver.findElement(By.xpath("//a[@title='Calculators']"));
		}
		
		public static WebElement homeloanCalculator() {
			return driver.findElement(By.xpath("//a[@title='Home Loan EMI Calculator']"));
		}
		
		public static WebElement noExtras() {
			return driver.findElement(By.xpath("//table[@class='noextras']"));
		}
		
		public static List<WebElement> noExtrass() {
			return driver.findElements(By.xpath("//table[@class='noextras']"));
		}
		
		public static List<WebElement> rowNoMargin() {
			return driver.findElements(By.xpath("(//tr[@class='row no-margin'])[1]"));
		}
		
		public static WebElement loanCalculator() {
			return driver.findElement(By.xpath("//a[@title='Loan Calculator']"));
		}
		
		public static WebElement checkloanAmount() {
			return driver.findElement(By.xpath("//input[@id='loanamount']"));
		}
		
		public static WebElement checkloanamountSlider() {
			return driver.findElement(By.xpath("//div[@id='loanamountslider']"));
		}
		
		public static WebElement checkinterestRate() {
			return driver.findElement(By.xpath("//input[@id='loaninterest']"));
		}
		
		public static WebElement checkinterestrateSlider() {
			return driver.findElement(By.xpath("//div[@id='loaninterestslider']"));
		}
		
		public static WebElement checkloanTenure() {
			return driver.findElement(By.xpath("//input[@id='loanterm']"));
		}
		
		public static WebElement checkloantenureSlider() {
			return driver.findElement(By.xpath("//div[@id='loantermslider']"));
		}
		
		public static WebElement checkfeesCharges() {
			return driver.findElement(By.xpath("//input[@id='loanfees']"));
		}
		
		public static WebElement checkfeeschargesSlider() {
			return driver.findElement(By.xpath("//div[@id='loanfeesslider']"));
		}
		
		public static List<WebElement> changeloantermSteps() {
			return driver.findElements(By.xpath("//div[@id='loantermsteps']"));
		}
		
		public static WebElement loanMonthsButton() {
			return driver.findElement(By.xpath("//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]"));
		}
		
		public static WebElement loanamountCalc() {
			return driver.findElement(By.id("loan-amount-calc"));
		}
		
		public static WebElement checkloanEmi() {
			return driver.findElement(By.xpath("//input[@id='loanemi']"));
		}
		
		public static WebElement checkloanEmiSlider() {
			return driver.findElement(By.xpath("//div[@id='loanemislider']"));
		}
		
		public static WebElement loanYearButton() {
			return driver.findElement(By.xpath("//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[1]"));
		}
		
		public static WebElement loantenureCalc() {
			return driver.findElement(By.id("loan-tenure-calc"));
		}
}


