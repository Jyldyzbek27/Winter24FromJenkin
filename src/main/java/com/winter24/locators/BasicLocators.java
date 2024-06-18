package com.winter24.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicLocators {
    WebDriver driver;

    @Test(description = "Find by ID")
    void findByIdTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/textBox");

//        WebElement fullNameInput = driver.findElement(By.className("mr-sm-2"));
//        fullNameInput.sendKeys("John Doe");
//
//        String textBox = driver.findElement(By.tagName("h1")).getText();
//        System.out.println(textBox);


        //Home

        WebElement homeLink = driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
        homeLink.sendKeys("Wall Street 123");

        String permanentAddressTxt = driver.findElement(By.xpath("//label[text()='Permanent Address']")).getText();
        System.out.println(permanentAddressTxt);



    }
}
