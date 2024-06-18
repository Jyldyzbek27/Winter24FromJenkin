import com.winter24.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.winter24.enums.Endpoints.*;

public class AlertTest extends BaseTest {
    @Test(groups = {"Smoke", "UI", "1721"}, description = "Alert test")
    @Description("Verify that alert is present")
    @Owner("Nuta")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GCPINT-8877")
    @Epic("Registration")
    @Link("www.google.com")
    void alertTest() throws InterruptedException {
        browserHelper.open(DEMO_QA_HOME_PAGE + ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();
    }

    @Test(groups = {"Regression", "Api", "1722"}, description = "Alert test 1")
    void alertTest1() throws InterruptedException {
        browserHelper.open(DEMO_QA_HOME_PAGE + ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000);
        alertHelper.acceptAlert();
        Thread.sleep(3000);
    }

    @Test(groups = {"E2E", "SQL", "1723"}, description = "Alert test 2")
    void alertTest2() throws InterruptedException {
        browserHelper.open(DEMO_QA_HOME_PAGE + ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000);
        alertHelper.acceptAlert();
        Thread.sleep(3000);
    }

}
