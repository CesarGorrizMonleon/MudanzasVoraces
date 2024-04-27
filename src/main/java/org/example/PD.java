package org.example;


import java.util.Random;
import java.util.Scanner;
import org.example.Mercancia;

public class PD {
    static Scanner scanner = new Scanner(System.in);
    private final static int CAPACIDAD = 8;
    private final static int PAGO = 6;
    public static void main(String[] args) {
        int c = CAPACIDAD;
        Mercancia[] v = getPaquetes();
        pd(v,c);
    }
    public static Mercancia[] getPaquetes(){
        System.out.println("Total paquetes: ");
        Mercancia[] v = new Mercancia[scanner.nextInt() +1];  //Por la fila vacia.
        //Dejamos la posición 0 con el valor 0 para el vacio.
        for(int i = 0; i < v.length; i++){
            System.out.println("Peso: ");
            v[i].peso =scanner.nextInt();
            System.out.println("Beneficio: ");
            v[i].beneficio =scanner.nextInt();
        }

        return v;
    }
    public static void pd (Mercancia[] v, int C){
        int f = v.length+1;
        int c = C +1;  //Columna para camión sin capacidad
        int[][] T = new int[f][c];

        //HACER TABLA
        for(int i = 0; i < f; i++){
            for(int j = 0; j < c; j++){
                T[i][j]= Integer.max(T[i-1][j],)
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
                System.out.print("[" + v[i] + "]");
                j -= v[i];
            }
            i--;
        }
        System.out.println("");
        System.out.println("Factura: " + pesoT * PAGO);

    }
}
