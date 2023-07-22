package aeropuerto;

import java.util.concurrent.Semaphore;
public class Avion2 implements Runnable {
    private final Semaphore semaforoAterrizajePista2;
    private final Semaphore semaforoDespeguePista2;
    
    public Avion2(Semaphore semaforoAterrizajePista2, Semaphore semaforoDespeguePista2) {
        this.semaforoAterrizajePista2 = semaforoAterrizajePista2;
        this.semaforoDespeguePista2 = semaforoDespeguePista2;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Avion2 está esperando el embarque de equipaje en Pista2.*AVION2*");
            semaforoAterrizajePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion2 ha embarcado el equipaje en Pista2.*AVION2*");
            semaforoAterrizajePista2.release();
            
            System.out.println("Avion2 inicia el despegue desde Pista2.*AVION2*");
            semaforoDespeguePista2.acquire();
            Thread.sleep(2000);
            System.out.println("Avion2 ha despegado desde Pista2.*AVION2*");
            semaforoDespeguePista2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}