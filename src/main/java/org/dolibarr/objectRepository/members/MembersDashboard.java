package org.dolibarr.objectRepository.members;

import org.dolibarr.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembersDashboard extends BasePage {
    @FindBy(xpath = ".//div[contains(@class,'blockvmenulast')]//a[text()='New']")
    WebElement newMemberTypeLink;
    @FindBy(xpath = ".//div[contains(@class,'blockvmenulast')]//a[text()='List']")
    WebElement listMemberTypeLink;
    @FindBy(xpath = ".//div[contains(@class,'blockvmenufirst')]//a[text()='New member']")
    WebElement newMemberLink;
    @FindBy(xpath = ".//div[contains(@class,'blockvmenufirst')]//a[text()='List']")
    WebElement listMembersLink;

    public MembersDashboard(WebDriver driver) {
        super(driver);
    }
    public NewMemberTypeForm getNewMemberTypeForm(){
        newMemberTypeLink.click();
        return new NewMemberTypeForm(driver);
    }
    public ListMemberTypes getMemberTypesList(){
        listMemberTypeLink.click();
        return new ListMemberTypes(driver);
    }
    public NewMemberForm getNewMemberForm(){
        newMemberLink.click();
        return new NewMemberForm();
    }
    public ListMembers getMembersList(){
        listMembersLink.click();
        return new ListMembers();
    }
}
