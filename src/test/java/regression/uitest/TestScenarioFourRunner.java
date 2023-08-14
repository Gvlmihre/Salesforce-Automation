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

import java.awt.*;

public class TestScenarioFourRunner extends TestBase{
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
    public void uploadFileOne() throws InterruptedException, AWTException {
        userProfilePage.navigateToAccountsTab();
        Assert.assertTrue(userProfilePage.verifyNavigatedToAccountsTab());
        userProfilePage.openCyanGateAccountPage();
        Assert.assertTrue(userProfilePage.verifyCyanGateAccount());
        userProfilePage.uploadFileOne();
        Assert.assertTrue(userProfilePage.fileUploadedSuccessfully());
    }

    @Test(priority = 2)
    public void uploadFileTwo() throws InterruptedException, AWTException {
        userProfilePage.uploadFileTwo();
        Assert.assertTrue(userProfilePage.fileUploadedSuccessfully());
    }

    @Test(priority = 3)
    public void uploadFileThree() throws InterruptedException, AWTException {
        userProfilePage.uploadFileThree();
        Assert.assertTrue(userProfilePage.fileUploadedSuccessfully());
    }

    @Test(priority = 4)
    public void uploadFileFour() throws InterruptedException, AWTException {
        userProfilePage.uploadFileFour();
        Assert.assertTrue(userProfilePage.fileUploadedSuccessfully());
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }


}
