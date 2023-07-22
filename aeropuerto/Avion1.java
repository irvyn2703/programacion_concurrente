package aeropuerto;
import java.util.concurrent.Semaphore;
public class Avion1 implements Runnable {
    private final Semaphore semaforoAterrizajePista1;
    private final Semaphore semaforoAterrizajePista2;
    private final Semaphore semaforoEmbarquePasajerosPista2;
    
    public Avion1(Semaphore semaforoAterrizajePista1, Semaphore semaforoDespeguePista1, Semaphore semaforoAterrizajePista2,
                  Semaphore semaforoEmbarquePasajerosPista2) {
        this.semaforoAterrizajePista1 = semaforoAterrizajePista1;
        this.semaforoAterrizajePista2 = semaforoAterrizajePista2;
        this.semaforoEmbarquePasajerosPista2 = semaforoEmbarquePasajerosPista2;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Avion1 está aterrizando.*AVION1*");
            semaforoAterrizajePista1.acquire();
            Thread.sleep(2000);
            System.out.println("Avion1 ha aterrizado.*AVION1*");
            semaforoAterrizajePista1.release();
            
            System.out.println("Avion1 está desembarcando pasajeros.*AVION1*");
            Thread.sleep(2000);
            System.out.println("Avion1 ha desembarcado pasajeros.*AVION1*");
            
            System.out.println("Avion1 está en limpieza.*AVION1*");
            Thread.sleep(2000);
            System.out.println("Avion1 ha sido limpiado.*AVION1*");
            
            System.out.println("Avion1 se traslada a Pista2.*AVION1*");
            semaforoAterrizajePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion1 ha llegado a Pista2.*AVION1*");
            semaforoAterrizajePista2.release();
            
            System.out.println("Avion1 está en espera de pasajeros en Pista2.*AVION1*");
            semaforoEmbarquePasajerosPista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion1 está en espera de pasajeros.*AVION1*");
            semaforoEmbarquePasajerosPista2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}