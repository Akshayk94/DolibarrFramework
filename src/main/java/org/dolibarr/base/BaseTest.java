package org.dolibarr.base;

import org.dolibarr.genericUtils.PropertyUtils;
import org.dolibarr.objectRepository.PurchaseOrder.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected PropertyUtils prop;
    @BeforeClass
    public void initializeDriver() throws IOException {
        prop=new PropertyUtils();
        String browser=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getValue("browser");
        driver=switch (browser.toLowerCase()){
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            default -> new FirefoxDriver();
        };
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @BeforeMethod(alwaysRun = true)
    public void launchApplication() throws IOException {
        loginPage=new LoginPage(driver);
        loginPage.goToLoginPage(prop.getValue("url"));
        loginPage.loginToApplication(prop.getValue("username"), prop.getValue("password") );
    }
    @AfterMethod(alwaysRun = true)
    public void logout(){
        loginPage.logout();
    }
    @AfterClass(alwaysRun = true)
    public void terminateBrowser(){
        driver.close();
    }
}
