package Testes_08_09;

public final class CalculadoraFrete {

    private CalculadoraFrete(){

    }

    public static double calcular(double pesoKg, boolean entregaExpressa){
            if (pesoKg <= 0){
                throw new IllegalArgumentException("O peso deve ser maior que zero");
            }

            double freteComum = 8.0 + pesoKg * 2.0;

            if (entregaExpressa){
                return freteComum * 1.5;
            }

            return freteComum;
    }

}
