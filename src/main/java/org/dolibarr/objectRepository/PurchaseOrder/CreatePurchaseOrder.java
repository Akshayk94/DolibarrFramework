package org.dolibarr.objectRepository.PurchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePurchaseOrder extends PurchaseOrderDashboard {
    public CreatePurchaseOrder(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@id='select2-socid-container']")
    private WebElement vendorDropDown ;

    public void setVendor( String vendor )
    {
        vendorDropDown.click();
        dropdownSearchBox.sendKeys(vendor);
        dropdownFirstElement.click();
    }

    @FindBy(xpath = "//input[@name='refsupplier']")
    private WebElement refVendorTextFiled ;

    @FindBy(xpath = "//span[@id='select2-cond_reglement_id-container']")
    private WebElement paymetnsTermDropDown;

    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement dropdownSearchBox ;


    @FindBy(xpath = "//span[@class='select2-results']/ul/li[1]")
    private WebElement dropdownFirstElement ;

    public void setPaymentTerms( String paymentTerms )
    {
        paymetnsTermDropDown.click();
        dropdownSearchBox.sendKeys(paymentTerms);
        dropdownFirstElement.click();
    }

    @FindBy(xpath = "//span[@id='select2-selectmode_reglement_id-container']")
    private WebElement paymentMethodDropDown ;

//    method to set the payment method
    public void setPaymentMethod( String paymentMethod )
    {
        paymentMethodDropDown.click();
        dropdownSearchBox.sendKeys(paymentMethod);
        dropdownFirstElement.click();
    }

    @FindBy(xpath = "//input[@id='liv_']")
    private WebElement dateOfDelivery ;

    public void addDateOfDelivery(String date )
    {
        dateOfDelivery.sendKeys(date);
    }


    @FindBy(xpath = "//input[@name='save']")
    private WebElement createDraftBtn ;


    public PurchaseOrder createDraft()
    {
        createDraftBtn.click();
        return new PurchaseOrder(driver) ;
    }

    public PurchaseOrder createDraftPurchaseOrder(Order order) {

        setVendor(order.getVendorName());
        setPaymentTerms(order.getPaymentsTerms());
        setPaymentMethod(order.getPaymentsMethods());
        addDateOfDelivery(order.getDateOfDelivery());
        return createDraft() ;
    }
}
