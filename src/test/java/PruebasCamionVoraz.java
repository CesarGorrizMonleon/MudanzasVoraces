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
        //lenamo el camion de objetos
        for(int i=0;i<10; i++){
            objetos.add(i);
        }
        int preciototal;
        //llamamos al metodo para que calcules el peso
        preciototal= camvor.precioCamion(objetos);
        //Comparamos el precio que deberia de salir con lo que nos devuelve el metodo
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
        //llamamos al metodo para que calcules el peso
        preciototal= camvor.precioCamion(objetos);
        //Comparamos el precio que deberia de salir con lo que nos devuelve el metodo
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
        //llamamos al metodo para que calcules el peso
        preciototal= camvor.precioCamion(objetos);
        //Comparamos el precio que deberia de salir con lo que nos devuelve el metodo
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
        //llamamos al metodo para que calcules el peso
        preciototal= camvor.precioCamion(objetos);
        //Comparamos el precio que deberia de salir con lo que nos devuelve el metodo
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
        //recorremos un arry y lo llenamos de numeros de 15 al 1
        for (int i = 15; i >=1; i--) {
            mercancia.add(i);

        }

        ArrayList<Integer> mercanciaFinal = new ArrayList<Integer>();
        //recorremos un arry y lo llenamos de numeros de 1 al 15
        for (int i = 1; i <= 15; i++) {

            mercanciaFinal.add(i);

        }
        //Comprobamos que el metodo ordena el array comparando el array ordenado
        //con el metodo pasandole el desordenado
        assertEquals(mercanciaFinal,camvor.pesoPaqueteCamion(mercancia));
    }

    @Test
    public void MercanciaJusta(){
        System.out.println("Test de la mercancia va justa y llena el camion");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> mercancia = new ArrayList<Integer>();
        ArrayList<Integer> mercanciajusta = new ArrayList<Integer>();
        //Llenamos los arrays con un peso de 10 toneladas
        mercancia.add(9999);
        mercancia.add(1);
        mercanciajusta.add(1);
        mercanciajusta.add(9999);
        //comprobamos que caben los 2 objetos llenando el camion al maximo

        assertEquals(mercanciajusta,camvor.pesoPaqueteCamion(mercancia));
    }
    @Test
    public void Mercanciapasada(){
        System.out.println("Test de que no pone la mercancia si se pasa de peso el camion");
        CamionVoraz camvor = new CamionVoraz();
        ArrayList<Integer> mercancia = new ArrayList<Integer>();
        ArrayList<Integer> mercanciajusta = new ArrayList<Integer>();
        //añadimos la mercancia al array superando el peso
        mercancia.add(9999);
        mercancia.add(1);
        mercancia.add(1);
        //añadimos la mecacia que deberia de ser el resultado
        mercanciajusta.add(1);
        mercanciajusta.add(1);
        //comprobamos que el array que le pasmos al medo devuelve la mercancia correcta
        //dejado fuera la mercancia que no cabe
        assertEquals(mercanciajusta,camvor.pesoPaqueteCamion(mercancia));
    }

}
