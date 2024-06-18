import com.winter24.drivers.DriverManager;
import com.winter24.helper.AlertHelper;
import com.winter24.helper.BrowserHelper;
import com.winter24.helper.IframeHelper;
import com.winter24.helper.WebElementActions;
import com.winter24.pages.*;
import com.winter24.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected DemoQAPages demoQAPages;
    protected IframeHelper iframeHelper;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        demoQAPages = new DemoQAPages();
        iframeHelper = new IframeHelper(driver);

    }

//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        DriverManager.closeDriver();
//    }
}
