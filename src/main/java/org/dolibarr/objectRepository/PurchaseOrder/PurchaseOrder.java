package org.dolibarr.objectRepository.PurchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchaseOrder extends PurchaseOrderDashboard {
    public PurchaseOrder(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@title='Set Payment Terms']")
    private WebElement editPaymentTermsIcon ;

    @FindBy(xpath = "//span[@id='select2-cond_reglement_id-container']")
    private WebElement paymentTermDropdown ;

    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement dropdownSearchBox ;

    @FindBy(xpath = "//span[@class='select2-results']/ul/li[1]")
    private WebElement dropDownFirstElements ;

    @FindBy(xpath = "//input[@value='Modify']")
    private WebElement modifyBtn ;

    public void setPaymentTerms(String paymentTerms)
    {
        editPaymentTermsIcon.click();
        paymentTermDropdown.click();
        dropdownSearchBox.sendKeys(paymentTerms);
        dropDownFirstElements.click();
        modifyBtn.click();
    }

    @FindBy(xpath = "//span[@title='Set Payment Type']")
    private WebElement editPaymentMethodIcon;

    @FindBy(xpath = "//span[@id='select2-selectmode_reglement_id-container']")
    private WebElement paymentMethodDropdown ;

    public void setEditPaymentMethod(String paymentMethod)
    {
        editPaymentMethodIcon.click();
        paymentMethodDropdown.click();
        dropdownSearchBox.sendKeys(paymentMethod);
        dropDownFirstElements.click();
        modifyBtn.click();
    }

    @FindBy(xpath = "//span[@title='Set shipping date']")
    private WebElement editDateOfDeliveryIcon ;

    @FindBy(xpath = "//input[@id='liv_']")
    private WebElement dateOfDelivery ;

    public void setDateOfDelivery(String date ){
        editDateOfDeliveryIcon.click();
        dateOfDelivery.sendKeys(date);
        modifyBtn.click();
    }

    @FindBy(xpath = "//a[normalize-space()='Back to list']")
    private WebElement backToListText;

    @FindBy(xpath = "//a[@class='butActionDelete']")
    private WebElement deleteBtn ;

    @FindBy(xpath = "//span[@id='select2-select_type-container']")
    private WebElement freeTextItemTypeDropdown;

    public void setFreeTextItemType(String type )
    {
        freeTextItemTypeDropdown.click();
        dropdownSearchBox.sendKeys(type);
        dropDownFirstElements.click();
    }

    @FindBy(xpath = "//textarea[@id='dp_desc']")
    private WebElement productTextarea;

    @FindBy(xpath = "//input[@id='price_ht']")
    private WebElement upNetTextField ;

    @FindBy(xpath = "//input[@id='price_ttc']")
    private WebElement upINCTaxTextField ;

    @FindBy(xpath = "//input[@id='qty']")
    private WebElement qtyTextField ;

    @FindBy(xpath = "//input[@id='remise_percent']")
    private WebElement discountTextField ;

    @FindBy(xpath = "//input[@id='addline']")
    private WebElement addBtn ;

//    method to add item in lineitem
    public void addLineItem(List<Product> productList)
    {
        for(Product product : productList) {

            setFreeTextItemType(product.getProductType());
            productTextarea.sendKeys(product.getProductName());
            upNetTextField.sendKeys(product.getUpNet());
            upINCTaxTextField.sendKeys(product.getUpINCTax());
            qtyTextField.sendKeys(product.getQty());
            discountTextField.sendKeys(product.getDiscount());
            addBtn.click();
        }
    }

    @FindBy(xpath = "//a[normalize-space()='Validate and Approve']")
    private WebElement validateAndApproveBtn ;

    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']/button[text()='Yes']")
    private WebElement popupYes ;

    public void validatePurchaseOrder(List<Product> productList)
    {
        addLineItem(productList);
        validateAndApproveBtn.click();
        popupYes.click();
    }

}
