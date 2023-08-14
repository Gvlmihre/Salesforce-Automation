package com.salesforce.uipages.testng;

import com.salesforce.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    TestUtility testUtility;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(css = "div.setup-header-element > div > div:nth-child(2) > h1 > span")
    WebElement homePageMessage;

    @FindBy(css = "div.setupGear")
    WebElement setUpButton;

    @FindBy(xpath = "//header[@id='oneHeader']/div[2]/span/div[2]/ul/li[8]/span/button/div/span")
    WebElement setUpNavigationButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[1]/div/div/div[2]/span")
    WebElement setupPageVerificationMessage;

    @FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[2]/div/div/ul[2]/li[3]/a/span")
    WebElement objectManagerButton;

    @FindBy(xpath = "//*[@class=\"tooltipTrigger tooltip-trigger uiTooltip\"]/span[1]/div/span")
    WebElement userProfileSection;

    @FindBy(xpath = "//*[@class=\"avatar-holder\"]/a/span/span/div/span")
    WebElement userAvatar;

    public boolean verifyNavigatedToHomePage() {
        testUtility.waitForElementPresent(homePageMessage);
        return homePageMessage.isDisplayed();
    }

    public void navigateToSetUpPage(){
        testUtility.waitForElementPresent(setUpButton);
        setUpButton.click();
        testUtility.waitForElementPresent(setUpNavigationButton);
        setUpNavigationButton.click();
    }

    public boolean verifyNavigatedToSetupPage(){
        testUtility.waitForElementPresent(setupPageVerificationMessage);
        return setupPageVerificationMessage.isDisplayed();
    }

    public void navigateToObjectManagerPage(){
        testUtility.waitForElementPresent(objectManagerButton);
        objectManagerButton.click();
    }

    public void navigateToUserProfilePage(){
        testUtility.waitForElementPresent(userProfileSection);
        userProfileSection.click();
        testUtility.waitForElementPresent(userAvatar);
        userAvatar.click();
    }



}
