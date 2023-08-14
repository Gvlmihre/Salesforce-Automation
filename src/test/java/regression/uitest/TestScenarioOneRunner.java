package regression.uitest;

import com.salesforce.configutility.ApplicationConfig;
import com.salesforce.configutility.TestBase;
import com.salesforce.uipages.testng.AccountPage;
import com.salesforce.uipages.testng.HomePage;
import com.salesforce.uipages.testng.LoginPage;
import com.salesforce.uipages.testng.ObjectManagerPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenarioOneRunner extends TestBase {
    String configFile="config.properties";
    String URL=ApplicationConfig.readFromConfigProperties(configFile,"URL");
    LoginPage loginPage;
    HomePage homePage;
    ObjectManagerPage objectManagerPage;
    AccountPage accountPage;

    @BeforeClass
    public void setup(){
        browserSetUp(URL);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        objectManagerPage = new ObjectManagerPage(driver);
        accountPage=new AccountPage(driver);

    }

    @Test(priority = 1)
    public void login(){
        loginPage.login();
        Assert.assertTrue(homePage.verifyNavigatedToHomePage());
    }

    @Test(priority = 2)
    public void navigateToSetUpPage(){
        homePage.navigateToSetUpPage();
        Assert.assertTrue(homePage.verifyNavigatedToSetupPage());
    }

    @Test(priority = 3)
    public void navigateToObjectManagerPage(){
        homePage.navigateToObjectManagerPage();
        Assert.assertTrue(objectManagerPage.verifyNavigatedToObjectManagerPage());
    }

    @Test(priority = 4)
    public void navigateToAccountPage(){
        objectManagerPage.navigateToAccountPage();
        Assert.assertTrue(accountPage.verifyNavigatedToAccountPage());
    }

    @Test(priority = 5)
    public void navigateToNewCustomFieldPage(){
        accountPage.navigateToFieldsAndRelationshipsPage();
        Assert.assertTrue(accountPage.verifyNavigatedToFieldsAndRelationshipsPage());
        accountPage.navigateToNewCustomFieldPage();
        Assert.assertTrue(accountPage.verifyNavigatedToNewCustomFieldPage());
    }

    @Test(priority = 6)
    public void addNewField() throws InterruptedException {
        accountPage.createNewTextField();
        Assert.assertTrue(accountPage.verifyNavigatedToEnterDetailsPage());
        accountPage.enterNewFieldDetails();
        Assert.assertTrue(accountPage.verifyNewlyAddedField());
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }

}
