import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.winter24.enums.Endpoints.*;

public class FrameTest extends BaseTest{

    @Test(description = "Verify driver can switch to another frame")
    public void frameTextPrint() {
        browserHelper.open(DEMO_QA_HOME_PAGE.getEndpoint() + FRAMES.getEndpoint());
        iframeHelper.switchToFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        webElementActions.pause(5000);
    }
}
