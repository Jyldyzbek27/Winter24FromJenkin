import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressBarPageTest extends BaseTest{
    @Test(description = "ariaValueNow")
    @Step("Progress bar page Test")
    public void progressBarPageTest(){
        browserHelper.open("https://demoqa.com/progress-bar");
        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);
        String value;
        while (true) {
            value = demoQAPages.getProgressBarPage().aria_valueNow.getAttribute("aria-valueNow");
            if (value.equals("52")) {
                webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);
                break;
            }
        }
        Assert.assertEquals(value, "52");
    }
}