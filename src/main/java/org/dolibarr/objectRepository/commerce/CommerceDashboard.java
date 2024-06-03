package org.dolibarr.objectRepository.commerce;

import org.dolibarr.base.BasePage;
import org.dolibarr.objectRepository.*;
import org.dolibarr.objectRepository.commerce.PurchaseOrder.PurchaseOrderDashboard;
import org.dolibarr.objectRepository.commerce.PurchaseOrder.PurchaseOrderList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommerceDashboard extends BasePage {

    @FindBy(xpath = "//a[text()='Sales Orders']")
    WebElement salesOrderLink;

    @FindBy(linkText = "List")
    WebElement salesOrderListLink;

    @FindBy(linkText = "New order")
    WebElement newSalesOrderLink;

    public CommerceDashboard(WebDriver driver) {
        super(driver);
    }

    public SalesOrderDashBoard clickOnSalesOrder(){
        salesOrderLink.click();
        return new SalesOrderDashBoard(driver);
    }

    public SalesOrderList clickOnSalesOrderList(){
        salesOrderListLink.click();
        return new SalesOrderList(driver);
    }

    public NewSalesOrderPage clickNewSalesOrder(){
        newSalesOrderLink.click();
        return new NewSalesOrderPage(driver);
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
