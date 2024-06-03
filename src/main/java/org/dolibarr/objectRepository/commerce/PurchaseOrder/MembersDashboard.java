package org.dolibarr.objectRepository.commerce.PurchaseOrder;

import org.dolibarr.base.BasePage;
import org.dolibarr.objectRepository.members.NewMemberTypeForm;
import org.openqa.selenium.WebDriver;

public class MembersDashboard extends BasePage {
    public MembersDashboard(WebDriver driver) {
        super(driver);
    }

    public NewMemberTypeForm getNewMemberTypeForm() {
        return new NewMemberTypeForm(driver);
    }
}
