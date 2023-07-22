package aeropuerto;
import java.util.concurrent.Semaphore;

public class Avion3 implements Runnable {
    private final Semaphore semaforoEmbarquePasajeros;
    private final Semaphore semaforoAterrizajePista2;
    private final Semaphore semaforoDespeguePista2;
    
    public Avion3(Semaphore semaforoEmbarquePasajeros, Semaphore semaforoAterrizajePista2, Semaphore semaforoDespeguePista2) {
        this.semaforoEmbarquePasajeros = semaforoEmbarquePasajeros;
        this.semaforoAterrizajePista2 = semaforoAterrizajePista2;
        this.semaforoDespeguePista2 = semaforoDespeguePista2;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Avion3 se está trasladando a Pista 2.*AVION3*");
            semaforoAterrizajePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion3 ha llegado a Pista 2.*AVION3*");
            semaforoAterrizajePista2.release();
            
            System.out.println("Avion3 está esperando el embarque de pasajeros en Pista 2.*AVION3*");
            semaforoEmbarquePasajeros.acquire();
            System.out.println("Avion3 ha iniciado el embarque de pasajeros en Pista 2.*AVION3*");
            Thread.sleep(2000);
            System.out.println("Avion3 ha finalizado el embarque de pasajeros en Pista 2.*AVION3*");
            semaforoEmbarquePasajeros.release();
            
            System.out.println("Avion3 está iniciando el despegue desde Pista 2.*AVION3*");
            semaforoDespeguePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion3 ha despegado desde Pista 2.*AVION3*");
            semaforoDespeguePista2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
