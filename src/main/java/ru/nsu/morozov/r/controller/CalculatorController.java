package ru.nsu.morozov.r.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.morozov.r.service.CalculatorService;


@RestController
public class CalculatorController {

    @GetMapping("/"+"${api.queries.calculate}")
    public ResponseEntity<Integer> calculate(@RequestParam("${api.queries.calculate.options.averageSalary}") int averageSalary, @RequestParam("${api.queries.calculate.options.vacationDaysCount}") int vacationDaysCount) {
        int vacationPay = CalculatorService.calculate(averageSalary, vacationDaysCount);
        return new ResponseEntity<>(vacationPay, HttpStatus.OK);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<?> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
