package Testes_01_09;

public class Lampada {

    private final String comodo;
    private boolean ligada;
    private int intensidade;

    public Lampada(String comodo) {
        this.comodo = comodo;
        this.ligada = false;
        this.intensidade = 0;
    }

    public void ligar() {
        ligada = true;
        intensidade = 100;
    }

    public void desligar() {
        ligada = false;
        intensidade = 0;
    }

    public String getComodo() {
        return comodo;
    }

    public boolean isLigada() {
        return ligada;
    }

    public int getIntensidade() {
        return intensidade;
    }
}
