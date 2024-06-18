package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import com.winter24.helper.DropDownHelper;
import com.winter24.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage  {

    public BasePage(){

        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElementActions webElementActions = new WebElementActions();
    public DropDownHelper dropDownHelper = new DropDownHelper(DriverManager.getDriver());



}
