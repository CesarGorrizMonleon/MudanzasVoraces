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
    public static int calcularPrecioCamion (ArrayList<Mercancia> camion){
       if (camion.size()==0)return 0;
        int acumulado =0;
        for (Mercancia d:camion) {
            acumulado= acumulado+d.beneficio;
            System.out.println("d.peso+\" \"+d.beneficio = " + d.peso+" "+d.beneficio);
        }
        System.out.println("El precio  del  camión es" + acumulado+"€");
        return acumulado;
    }

    public static ArrayList<Mercancia> objetosSeleccionado(int[][] tabla,ArrayList<Mercancia>mercancias){


        ArrayList<Mercancia> camion= new ArrayList<>();
        for (int i = CAPACIDAD; i > 0; i--) {
            for (int j = tabla.length-1; j > 0 ; j--) {
                if (tabla[j][i]!=tabla[j-1][i]){

                    camion.add(mercancias.get(j));
                    i=i-mercancias.get(j).peso+1;
                    break;
                }
            }
        }
        return camion;
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
                if(tabla.get(i).peso>j){
                    T[i][j]=T[i-1][j];
                }
                else T[i][j]= Integer.max(T[i-1][j],tabla.get(i).beneficio + T[i-1][j-tabla.get(i).peso]);
            }
        }
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
        ArrayList<Mercancia> camion = objetosSeleccionado(T,tabla);
        int precio = calcularPrecioCamion(camion);
        return T;

//        int i, j, pesoT;
//
//
//        pesoT = T[tabla.size() - 1][c - 1];
//        System.out.println("Capacidad maxima del camion: " + pesoT);
//        System.out.println("Mercancias utilizadas: ");
//        i = tabla.size() - 1;
//        j = c - 1;
//        while (i > 0 && j > 0) {
//            if (T[i][j] != T[i - 1][j]) {
//
//                //j == v[i];
//            }
//            i--;
//        }
//        System.out.println("");
//        System.out.println("Factura: " + pesoT * PAGO);
//        return T;
    }
}
