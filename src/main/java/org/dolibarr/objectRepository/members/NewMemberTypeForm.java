package org.dolibarr.objectRepository.members;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewMemberTypeForm extends MembersDashboard{
    @FindBy(xpath = "//input[@name='label']")
    WebElement labelTextField;

    @FindBy(xpath = "//span[@id='select2-status-container']")
    WebElement selectStatus;

    @FindBy(xpath = "//span[@id='select2-morphy-container']")
    WebElement selectNatureOfMember;

    @FindBy(xpath = "//select[@id='subscription']")
    WebElement subscriptionStatus;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement amount;

    @FindBy(xpath = "//select[@id='caneditamount']")
    WebElement anyAmount;

    @FindBy(xpath = "//select[@id='vote']")
    WebElement vote;

    @FindBy(xpath = "//input[@name='duration_value']")
    WebElement durationValue;
    @FindBy(xpath = "//span[@id='select2-duration_unit-container']")
    WebElement durationTypes;

    @FindBy(xpath = "//textarea[@id='comment']")
    WebElement comment;

    @FindBy(xpath = "//textarea[@id='mail_valid']")
    WebElement welcomeMail;

    @FindBy(xpath = "//input[@name='save']")
    WebElement saveButton;

    @FindBy(xpath = "//input[@name='cancel']")
    WebElement cancelButton;

    public NewMemberTypeForm(WebDriver driver) {
        super(driver);
    }

    public void saveAllDetails(MemberType type){
        labelTextField.sendKeys(type.getLabel());

        selectStatus.click();
        Actions actions=new Actions(driver);

        actions.sendKeys(type.getSelectStatus()).perform();
        actions.sendKeys(Keys.ENTER).perform();

        selectNatureOfMember.click();
        actions.sendKeys(type.getNatureOfMember()).perform();
        actions.sendKeys(Keys.ENTER).perform();

        Select selectContribution=new Select(subscriptionStatus);
        selectContribution.selectByIndex((type.getSubscriptionStatus().equalsIgnoreCase("YES")?0:1));

        amount.sendKeys(type.getAmount());

        Select selectAnyAmount=new Select(anyAmount);
        selectAnyAmount.selectByIndex((type.getAnyAmount().equalsIgnoreCase("YES")?0:1));

        Select selectVote=new Select(vote);
        selectVote.selectByIndex((type.getVote().equalsIgnoreCase("YES")?0:1));

        durationValue.sendKeys(type.getDurationValue());

        durationTypes.click();
        actions.sendKeys(type.getDurationType()).perform();
        actions.sendKeys(Keys.ENTER).perform();

        comment.sendKeys(type.getComment());
        welcomeMail.sendKeys(type.getWelcomeMail());

        saveButton.click();
    }
    public void saveMandatoryDetails(String label){
        labelTextField.sendKeys(label);
        saveButton.click();
    }
}
