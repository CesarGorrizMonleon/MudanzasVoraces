import org.example.CamionVoraz;

import org.example.PD;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;;

public class PruebasPD {

    public static void main(String[] args) {
        System.out.println("Test");
        PD camion = new PD();
    }

    @Test
    public void MercanciaVacia(){
        System.out.println("Test de que no haya mercancia");
        PD camvor = new PD();
        int[] mercancia = new int[0];
        int[] vacio = new int[0];

        //assertEquals(vacio,camvor.pd(mercancia,4));
    }



}
