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


}
