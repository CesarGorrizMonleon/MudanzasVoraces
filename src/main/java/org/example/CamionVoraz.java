package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CamionVoraz {

    public ArrayList<Integer> pesoPaqueteCamion (ArrayList<Integer> mercancia ){
        //ordenamos mercancia

        //comprobamos que la mercancia entrante no sea 0
        if (mercancia.size()==0){
            System.out.println("No hay mercancia");
            return new ArrayList<>();
        }
        int pesoCamion = 10000;

        //ordemanomos la mercacia de menos kg a mas kg
        Collections.sort(mercancia);

        //creamos el arry de camion y recorremos la mercancia con un for each
        ArrayList<Integer> camion=new ArrayList<Integer>();
        for (int m:mercancia.stream().toList( )) {
            //calculamos que entre en el camion
            if (pesoCamion - m >= 0 ) {
                //añadimos la carca y restamos el peso y lo mostramos por pantalla
                camion.add(m);
                pesoCamion=pesoCamion-m;

                System.out.println("Introduciomos al camion un peso de "+ m+"kg y un precio de 40 Euros ");

            }else {
                return camion ;
            }
        }
        //calculamos el precio del camion y motramos por pantalla
        int precio = precioCamion(camion);
        System.out.println("La factura es de "+precio + " han cabido "+ camion.size()+" productos.");
        return camion;
    }

    //en el siguiente metodo calculamos el precio de la factura del camion
    public int precioCamion(ArrayList<Integer> camion) {
        return (camion.size())*40;
    }

    public static void main(String[] args) {

    }
}
