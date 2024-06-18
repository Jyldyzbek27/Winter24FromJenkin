import com.winter24.helper.WebElementActions;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test(description = "Verify move to element method is working")
    public void moveToElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(demoQAPages.getMenuPage().mainItem2);
        Thread.sleep(5000);
    }
}
