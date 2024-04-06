package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CamionVoraz {

    public ArrayList<Integer> pesoPaqueteCamion (ArrayList<Integer> mercancia ){
        //ordenamos mercancia


        if (mercancia.size()==0){
            System.out.println("No hay mercancia");
            return new ArrayList<>();
        }
        int pesoCamion = 10000;

        Collections.sort(mercancia);

        ArrayList<Integer> camion=new ArrayList<Integer>();
        for (int m:mercancia.stream().toList( )) {
            if (pesoCamion - m >= 0 ) {
                camion.add(m);
                pesoCamion=pesoCamion-m;

                System.out.println("Introduciomos al camion un peso de "+ m+"kg y un precio de 40 Euros ");

            }else {
                return camion ;
            }
        }
        int precio = precioCamion(camion);
        System.out.println("La factura es de "+precio + " han cabido "+ camion.size()+" productos.");
        return camion;
    }

    public int precioCamion(ArrayList<Integer> camion) {
        return (camion.size())*40;
    }

    public static void main(String[] args) {

    }
}
