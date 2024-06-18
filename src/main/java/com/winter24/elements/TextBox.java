package com.winter24.elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

 public class TextBox {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    void fillTextBoxAndSubmit() throws InterruptedException {

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Jyldyzbek");


        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("KubatbekovVv@gmail.com");


        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("Bishkek, 1a Gorkii Street");

        WebElement permanent  = driver.findElement(By.id("permanentAddress"));
        permanent .sendKeys("Bishkek, 42 Chyi avenue");


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(15000);
    }

    @AfterMethod
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}










