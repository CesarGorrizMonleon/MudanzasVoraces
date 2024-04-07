import org.example.CamionVoraz;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PruebasCamionVoraz {


    public static void main(String[] args) {
        System.out.println("Test");
        CamionVoraz camion = new CamionVoraz();
    }

    @Test
    public void precioDiez(){
        System.out.println("Test de precio de 10 elemento");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> objetos = new ArrayList<Integer>();
        for(int i=0;i<10; i++){
            objetos.add(i);
        }
        int preciototal;
        preciototal= camvor.precioCamion(objetos);
        assertEquals(400, preciototal);
    }

    @Test
    public void precioVeinte(){
        System.out.println("Test de precio de 20 elemento");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> objetos = new ArrayList<Integer>();
        for(int i=0;i<20; i++){
            objetos.add(i);
        }
        int preciototal;
        preciototal= camvor.precioCamion(objetos);
        assertEquals(800, preciototal);
    }
    @Test
    public void precioQuince(){
        System.out.println("Test de precio de 15 elemento");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> objetos = new ArrayList<Integer>();
        for(int i=0;i<15; i++){
            objetos.add(i);
        }
        int preciototal;
        preciototal= camvor.precioCamion(objetos);
        assertEquals(600, preciototal);
    }

    @Test
    public void precioTrece(){
        System.out.println("Test de precio de 13 elemento");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> objetos = new ArrayList<Integer>();
        for(int i=0;i<13; i++){
            objetos.add(i);
        }
        int preciototal;
        preciototal= camvor.precioCamion(objetos);
        assertEquals(520, preciototal);
    }

    @Test
    public void MercanciaVacia(){
        System.out.println("Test de que no haya mercancia");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> mercancia = new ArrayList<Integer>();
        ArrayList<Integer> vacio = new ArrayList<Integer>();

        assertEquals(vacio,camvor.pesoPaqueteCamion(mercancia));
    }

}
