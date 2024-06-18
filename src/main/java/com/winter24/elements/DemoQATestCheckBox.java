package com.winter24.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQATestCheckBox {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    void checkTestBoxButton() {

        // Открытие вкладки CheckBox
        WebElement checkBoxText = driver.findElement(By.xpath("//span[contains(text(),'Check Box')]"));
        checkBoxText.click();
        // Стрелка вниз Home
        WebElement buttonHomeDown = driver.findElement(By.xpath("//ol//li//button"));
        buttonHomeDown.click();
        // Клик на галочку Notes
        WebElement checkmarkOnDesktop = driver.findElement(By.xpath("(//span[@class='rct-title'])[2]"));
        checkmarkOnDesktop.click();
        // Ожидание отображения текста
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectedItemsTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'display')]")));
        // Печать текста элемента для отладки
        String selectedItemsText = selectedItemsTextElement.getText();
        System.out.println("Появившиеся элементы: " + selectedItemsText);
        // Ожидаемый текст
        String expectedText = "You have selected :\ndesktop\nnotes\ncommands";
        // Проверка, что фактический текст содержит ожидаемый текст
        Assert.assertTrue(selectedItemsText.contains(expectedText), "Текст не совпадает! Ожидался: " + expectedText + ", но был: " + selectedItemsText);
        // Печать текста для отладки (опционально)
        System.out.println("Фактический текст: " + selectedItemsText);











        //Стрелка вних Decuments
        WebElement buttonDocuments = driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[3]"));
        buttonDocuments.click();

        //Стрелка вниз WorkSpace (в Documents)
        WebElement buttonWorkSpace = driver.findElement(By.xpath("(//button[@aria-label='Toggle'])[4]"));
        buttonWorkSpace.click();
        //Стрелка вниз Office (в Documents)
        WebElement buttonOffice = driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[5]"));
        buttonOffice.click();
        //Стрелка вних Downloads
        WebElement buttonDownloads = driver.findElement(By.xpath("(//button[@class='rct-collapse rct-collapse-btn'])[6]"));
        buttonDownloads.click();


    }
}
