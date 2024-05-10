import com.beust.ah.A;
import org.apache.log4j.BasicConfigurator;
import org.example.MundanzBacktraking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.TestNG;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasMudanzaBactraking {

    @BeforeEach
    public void setUp() {

        // Restablecer valores estáticos antes de cada prueba
        MundanzBacktraking.N= 3;  // Número de camiones
        MundanzBacktraking.M = 20000; // Capacidad máxima por camión
        MundanzBacktraking.C = new int[MundanzBacktraking.N]; // Inicializar cargas
    }
    @Test
    public void testSolucionNoValida() {
        MundanzBacktraking.A = new  int[3];
        // Configurar entrada simulada para el número de paquetes y sus pesos
        String input = "3\n50000\n7000\n3000\n"; // 3 paquetes con pesos 5000, 7000 y 3000
        System.setIn(new ByteArrayInputStream(input.getBytes())); // Simular entrada por teclado


        // Comprobamos la salida
        int[] solucion = MundanzBacktraking.mostrarSolucion(MundanzBacktraking.A);

        assertEquals(3, solucion.length);

    }

    @Test
    public void testVivo() {

        MundanzBacktraking.C[0] = 21000; // Excede la capacidad
        Assertions.assertFalse(MundanzBacktraking.vivo(0), "Debe exceder la capacidad");
    }

    @Test
    public void testvivo2(){
        // Verificar la lógica del método "vivo"
        MundanzBacktraking.C[0] = 10000; // Primera carga
        Assertions.assertTrue(MundanzBacktraking.vivo(0), "Debe estar dentro de la capacidad");

    }

    @Test
    public void testSolucionValida() {

        MundanzBacktraking.A = new  int[3];
        // Configurar entrada simulada para el número de paquetes y sus pesos
        MundanzBacktraking.V = new int[]{150,123,145,565,1323,1312,545,7675,5764,543,456,456,654,456,546,215,245,232,564,436,67,23,766,243,452,123,124,435,65,12,878,232,445,17758,3};
        MundanzBacktraking.P = MundanzBacktraking.V.length; // 3 paquetes con pesos 5000, 7000 y 3000
       // System.setIn(new ByteArr ayInputStream(input.getBytes())); // Simular entrada por teclado
        MundanzBacktraking.inicializar();

        MundanzBacktraking.VA(0,MundanzBacktraking.V, MundanzBacktraking.A);
        MundanzBacktraking.mostrarSolucion(MundanzBacktraking.A);
        int a =MundanzBacktraking.A.length;
        int b =MundanzBacktraking.V.length;


        assertEquals(a,b );

    }
}
