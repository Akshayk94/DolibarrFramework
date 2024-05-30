package org.dolibarr.membersType;

import org.dolibarr.base.BaseTest;
import org.dolibarr.objectRepository.HomeDashboard;
import org.dolibarr.objectRepository.LoginPage;

public class Dolibarr_Members_TypeTest extends BaseTest {
    /*Verify that user is able to create new member type*/
    public void addNewMemberTypeTest(){
        //landing page
        //login--> Page
        HomeDashboard dashboard =loginPage.loginToApplication(prop.getValue("username"), prop.getValue("password"));
        //dashboard --> Page
        //members dashboard--> Page
        //members type list --> Page
        //new member type --> Page
    }
}
