import com.winter24.entities.Employee;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest{

    @Test(description = "Web tables page test")
    public void webTablesTest(){
        driver.get("https://demoqa.com/webtables");
        demoQAPages.getWebTablesPage().addNewEmployee(randomUtils.createMockEmployee());

        List<Employee> employees = demoQAPages.getWebTablesPage().getEmployeesFromTable();

        for (Employee employee: employees){
            System.out.println(employee);
        }
    }
}
