package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import com.winter24.pages.alerts.enums.SideBarMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarMenu extends BasePage {

    @FindBy(className = "oxd-topbar-body")
    public WebElement topBarBody;

    @FindBy(className = "oxd-sidepanel-body")
    public WebElement sideBarMenu;

    public String someTxt(String topBarMenuName, String... value) {
        return "dasds";
    }

    public SideBarMenu chooseSideBarMenu(SideBarMenuEnum sideBarMenuName) {
        topBarBody.findElement(By.xpath("example xpath"));
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//ul[@class='oxd-main-menu']/li/a/span[text()='"+ sideBarMenuName.getMenu() +"']"));
        element.click();
        return this;
    }

    public static void main(String[] args) {
        SideBarMenu sideBarMenu = new SideBarMenu();

        sideBarMenu.someTxt("Hello");
        sideBarMenu.someTxt("Hello", "World");
    }
}
