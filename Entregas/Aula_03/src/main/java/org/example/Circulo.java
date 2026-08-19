package org.example;

public class Circulo {

    private double raio;

    public Circulo(double raio){
        if (raio <= 0){
            throw new IllegalArgumentException("O raio deve ser maior que zero");
        }
        this.raio = raio;
    }

    public Circulo(){

    }

    public double getRaio() {
        return raio;
    }

    public double calcularArea(){
        return Math.PI * Math.pow(raio, 2);
    }

}
