package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class PD {
    private static final Logger logger = LogManager.getLogger(PD.class);
    static Scanner scanner = new Scanner(System.in);
    private final static int CAPACIDAD = 9;
    private final static int PAGO = 6;
    public static void main(String[] args) {

    }
    public static int calcularPrecioCamion(ArrayList<Mercancia> camion){

       if (camion.size()==0)return 0;
        int acumulado =0;
        for (Mercancia d:camion) {
            acumulado= acumulado+d.beneficio;
            System.out.println("d.peso+\" \"+d.beneficio = " + d.peso+" "+d.beneficio);
        }
        logger.info("El precio del camión es "+acumulado);
        return acumulado;
    }

    public static ArrayList<Mercancia> objetosSeleccionado(int[][] tabla, ArrayList<Mercancia> mercancias){


        ArrayList<Mercancia> camion= new ArrayList<Mercancia>();
        for (int i = CAPACIDAD; i > 0; i--) {
            for (int j = tabla.length-1; j > 0 ; j--) {
                if (tabla[j][i]!=tabla[j-1][i]){

                    camion.add(mercancias.get(j));
                    i=i-mercancias.get(j).peso+1;
                    break;
                }
            }
        }

        logger.info("se ha calculado el camion"+camion);
        return camion;
    }

    public static int[][] tablaProgDinamica(ArrayList<Mercancia> tabla, int C){
        if (tabla.size()==0)return null;

       tabla.add(0, new Mercancia(0,0));


        for (Mercancia d:tabla) {
            System.out.println("d.peso = " + d.peso);
        }
        int c = C +1;  //Columna para camión sin capacidad
        int[][] T = new int[tabla.size()][c];
        //HACER TABLA
        for(int i = 1; i < tabla.size(); i++){
            for(int j = 0; j < c; j++){
                if(tabla.get(i).peso>j){
                    T[i][j]=T[i-1][j];
                }
                else T[i][j]= Integer.max(T[i-1][j],tabla.get(i).beneficio + T[i-1][j-tabla.get(i).peso]);
            }
        }
        logger.info("calculando la matriz");

        // IMPRIMIR TABLA
        System.out.print("\t\t|\t");
        for (int j = 0; j < c; j++) {
            System.out.print(j + "\t");
        }
        System.out.println("\n-----------------------------------------------");
        for (int i = 0; i < tabla.size(); i++) {
           System.out.print("Peso " + tabla.get(i).peso+ ','+tabla.get(i).beneficio+ "\t|\t");
            for (int j = 0; j < c; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println("\n");
        }



        // MOSTRAR SOLUCION
        //ArrayList<Mercancia> camion = objetosSeleccionado(T,tabla);
        //int precio = calcularPrecioCamion(camion);
        return T;


    }
}
