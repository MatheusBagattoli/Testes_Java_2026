package Testes_08_09;

public class CalculadoraPedido {

    private CalculadoraPedido(){

    }

    public static double calculadoraSubTotal(Item item){
        if (item == null){
            throw new IllegalArgumentException("O item é obrigatório");
        }

        return item.precoUniario() * item.quantidade();
    }

    public static double calcularValorFinal(Item item, double percentualCupom){
        if (item == null){
            throw new IllegalArgumentException("O item é obrigatório");
        }

        if (percentualCupom < 0 || percentualCupom > 30){
            throw new IllegalArgumentException("O cupom deve estar entre 0 e 30");
        }

        double subtotal = calculadoraSubTotal(item);

        return subtotal - (subtotal * percentualCupom / 100);
    }

}
