package org.example;

public class Mercancia {
    int peso;
    int beneficio;

    public Mercancia(int p,int b){
        peso=p;
        beneficio=b;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }
}
