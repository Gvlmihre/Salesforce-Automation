package com.salesforce.configutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;

public class TestUtility {

    private WebDriver driver;
    @FindBy(xpath = "//div[@title=\"Upload Files\"]")
    WebElement uploadFilesButton;

    @FindBy(xpath = "//div[@class=\"footerCmps forceContentPanelFooter\"]/span[2]/button")
    WebElement fileUploadDoneButton;

    @FindBy(xpath = "//div[@class=\"footerCmps forceContentPanelFooter\"]/span[@role=\"status\"]")
    WebElement verifyFileUploadedSuccessfullyMessageSection;

    String fileUploadSuccessMessage;

    String jsonPath = "files/data.json";
    JSONObject data;



    public TestUtility(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        data = readJSONFile(jsonPath);
        fileUploadSuccessMessage = (String) data.get("file_uploaded_successfully_message");
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(d ->element.isDisplayed());
    }

    /**
     * Reads JSON data from a file and returns a JSONArray of users.
     * @param filePath Path to the JSON file.
     * @return JSONArray of users.
     */
    public JSONObject readJSONFile(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            Object obj = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void uploadFile(String filePath) throws AWTException, InterruptedException {
        waitForElementPresent(uploadFilesButton);
        clickWithJS(uploadFilesButton);
        Robot rb=new Robot();
        rb.delay(2000);
        //put path to file in a clipboard;
        StringSelection ss=new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //CTRL+V
        rb.keyPress(KeyEvent.VK_CONTROL);  //press on ctrl key
        rb.keyPress(KeyEvent.VK_V);  //press the v key
        //release the ctrl+v keys
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        //press the enter key to upload the file
        rb.keyPress(KeyEvent.VK_ENTER);
        //release the enter key
        rb.keyRelease(KeyEvent.VK_ENTER);
        //uploadFilesButton.sendKeys(filePath);
        Thread.sleep(3000);
        waitForElementPresent(fileUploadDoneButton);
        clickWithJS(fileUploadDoneButton);
    }


}


