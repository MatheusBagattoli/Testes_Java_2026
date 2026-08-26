package org.example;

public class CalculadoraFrete {

    private CalculadoraFrete(){

    }

    public static double calcular(double pesoKg, boolean entregaExpressa){
        if (pesoKg < 0 || pesoKg == 0){
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        }

        double valorFrete = 8.00 + (2.00 * pesoKg);

        if (entregaExpressa){
            valorFrete = valorFrete * 1.50;
        }

        return valorFrete;
    }
}
