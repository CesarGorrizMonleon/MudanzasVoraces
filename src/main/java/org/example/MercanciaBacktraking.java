package org.example;

public class MercanciaBacktraking {
    int peso;
    int camion;
    float beneficio;
    float preciokilo = 0.052543f;

    public MercanciaBacktraking(int peso,int camion, int beneficio) {

        this.camion = camion;
        this.peso = peso;
        this.beneficio= beneficio;
        //this.beneficio=Float.class.cast(peso)*preciokilo ;
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
