import org.junit.Before;
import org.junit.Test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.Assert.assertEquals;

public class servidorTest {

    private static final int PUERTO = 1101;
    private Interfaz interfaz;

    @Before
    public void setUp() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", PUERTO);
        interfaz = (Interfaz) registry.lookup("Calculadora");
    }

    @Test
    public void testSuma() throws RemoteException {
        assertEquals(5.0, interfaz.sumar(2.0f, 3.0f), 0.001);
    }

    @Test
    public void testResta() throws RemoteException {
        assertEquals(2.0, interfaz.restar(5.0f, 3.0f), 0.001);
    }

    @Test
    public void testMultiplicacion() throws RemoteException {
        assertEquals(15.0, interfaz.multiplicar(5.0f, 3.0f), 0.001);
    }

    @Test
    public void testDivision() throws RemoteException {
        assertEquals(2.0, interfaz.dividir(10.0f, 5.0f), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionPorCero() throws RemoteException {
        interfaz.dividir(10.0f, 0.0f);
    }

    @Test
    public void testRaizCuadrada() throws RemoteException {
        assertEquals(2.0, interfaz.raizcuadrada(4.0f), 0.001);
        assertEquals(3.0, interfaz.raizcuadrada(9.0f), 0.001);
    }

    @Test
    public void testPotencia() throws RemoteException {
        assertEquals(8.0, interfaz.potencia(2.0f, 3.0f), 0.001);
    }

    @Test
    public void testSeno() throws RemoteException {
        assertEquals(0.0, interfaz.seno(0.0f), 0.001);
    }

    @Test
    public void testSuma3() throws RemoteException {
        assertEquals(10.0, interfaz.suma3(2.0f, 3.0f, 5.0f), 0.001);
    }
}
