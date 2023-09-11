package com.example.prueba.tecnica.controllers;
import com.example.prueba.tecnica.models.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.prueba.tecnica.services.CalculatorService;


@RestController
@RequestMapping ("api/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {
    private final CalculatorService calculatorService;
    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @PostMapping("/calculate")
//    @CrossOrigin(origins = "*")
    public Calculation calculate(@RequestBody Calculation calculation) {
        return calculatorService.performCalculation(calculation);
    }
}
