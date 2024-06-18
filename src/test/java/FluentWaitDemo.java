import com.winter24.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {
    public static void main(String[] args) {

        // Настройка WebDriver для Chrome
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Переход на целевую страницу
        driver.get("https://example.com");

        // Настройка FluentWait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  // Максимальное время ожидания 30 секунд
                .pollingEvery(Duration.ofSeconds(5))  // Интервал проверки 5 секунд
                .ignoring(NoSuchElementException.class); // Игнорирование NoSuchElementException

        // Определение условия для ожидания
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = driver.findElement(By.id("dynamicElement"));
                if (el.isDisplayed()) {
                    return el;
                }
                return null;
            }
        });

        // Работа с найденным элементом
        System.out.println("Element is displayed: " + element.isDisplayed());

        // Закрытие браузера
        driver.quit();
    }
    }
