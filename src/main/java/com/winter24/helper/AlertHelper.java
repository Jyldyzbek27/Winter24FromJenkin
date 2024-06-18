package com.winter24.helper;

import com.winter24.drivers.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver = DriverManager.getDriver();

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public Alert getAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        getAlert().accept(); //Принимает алерт(согласие)
    }

    public void dismissAlert() {
        getAlert().dismiss(); //Не принимает алерт(несогласие)
    }

    public String getAlertText() {
        return getAlert().getText(); //Возвращает текст алерта
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlertIfPresented() {
        if (!isAlertPresent())
            return;
        acceptAlert();
    }

    public void dismissAlertIfPresented() {
        if (!isAlertPresent())
            return;
        dismissAlert();
    }

    public void acceptPrompt(String txt){
        if(!isAlertPresent())
            return;
        Alert alert = getAlert();
        alert.sendKeys(txt);
        alert.accept();
    }

    public void dismissPrompt(String txt){
        if(!isAlertPresent())
            return;
        Alert alert = getAlert();
        alert.sendKeys(txt);
        alert.dismiss();
    }


}
