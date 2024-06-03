package org.dolibarr.base;

import org.dolibarr.objectRepository.commerce.CommerceDashboard;
import org.dolibarr.objectRepository.commerce.PurchaseOrder.MembersDashboard;
import org.dolibarr.objectRepository.thirdParty.ThirdPartyDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    @FindBy(xpath = "//span[@class='fas fa-home fa-fw']")
    WebElement home;
    @FindBy(xpath = "//span[contains(@class,'fas fa-user-alt')]")
    WebElement members;
    @FindBy(xpath = "//span[contains(@class,'fas fa-building')]")
    WebElement thirdParty;
    @FindBy(xpath = "//span[contains(@class,'fas fa-suitcase')]")
    WebElement commerce;
    @FindBy(xpath = "//img[contains(@class,'photo userphoto')]")
    WebElement adminProfile;
    @FindBy(xpath = "//span[text()='Logout']")
    WebElement logout;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MembersDashboard goToMembersDashboard(){
        members.click();
        return new MembersDashboard(driver);
    }
    public ThirdPartyDashboard goToThirdPartyDashboard(){
        thirdParty.click();
        return new ThirdPartyDashboard(driver);
    }
    public CommerceDashboard goToCommerceDashboard(){
        commerce.click();
        return new CommerceDashboard(driver);
    }
    public void logout(){
        adminProfile.click();
        waitForWebElementToAppear(logout);
        logout.click();
    }
    public void waitForWebElementToAppear(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
