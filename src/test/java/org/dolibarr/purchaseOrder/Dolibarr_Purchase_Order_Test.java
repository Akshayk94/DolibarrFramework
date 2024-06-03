package org.dolibarr.purchaseOrder;

import org.dolibarr.base.BaseTest;
import org.dolibarr.objectRepository.commerce.CommerceDashboard;
import org.dolibarr.objectRepository.commerce.PurchaseOrder.*;
import org.testng.Assert;
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
        PurchaseOrder purchaseOrder = createPurchaseOrder.createDraftPurchaseOrder(ord);

        Assert.assertEquals( purchaseOrder.getPurchaseOrderStatus()  , "Draft (needs to be validated)");

    }


//    .............................................................................................................................................................................

    @Test
    public void updatePurchaseOrder()
    {
//        navigate to commerce dashboard
        CommerceDashboard commerceDashboard = dashboard.goToCommerceDashboard();
//        navigate to purchase order list
        PurchaseOrderList purchaseOrderList = commerceDashboard.goToPurchaseOrderList() ;
//        search purchase order and goto purchase order
        PurchaseOrder purchaseOrder =  purchaseOrderList.searchPurchaseOrder("(PROV25)");

        purchaseOrder.setPaymentTerms("");
        purchaseOrder.setDateOfDelivery("");
        purchaseOrder.setEditPaymentMethod("");

    }


//    .............................................................................................................................................................................



/*
    this method is used validate the purchase Order
    ,it is first searched from the list of purchase order
    , then added the products in it and validated
*/
    @Test
    public void  validatePurchaseOrder()
    {
//        navigate to commerce dashboard
        CommerceDashboard commerceDashboard = dashboard.goToCommerceDashboard();
//        navigate to purchase order list
        PurchaseOrderList purchaseOrderList = commerceDashboard.goToPurchaseOrderList() ;
//        search purchase order and goto purchase order
        PurchaseOrder purchaseOrder =  purchaseOrderList.searchPurchaseOrder("(PROV25)");

//       storing multiple products in listr
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product("Product" , "Product 1") ;
        Product p2 = new Product("Product" , "Product 2") ;
        Product p3 = new Product("Product" , "Product 3") ;
        productList.add(p1);
        productList.add(p2);
        productList.add(p3) ;

//      validating purchase order
         purchaseOrder.validatePurchaseOrder(productList);
        Assert.assertEquals( purchaseOrder.getPurchaseOrderStatus()  , "Approved");
    }


//    .............................................................................................................................................................................


    /*
    this method is to place order
    after validating a draft purchase order, it is converted into order
 */
    public void makeOrder()
    {
//        navigate to commerce dashboard
        CommerceDashboard commerceDashboard = dashboard.goToCommerceDashboard();
//        navigate to purchase order list
        PurchaseOrderList purchaseOrderList = commerceDashboard.goToPurchaseOrderList() ;
//        search purchase order and goto purchase order
        PurchaseOrder purchaseOrder =  purchaseOrderList.searchPurchaseOrder("(PROV25)");

        purchaseOrder.makeOrder("Email");
        Assert.assertEquals( purchaseOrder.getPurchaseOrderStatus()  , "Ordered - Standby reception");

    }

//    .............................................................................................................................................................................

/*
    this method is used to classify order
    after placing order, we have to classify order
 */

    public void classifyOrder()
    {
//        navigate to commerce dashboard
        CommerceDashboard commerceDashboard = dashboard.goToCommerceDashboard();
//        navigate to purchase order list
        PurchaseOrderList purchaseOrderList = commerceDashboard.goToPurchaseOrderList() ;
//        search purchase order and goto purchase order
        PurchaseOrder purchaseOrder =  purchaseOrderList.searchPurchaseOrder("(PROV25)");
        String delivery = "";
        purchaseOrder.classifyOrderReceived(delivery);
        Assert.assertTrue( purchaseOrder.getPurchaseOrderStatus().contains(delivery));

    }

//    .............................................................................................................................................................................

/*    this method ic use to
      delete the purchase order
*/
    public void deletePurchaseOrder()
    {
//        navigate to commerce dashboard
        CommerceDashboard commerceDashboard = dashboard.goToCommerceDashboard() ;

//        naviagte to purchase order list
        PurchaseOrderList purchaseOrderList = commerceDashboard.goToPurchaseOrderList() ;

//        search purchase order and goto purchase order
        PurchaseOrder purchaseOrder =  purchaseOrderList.searchPurchaseOrder("(PROV25)") ;

//        delete purchase order
        purchaseOrder.deletePurchaseOrder();

    }

//.............................................................................................................................................................................

}
