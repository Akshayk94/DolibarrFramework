package org.dolibarr.objectRepository;

import org.dolibarr.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesOrderDashBoard extends CommerceDashboard {

    @FindBy(linkText = "New order")
    WebElement newOrderListLink;

    @FindBy(xpath = "//div[@class='menu_contenu menu_contenu_commande_list']//a[text()='List']")
    WebElement listLink;



    public SalesOrderDashBoard(WebDriver driver) {
        super(driver);
    }

    public SalesOrderList clickOnSalesOrderList(){
        salesOrderListLink.click();
        return new SalesOrderList(driver);
    }



}
