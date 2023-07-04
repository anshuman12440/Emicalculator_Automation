package Hackathon;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Driver {
	
	
	public static WebDriver driver;
	@BeforeSuite
	public static WebDriver setDriver() {

        Scanner scan = new Scanner(System.in);
        while(true)
        {
        System.out.println("Enter your choice of browser : Chrome or Edge");
        String str = scan.nextLine();
        if(str.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }
        else if(str.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver= new EdgeDriver();
            return driver;
        }else
        {
            System.out.println("---Wrong Choice---");
            continue;
        
        }
     }
  }
	@BeforeClass
	public static void getURL() {
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
