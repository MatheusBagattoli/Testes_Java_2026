package Testes_01_09;

public class ContaDigital {

    private final String titular;
    private double saldo;

    public ContaDigital(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O deposito deve ser maior que zero");
        }

        saldo += valor;
    }

    public void sacar(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("O saque deve ser maior que zero");
        }

        if (valor > saldo){
            throw new IllegalStateException("Saldo insuficiente");
        }

        saldo -= valor;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
