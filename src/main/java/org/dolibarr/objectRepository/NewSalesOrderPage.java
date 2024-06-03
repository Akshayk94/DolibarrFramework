package org.dolibarr.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewSalesOrderPage extends SalesOrderDashBoard{

    @FindBy(css = "[name='ref_client']")
    WebElement customerRefTextField;

    @FindBy(id="select2-socid-container")
    WebElement thirdPartyTextField;

    By thirdPartyOption;

    @FindBy(css = "input[id='liv_']+img[class='ui-datepicker-trigger']")
    WebElement plannedDateOfDeliveryCalendarImg;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    WebElement plannedDateYearDropDown;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    WebElement plannedDateMonthDropDown;

    By plannedDateDate;

    By plannedDateYear;

    @FindBy(id="select2-availability_id-container")
    WebElement availableDelayTextField;

    By availableDelayOption;

    @FindBy(id = "select2-cond_reglement_id-container")
    WebElement paymentTermDropDown;

    By paymentTermOption;

    @FindBy(id="#select2-selectmode_reglement_id-container")
    WebElement paymentMethodDropDown;

    By paymentOption;

    @FindBy(css = "input[value='Create draft']")
    WebElement createDraftButton;

    @FindBy(xpath = "//div[@class='menu_contenu menu_contenu_commande_list']//a[text()='List']")
    WebElement salesOrderList;

    public NewSalesOrderPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerRefTextField(String customerRef){
        customerRefTextField.sendKeys(customerRef);
    }

    public void clickOnThirdParty(){
        thirdPartyTextField.click();
    }

    public void enterThirdPartyTextField(String thirdParty){
       thirdPartyOption=By.xpath("//span[@class='select2-dropdown ui-dialog select2-dropdown--below']//li[text()='"+thirdParty+"']");
       driver.findElement(thirdPartyOption).click();
    }

    public void clickOnCalendarImg(){
        plannedDateOfDeliveryCalendarImg.click();
    }

    public void selectPlannedDateYearDropDown(){
        plannedDateYearDropDown.click();
    }

    public void selectPlannedYear(String year){
        //Ex. year=2025 then 2025-1924=101 but 2025 is present at 102 index so +1
        plannedDateYear=By.xpath("//select[@class='ui-datepicker-year']//option");
        List<WebElement> years=driver.findElements(plannedDateYear);
        int actualYear=Integer.parseInt(year);
        actualYear=((actualYear-1924));
        years.get(actualYear).click();
    }

    public void selectPlannedDateMonthDropDown(){
        plannedDateMonthDropDown.click();
    }

    public void selectPlannedDateMonth(String month){
        Select select=new Select(plannedDateMonthDropDown);
        select.selectByVisibleText(month);
    }

    public void selectPlannedDate(String date){
        plannedDateDate=By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a[text()='"+date+"']");
        driver.findElement(plannedDateDate).click();
    }

    public void selectAvailableDelay(){
        availableDelayTextField.click();
    }

    public void selectAvailableDelayOption(String delay){
       availableDelayOption=By.xpath("//span[@class='select2-dropdown ui-dialog select2-dropdown--below']//li[text()='"+delay+"']");
       driver.findElement(availableDelayOption).click();
    }

    public void selectPaymentTermDropDown(){
        paymentTermDropDown.click();
    }

    public void selectPaymentTerm(String paymentTerm){
       paymentTermOption=By.xpath("//span[@class=\"select2-dropdown ui-dialog select2-dropdown--below\"]//li[text()='"+paymentTerm+"']");
       driver.findElement(paymentTermOption).click();
    }

    public void selectPaymentDropDown(){
        paymentMethodDropDown.click();
    }

    public void selectPaymentMethod(String paymentMethod){
        paymentOption=By.xpath("//span[@class='select2-dropdown ui-dialog select2-dropdown--above']//li[text()='"+paymentMethod+"']");
        driver.findElement(paymentOption).click();
    }

    public String createDraftButton(){
        createDraftButton.click();
       return driver.getTitle();
    }

    public SalesOrderList clickOnListLink(){
        salesOrderList.click();
        return new SalesOrderList(driver);
    }
}
