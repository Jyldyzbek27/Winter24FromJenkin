package com.winter24.pages.alerts;

import com.winter24.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    @FindBy(id = "confirmButton")
    public WebElement confirmAlertBtn;
}
