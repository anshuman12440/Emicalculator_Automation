package Hackathon;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
 


public class Main extends Driver{
	
	@Test(priority=1)
	public void carLoan() {
		Locators.carLoan().click();
	}
	
	@Test(priority=2)
	public void loanAmount() throws InterruptedException {
		Locators.loanAmount().clear();
		Locators.loanAmount().sendKeys("15,00,000");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void loanInterest() throws InterruptedException {
		Locators.loanInterest().clear();
		Locators.loanInterest().sendKeys(".5");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void loanTerm() throws InterruptedException {
		Locators.loanTerm().clear();
		Locators.loanTerm().sendKeys("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//Thread.sleep(2000);
	}	
	
	@Test(priority=5)
	public void printTotal() throws InterruptedException {
	System.out.println("---Total Loan EMI, Total Interest Payable and Total Payment(Principal + Interest)---");
	List<WebElement> emi= Locators.emiAmount();
	List<WebElement> interest= Locators.emitotalInterest();
	List<WebElement> total= Locators.emitotalAmount();
	for(WebElement e:emi)
	{
		System.out.println(e.getText());
	}
	for(WebElement e:interest)
	{
		System.out.println(e.getText());
	}
	for(WebElement e:total)
	{
		System.out.println(e.getText());
	}
	Actions action = new Actions(driver);
	action.scrollToElement(Locators.emipaymentSummary())
	.perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	//Thread.sleep(2000);
	}
	
	@Test(priority=6)
	public void printforOneMonth() throws InterruptedException {
		//Display the Loan EMI, Total Interest Payable and Total Payment(Principal + Interest) for a month for year 2023
		System.out.println("\n---For one Month---");
		WebElement element = Locators.currentYear();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
		element.click();
		
		System.out.println("Month Principal Interest Total Payment Balance LoanPaidtoDate");
		List<WebElement> month= Locators.rownoMargin();
		for(WebElement e:month)
		{
			System.out.println(e.getText());
		}
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.id("ecalprintandsharetext")))
		.perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//Thread.sleep(2000);
	}
	
	//Description-2: From Menu, pick Home Loan EMI Calculator, fill relevant details & extract all the data from  year on year table & store in excel.
	@Test(priority=7)
	public void chooseEMICalculators() throws IOException {
		
		FileInputStream fin2=new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Desktop\\HackathonProject\\write.xlsx");	
		XSSFWorkbook w1 = new XSSFWorkbook(fin2);
		XSSFSheet s1=w1.getSheet("Sheet1");		
		FileOutputStream fout= new FileOutputStream("C:\\Users\\Lenovo\\OneDrive\\Desktop\\HackathonProject\\write.xlsx");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.manage().deleteAllCookies();
		Locators.calculators().click();
		Locators.homeloanCalculator().click();
		Actions action = new Actions(driver);
		action.moveToElement(Locators.noExtras()).perform();
		List<WebElement> table= Locators.noExtrass();
		for(WebElement t:table)
		{
			System.out.println(t.getText());
		}
		
		List<WebElement> head = Locators.rownoMargin();
		XSSFRow r=s1.createRow(0);
		int x=0;
		for(WebElement h:head)
		{
			XSSFCell c=r.createCell(x++); 
			c.setCellValue(h.getText());
		}
		
		int j=0,row=1;
		for(int i=1;i<22;i++) {
		XSSFRow r1=s1.createRow(row++);		
		List<WebElement> data = driver.findElements(By.xpath("(//tr[@class='row no-margin yearlypaymentdetails'])["+i+"]")); 
		for(WebElement d:data) {
			XSSFCell c7=r1.createCell(j++);
			c7.setCellValue(d.getText());
		}
			j=0;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		w1.write(fout);
		
	}
	
	//Description-3: Click Calculators menu and goto Loan Calculator
	@Test(priority=8)
	public void chooseLoanCalculator() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Locators.calculators().click();
		Locators.loanCalculator().click();
	}	
	
	//Move to LOAN AMOUNT CALCULATOR
	@Test(priority=12)
	public void movetoloanamountCalculator() {
		Locators.loanamountCalc().click();
	}
	
	//move to LOAN TENURE CALCULATOR
	@Test(priority=16)
	public void movetoloantenureCalculator() {
		Locators.loantenureCalc().click();
	}
	
	@Test(priority=9)
	public void EmicalculatortextBox() {
		 WebElement searchloanTextBox = Locators.checkloanAmount();
		 WebElement searchinterestTextBox=Locators.checkinterestRate();
		 WebElement searchtenureTextBox=Locators.checkloanTenure();
		 WebElement searchfeeschargesTextBox = Locators.checkfeesCharges();
		 
		 if(searchloanTextBox.isEnabled() && searchloanTextBox.isDisplayed()) {
				System.out.println("Loan textbox is fully functioning ");
			}
			else {
				System.out.println("Loan textbox is not fully functioning");
			}
		 System.out.println("--------------------------------------------------------");
		 
		 if(searchinterestTextBox.isDisplayed() && searchinterestTextBox.isEnabled()) {
				System.out.println("Interest textbox is fully functioning");
			}
			else {
				System.out.println("Interest textbox isv not fully functioning");
			}
		 System.out.println("--------------------------------------------------------");
		 if (searchtenureTextBox.isDisplayed() && searchtenureTextBox.isEnabled()) {
				System.out.println("Tenure textbox is fully functioning");
			}
			else {
				System.out.println("Tenure textbox is not fully functioning");
			}
		 System.out.println("--------------------------------------------------------");
		 if (searchfeeschargesTextBox.isDisplayed() && searchfeeschargesTextBox.isEnabled()) {
				System.out.println("Fees&Charges textbox is fully functioning");
			}
			else {
				System.out.println("Fees&Charges textbox is not fully functioning");
			}
	}
	
	@Test(priority=10)
	public void Emicalculatorslider() throws InterruptedException {
		   WebElement slider = Locators.checkloanamountSlider();
		   Actions move = new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action = (Action) move.dragAndDropBy(slider, 30, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action.perform();
		   System.out.println("\nLoan slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   System.out.println("--------------------------------------------------------");
		   WebElement sliders = Locators.checkinterestrateSlider();
		   Actions moves= new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action1= (Action) moves.dragAndDropBy(sliders, 20, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action1.perform();
		   System.out.println("Interest slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   System.out.println("--------------------------------------------------------");
		   WebElement slider2= Locators.checkloantenureSlider();
		   Actions move2= new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action2= (Action) move2.dragAndDropBy(slider2, 10, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action2.perform();
		   System.out.println("Tenure slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   System.out.println("--------------------------------------------------------");
		   WebElement slider3= Locators.checkfeeschargesSlider();
		   Actions move3= new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action3= (Action) move3.dragAndDropBy(slider3, 15, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action3.perform();
		   System.out.println("Fees&Charges slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
	}
	
	@Test(priority=11)
	public void changemonthyearforEMICALCULATOR() throws InterruptedException {
		//change the Loan tenure for year & month,check the change in scale
		//Print the Scale in Year.
		List<WebElement> year = Locators.changeloantermSteps();
		System.out.println("\n---------Scale for year------------");
		for(WebElement y:year)
		{
			System.out.print(y.getText()+" ");
		}
		//Click on Month button.
		Locators.loanMonthsButton().click();
		System.out.println("\n---Scale for month---");
		List<WebElement> month1=Locators.changeloantermSteps();
		for(WebElement m:month1)
		{
			System.out.print(m.getText()+" ");
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(1000);
	}
	
	//LoanamountCalculator UI Validation
	@Test(priority=13)
	public void loanamountCalculatortextBox() {
		 WebElement searchloanTextBox = Locators.checkloanEmi();
		 WebElement searchinterestTextBox=Locators.checkinterestRate();
		 WebElement searchtenureTextBox=Locators.checkloanTenure();
		 WebElement searchfeeschargesTextBox = Locators.checkfeesCharges();
		 
		 if(searchloanTextBox.isEnabled() && searchloanTextBox.isDisplayed()) {
				System.out.println("\nEMI textbox is fully functioning ");
			}
			else {
				System.out.println("EMI textbox is not fully functioning");
			}
		 System.out.println("--------------------------------------------------------");
		 
		 if(searchinterestTextBox.isDisplayed() && searchinterestTextBox.isEnabled()) {
				System.out.println("InterestRate textbox is fully functioning");
			}
			else {
				System.out.println("Interestrate textbox is not fully functioning");
			}
		 System.out.println("--------------------------------------------------------");
		 if (searchtenureTextBox.isDisplayed() && searchtenureTextBox.isEnabled()) {
				System.out.println("LoanTenure textbox is fully functioning");
			}
			else {
				System.out.println("LoanTenure textbox is not fully functioning");
			}
		 System.out.println("--------------------------------------------------------");
		 if (searchfeeschargesTextBox.isDisplayed() && searchfeeschargesTextBox.isEnabled()) {
				System.out.println("Fees&Charges textbox is fully functioning");
			}
			else {
				System.out.println("Fees&Charges textbox is not fully functioning");
			}
	}
	
	@Test(priority=14)
	public void loanamountCalculatorslider() throws InterruptedException {
		   WebElement slider = Locators.checkloanEmiSlider();
		   Actions move = new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action = (Action) move.dragAndDropBy(slider, 35, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action.perform();
		   System.out.println("\nEMI slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   System.out.println("--------------------------------------------------------");
		   WebElement sliders = Locators.checkinterestrateSlider();
		   Actions moves= new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action1= (Action) moves.dragAndDropBy(sliders, 25, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action1.perform();
		   System.out.println("InterestRate slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   System.out.println("--------------------------------------------------------");
		   WebElement slider2= Locators.checkloantenureSlider();
		   Actions move2= new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action2= (Action) move2.dragAndDropBy(slider2, 20, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action2.perform();
		   System.out.println("Loan Tenure slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   System.out.println("--------------------------------------------------------");
		   WebElement slider3= Locators.checkfeeschargesSlider();
		   Actions move3= new Actions(driver);
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   Action action3= (Action) move3.dragAndDropBy(slider3, 20, 0).build();
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
		   action3.perform();
		   System.out.println("Fees&Charges slider is working properly");
		   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		   Thread.sleep(1000);
	}
	
	@Test(priority=15)
	public void changemonthyearforLOANAMOUNTCALCULATOR() throws InterruptedException {
		//change the Loan tenure for year & month,check the change in scale
		
		//Print the scale in Month .
		System.out.println("\n---Scale for month---");
		List<WebElement> month1=Locators.changeloantermSteps();
		for(WebElement m:month1)
		{
			System.out.print(m.getText()+" ");
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Thread.sleep(1000);
		
		//Click on Year button.
		Locators.loanYearButton().click();
		List<WebElement> year = Locators.changeloantermSteps();
		System.out.println("\n---------Scale for year------------");
		for(WebElement y:year)
		{
			System.out.print(y.getText()+" ");
		}
		
	}
	
	//LoantenureCalculator UI Validation
	@Test(priority=17)
	public void loantenureCalculatortextBox() {
			 WebElement searchloanTextBox = Locators.checkloanAmount();
			 WebElement searchinterestTextBox=Locators.checkloanEmi();
			 WebElement searchtenureTextBox=Locators.checkinterestRate();
			 WebElement searchfeeschargesTextBox = Locators.checkfeesCharges();
			 
			 if(searchloanTextBox.isEnabled() && searchloanTextBox.isDisplayed()) {
					System.out.println("\nLoan Amount textbox is fully functioning ");
				}
				else {
					System.out.println("Loan Amount textbox is not fully functioning");
				}
			 System.out.println("--------------------------------------------------------");
			 
			 if(searchinterestTextBox.isDisplayed() && searchinterestTextBox.isEnabled()) {
					System.out.println("EMI textbox is fully functioning");
				}
				else {
					System.out.println("EMI textbox is not fully functioning");
				}
			 System.out.println("--------------------------------------------------------");
			 if (searchtenureTextBox.isDisplayed() && searchtenureTextBox.isEnabled()) {
					System.out.println("InterestRate textbox is fully functioning");
				}
				else {
					System.out.println("InterestRate textbox is not fully functioning");
				}
			 System.out.println("--------------------------------------------------------");
			 if (searchfeeschargesTextBox.isDisplayed() && searchfeeschargesTextBox.isEnabled()) {
					System.out.println("Fees&Charges textbox is fully functioning");
				}
				else {
					System.out.println("Fees&Charges textbox is not fully functioning");
				}
		}
		
	
	@Test(priority=18)
		public void loantenureCalculatorslider() throws InterruptedException {
			   WebElement slider = Locators.checkloanamountSlider();
			   Actions move = new Actions(driver);
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   Action action = (Action) move.dragAndDropBy(slider, 40, 0).build();
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   action.perform();
			   System.out.println("\nLoan Amount slider is working properly");
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   System.out.println("--------------------------------------------------------");
			   WebElement sliders = Locators.checkloanEmiSlider();
			   Actions moves= new Actions(driver);
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   Action action1= (Action) moves.dragAndDropBy(sliders, 7, 0).build();
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   action1.perform();
			   System.out.println("EMI slider is working properly");
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   System.out.println("--------------------------------------------------------");
			   WebElement slider2= Locators.checkinterestrateSlider();
			   Actions move2= new Actions(driver);
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   Action action2= (Action) move2.dragAndDropBy(slider2, -100, 20).build();
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   action2.perform();
			   System.out.println("InterestRate slider is working properly");
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   System.out.println("--------------------------------------------------------");
			   WebElement slider3= Locators.checkfeeschargesSlider();
			   Actions move3= new Actions(driver);
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   Action action3= (Action) move3.dragAndDropBy(slider3, 22, 0).build();
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
			   action3.perform();
			   System.out.println("Fees&Charges slider is working properly");
			   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			   Thread.sleep(1000);
		}
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Main obj = new Main();
		setDriver();
		getURL();
		
		obj.carLoan();
		obj.loanAmount();
		obj.loanInterest();
		obj.loanTerm();
		obj.printTotal();
		obj.printforOneMonth();
		obj.chooseEMICalculators();
		obj.chooseLoanCalculator();
		obj.EmicalculatortextBox();
		obj.Emicalculatorslider();
		obj.changemonthyearforEMICALCULATOR();
		
		obj.movetoloanamountCalculator();
		obj.loanamountCalculatortextBox();
		obj.loanamountCalculatorslider();
		obj.changemonthyearforLOANAMOUNTCALCULATOR();
		
		obj.movetoloantenureCalculator();
		obj.loantenureCalculatortextBox();
		obj.loantenureCalculatorslider();
				
		closeBrowser();
	}
}

