package com.winter24.utils;
import com.github.javafaker.Faker;
import com.winter24.entities.Employee;
import com.winter24.entities.PracticeFormEntity;
import com.winter24.entities.TextBoxEntity;

public class RandomUtils {

    Faker faker = new Faker();


    public TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }


    public PracticeFormEntity generateRandomPracticeFormEntity() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstName(faker.name().firstName());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setUserNumber(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setPicture("C://Users//User//OneDrive//Рабочий стол//1_Arsenal.jpg");
        practiceFormEntity.setCurrentAddress(faker.address().fullAddress());

        return practiceFormEntity;
    }

    public Employee createMockEmployee(){
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18, 100));
        //employee.setEmail("alden@example.com");
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(100000L, 200000L));
        employee.setDepartment(faker.job().position());
        return employee;
    }

}
