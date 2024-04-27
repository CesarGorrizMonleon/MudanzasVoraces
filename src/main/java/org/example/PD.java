package org.example;


import java.util.*;

public class PD {
    static Scanner scanner = new Scanner(System.in);
    private final static int CAPACIDAD = 9;
    private final static int PAGO = 6;
    public static void main(String[] args) {
        int c = CAPACIDAD;
        ArrayList<Mercancia> v = new ArrayList<>();
        v.add(new Mercancia(3,7));
        v.add(new Mercancia(4,9));
        v.add(new Mercancia(3,6));
        v.add(new Mercancia(3,6));
        v.add(new Mercancia(3,6));


        tablaProgDinamica(v,c);

    }
    public int calcularPrecioCamion (ArrayList<Mercancia> camion){
       if (camion.size()==0)return 0;
        int acumulado =0;
        for (Mercancia d:camion) {
            acumulado= acumulado+d.beneficio;
        }
        System.out.println("El precio  del  camión es" + camion+"€");
        return acumulado;
    }

    public static int[][] tablaProgDinamica(ArrayList<Mercancia> tabla, int C){
        

       tabla.add(0, new Mercancia(0,0));


        for (Mercancia d:tabla) {
            System.out.println("d.peso = " + d.peso);
        }
        int c = C +1;  //Columna para camión sin capacidad
        int[][] T = new int[tabla.size()][c];

        //HACER TABLA
        for(int i = 1; i < tabla.size(); i++){
            for(int j = 0; j < c; j++){

                T[i][j]= Integer.max(T[i-1][j],tabla.get(i).beneficio + T[i-1][j-tabla.get(i).peso]);
            }
        }
        // IMPRIMIR TABLA
        System.out.print("\t\t|\t");
        for (int j = 0; j < c; j++) {
            System.out.print(j + "\t");
        }
        System.out.println("\n-----------------------------------------------");
        for (int i = 0; i < tabla.size(); i++) {
           System.out.print("Peso " + tabla.get(i) + "\t|\t");
            for (int j = 0; j < c; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println("\n");
        }

        // MOSTRAR SOLUCION
        int i, j, pesoT;


        pesoT = T[tabla.size() - 1][c - 1];
        System.out.println("Capacidad maxima del camion: " + pesoT);
        System.out.println("Mercancias utilizadas: ");
        i = tabla.size() - 1;
        j = c - 1;
        while (i > 0 && j > 0) {
            if (T[i][j] != T[i - 1][j]) {

                //j == v[i];
            }
            i--;
        }
        System.out.println("");
        System.out.println("Factura: " + pesoT * PAGO);
        return T;
    }
}
