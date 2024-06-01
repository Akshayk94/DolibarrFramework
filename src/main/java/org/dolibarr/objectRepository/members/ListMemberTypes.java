package org.dolibarr.objectRepository.members;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListMemberTypes extends MembersDashboard{
    List<WebElement> labels;
    public ListMemberTypes(WebDriver driver) {
        super(driver);
    }

    public void verifyNewMemberType(String label){

    }
}
