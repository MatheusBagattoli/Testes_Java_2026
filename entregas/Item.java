package Testes_08_09;

public record Item(String nome, double precoUniario, int quantidade) {

    public Item{

        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("O nome do item é obrigatório");
        }

        if (precoUniario <= 0){
            throw new IllegalArgumentException("O preço deve ser maior que zero");
        }

        if (quantidade <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
    }
}
