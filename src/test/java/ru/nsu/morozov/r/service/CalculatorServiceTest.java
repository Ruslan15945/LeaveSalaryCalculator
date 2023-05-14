package ru.nsu.morozov.r.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nsu.morozov.r.service.CalculatorService;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    CalculatorService service;

    @Test
    public void testCalculateInteger() {
        int salary = 365;
        int vacationDays = 100;
        int expectedVacationPay = 100;
        int actualVacationPay = service.calculate(salary, vacationDays);
        Assertions.assertEquals(expectedVacationPay, actualVacationPay);
    }

    @Test
    public void testCalculateRound() {
        int salary = 120000;
        int vacationDays = 20;
        int expectedVacationPay = 6575; // 120k/365*20=6575.342
        int actualVacationPay = service.calculate(salary, vacationDays);
        Assertions.assertEquals(expectedVacationPay, actualVacationPay);
    }

    @Test
    public void testCalculateWithZeroSalary() {
        int salary = 0;
        int vacationDays = 20;
        int expectedVacationPay = 0;
        int actualVacationPay = service.calculate(salary, vacationDays);
        Assertions.assertEquals(expectedVacationPay, actualVacationPay);
    }

    @Test
    public void testCalculateWithZeroVacationDays() {
        int salary = 120000;
        int vacationDays = 0;
        int expectedVacationPay = 0;
        int actualVacationPay = service.calculate(salary, vacationDays);
        Assertions.assertEquals(expectedVacationPay, actualVacationPay);
    }

    @Test
    public void testCalculateWithNullArguments() {
        Integer salary = null;
        Integer vacationDays = null;
        int expectedVacationPay = 0;
        int actualVacationPay = service.calculate(salary, vacationDays);
        Assertions.assertEquals(expectedVacationPay, actualVacationPay);
    }
}
