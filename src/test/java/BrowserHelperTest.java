import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.winter24.enums.Endpoints.BROWSER_WINDOWS;
import static com.winter24.enums.Endpoints.DEMO_QA_HOME_PAGE;

public class BrowserHelperTest extends BaseTest{

    @Test
    void test123() throws InterruptedException {
        browserHelper.open(DEMO_QA_HOME_PAGE + BROWSER_WINDOWS.getEndpoint());
        driver.findElement(By.xpath("//span[text()='Alerts']"));
        Thread.sleep(3000);
//        browserHelper.goBack();
//        Thread.sleep(3000);
//        browserHelper.goForward();
//        Thread.sleep(3000);
//        browserHelper.refreshThePage();
////        Thread.sleep(3000);
//        driver.findElement(By.id("tabButton")).click();
//        Thread.sleep(3000);
//        browserHelper.switchToWindow(0);
//        Thread.sleep(3000);
//        driver.findElement(By.id("tabButton")).click();
//        Thread.sleep(5000);
//        browserHelper.switchToWindow(0);
//        driver.findElement(By.id("tabButton")).click();
//        Thread.sleep(5000);

        browserHelper.switchToParentWithChildClose();
    }
}
