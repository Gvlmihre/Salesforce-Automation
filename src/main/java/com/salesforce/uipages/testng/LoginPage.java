package com.salesforce.uipages.testng;

import com.salesforce.configutility.ApplicationConfig;
import com.salesforce.configutility.TestBase;
import com.salesforce.configutility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends TestBase {

    TestUtility testUtility;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility=new TestUtility(driver);
    }

    @FindBy(css = "input[type='email'][name='username']")
    WebElement usernameField;

    @FindBy(css = "input[type='password'][name='pw']")
    WebElement passwordField;

    @FindBy(css = "input[type='submit'][name='Login']")
    WebElement loginButton;

    String username = ApplicationConfig.readFromConfigProperties("config.properties", "username");
    String password = ApplicationConfig.readFromConfigProperties("config.properties", "password");

    public void login(){
        testUtility.waitForElementPresent(usernameField);
        usernameField.sendKeys(username);
        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
