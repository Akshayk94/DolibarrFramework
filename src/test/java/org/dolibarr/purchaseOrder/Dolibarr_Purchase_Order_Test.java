package org.dolibarr.purchaseOrder;

import org.dolibarr.base.BaseTest;
import org.dolibarr.objectRepository.PurchaseOrder.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Dolibarr_Purchase_Order_Test extends BaseTest {


    @Test
    public void createNewPurchaseOrder()
    {
//        navigate to commerce dashboard
        CommerceDashboard commerce = dashboard.goToCommerceDashboard();

//        navigate to purchase order list
        PurchaseOrderList purchaseOrderList = commerce.goToPurchaseOrderList() ;

//        navigate to create purchase order page
        CreatePurchaseOrder createPurchaseOrder = purchaseOrderList.goToAddPurchaseOrder() ;
        Order ord = new Order();
        ord.setVendorName("BAJAJ (ALIANCE)");
        ord.setPaymentsTerms("30 days");
        ord.setPaymentsMethods("Cash");
        ord.setDateOfDelivery("06/10/2024");

//        creating a new purchase order as draft
        createPurchaseOrder.createDraftPurchaseOrder(ord);
    }

    @Test
    public void  validatePurchaseOrder()
    {
        CommerceDashboard commerceDashboard = dashboard.goToCommerceDashboard();
         PurchaseOrderList purchaseOrderList = commerceDashboard.goToPurchaseOrderList() ;
         PurchaseOrder purchaseOrder =  purchaseOrderList.searchPurchaseOrder("(PROV26)");

        List<Product> productList = new ArrayList<>();
        Product p1 = new Product("Product" , "Product 1") ;
        Product p2 = new Product("Product" , "Product 2") ;
        Product p3 = new Product("Product" , "Product 3") ;
        productList.add(p1);
        productList.add(p2);
        productList.add(p3) ;

         purchaseOrder.validatePurchaseOrder(productList);
    }

}
