package org.dolibarr.objectRepository.PurchaseOrderAAAA;

import org.dolibarr.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommerceDashboard extends BasePage {
    public CommerceDashboard(WebDriver driver) {
        super(driver);
    }




    @FindBy(xpath = "//a[@title='Purchase orders']")
    private WebElement purchaseOrderDashboard ;

    @FindBy(xpath = "//a[@href='/dolibarr/fourn/commande/list.php?leftmenu=orders_suppliers']")
    private WebElement purchaseOrderList ;


    public PurchaseOrderDashboard goToPurchaseOrderDashboard()
    {
        purchaseOrderDashboard.click();
        return new PurchaseOrderDashboard(driver);
    }

    public PurchaseOrderList goToPurchaseOrderList()
    {
        purchaseOrderList.click();
        return new PurchaseOrderList(driver);
    }

}
