import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest{
@Test(description = "Verify double click is working properly")
    public void doubleClickTest(){
    browserHelper.open("https://demoqa.com/buttons");
    webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);
    Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");
}
@Test(description = "Verify right click is working properly")
    public void rightClickTest(){
    browserHelper.open("https://demoqa.com/buttons");
    webElementActions.rightClick(demoQAPages.getButtonsPage().rightClickBtn);
    Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(), "You have done a right click");
}

    @Test(description = "Verify  click is working properly")
    public void dynamicClickTest(){
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.click(demoQAPages.getButtonsPage().dynamicClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().dynamicClickMessage.getText(), "You have done a dynamic click");
    }
}
