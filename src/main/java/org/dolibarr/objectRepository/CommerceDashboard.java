package org.dolibarr.objectRepository;

import org.dolibarr.base.BasePage;
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

}
