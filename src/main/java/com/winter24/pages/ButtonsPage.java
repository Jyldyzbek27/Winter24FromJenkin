package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage{
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;

   @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

   @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;

   @FindBy(id = "rightClickMessage")
    public  WebElement rightClickMessage;

   @FindBy(xpath = "//div//button[@class='btn btn-primary' and @type='button' and text()='Click Me']")
    public WebElement dynamicClickBtn;

   @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;
}
