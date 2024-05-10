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
}
