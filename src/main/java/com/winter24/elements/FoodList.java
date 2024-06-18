package com.winter24.elements;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//import java.util.List;
//
//public class FoodList {

//    WebDriver driver;

//    @BeforeMethod
//    void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://dostavka312.kg/");
//    }
//
//    @AfterMethod
//    void closeDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    @Test
//    void koverSamoletTest() throws InterruptedException {
//
//        WebElement foodLink = driver.findElement(By.xpath("//*[text()='Eды']"));
//        foodLink.click();
//
//        WebElement pishpekRest = driver.findElement(By.xpath("//p[text()='Ресторан Пишпек']"));
//        pishpekRest.click();
//
//        List<WebElement> foodList = driver.findElements(By.xpath("//div[@class='art-postcontent clearfix']"));
//        for (WebElement list1 : foodList) {
//            System.out.println(list1.getText());
//        }
//        System.out.println(foodList.size());
//
//        WebElement pishpekRestMenu = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek']"));
//        pishpekRestMenu.click();
//
//        List<WebElement> breakfast = driver.findElements(By.id("WWMainPage"));
//        for (WebElement list2 : breakfast) {
//            System.out.println(list2.getText());
//        }
//        System.out.println(breakfast.size());
//    }
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

    public class FoodList {
        WebDriver driver;

        @BeforeMethod
        void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://dostavka312.kg/");
        }

        @AfterMethod
        void closeDown() {
            if (driver != null) {
                driver.quit();
            }
        }

        @Test
        void koverSamoletTest() throws InterruptedException {

            WebElement foodLink = driver.findElement(By.xpath("//*[text()='Eды']"));
            foodLink.click();

            WebElement pishpekRest = driver.findElement(By.xpath("//p[text()='Ресторан Пишпек']"));
            pishpekRest.click();

            // Поиск всех элементов с классом "art-postcontent clearfix"
            List<WebElement> restList = driver.findElements(By.xpath("//div[@class='panel-heading']//p[1]"));
            for (WebElement list1 : restList) {
                System.out.println(list1.getText());
            }
            System.out.println("Количество элементов в foodList: " + restList.size());
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");

            WebElement pishpekRestMenu = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek']"));
            pishpekRestMenu.click();

            // Поиск всех элементов с id "WWMainPage"
            List<WebElement> breakfast = driver.findElements(By.xpath("(//div//div[@class='art-postcontent clearfix product'])[1]"));
            for (WebElement list2 : breakfast) {
                System.out.println(list2.getText());
            }
            System.out.println("Количество элементов в breakfast: " + breakfast.size());
        }
    }







