package aeropuerto;
import java.util.concurrent.Semaphore;
public class Pista2 implements Runnable {
    private final Semaphore semaforoAterrizajePista2;
    private final Semaphore semaforoDespeguePista2;
    private final Semaphore semaforoEmbarquePasajerosPista2;
    
    public Pista2(Semaphore semaforoAterrizajePista2, Semaphore semaforoDespeguePista2,Semaphore semaforoEmbarquePasajerosPista2) {
        this.semaforoAterrizajePista2 = semaforoAterrizajePista2;
        this.semaforoDespeguePista2 = semaforoDespeguePista2;
        this.semaforoEmbarquePasajerosPista2 = semaforoEmbarquePasajerosPista2;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Pista2 inició sus operaciones.*PISTA2*");
            
            System.out.println("Avion2 está esperando el embarque de equipaje en Pista2. *PISTA2*");
            semaforoAterrizajePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion2 ha embarcado el equipaje en Pista2.*PISTA2*");
            semaforoAterrizajePista2.release();
            
            System.out.println("Avion3 se traslada a Pista2 desde otra pista.*PISTA2*");
            semaforoAterrizajePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion3 ha llegado a Pista2 desde otra pista.*PISTA2*");
            semaforoAterrizajePista2.release();
            
            System.out.println("Avion3 está esperando el embarque de pasajeros en Pista2.*PISTA2*");
            semaforoEmbarquePasajerosPista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion3 está esperando el embarque de pasajeros.*PISTA2*");
            semaforoEmbarquePasajerosPista2.release();
            
            System.out.println("Avion3 inicia el despegue desde Pista2.*PISTA2*");
            semaforoDespeguePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion3 ha despegado desde Pista2.*PISTA2*");
            semaforoDespeguePista2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}