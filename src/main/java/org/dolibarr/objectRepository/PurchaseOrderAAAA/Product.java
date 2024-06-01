package org.dolibarr.objectRepository.PurchaseOrderAAAA;

public class Product {

    private String productType ;
    private String productName ;
    private String upNet ;
    private String upINCTax ;
    private String qty ;
    private String  discount ;

    public Product() {
    }

    public Product(String productType, String productName) {
        this.productType = productType;
        this.productName = productName;
        this.upNet ="";
        this.upINCTax = "";
        this.qty = "";
        this.discount = "";
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUpNet() {
        return upNet;
    }

    public void setUpNet(String upNet) {
        this.upNet = upNet;
    }

    public String getUpINCTax() {
        return upINCTax;
    }

    public void setUpINCTax(String upINCTax) {
        this.upINCTax = upINCTax;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType + '\n' +
                ", productName=" + productName + '\n' +
                ", upNet=" + upNet + '\n' +
                ", upINCTax=" + upINCTax + '\n' +
                ", qty=" + qty + '\n' +
                ", discount=" + discount + '\n' +
                '}';
    }
}
