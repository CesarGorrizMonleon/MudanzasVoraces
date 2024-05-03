package org.example;

public class MercanciaBacktraking {
    int peso;
    int camion;

    public MercanciaBacktraking(int peso,int camion) {

        this.camion = camion;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCamion() {
        return camion;
    }

    public void setCamion(int camion) {
        this.camion = camion;
    }
}
