import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Servidor {
	private static final int PUERTO = 1101; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote remote = UnicastRemoteObject.exportObject(new Interfaz() {
        	/*
				Sobrescribir opcionalmente los métodos que escribimos en la interfaz
        	*/
            @Override
            public float sumar(float numero1, float numero2) throws RemoteException {
                return numero1 + numero2;
            };

            @Override
            public float restar(float numero1, float numero2) throws RemoteException {
                return numero1 - numero2;
            };

            @Override
            public float multiplicar(float numero1, float numero2) throws RemoteException {
                return numero1 * numero2;
            };

            @Override
            public float dividir(float numero1, float numero2) throws RemoteException {
                if (numero2 == 0) {
                    throw new ArithmeticException("No se puede dividir por cero");
                }
                return numero1 / numero2;
            }

            @Override
            public float raizcuadrada(float numero1) throws RemoteException {
                return (float) Math.sqrt(numero1);
            };

            @Override
            public float potencia(float numero1, float numero2) throws RemoteException {
                return (float) Math.pow(numero1, numero2);
            };

            @Override
            public float seno(float numero1) throws RemoteException {
                return (float) Math.sin(numero1);
            };

            @Override
            public float suma3(float numero1, float numero2, float numero3) throws RemoteException {
                return numero1 + numero2 + numero3;
            };

        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Calculadora", remote); // Registrar calculadora
    }
}
