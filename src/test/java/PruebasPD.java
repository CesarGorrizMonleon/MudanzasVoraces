import org.example.CamionVoraz;

import org.example.Mercancia;
import org.example.PD;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


import  org.junit.jupiter.api.Assertions.*;
;import static org.junit.jupiter.api.Assertions.*;

public class PruebasPD {
    private final static int CAPACIDAD = 9;

    public static void main(String[] args) {
        System.out.println("Test");
        PD camion = new PD();
    }

    @Test
    public void MercanciaVacia(){
        System.out.println("Test de que no haya mercancia");

        ArrayList<Mercancia> vacia = new ArrayList<Mercancia>();
        assertEquals(null,PD.tablaProgDinamica(vacia,1));
    }
    @Test
    public void ComprobarTablaDinamica(){
        System.out.println("Test de que no haya mercancia");
        ArrayList<Mercancia> v = new ArrayList<>();
        v.add(new Mercancia(3,7));
        v.add(new Mercancia(4,9));
        v.add(new Mercancia(3,6));
        v.add(new Mercancia(3,6));
        v.add(new Mercancia(3,6));
        ArrayList<Mercancia> vacia = new ArrayList<Mercancia>();
        int[][] vector = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,7,7,7,7,7,7,7},
                {0,0,0,7,9,9,9,16,16,16},
                {0,0,0,7,9,9,13,16,16,16},
                {0,0,0,7,9,9,13,16,16,19},
                {0,0,0,7,9,9,13,16,16,19}
        };
        int[][]d =PD.tablaProgDinamica(v,CAPACIDAD);

        //Debemos comprobar
        assertArrayEquals(vector,d);
    }

    @Test
    public void ComprovarPrecio(){
        ArrayList<Mercancia> precio = new ArrayList<>();
        precio.add(new Mercancia(3,7));
        precio.add(new Mercancia(3,6));
        precio.add(new Mercancia(3,6));
        int a = 19;
        assertEquals(19, PD.calcularPrecioCamion(precio));
        System.out.println("El precio  del  camión es" +PD.calcularPrecioCamion(precio)+"€");
    }

    @Test
    public void ComprovarObjetosSeleccionados(){

        ArrayList<Mercancia> v = new ArrayList<Mercancia>(Arrays.asList(
                new Mercancia(0,0),
                new Mercancia(3,7),
                new Mercancia(4,9),
                new Mercancia(3,6),
                new Mercancia(3,6),
                new Mercancia(3,6)
        ));


        int[][] vector = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,7,7,7,7,7,7,7},
                {0,0,0,7,9,9,9,16,16,16},
                {0,0,0,7,9,9,13,16,16,16},
                {0,0,0,7,9,9,13,16,16,19},
                {0,0,0,7,9,9,13,16,16,19}
        };
        Mercancia[] precio = {
                new Mercancia(3, 6),
                new Mercancia(3, 8),

                new Mercancia(3, 7)
        };
        ArrayList<Mercancia> camion = PD.objetosSeleccionado(vector,v);

        Mercancia[]compara = new Mercancia[precio.length];
        for (int i = 0; i < camion.size(); i++) {
            compara[i]= camion.get(i);
        }

        assertNotEquals(precio,compara);

    }



}
