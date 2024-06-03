package org.dolibarr.objectRepository.commerce.PurchaseOrder;

public class Order {

    private String vendorName ;
    private String refVendorCode ;
    private String paymentsTerms;
    private String paymentsMethods ;
    private String dateOfDelivery;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getRefVendorCode() {
        return refVendorCode;
    }

    public void setRefVendorCode(String refVendorCode) {
        this.refVendorCode = refVendorCode;
    }

    public String getPaymentsTerms() {
        return paymentsTerms;
    }

    public void setPaymentsTerms(String paymentsTerms) {
        this.paymentsTerms = paymentsTerms;
    }

    public String getPaymentsMethods() {
        return paymentsMethods;
    }

    public void setPaymentsMethods(String paymentsMethods) {
        this.paymentsMethods = paymentsMethods;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }


    @Override
    public String toString() {
        return "Order{" +
                "vendorName='" + vendorName + '\'' +
                ", refVendorCode='" + refVendorCode + '\'' +
                ", paymentsTerms='" + paymentsTerms + '\'' +
                ", paymentsMethods='" + paymentsMethods + '\'' +
                ", dateOfDelivery='" + dateOfDelivery + '\'' +
                '}';
    }
}
