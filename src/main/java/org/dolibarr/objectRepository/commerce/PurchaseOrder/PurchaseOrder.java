package org.dolibarr.objectRepository.commerce.PurchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PurchaseOrder extends PurchaseOrderDashboard {
    public PurchaseOrder(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class='statusref']/span")
    private WebElement purchaseOrderStatus;


    public String getPurchaseOrderStatus(){
        return purchaseOrderStatus.getText() ;
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

    @FindBy(xpath = "//a[normalize-space()='Make order']")
    private WebElement makeOrderBtn ;

    @FindBy(xpath = "//span[@id='select2-methodecommande-container']")
    private WebElement orderMethodDropdown ;

    public void selectOrderMethod(String orderMethod)
    {
        orderMethodDropdown.click();
        dropdownSearchBox.sendKeys(orderMethod);
        dropDownFirstElements.click();
    }

    @FindBy(xpath = "//input[@name='makeorder']")
    private WebElement makeOrderBtn2 ;

    public void makeOrder(String orderMethod)
    {
        makeOrderBtn.click();
        selectOrderMethod(orderMethod);
        makeOrderBtn2.click();
        popupYes.click();

    }

    @FindBy(xpath = "//a[normalize-space()='Classify Received']")
    private WebElement classifyReceivedBtn ;

    @FindBy(xpath = "//span[@id='select2-type-container']")
    private WebElement deliveryDropdown ;


    public void selectDeliveryType(String delivery)
    {
        deliveryDropdown.click();
        dropdownSearchBox.sendKeys(delivery);
        dropDownFirstElements.click();
    }


    @FindBy(xpath = "//input[@name='receive']")
    private WebElement receiveBtn ;

    public void classifyOrderReceived(String delivery)
    {
        classifyReceivedBtn.click();
        selectDeliveryType(delivery );
        receiveBtn.click();

    }

    @FindBy(xpath = "//a[@class='butActionDelete']")
    private WebElement deleteBtn ;

    public void deletePurchaseOrder()
    {
        deleteBtn.click();
        popupYes.click();
    }

}
