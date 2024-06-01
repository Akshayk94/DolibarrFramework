package org.dolibarr.objectRepository.PurchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PurchaseOrderList extends CommerceDashboard {
    public PurchaseOrderList(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@class='fa fa-plus-circle valignmiddle btnTitle-icon']")
    private WebElement newOrderBtn ;

    @FindBy(xpath = "//input[@name='search_ref']")
    private WebElement refSearchField ;

    @FindBy(xpath = "//span[@class='fas fa-search']")
    private WebElement searchIcon ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td/a")
    private WebElement refText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[2]")
    private WebElement refOrderVendorText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[3]/a")
    private WebElement thirdPartyText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[4]")
    private WebElement cityText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[5]")
    private WebElement zipCodeText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[6]")
    private WebElement orderDateText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[7]")
    private WebElement deliveryDateText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[11]/span")
    private WebElement statusText ;

    @FindBy(xpath = "//tbody/tr[@class='oddeven']/td[12]/input")
    private WebElement purchaseOrderCheckBox ;

    @FindBy(xpath = "//span[@id='select2-massaction-container']")
    private WebElement selectActionContainer ;

    @FindBy(xpath = "//span[@class='select2-results']//li[text()='Delete']")
    private WebElement deleteOption ;

    @FindBy(xpath = "//input[@name='confirmmassaction']")
    private WebElement confirmBtn ;

    @FindBy(xpath = "//select[@id='confirm']")
    private WebElement confirmationDropDown ;

    @FindBy(xpath = "//input[@value='Validate']")
    private WebElement validateBtn ;

    public void selectPurchaseOrder()
    {
        purchaseOrderCheckBox.click();
    }

    public CreatePurchaseOrder goToAddPurchaseOrder()
    {
         newOrderBtn.click();
         return new CreatePurchaseOrder(driver) ;
    }

    public void deletePurchaseOrder()
    {
        purchaseOrderCheckBox.click();
        selectActionContainer.click();
        deleteOption.click();
        confirmBtn.click();
        Select sel = new Select(confirmationDropDown);
        sel.selectByValue("yes");
        validateBtn.click();
    }

    public PurchaseOrder searchPurchaseOrder(String purchaseOrderName )
    {
        refSearchField.sendKeys(purchaseOrderName);
        searchIcon.click();
        refText.click();
        return new PurchaseOrder(driver);
    }
}
