package com.winter24.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DemoQATest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\DemoQAWinter24\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void navigateToUrl() {
        driver.get("https://demoqa.com/text-box");
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void textBoxAndSubmit() throws InterruptedException {

        //Ввод имени
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("John Doe");

        //Ввод имейла
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("JohnDoe@gmail.com");

        //Ввод текущего адреса
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("WallStreet 123");

        //Ввод постоянного адреса
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("London, Emirates Stadium");

        //Клик на кнопку Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        scrollToElement(submitButton); // Прокручиваем к элементу, если необходимо
        submitButton.click();

        //Установка ожидания для выплывающих данных после ввода
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

        //Инициализация выплывающих данных
        WebElement nameOutput = driver.findElement(By.id("name"));
        WebElement emailOutput = driver.findElement(By.id("email"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div/p[3]"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//div[@id='output']//p[@id='permanentAddress']"));


        try {
            // Используем Assert.assertEquals для точного сравнения строк
            Assert.assertEquals(nameOutput.getText().trim(), "Name:John Doe", "Name does not match");
            Assert.assertEquals(emailOutput.getText().trim(), "Email:JohnDoe@gmail.com", "Email does not match");
            Assert.assertEquals(currentAddressOutput.getText().trim(), "Current Address :WallStreet 123", "Current Address does not match");
            Assert.assertEquals(permanentAddressOutput.getText(), "Permananet Address :London, Emirates Stadium", "Permanent Address does not match");
            //Сравнение ожидаемого и фактического
        } catch (AssertionError e) {
            System.out.println("Expected Name: Name:John Doe");
            System.out.println("Actual Name: " + nameOutput.getText().trim());

            System.out.println("Expected Email: Email:JohnDoe@gmail.com");
            System.out.println("Actual Email: " + emailOutput.getText().trim());

            System.out.println("Expected Current Address: Current Address :WallStreet 123");
            System.out.println("Actual Current Address: " + currentAddressOutput.getText().trim());

            System.out.println("Expected Permanent Address: Permananet Address :London, Emirates Stadium");
            System.out.println("Actual Permanent Address: " + permanentAddressOutput.getText().trim());

            throw e; // Повторно бросаем исключение, чтобы тест не проходил в случае ошибки
        }
    }

    // Метод для прокрутки к элементу
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
