
import com.winter24.helper.DropDownHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectPageTest extends BaseTest {

//    @Test
//    void test123() throws InterruptedException {
//        driver.get("https://demoqa.com/select-menu");
//        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
//
//        DropDownHelper dropDownHelper = new DropDownHelper(driver);
//        dropDownHelper.selectByVisibleText(selectMenu, "Green");
//        Thread.sleep(4000);
//    }

    @Test
    void selectPageTest(){
        driver.get("https://demoqa.com/select-menu");
        demoQAPages.getSelectPage().fillUpSelectPage();
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
        DropDownHelper dropDownHelper = new DropDownHelper(driver);
        dropDownHelper.selectByVisibleText(selectMenu, "Purple");
    }
}
