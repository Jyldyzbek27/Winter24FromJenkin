import com.winter24.drivers.DriverManager;
import com.winter24.entities.TextBoxEntity;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    @Test
    public void textBoxTest() {
        driver.get("https://demoqa.com/text-box");
        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();
        demoQAPages.getTextBoxPage().fillUpTextBoxForm(textBoxEntity);
    }
}
