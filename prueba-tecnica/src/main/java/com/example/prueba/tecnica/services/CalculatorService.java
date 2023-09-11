package com.example.prueba.tecnica.services;
import com.example.prueba.tecnica.models.Calculation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Calculation performCalculation(Calculation calculation) {
        switch (calculation.getOperator()) {
            case "+":
                calculation.setResult(calculation.getOperand1() + calculation.getOperand2());
                break;
            case "-":
                calculation.setResult(calculation.getOperand1() - calculation.getOperand2());
                break;
            case "*":
                calculation.setResult(calculation.getOperand1() * calculation.getOperand2());
                break;
            case "/":
                if (calculation.getOperand2() != 0) {
                    calculation.setResult(calculation.getOperand1() / calculation.getOperand2());
                } else {
                    calculation.setResult(Double.NaN); // División por cero
                }
                break;
            default:
                calculation.setResult(Double.NaN); // Operador no válido
        }
        return calculation;
    }
}
