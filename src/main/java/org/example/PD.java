package org.example;

import java.util.Scanner;

public class PD {
    static Scanner scanner = new Scanner(System.in);
    private final static int CAPACIDAD = 4;
    private final static int PAGO = 6;
    public static void main(String[] args) {
        int c = CAPACIDAD;
        int[] v = getPaquetes();
        pd(v,c);
    }
    public static int[] getPaquetes(){
        System.out.println("Total paquetes: ");
        int[] v = new int [scanner.nextInt() +1];  //Por la fila vacia.
        //Dejamos la posición 0 con el valor 0 para el vacio.
        for(int i = 0; i < v.length; i++){
            System.out.println("Peso: ");
            v[i] = scanner.nextInt();
        }
        return v;
    }
    public class Paquete{
        public int id, peso, valor;

    }
    public static void pd (int[] v, int C){
        int f = v.length;
        int c = C +1;  //Columna para camión sin capacidad
        int[][] T = new int[f][c];

        //HACER TABLA
        for(int i = 0; i < f; i++){
            for(int j = 0; j < c; j++){
                if(i == 0 || j == 0) {
                    T[i][j] = 0;
                }
                else if(v[i] > j){
                    T[i][j] = T[i-1][j];
                }
                else if(T[i-1][j] >= v[i] + T[i-1][j-v[i]]){        //Si no coger el paquete actual me da mejores resultados que cogerlo
                    T[i][j] = T[i-1][j];
                }
                else{
                    T[i][j] = v[i] + T[i-1][j-v[i]];
                }
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
