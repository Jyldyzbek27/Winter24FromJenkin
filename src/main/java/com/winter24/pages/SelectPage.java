package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SelectPage extends BasePage {
    @FindBy(id = "withOptGroup")
    public WebElement selectValueBtn;

    @FindBy(id = "selectOne")
    public WebElement selectOneBtn;

    @FindBy(id = "oldSelectMenu")
    public WebElement oldSelectMenuBtn;


    public void choiceOptions() {
        Random random = new Random();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'option')]")));
        List<WebElement> optionMenuList = DriverManager.getDriver().findElements(By.xpath("//div[contains(@class,'option')]"));
        for (WebElement optionListPrint : optionMenuList) {
            System.out.println(optionListPrint.getText());
        }
        int optionIndex = random.nextInt(optionMenuList.size());
        WebElement selectedOption = optionMenuList.get(optionIndex);
        selectedOption.click();

    }

    public void choiceTitle() {
        Random random = new Random();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-26l3qy-menu']")));
        List<WebElement> titleList = DriverManager.getDriver().findElements(By.xpath("//div[@class=' css-26l3qy-menu']"));
        for (WebElement titleListPrint : titleList) {
            System.out.println(titleListPrint.getText());
        }
        int titleIndex = random.nextInt(titleList.size());
        WebElement selectedTitle = titleList.get(titleIndex);
        selectedTitle.click();

    }

    public void oldSelectMenuList(){
        List<WebElement> oldSelectMenuList = DriverManager.getDriver().findElements(By.xpath("oldSelectMenu"));
        for (WebElement oldSelectMenuListPrint : oldSelectMenuList) {
            System.out.println(oldSelectMenuListPrint.getText());
        }
    }


    public SelectPage fillUpSelectPage() {
        webElementActions.click(selectValueBtn);
        choiceOptions();
        webElementActions.click(selectOneBtn);
        choiceTitle();
        oldSelectMenuList();
        return this;
    }
}
