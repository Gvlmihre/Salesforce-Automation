package com.salesforce.uipages.testng;

import com.salesforce.configutility.TestUtility;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.awt.*;
import java.util.List;

    public class UserProfilePage {
        TestUtility testUtility;
        LoginPage loginPage;

        WebDriver driver;
        String jsonPath = "files/data.json";
        JSONObject data;
        String accountName;
        String accountRegion;
        String contactFirstName;
        String contactLastName;
        String language;
        String accountOwnerSectionName;
        String firstAccountOwner;
        String newAccountOwner;
        String fileUploadSuccessMessage;
        String contactFullName;
        String emailAddress;
        String emailSubject;
        String emailBody;
        String emailSuccessfulMessage;
        String projectPath = System.getProperty("user.dir");
        public UserProfilePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            testUtility = new TestUtility(driver);
            data = testUtility.readJSONFile(jsonPath);
            accountName = (String) data.get("account_name");
            accountRegion = (String) data.get("account_region");
            contactFirstName = (String) data.get("contact_first_name");
            contactLastName = (String) data.get("contact_last_name");
            contactFullName = (String) data.get("contact_full_name");
            language = (String) data.get("language");
            newAccountOwner = (String) data.get("new_account_owner");
            firstAccountOwner = (String) data.get("first_account_owner");
            accountOwnerSectionName = (String) data.get("account_owner_section");
            fileUploadSuccessMessage = (String) data.get("file_uploaded_successfully_message");
            emailAddress = (String) data.get("email_address");
            emailSubject = (String) data.get("email_subject");
            emailBody = (String) data.get("email_body");
            emailSuccessfulMessage = (String) data.get("email_successful_message");
            loginPage=new LoginPage(driver);
        }

        @FindBy(xpath = "//*[text()=\"Nurane Kutbilge\"]/parent::b")
        WebElement userProfilePageVerificationMessage;

        //@FindBy(xpath = "//a[@title = \"Accounts\"]/span[@class = \"slds-truncate\"]")
        @FindBy(xpath = "//a[@title = \"Accounts\"]")
        WebElement accountsTab;

        @FindBy(xpath = "//div[@title=\"New\"]")
        WebElement addNewAccountButton;

        @FindBy(xpath = "//span[text()=\"Accounts\" and @class=\"slds-var-p-right_x-small\"]")
        WebElement accountsTabVerificationMessage;

        @FindBy(xpath = "//input[@name = \"Name\"]")
        WebElement newAccountName;

        @FindBy(xpath = "//input[@name = \"Account_Region__c\"]")
        WebElement newAccountRegion;

        @FindBy(xpath = "//button[@name = \"SaveEdit\"]")
        WebElement saveNewAccountButton;

        @FindBy(xpath = "//*[text()=\"CyanGate\"]")
        WebElement newAccountNameVerificationMessage;

        @FindBy(xpath = "//a[@title = \"Contacts\"]/span[@class = \"slds-truncate\"]")
        WebElement contactsTab;

        @FindBy(xpath = "//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")
        WebElement addNewContactButton;

        @FindBy(xpath = "//span[text()=\"Contacts\" and @class=\"slds-var-p-right_x-small\"]")
        WebElement contactsTabVerificationMessage;

        @FindBy(xpath = "//*[@name=\"firstName\"]")
        WebElement newContactFirstNameField;

        @FindBy(xpath = "//*[@name=\"lastName\"]")
        WebElement newContactLastNameField;

        @FindBy(xpath = "//*[@placeholder=\"Search Accounts...\"]")
        WebElement newContactAccountNameField;

        @FindBys(@FindBy(xpath = "//ul[@role=\"group\"]/li"))
        List<WebElement> accountNamesToSelect;

        @FindBy(xpath = "//input[@name='Languages__c']")
        WebElement languageSection;

        @FindBy(xpath = "//button[@name=\"SaveEdit\"]")
        WebElement saveNewContactButton;

        @FindBy(xpath = "(//a[@title=\"Brad Scott\"])[1]/parent::span/parent::th/parent::tr/td[3]")
        WebElement newlyAddedContactAccountNameVerificationMessageField;

        @FindBy(xpath = "//ul[@role=\"group\"]/li/lightning-base-combobox-item/span[2]/span/lightning-base-combobox-formatted-text")
        WebElement accountNameToChoose;

        @FindBy(xpath = "(//h1)[3]")
        WebElement newlyAddedContactNameVerificationMessageField;

        @FindBy(xpath = "(//*[text() = \"CyanGate\"])[1]")
        WebElement accountNameToProceed;
        @FindBy(xpath = "//p[@title=\"Account Owner\"]")
        WebElement accountOwnerSection;
        @FindBy(xpath = "//p[@title=\"Account Owner\"]/parent::div/p[2]")
        WebElement accountOwnerName;

        @FindBy(xpath = "//*[text() = \"Change Owner\"]")
        WebElement changeOwnerButton;

        @FindBy(xpath = "//input[@title = \"Search Users\"]")
        WebElement searchUsersSection;

        @FindBy(xpath = "//div[@title=\"Integration User\"]")
        WebElement integrationUserToSelect;

        @FindBy(xpath = "//button[@name=\"change owner\"]")
        WebElement changeOwnerConfirmationButton;
        //goto accounts page and upload file related elements starts here
        @FindBy(xpath = "//a[@title=\"CyanGate\"]")
        WebElement cyanGateInAccountsList;

        @FindBy(xpath = "//lightning-formatted-text[@class=\"custom-truncate\"]")
        WebElement accountNameVerificationInAnAccountPage;

        @FindBy(xpath = "//div[@title=\"Upload Files\"]")
        WebElement uploadFilesButton;

        @FindBy(xpath = " //span[@class=\" label bBody\" and text()=\"Done\"]")
        WebElement fileUploadDoneButton;

        @FindBy(xpath = "//span[@class = \"toastMessage slds-text-heading--small forceActionsText\"]")
        WebElement verifyFileUploadedSuccessfullyMessageSection;

        @FindBy(xpath = "//span[@title=\"Notes & Attachments\"]")
        WebElement attachmentAndFileSection;

        //goto contacts page and send email page elements starts here
        @FindBy(xpath = "//*[text()=\"Brad Scott\"]")
        WebElement bradScottInContactsList;

        @FindBy(xpath = "//span[@class = \"custom-truncate uiOutputText\"]")
        WebElement contactNameVerificationInAContactPage;

        @FindBy(xpath = "//button[@title=\"Email\"]")
        WebElement emailButton;

        @FindBy(xpath = "//a[@class=\"select\"]")
        WebElement emailFromSection;

        @FindBy(xpath = "//ul[@aria-label=\"To\"]/li/input")
        WebElement emailToSection;

        @FindBy(xpath = "//input[@class=\"standardField input\"]")
        WebElement emailSubjectSection;

        @FindBy(xpath = "//iframe[@title=\"CK Editor Container\"]")
        WebElement emailBodyParentIframe;

        @FindBy(xpath = "//iframe[@title=\"Email Body\"]")
        WebElement emailBodyIframe;

        @FindBy(xpath = "//body[@class=\"cke_editable cke_editable_themed cke_contents_ltr\"]")
        WebElement emailBodySection;

        @FindBy(xpath = "//*[text() = \"Attach file\" and @class=\"assistiveText\"]")
        WebElement attachFileSection;

        @FindBy(xpath = "//label[@class=\"uiLabel\"]/span[@class=\"slds-checkbox--faux\"]")
        WebElement selectFileCheckBox;

        @FindBy(xpath = "//span[text() = \"Add (1)\" and @class=\" label bBody\"]")
        WebElement addFileConfirmationButton;

        @FindBy(xpath = "//span[text() = \"Send\" and @class=\" label bBody\"]")
        WebElement sendEmailButton;

        @FindBy(xpath = "//div[@class=\"buttonContainer\"]/button[2]")
        WebElement attachAndSendButton;

        @FindBy(xpath = "//span[@class = \"toastMessage slds-text-heading--small forceActionsText\"]")
        WebElement verifyEmailSentSuccessfullyMessageSection;

        @FindBy(xpath = "//*[@class=\"tooltipTrigger tooltip-trigger uiTooltip\"]/span[1]/div/span")
        WebElement userProfileSection;

        @FindBy(xpath = "//a[@class=\"profile-link-label logout uiOutputURL\"]")
        WebElement logoutButton;

        @FindBy(css = "input[type='submit'][name='Login']")
        WebElement loginButton;


        public void logout(){
            testUtility.waitForElementPresent(userProfileSection);
            userProfileSection.click();
            testUtility.waitForElementPresent(logoutButton);
            logoutButton.click();
        }

        public boolean logoutSuccessfully(){
            testUtility.waitForElementPresent(loginButton);
            return loginButton.isDisplayed();
        }

        //upload file methods starts here
        public void openCyanGateAccountPage(){
            testUtility.waitForElementPresent(cyanGateInAccountsList);
            testUtility.clickWithJS(cyanGateInAccountsList);
        }

        public boolean verifyCyanGateAccount() {
            testUtility.waitForElementPresent(accountNameVerificationInAnAccountPage);
            String currentAccountName = accountNameVerificationInAnAccountPage.getText();
            System.out.println(currentAccountName);
            System.out.println(accountName);
            return currentAccountName.equalsIgnoreCase(accountName);
        }

        public void uploadFileOne() throws InterruptedException, AWTException {
            String fileOnePath = projectPath + "\\files\\Test1.txt";
            testUtility.uploadFile(fileOnePath);
            System.out.println("File 1 uploaded successfully!");
        }

        public void uploadFileTwo() throws InterruptedException, AWTException {
            String fileTwoPath = projectPath + "\\files\\Test2.txt";
            navigateToAccountsTab();
            openCyanGateAccountPage();
            verifyCyanGateAccount();
            testUtility.uploadFile(fileTwoPath);
            System.out.println("File 2 uploaded successfully!");
        }

        public void uploadFileThree() throws InterruptedException, AWTException {
            String fileThreePath = projectPath + "\\files\\Test3.txt";
            openCyanGateAccountPage();
            navigateToAccountsTab();
            verifyCyanGateAccount();
            testUtility.uploadFile(fileThreePath);
            System.out.println("File 3 uploaded successfully!");
        }

        public void uploadFileFour() throws InterruptedException, AWTException {
            String fileFourPath = projectPath + "\\files\\Test4.txt";
            openCyanGateAccountPage();
            verifyCyanGateAccount();
            testUtility.uploadFile(fileFourPath);
            System.out.println("File 4 uploaded successfully!");
        }

        public boolean fileUploadedSuccessfully(){
            testUtility.waitForElementPresent(verifyEmailSentSuccessfullyMessageSection);
            String successMessage = verifyEmailSentSuccessfullyMessageSection.getText();
            System.out.println(successMessage);
            return successMessage.contains("1 file was added to the Account.");
        }

        // send email methods starts here
        public void openBradScottPage() {
            testUtility.waitForElementPresent(bradScottInContactsList);
            bradScottInContactsList.click();
        }

        public boolean verifyBradScottPage() {
            testUtility.waitForElementPresent(contactNameVerificationInAContactPage);
            String currentName = contactNameVerificationInAContactPage.getText();
            System.out.println(currentName);
            System.out.println(contactFullName);
            return currentName.equalsIgnoreCase(contactFullName);
        }

        public void sendEmail() throws InterruptedException {
            testUtility.waitForElementPresent(emailButton);
            testUtility.clickWithJS(emailButton);
            Thread.sleep(3000);
            testUtility.waitForElementPresent(emailFromSection);
            String emailFromText = emailFromSection.getText();
            System.out.println(emailFromText);
            Assert.assertFalse(emailFromText.isEmpty());
            testUtility.waitForElementPresent(emailToSection);
            emailToSection.sendKeys(emailAddress);
            testUtility.waitForElementPresent(emailSubjectSection);
            emailSubjectSection.sendKeys(emailSubject);
            testUtility.waitForElementPresent(emailBodyParentIframe);
            driver.switchTo().frame(emailBodyParentIframe);
            testUtility.waitForElementPresent(emailBodyIframe);
            driver.switchTo().frame(emailBodyIframe);
            testUtility.waitForElementPresent(emailBodySection);
            emailBodySection.sendKeys(emailBody);
            driver.switchTo().defaultContent();
            testUtility.waitForElementPresent(attachFileSection);
            testUtility.clickWithJS(attachFileSection);
            Thread.sleep(5000);
            testUtility.waitForElementPresent(selectFileCheckBox);
            testUtility.clickWithJS(selectFileCheckBox);
            testUtility.waitForElementPresent(addFileConfirmationButton);
            testUtility.clickWithJS(addFileConfirmationButton);
            Thread.sleep(3000);
            testUtility.waitForElementPresent(sendEmailButton);
            testUtility.clickWithJS(sendEmailButton);
            Thread.sleep(3000);
            testUtility.waitForElementPresent(attachAndSendButton);
            testUtility.clickWithJS(attachAndSendButton);
        }

        public boolean verifyEmailSentSuccessfully() {
            //Thread.sleep(1000);
            testUtility.waitForElementPresent(verifyEmailSentSuccessfullyMessageSection);
            String successMessage = verifyEmailSentSuccessfullyMessageSection.getText();
            System.out.println(successMessage);
            return successMessage.contains("Email was sent");
        }

        public boolean verifyNavigatedToUserProfilePage() {
            testUtility.waitForElementPresent(userProfilePageVerificationMessage);
            return userProfilePageVerificationMessage.getText().contains("Nurane");
        }

        public void navigateToAccountsTab() {
            testUtility.waitForElementPresent(accountsTab);
            testUtility.clickWithJS(accountsTab);
        }

        public boolean verifyNavigatedToAccountsTab() {
            testUtility.waitForElementPresent(accountsTabVerificationMessage);
            return accountsTabVerificationMessage.getText().contains("Accounts");
        }

        public void createNewAccount() {
            testUtility.waitForElementPresent(addNewAccountButton);
            addNewAccountButton.click();
            testUtility.waitForElementPresent(newAccountName);
            newAccountName.sendKeys(accountName);
            testUtility.waitForElementPresent(newAccountRegion);
            newAccountRegion.sendKeys(accountRegion);
            testUtility.waitForElementPresent(saveNewAccountButton);
            saveNewAccountButton.click();
        }

        public boolean verifyNewAccountCreated() {
            testUtility.waitForElementPresent(newAccountNameVerificationMessage);
            return newAccountNameVerificationMessage.getText().equalsIgnoreCase("CyanGate");
        }

        public void navigateToContactsTab() throws InterruptedException {
            Thread.sleep(5000);
            testUtility.waitForElementPresent(contactsTab);
            testUtility.clickWithJS(contactsTab);
        }

        public boolean verifyNavigatedToContactsTab() {
            testUtility.waitForElementPresent(contactsTabVerificationMessage);
            return contactsTabVerificationMessage.getText().equalsIgnoreCase("Contacts");
        }

        public void addNewContact() throws InterruptedException {
            testUtility.waitForElementPresent(addNewContactButton);
            addNewContactButton.click();
            Thread.sleep(3000);
            testUtility.waitForElementPresent(newContactFirstNameField);
            newContactFirstNameField.sendKeys(contactFirstName);
            Thread.sleep(3000);
            testUtility.waitForElementPresent(newContactLastNameField);
            newContactLastNameField.sendKeys(contactLastName);
            Thread.sleep(3000);
            testUtility.waitForElementPresent(newContactAccountNameField);
            newContactAccountNameField.sendKeys("Cyan");
            testUtility.waitForElementPresent(accountNameToChoose);
            accountNameToChoose.click();
            Thread.sleep(3000);
            testUtility.waitForElementPresent(languageSection);
            languageSection.sendKeys(language);
            Thread.sleep(3000);
            testUtility.waitForElementPresent(saveNewContactButton);
            saveNewContactButton.click();
            Thread.sleep(3000);
        }

        public boolean verifyNewContactAddedSuccessfully() {
            String currentName = newlyAddedContactNameVerificationMessageField.getText();
            return currentName.contains(contactFirstName);
        }

        public boolean verifyNewContactAccountName() throws InterruptedException {
            Thread.sleep(6000);
            navigateToContactsTab();
            String currentAccountName = newlyAddedContactAccountNameVerificationMessageField.getText();
            System.out.println(currentAccountName);
            System.out.println(accountName);
            return currentAccountName.contains(accountName);
        }

        public boolean verifyFirstAccountOwner() throws InterruptedException {
            navigateToAccountsTab();
            Assert.assertTrue(verifyNavigatedToAccountsTab());
            testUtility.waitForElementPresent(accountNameToProceed);
            accountNameToProceed.click();
            Thread.sleep(3000);
            testUtility.waitForElementPresent(accountOwnerSection);
            String sectionName = accountOwnerSection.getText();
            System.out.println("Current section name in website is: " + sectionName);
            System.out.println("The section name we need is: " + accountOwnerSectionName);;
            Assert.assertEquals(sectionName, accountOwnerSectionName);
            String currentAccountOwner = accountOwnerName.getText();
            System.out.println("Current account owner name in website is: " + currentAccountOwner);
            System.out.println("The account owner should be: " + firstAccountOwner);;
            return currentAccountOwner.contains(firstAccountOwner);
        }
        public void changeAccountOwner() throws InterruptedException {
            testUtility.waitForElementPresent(changeOwnerButton);
            testUtility.clickWithJS(changeOwnerButton);
            Thread.sleep(4000);
            testUtility.waitForElementPresent(searchUsersSection);
            searchUsersSection.sendKeys(newAccountOwner);
            testUtility.waitForElementPresent(integrationUserToSelect);
            integrationUserToSelect.click();
            testUtility.waitForElementPresent(changeOwnerConfirmationButton);
            changeOwnerConfirmationButton.click();
        }

        public boolean verifyAccountOwnerChangedSuccessfully() throws InterruptedException {
            Thread.sleep(5000);
            testUtility.waitForElementPresent(accountOwnerSection);
            String sectionName = accountOwnerSection.getText();
            System.out.println("Current section name in website is: " + sectionName);
            System.out.println("The section name we need is: " + accountOwnerSectionName);;
            Assert.assertEquals(sectionName, accountOwnerSectionName);
            String currentAccountOwner = accountOwnerName.getText();
            System.out.println("Current account owner name in website is: " + currentAccountOwner);
            System.out.println("The account owner should be: " + newAccountOwner);;
            return currentAccountOwner.contains(newAccountOwner) ;
        }
    }

