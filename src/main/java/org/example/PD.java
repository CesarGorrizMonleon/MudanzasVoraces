package org.example;


import java.util.Random;
import java.util.Scanner;
import org.example.Mercancia;

public class PD {
    static Scanner scanner = new Scanner(System.in);
    private final static int CAPACIDAD = 9;
    private final static int PAGO = 6;
    public static void main(String[] args) {
        int c = CAPACIDAD;
        Mercancia[] v = new Mercancia[5];
        Mercancia m1 = new Mercancia(3,7);
        v[0]=m1;
        Mercancia m2 = new Mercancia(4,9);
        v[1]=m2;
        Mercancia m3 = new Mercancia(3,6);
        v[2]= m3;
        Mercancia m4 = new Mercancia(3,6);
        v[3]=m4;
        Mercancia m5 = new Mercancia(3,6);
        v[4]=m5;
        pd(v,c);

    }


    public static int[][] pd (Mercancia[] v, int C){
        int f = v.length+1;
        int c = C +1;  //Columna para camión sin capacidad
        int[][] T = new int[f][c];

        //HACER TABLA
        for(int i = 0; i < f; i++){
            for(int j = 0; j < c; j++){
                T[i][j]= Integer.max(T[i-1][j],v[i].beneficio + T[i-1][j-v[i].peso]);
            }
        }
        // IMPRIMIR TABLA
        System.out.print("\t\t|\t");
        for (int j = 0; j < c; j++) {
            System.out.print(j + "\t");
        }
        System.out.println("\n-----------------------------------------------");
        for (int i = 0; i < f; i++) {
            System.out.print("Peso " + v[i] + "\t|\t");
            for (int j = 0; j < c; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println("\n");
        }

        // MOSTRAR SOLUCION
        int i, j, pesoT;


        pesoT = T[f - 1][c - 1];
        System.out.println("Capacidad maxima del camion: " + pesoT);
        System.out.println("Mercancias utilizadas: ");
        i = f - 1;
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
