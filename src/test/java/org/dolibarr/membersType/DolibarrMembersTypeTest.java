package org.dolibarr.membersType;

import org.dolibarr.base.BaseTest;
import org.dolibarr.objectRepository.home.HomeDashboard;
import org.dolibarr.objectRepository.members.MemberType;
import org.dolibarr.objectRepository.members.MembersDashboard;
import org.dolibarr.objectRepository.members.NewMemberTypeForm;
import org.testng.annotations.Test;

public class DolibarrMembersTypeTest extends BaseTest {
    MembersDashboard membersDashboard;
    /*Verify that user is able to create new member type
    * with mandatory fields*/
    @Test
    public void addNewMemberTypeWithRequiredFieldsTest(){
        membersDashboard=dashboard.goToMembersDashboard();
        NewMemberTypeForm form=membersDashboard.getNewMemberTypeForm();
        form.saveMandatoryDetails("Merchant");
    }
    /*Verify that user is able to add mew member type
    * with all details*/
    @Test
    public void addNewMemberTypeWithAllFieldsTest(){
        membersDashboard=dashboard.goToMembersDashboard();
        NewMemberTypeForm form=membersDashboard.getNewMemberTypeForm();
        MemberType type=new MemberType();
        type.setLabel("HR");
        type.setSelectStatus("Open");
        type.setNatureOfMember("Individual");
        type.setSubscriptionStatus("YES");
        type.setAmount("1500");
        type.setAnyAmount("YES");
        type.setVote("YES");
        type.setDurationValue("1");
        type.setDurationType("Year");
        type.setComment("Adding new member type of HR");
        type.setWelcomeMail("Welcome to dolibarr ERP");
        form.saveAllDetails(type);
    }
}
