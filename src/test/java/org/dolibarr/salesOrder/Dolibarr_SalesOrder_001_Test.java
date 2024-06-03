package org.dolibarr.salesOrder;

import org.dolibarr.base.BaseTest;
import org.dolibarr.objectRepository.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dolibarr_SalesOrder_001_Test extends BaseTest {

    @Test(threadPoolSize = 5000)
    public void createDraftSalesOrderTest(){
        HomeDashboard dashboard=loginPage.loginToApplication(prop.getValue("username"), prop.getValue("password") );
        CommerceDashboard commerceOrderDashBoard=dashboard.goToCommerceDashboard();
        NewSalesOrderPage newSalesOrderPage=commerceOrderDashBoard.clickNewSalesOrder();

        newSalesOrderPage.enterCustomerRefTextField("CU2405-00105");
        newSalesOrderPage.clickOnThirdParty();
        newSalesOrderPage.enterThirdPartyTextField("123456 ");

        newSalesOrderPage.clickOnCalendarImg();
        newSalesOrderPage.selectPlannedDateYearDropDown();
        newSalesOrderPage.selectPlannedYear("2025");
        newSalesOrderPage.selectPlannedDateMonthDropDown();
        newSalesOrderPage.selectPlannedDateMonth("Jan");
        newSalesOrderPage.selectPlannedDate("21");

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
