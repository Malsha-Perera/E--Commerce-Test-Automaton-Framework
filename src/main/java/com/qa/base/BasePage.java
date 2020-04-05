package com.qa.base;

import com.qa.utilities.GlobalVariable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    Select select = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, GlobalVariable.TIMEOUT);

    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void waitForElementToDisappear(WebElement locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) locator));
    }
    public void enterText(WebElement element, String text)
    {
        element.sendKeys(text);
    }
    public void clickElement(WebElement element) {
        element.click();
    }
    public void selectValue(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
    }
    public String getElementText(WebElement element) {
        return element.getText();
    }
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

}
