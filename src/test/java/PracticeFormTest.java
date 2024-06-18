import com.winter24.entities.PracticeFormEntity;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest{

    @Test
    public void practiceFormTest() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        demoQAPages.getPracticeFormPage().fillUpPracticeFormPage(practiceFormEntity);
        Thread.sleep(7000);
    }
}
