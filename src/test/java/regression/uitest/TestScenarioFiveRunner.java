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

public class TestScenarioFiveRunner extends TestBase {
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
        loginPage.login();
        Assert.assertTrue(homePage.verifyNavigatedToHomePage());
        homePage.navigateToUserProfilePage();
        Assert.assertTrue(userProfilePage.verifyNavigatedToUserProfilePage());
    }

    @Test(priority = 1)
    public void sendEmail() throws InterruptedException {
        userProfilePage.navigateToContactsTab();
        Assert.assertTrue(userProfilePage.verifyNavigatedToContactsTab());
        userProfilePage.openBradScottPage();
        Assert.assertTrue(userProfilePage.verifyBradScottPage());
        userProfilePage.sendEmail();
        Assert.assertTrue(userProfilePage.verifyEmailSentSuccessfully());
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
