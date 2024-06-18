package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import com.winter24.entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BasePage {

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public WebTablesPage addNewEmployee(Employee employee) {

        boolean checkEmail = getEmployeesFromTable().stream().anyMatch(e -> e.getEmail().equals(employee.getEmail()));

        if (checkEmail){
            throw new IllegalArgumentException("Such an email already exists: " + employee.getEmail());
        }
        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput, employee.getFirstName())
                .sendKeys(lastNameInput, employee.getLastName())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment())
                .click(submitBtn);
        return this;
    }

    public ArrayList<Employee> getEmployeesFromTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() ||
                    department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));

        }
        return employees;
    }

    public WebTablesPage editEmployeeDate(String email, String fieldToEdit, String newValue) {
        // Получаем все строки таблицы
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        // Проходим по каждой строке
        for (WebElement row : rows) {
            // Получаем все ячейки в строке
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));

            // Проверяем, что количество ячеек больше 3 и что email совпадает
            if (cells.size() > 3 && cells.get(3).getText().equals(email)) {
                // Находим и кликаем по кнопке редактирования
                WebElement editBtn = row.findElement(By.cssSelector("#edit-record-1"));
                webElementActions.click(editBtn);

                // Объявляем переменную для элемента поля ввода
                WebElement inputField;

                // Выбираем поле для редактирования на основе переданного имени поля
                switch (fieldToEdit) {
                    case "firstName":
                        inputField = DriverManager.getDriver().findElement(By.id("firstName"));
                        break;
                    case "lastName":
                        inputField = DriverManager.getDriver().findElement(By.id("lastName"));
                        break;
                    case "age":
                        inputField = DriverManager.getDriver().findElement(By.id("age"));
                        break;
                    case "userEmail":
                        inputField = DriverManager.getDriver().findElement(By.id("userEmail"));
                        break;
                    case "salary":
                        inputField = DriverManager.getDriver().findElement(By.id("salary"));
                        break;
                    case "department":
                        inputField = DriverManager.getDriver().findElement(By.id("department"));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field: " + fieldToEdit);
                }

                // Очищаем и вводим новое значение в поле
                webElementActions.clear(inputField)
                        .sendKeys(inputField, newValue);

                // Находим и кликаем по кнопке сохранения
                WebElement submitBtn = DriverManager.getDriver().findElement(By.id("submit"));
                webElementActions.click(submitBtn);
                break; // Прерываем цикл после редактирования нужной строки
            }
        }
        return this;
    }


    public WebTablesPage deleteEmployeeByEmail(String email){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
        for (WebElement row: rows){
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            if (cells.size() >3 && cells.get(3).getText().equals(email)){
                WebElement deleteBtn = row.findElement(By.cssSelector("span[id^='delete-record-']"));
                webElementActions.click(deleteBtn);
                break;
            }
        }
        return this;
    }
}
