package aeropuerto;
import java.util.concurrent.Semaphore;
public class Pista1 implements Runnable {
    private final Semaphore semaforoAterrizajePista1;
    public Pista1(Semaphore semaforoAterrizajePista1, Semaphore semaforoDespeguePista1) {
        this.semaforoAterrizajePista1 = semaforoAterrizajePista1;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Pista1 inició sus operaciones. *PISTA1*");
            
            System.out.println("Avion1 está aterrizando en Pista1. *PISTA1*");
            semaforoAterrizajePista1.acquire();
            Thread.sleep(2000);
            semaforoAterrizajePista1.release();
            
            System.out.println("Avion1 está desembarcando pasajeros en Pista1.*PISTA1*");
            Thread.sleep(2000);
            System.out.println("Avion1 ha desembarcado pasajeros en Pista1.*PISTA1*");
            
            System.out.println("Avion1 está en limpieza en Pista1.*PISTA1*");
            Thread.sleep(2000);
            System.out.println("Avion1 ha sido limpiado en Pista1.*PISTA1*");
            
            System.out.println("Avion1 se traslada a Pista2 desde Pista1.*PISTA1*");
            semaforoAterrizajePista1.acquire();
            Thread.sleep(2000);
            System.out.println("Avion1 ha llegado a Pista2 desde Pista1.*PISTA1*");
            semaforoAterrizajePista1.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}