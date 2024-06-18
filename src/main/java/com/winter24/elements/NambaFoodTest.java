package com.winter24.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NambaFoodTest {
    WebDriver driver;

    @BeforeMethod
    void makingAnOrder() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://nambafood.kg/");
    }

//    @AfterMethod
//    void closeDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }


    @Test
    void clickFoodNambe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement foodLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/food']")));
        foodLink.click();

        WebElement nationalCuisineLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'cat-item--title') and text()='Национальная кухня']")));
        nationalCuisineLink.click();

        WebElement alligator = driver.findElement(By.xpath("//img[@src='/image/125x125/18560.png']"));
        alligator.click();


        WebElement rukkola = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'status') and contains(@class, 'active') and contains(@class, 'bay_item')]"));
        rukkola.click();


        WebElement orderButton1 = driver.findElement(By.xpath("//button[@class='status active bay_item' and normalize-space()='Заказать']"));
        orderButton1.click();

        WebElement basketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart\"]/a")));

        basketButton.click();



        WebElement placeHolder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='order--btn order--access']")));
        placeHolder = wait.until(ExpectedConditions.elementToBeClickable(placeHolder));
        placeHolder.click();

        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#food_order_client_name")));
        name.sendKeys("Husein");

        WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#food_order_address")));
        address.sendKeys("Бишкек, Ак-Ордо");

        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#food_order_phone")));
        phone.sendKeys("0777 333 777");

        WebElement moneyChange = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#food_order_money_change")));
        moneyChange.sendKeys("2000");

        WebElement buttonOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='payment_cash']")));

        buttonOrder.click();

    }


}
