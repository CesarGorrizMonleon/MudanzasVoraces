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
    @Test
    public void MercanciaOrdenada(){
        System.out.println("Test de que se ordene correctamenta la mercancia");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> mercancia = new ArrayList<Integer>();

        for (int i = 15; i >=1; i--) {
            mercancia.add(i);

        }

        ArrayList<Integer> mercanciaFinal = new ArrayList<Integer>();

        for (int i = 1; i <= 15; i++) {

            mercanciaFinal.add(i);

        }
        assertEquals(mercanciaFinal,camvor.pesoPaqueteCamion(mercancia));
    }

    @Test
    public void MercanciaJusta(){
        System.out.println("Test de la mercancia va justa y llena el camion");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> mercancia = new ArrayList<Integer>();
        ArrayList<Integer> mercanciajusta = new ArrayList<Integer>();
        mercancia.add(9999);
        mercancia.add(1);
        mercanciajusta.add(1);
        mercanciajusta.add(9999);

        assertEquals(mercanciajusta,camvor.pesoPaqueteCamion(mercancia));
    }
    @Test
    public void Mercanciapasada(){
        System.out.println("Test de que no pone la mercancia si se pasa de peso el camion");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> mercancia = new ArrayList<Integer>();
        ArrayList<Integer> mercanciajusta = new ArrayList<Integer>();
        mercancia.add(9999);
        mercancia.add(1);
        mercancia.add(1);
        mercanciajusta.add(1);
        mercanciajusta.add(1);

        assertEquals(mercanciajusta,camvor.pesoPaqueteCamion(mercancia));
    }

}
