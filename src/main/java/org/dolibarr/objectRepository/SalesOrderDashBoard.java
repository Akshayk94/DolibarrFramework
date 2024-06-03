package org.dolibarr.objectRepository;

import org.dolibarr.base.BasePage;
import org.dolibarr.objectRepository.commerce.CommerceDashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class SalesOrderDashBoard extends CommerceDashboard {

    @FindBy(linkText = "New order")
    WebElement newOrderListLink;

    @FindBy(xpath = "//div[@class='menu_contenu menu_contenu_commande_list']//a[text()='List']")
    WebElement listLink;



    public SalesOrderDashBoard(WebDriver driver) {
        super(driver);
    }

    public SalesOrderList clickOnSalesOrderList(){
        WebElement salesOrderListLink = driver.findElement(By.xpath(""));
        salesOrderListLink.click();
        return new SalesOrderList(driver);
    }



}
