package epack;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {
	WebDriver driver;
	ExtentReports extent;
	@BeforeMethod
	public void configuration() {
String reportpath =	System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
		reporter.config().setReportName("Omayo test Report");
		reporter.config().setDocumentTitle("omayo test report title");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("operating system", "windows 10");
		extent.setSystemInfo("Tested By", "Oyshe");
		}
	@Test
	public void testOne(){
	ExtentTest eTest = extent.createTest("Test One Created");
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    eTest.info("FireFox Browser Lauched");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://omayo.blogspot.com/");
		eTest.info("Navigated to Omayo Home Page");
		eTest.fail("Test One failed");
Assert.assertEquals(driver.findElement(By.id("pah")).getText(), "PractiseAutomationHere");
}
@AfterMethod
public void teardown() {
	driver.close();
	extent.flush();
}
}
