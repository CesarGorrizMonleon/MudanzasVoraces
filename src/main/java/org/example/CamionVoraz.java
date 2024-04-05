package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CamionVoraz {

    public void camion (ArrayList<Integer> mercancia ){
        //ordenamos mercancia


        if (mercancia.size()==0){
            System.out.println("No hay mercancia");

        }
        int pesoCamion = 10000;

        Collections.sort(mercancia);
        int precio=0;
        ArrayList<Integer> camion=new ArrayList<Integer>();
        for (int m:mercancia.stream().toList( )) {
            if (pesoCamion - m >= 0) {
                camion.add(m);
                precio=precio+40;
                System.out.println("Introduciomos al camion un peso de "+ m+"kg y un precio de 40 Euros ");

            }else {
                return;
            }
        }
        System.out.println("La factura es de "+precio + " han cabido "+ camion.size()+" productos.");

    }
    public static void main(String[] args) {
        System.out.println("args = " + args);
    }
}
