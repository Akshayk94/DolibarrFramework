package org.dolibarr.objectRepository;

import org.dolibarr.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesOrderList extends SalesOrderDashBoard {

    @FindBy(xpath = "//div[@class='menu_contenu menu_contenu_commande_list']//a[text()='Draft']")
    WebElement draftLink;

    @FindBy(xpath = "//td[@class='liste_titre']//input[@size='6']")
    WebElement draftRefSearchTextField;

    @FindBy(linkText = "Validated")
    WebElement validateLink;

    @FindBy(linkText = "Delivered")
    WebElement deliveredLink;

    @FindBy(linkText = "Canceled")
    WebElement cancelled;

    @FindBy(xpath = "//span[@class='fas fa-search']")
    WebElement searchButton;

    @FindBy(xpath = "//td[@class='nowraponall']")
    WebElement draftRef;

    public SalesOrderList(WebDriver driver) {
        super(driver);
    }

    public void clickOnDraftLink(){
        draftLink.click();
    }

    public void enterTextIntoTheDraftTextField(String draftRef){
        draftRefSearchTextField.sendKeys(draftRef);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public String getDraftRef(){
       return draftRef.getText();
    }

}
