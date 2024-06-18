import org.testng.annotations.Test;

import static com.winter24.pages.alerts.enums.SideBarMenuEnum.ADMIN;

public class SideBarMenuTest extends BaseTest{


    @Test
    public void SideBarMenuTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        demoQAPages.getSideBarMenu().chooseSideBarMenu(ADMIN);
        Thread.sleep(200);
    }
}
