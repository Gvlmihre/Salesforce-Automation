package com.salesforce.uipages.testng;

import com.salesforce.configutility.TestUtility;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    TestUtility testUtility;

    WebDriver driver;
    String jsonPath = "files/data.json";
    JSONObject data;
    String fieldLabelContent;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
        data = testUtility.readJSONFile(jsonPath);
        fieldLabelContent = (String) data.get("field_label");
    }

    @FindBy(xpath = "//*[text()=\"Account\"]/parent::h1")
    WebElement verifyAccountPageMessage;

    @FindBy(linkText = "Fields & Relationships")
    WebElement fieldsAndRelationshipsButton;

    @FindBy(xpath = "//*[text()=\"Fields & Relationships\"]/parent::span")
    WebElement fieldsAndRelationshipsVerificationMessage;

    @FindBy(css = "button[title='Custom Field']")
    WebElement newFieldTypeButton;

    @FindBy(css = "#stageForm > div > div.pbWizardTitle.tertiaryPalette.brandTertiaryBgr > h2")
    WebElement newCustomFieldPageVerificationMessage;

    @FindBy(css = "#ep > div.pbBody > div:nth-child(9) > table > tbody > tr:nth-child(12) > td.labelCol > label")
    WebElement addingNewTextFieldRadioButton;

    @FindBy(css = "div.pbBottomButtons > input.btn")
    WebElement firstNextButton;

    @FindBy(css = "div.pbWizardTitle > h2")
    WebElement verifyNavigatedToEnterDetailsPageMessage;

    @FindBy(css = "input#MasterLabel")
    WebElement fieldLabel;

    @FindBy(css = "#Length")
    WebElement lengthField;

    @FindBy(css = "div.pbBottomButtons > input[name='goNext']")
    WebElement secondNextButton;

    @FindBy(css = "div.pbBottomButtons > input[name='save']")
    WebElement saveButton;

    @FindBy(xpath = "//*[text()=\"Account Region\"]/parent::a")
    WebElement newlyAddedFieldVerificationMessage;

    @FindBy(xpath = "//*[@id=\"setupComponent\"]/div/div/div/force-aloha-page/div/iframe")
    WebElement iframeSection;



    public boolean verifyNavigatedToAccountPage() {
        testUtility.waitForElementPresent(verifyAccountPageMessage);
        return verifyAccountPageMessage.isDisplayed();
    }

    public void navigateToFieldsAndRelationshipsPage() {
        testUtility.waitForElementPresent(fieldsAndRelationshipsButton);
        fieldsAndRelationshipsButton.click();
    }

    public boolean verifyNavigatedToFieldsAndRelationshipsPage() {
        testUtility.waitForElementPresent(fieldsAndRelationshipsVerificationMessage);
        return fieldsAndRelationshipsVerificationMessage.isDisplayed();
    }

    public void navigateToNewCustomFieldPage() {
        testUtility.waitForElementPresent(newFieldTypeButton);
        newFieldTypeButton.click();
    }

    public boolean verifyNavigatedToNewCustomFieldPage() {
        testUtility.waitForElementPresent(iframeSection);
        driver.switchTo().frame(iframeSection);
        testUtility.waitForElementPresent(newCustomFieldPageVerificationMessage);
        return newCustomFieldPageVerificationMessage.isDisplayed();
    }

    public void createNewTextField() throws InterruptedException {
        testUtility.waitForElementPresent(addingNewTextFieldRadioButton);
        addingNewTextFieldRadioButton.click();
        testUtility.waitForElementPresent(firstNextButton);
        firstNextButton.click();
    }

    public boolean verifyNavigatedToEnterDetailsPage() {
        testUtility.waitForElementPresent(verifyNavigatedToEnterDetailsPageMessage);
        return verifyNavigatedToEnterDetailsPageMessage.isDisplayed();
    }

    public void enterNewFieldDetails() {
        String fieldLength = (String) data.get("field_length");
        testUtility.waitForElementPresent(fieldLabel);
        fieldLabel.sendKeys(fieldLabelContent);
        testUtility.waitForElementPresent(lengthField);
        lengthField.sendKeys(fieldLength);
        testUtility.waitForElementPresent(secondNextButton);
        secondNextButton.click();
        testUtility.waitForElementPresent(secondNextButton);
        secondNextButton.click();
        testUtility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyNewlyAddedField() {
        testUtility.waitForElementPresent(newlyAddedFieldVerificationMessage);
        return newlyAddedFieldVerificationMessage.getText().contains("Account Region");
    }



}
