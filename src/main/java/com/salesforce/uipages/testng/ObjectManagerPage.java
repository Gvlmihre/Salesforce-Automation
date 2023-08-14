package com.salesforce.uipages.testng;

import com.salesforce.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectManagerPage {
    TestUtility testUtility;

    WebDriver driver;

    public ObjectManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(xpath = "//*[text()=\"Object Manager\"]/parent::h1")
    WebElement objectManagerVerificationMessage;
    @FindBy(xpath = "//*[@id=\"setupComponent\"]/div[2]/div/div[2]/div/table/tbody/tr[1]/th/a")
    WebElement accountButton;



    public boolean verifyNavigatedToObjectManagerPage(){
        testUtility.waitForElementPresent(objectManagerVerificationMessage);
        return objectManagerVerificationMessage.isDisplayed();
    }

    public void navigateToAccountPage(){
        testUtility.waitForElementPresent(accountButton);
        accountButton.click();
    }



}
