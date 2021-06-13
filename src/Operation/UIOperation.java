package Operation;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UIOperation {

    WebDriver driver;

    public void perform(String keyword, String testData, String expectResult, String xpath) throws Exception {
        //System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        switch (keyword) {
            case "openBrowser":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                System.out.println("Testcase " + "\n");
                break;

            case "navigate":
                driver.get(testData);
                break;

            case "clickButton":
                WebDriverWait wait = new WebDriverWait(driver, 15);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                driver.findElement(By.xpath(xpath)).click();
                break;
            case "verifyWebTitle":
                driver.getTitle();
                assertEquals(driver.getTitle(), expectResult);
                break;
            case "verifyElementIsDisplay":
                assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
                break;

            case "inputText":
                driver.navigate().refresh();
                driver.findElement(By.xpath(xpath)).sendKeys(testData);
                break;

            case "verityUrlIsDisplay":
                assertEquals(driver.getCurrentUrl(), expectResult);
                break;

            case "verifyErrorMessage":
                WebDriverWait waita = new WebDriverWait(driver, 15);
                waita.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                assertEquals(driver.findElement(By.xpath(xpath)).getText(), expectResult);
                break;

            case "closeBrowser":
                driver.close();
                break;
            default:
                break;

        }
    }
}
