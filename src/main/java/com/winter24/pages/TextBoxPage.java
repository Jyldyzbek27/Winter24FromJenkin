package com.winter24.pages;
import com.winter24.entities.TextBoxEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TextBoxPage extends BasePage{


    @FindBy(id = "userName")
    public WebElement fullNameInput;
    //WebElement getUserNameInput = DriverManager.getDriver().findElement(By.id("userName"));

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public TextBoxPage fillUpTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress){
    webElementActions.sendKeys(fullNameInput, fullName)
            .jsSendKeys(emailInput, email)
            .jsSendKeys(currentAddressInput, currentAddress)
            .jsSendKeys(permanentAddressInput, permanentAddress)
            .click(submitBtn);
    return this;
    }
@Step("Fill up text box form")
    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity){
        webElementActions.sendKeys(fullNameInput, textBoxEntity.getFullName())
                .jsSendKeys(emailInput, textBoxEntity.getEmail())
                .jsSendKeys(currentAddressInput, textBoxEntity.getCurrentAddress())
                .jsSendKeys(permanentAddressInput, textBoxEntity.getPermanentAddress())
                .click(submitBtn);
        return this;

    }

}
