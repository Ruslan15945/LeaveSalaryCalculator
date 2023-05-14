package ru.nsu.morozov.r.service;

public class CalculatorService {

    private CalculatorService() {};

    private static final int DAYS_IN_A_YEAR = 365;

    public static int calculate(Integer salary, Integer vacationDays) {
        int vacationPay = (int) Math.round(
                ((salary==null?0:salary) / (double)DAYS_IN_A_YEAR) *
                        (vacationDays==null?0:vacationDays)
        );
        return vacationPay;
    }

}
