package org.dolibarr.base;

import org.dolibarr.objectRepository.PurchaseOrder.CommerceDashboard;
import org.dolibarr.objectRepository.PurchaseOrder.MembersDashboard;
import org.dolibarr.objectRepository.PurchaseOrder.ThirdPartyDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        logout.click();
    }
}
