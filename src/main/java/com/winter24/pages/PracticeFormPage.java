package com.winter24.pages;

import com.winter24.drivers.DriverManager;
import com.winter24.entities.PracticeFormEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class PracticeFormPage extends BasePage {

    @FindBy(xpath = "(//div[@class='header-wrapper'])[2]")
    public WebElement formsBtn;

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement practiceEmailInput;

    @FindBy(id = "userNumber")
    public WebElement userNumberInput;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(xpath = "//label[(text())='Male']")
    public WebElement choiceMaleBtn;

    @FindBy(xpath = "//label[(text())='Female']")
    public WebElement choiceFemaleBtn;

    @FindBy(xpath = "//label[(text())='Other']")
    public WebElement choiceOtherBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement choiceSportBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    public WebElement choiceReadingBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    public WebElement choiceMusicBtn;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerBtn;


    public void randomChoiceGender() {
        WebElement[] genderOptions = {choiceMaleBtn, choiceFemaleBtn, choiceOtherBtn};
        Random random = new Random();
        int randomIndex = random.nextInt(genderOptions.length);
        WebElement selectedGenderOption = genderOptions[randomIndex];
        webElementActions.click(selectedGenderOption);
    }

    public void randomChoiceHobbies() {
        WebElement[] hobbiesOptions = {choiceSportBtn, choiceReadingBtn, choiceMusicBtn};
        Random random = new Random();
        int randomIndex = random.nextInt(hobbiesOptions.length);
        WebElement selectedHobbiesOption = hobbiesOptions[randomIndex];
        webElementActions.click(selectedHobbiesOption);
    }

    public void selectDateMonthYear(String dateMonthYear) { //05 Jun 2024
        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String date = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        webElementActions.click(datePickerBtn);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        dropDownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);
////div[contains(@class,'react-datepicker__day') and not (contains(@class, 'react-datepicker__day--outside-month')) and text()='4']
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'react-datepicker__day') and not (contains(@class, 'react-datepicker__day--outside-month')) and text()='" + date + "']")));
        webElementActions.click(day);
    }


    @Step("Enter random date")
    private void enterRandomDate() {
        // Формат даты, используемый в поле формы
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        // Создаем обьект с определенной датой для проверки возраста. Чтобы к 01.05.2024 ползователю было 18лет или более
        LocalDate checkDate = LocalDate.of(2024, 5, 1);
        // Минимальная допустимая дата рождения для людей старше 18 лет на момент 1 мая 2024 года
        LocalDate minDateOfBirth = checkDate.minusYears(18);
        // Генерация случайной даты рождения (от 19 до 100 лет назад)
        long days = ChronoUnit.DAYS.between(minDateOfBirth.minusYears(82), minDateOfBirth.minusYears(1));
        Random random = new Random();
        long randomDays = random.nextInt((int) days + 1);
        LocalDate randomDateOfBirth = minDateOfBirth.minusYears(82).plusDays(randomDays);
        // Преобразование даты в строку для ввода в форму
        String inputDateStr = randomDateOfBirth.format(dateFormatter);
        // Ввод данных в форму
        WebElement dateOfBirthInput = DriverManager.getDriver().findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        // Открытие календаря и выбор даты
        Select monthSelect = new Select(DriverManager.getDriver().findElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByValue(String.valueOf(randomDateOfBirth.getMonthValue() - 1));
        Select yearSelect = new Select(DriverManager.getDriver().findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByValue(String.valueOf(randomDateOfBirth.getYear()));
        WebElement daySelect = DriverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'react-datepicker__day--0" + randomDateOfBirth.getDayOfMonth() + "')]"));
        daySelect.click();
    }


    public void randomChoiceSubject() {
        try {
            // Список букв для выбора
            String[] letters = {"m", "s", "c"};
            Random random = new Random();
            // Выбор случайной буквы
            String randomLetter = letters[random.nextInt(letters.length)];
            // Ввести случайную букву в поле ввода, чтобы вызвать выпадающий список
            webElementActions.sendKeys(subjectsInput, randomLetter);
            // Явное ожидание появления выпадающего списка
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            List<WebElement> dropDownItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".subjects-auto-complete__option")));
            // Выбрать случайный элемент из выпадающего списка
            int randomIndex = random.nextInt(dropDownItems.size());
            WebElement randomItem = dropDownItems.get(randomIndex);
            randomItem.click();
        } catch (NoSuchElementException ignored) {
        }
    }


    public void choiceRandomStateAndCity() {
        Random random = new Random();
        // Клик на вкладку штаты
        WebElement stateDropdown = DriverManager.getDriver().findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder' and text()='Select State']"));
        stateDropdown.click();
        // Ожидание, пока выпадающее меню будет видимо
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,' css-26l3qy-menu')]")));
        // Получение списка всех штатов в выпадающем меню
        List<WebElement> stateOptions = DriverManager.getDriver().findElements(By.xpath("//div[contains(@class,' css-26l3qy-menu')]"));
        int stateIndex = random.nextInt(stateOptions.size());
        WebElement selectedState = stateOptions.get(stateIndex);
        selectedState.click();
        // Выбор города
        WebElement cityDropdown = DriverManager.getDriver().findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder' and text()='Select City']"));
        cityDropdown.click();
        // Ожидание, пока выпадающее меню будет видимо
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-11unzgr']")));
        // Получение списка всех городов в выпадающем меню
        List<WebElement> cityOptions = DriverManager.getDriver().findElements(By.xpath("//div[@class=' css-11unzgr']"));
        int cityIndex = random.nextInt(cityOptions.size());
        WebElement selectedCity = cityOptions.get(cityIndex);
        selectedCity.click();
    }


    public PracticeFormPage fillUpPracticeFormPage(PracticeFormEntity practiceFormEntity) {
        webElementActions.click(formsBtn).click(practiceFormBtn);
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(practiceEmailInput, practiceFormEntity.getEmail());
        randomChoiceGender();
        webElementActions.sendKeys(userNumberInput, practiceFormEntity.getUserNumber());
        enterRandomDate();
        //selectDateMonthYear("30 Jul 2009");
        randomChoiceSubject();
        randomChoiceHobbies();
        webElementActions.sendKeys(uploadPicture, practiceFormEntity.getPicture())
                .sendKeys(currentAddress, practiceFormEntity.getCurrentAddress());
        choiceRandomStateAndCity();
        webElementActions.click(submitBtn);
        return this;

    }


}

