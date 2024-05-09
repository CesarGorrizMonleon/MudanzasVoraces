package org.example;

import java.util.Scanner;

public class MundanzBacktraking {

   public static final int MAX_CAMIONES = 3;
    public  static final int MAX_CAPACIDAD = 20000;
    public static int N =MAX_CAPACIDAD;
    public static int M = MAX_CAPACIDAD;
    public static int[] C =new int[N];   //Carga
    public static int P;
    public static int[] V;
    public static int[] A =new int[3];   //Asignados

    public static void main(String[] args) {
        inicializar();
        VA(0,V,A);      //0 porque es la etapa 1 en el arbol de expansión
        mostrarSolucion(A);
    }
    public static void inicializar() {
        Scanner sc = new Scanner(System.in);
        //Paquetes
        System.out.println("Nº paquetes: ");
        P = sc.nextInt();
        V = new int[P];
        A = new int[P];
        for (int i = 0; i < V.length; i++) {
            System.out.println("Paquete " + (i + 1) + ":");
            V[i] = sc.nextInt();
        }
        //Camiones
        N = MAX_CAPACIDAD;
        C = new int[N];
        M = MAX_CAPACIDAD;
    }
    public static void VA(int k, int[]  V, int[] A){//k = Paquete en el cual estoy
        int[] sol= new int[N];
        for (int camion = 1; camion <= N; camion++) {   //Restriccion explicita
            A[k] = camion;          //Asigno el paquete k en al camion "camion"
            C[camion -1] += V[k];   //Sumo el peso del paquete recien asignado al peso que ya tenia el camion
            if(vivo(camion-1)){     //Comprobamos si la carga, no supera la capacidad maxima del camion
                if(k < P-1){    //Si aun quedan paquetes pasamos a la siguiente etapa (siguiente paquete)
                    VA(k+1,  V,A);
                }else{

                    //Si ya no quedan paquetes hemos encontrado solucion
                     mostrarSolucion(A);

                    System.exit(0);
                }
            }
            C[camion -1] -= V[k];   //Nodo muerto, restamos la carga que habiamos sumado
        }
        A[k] = 0;//Al terminar el ultimo valor de la restricción explicita, hacemos VA. Esto es el nodo VA

    }
    public static int[] mostrarSolucion(int[] A) {  // Misma funcion utilizada para "Mostrar primera solucion" y "no hay solucion"
        if (A.length > 0 && A[0] != 0) {
            for (int i = 0; i < A.length; i++) {
                System.out.print("[" + A[i] + "]");
            }
            System.out.println();
        } else {
            System.out.println("No es posible cargar los 3 camiones");
        }
        return A;
    }
    public static boolean vivo(int k) {
        return C[k] <= M;
    }

}