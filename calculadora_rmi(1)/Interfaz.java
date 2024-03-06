import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote {
    float sumar(float numero1, float numero2) throws RemoteException;
    float restar(float numero1, float numero2) throws RemoteException;

    float dividir(float numero1, float numero2) throws RemoteException;

    float multiplicar(float numero1, float numero2) throws RemoteException;

    float raizcuadrada(float numero1) throws RemoteException;

    float potencia (float numero1, float numero2) throws RemoteException;
    float seno (float numero1) throws RemoteException;

    float suma3 (float numero1, float numero2, float numero3) throws RemoteException;

}
