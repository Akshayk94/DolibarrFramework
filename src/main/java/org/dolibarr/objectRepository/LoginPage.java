package org.dolibarr.objectRepository;

import org.dolibarr.base.BasePage;
import org.dolibarr.objectRepository.home.HomeDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameText;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordText;
    @FindBy(css = "input.button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public HomeDashboard loginToApplication(String username, String password){
        usernameText.sendKeys(username);
        passwordText.sendKeys(password);
        loginButton.click();
        return new HomeDashboard(driver);
    }
    public void goToLoginPage(String url){
        driver.get(url);
    }
}
