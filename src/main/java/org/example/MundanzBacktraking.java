package org.example;

import java.util.ArrayList;

public class MundanzBacktraking {
    static int CAPACIDAD=20;

    public static void main(String[] args) {
        ArrayList<MercanciaBacktraking> mercancias = new ArrayList<MercanciaBacktraking>();
        mercancias.add(new MercanciaBacktraking(3,0,7));
        mercancias.add(new MercanciaBacktraking(4,0,9));
        mercancias.add(new MercanciaBacktraking(5,0,10));
        ArrayList<Integer> y = new ArrayList<Integer>();
        ArrayList<Integer> x = new ArrayList<Integer>();

        Mochila(mercancias, 1,x,y);
    }

    public static int pesoTotal(ArrayList<Integer> x, ArrayList<MercanciaBacktraking> mercancias){
        int total=0;
        for(int i=0;i<x.size();i++){
            if(x.get(i)==1) {
                total = total + mercancias.get(i).peso;
            }
        }
        return total;
    }

    public static boolean beneficio(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<MercanciaBacktraking> mercancias){
        float beneficio1 = 0;
        float beneficio2=0;
        for(int i=0;i<y.size();i++){
            if(y.get(i) == 1) {
                beneficio1 = beneficio1 + mercancias.get(i).beneficio;
            }
            else if(x.get(i)==1) {
                beneficio2 = beneficio2 + mercancias.get(i).beneficio;
            }
        }
        if (beneficio2>=beneficio1) return true;
        return false;
    }


    public static boolean Mochila(ArrayList<MercanciaBacktraking> mercancias, int k,ArrayList<Integer> x,ArrayList<Integer> y) {
        // k : objeto o nivel k
        // Globales: vectores de beneficios y pesos, capacidad de la mochila,
        // x vector solución con x[1],…,x[k-1] ya calculados,
        // y vector óptimo temporal

        for (int i = 0; i<=1; i++) {
                x.add(i);
                if(pesoTotal(x,mercancias)<CAPACIDAD){ // los elegidos desde 1 hasta k caben en la mochila
                    if(k==mercancias.size()){ // solución
                        if(beneficio(x,y,mercancias)){  // y=x si beneficio de x mejora al de y
                            y=x; // actualizar óptimo local

                        }
                    }
                    else Mochila(mercancias, k+1,x,y);// k<n meter mercancia
                }
            }
        for(int j=0;j<y.size();j++){
            System.out.println(y.get(j));
        }

        return true;
    }
}
