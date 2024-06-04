package org.dolibarr.salesOrder;

import org.dolibarr.base.BaseTest;
import org.dolibarr.objectRepository.commerce.CommerceDashboard;
import org.dolibarr.objectRepository.commerce.SalesOrder.NewSalesOrderPage;
import org.dolibarr.objectRepository.commerce.SalesOrder.SalesOrderList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dolibarr_SalesOrder_001_Test extends BaseTest {

    @Test(threadPoolSize = 1500)
    public void createDraftSalesOrderTest(){

        CommerceDashboard commerceOrderDashBoard=dashboard.goToCommerceDashboard();
        NewSalesOrderPage newSalesOrderPage=commerceOrderDashBoard.clickNewSalesOrder();

        newSalesOrderPage.enterCustomerRefTextField("CU2405-00105");
        newSalesOrderPage.clickOnThirdParty();
        newSalesOrderPage.enterThirdPartyTextField("123456 ");

        newSalesOrderPage.clickOnCalendarImg();
        newSalesOrderPage.selectPlannedDateYearDropDown();
        newSalesOrderPage.selectPlannedYear("2025","Jan","21");


        newSalesOrderPage.selectAvailableDelay();
        newSalesOrderPage.selectAvailableDelayOption("5 days");

        newSalesOrderPage.selectPaymentTermDropDown();
        newSalesOrderPage.selectPaymentTerm("60 days");

        String title=newSalesOrderPage.createDraftButton();
        title=title.replace(" - Card","");

        newSalesOrderPage.clickOnListLink();

        SalesOrderList salesOrderList=newSalesOrderPage.clickOnListLink();
        salesOrderList.clickOnDraftLink();

        salesOrderList.enterTextIntoTheDraftTextField(title);
        salesOrderList.clickOnSearchButton();

        String getDraftRef=salesOrderList.getDraftRef();

        Assert.assertEquals(getDraftRef,title);
    }

}
