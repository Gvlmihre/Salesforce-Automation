package regression.uitest;

import com.salesforce.configutility.ApplicationConfig;
import com.salesforce.configutility.TestBase;
import com.salesforce.uipages.testng.HomePage;
import com.salesforce.uipages.testng.LoginPage;
import com.salesforce.uipages.testng.UserProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenarioTwoRunner extends TestBase {

    String configFile="config.properties";
    String URL= ApplicationConfig.readFromConfigProperties(configFile,"URL");
    LoginPage loginPage;
    HomePage homePage;
    UserProfilePage userProfilePage;

    @BeforeClass
    public void setup(){
        browserSetUp(URL);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        userProfilePage=new UserProfilePage(driver);
    }

    @Test(priority = 1)
    public void login(){
        loginPage.login();
        Assert.assertTrue(homePage.verifyNavigatedToHomePage());
    }

    @Test(priority = 2)
    public void navigateToUserProfilePage() {
        homePage.navigateToUserProfilePage();
        Assert.assertTrue(userProfilePage.verifyNavigatedToUserProfilePage());
    }

    @Test(priority = 3)
    public void navigateToAccountsTab(){
        userProfilePage.navigateToAccountsTab();
        Assert.assertTrue(userProfilePage.verifyNavigatedToAccountsTab());
    }
    @Test(priority = 4)
    public void createNewAccount(){
        userProfilePage.createNewAccount();
        Assert.assertTrue(userProfilePage.verifyNewAccountCreated());
    }

    @Test(priority = 5)
    public void navigateToContactsTab() throws InterruptedException {
        userProfilePage.navigateToContactsTab();
        Assert.assertTrue(userProfilePage.verifyNavigatedToContactsTab());
    }

    @Test(priority = 6)
    public void createNewContact() throws InterruptedException {
        userProfilePage.addNewContact();
        Assert.assertTrue(userProfilePage.verifyNewContactAddedSuccessfully());
        Assert.assertTrue(userProfilePage.verifyNewContactAccountName());
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
