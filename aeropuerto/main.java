package aeropuerto;

import java.util.concurrent.Semaphore;

public class main {
    public static void main(String[] args) {
        Semaphore semaforoAterrizajePista1 = new Semaphore(1);
        Semaphore semaforoDespeguePista1 = new Semaphore(1);
        Semaphore semaforoAterrizajePista2 = new Semaphore(1);
        Semaphore semaforoDespeguePista2 = new Semaphore(1);
        Semaphore semaforoEmbarquePasajerosPista2 = new Semaphore(1);
        
        Pista1 pista1 = new Pista1(semaforoAterrizajePista1, semaforoDespeguePista1);
        Pista2 pista2 = new Pista2(semaforoAterrizajePista2, semaforoDespeguePista2,semaforoEmbarquePasajerosPista2);
        Avion1 avion1 = new Avion1(semaforoAterrizajePista1, semaforoDespeguePista1, semaforoAterrizajePista2, semaforoEmbarquePasajerosPista2);
        Avion2 avion2 = new Avion2(semaforoAterrizajePista2, semaforoDespeguePista2);
        Avion3 avion3 = new Avion3(semaforoEmbarquePasajerosPista2, semaforoAterrizajePista2, semaforoDespeguePista2);
        
        Thread hiloPista1 = new Thread(pista1);
        Thread hiloPista2 = new Thread(pista2);
        Thread hiloAvion1 = new Thread(avion1);
        Thread hiloAvion2 = new Thread(avion2);
        Thread hiloAvion3 = new Thread(avion3);
        
        hiloPista1.start();
        hiloPista2.start();
        hiloAvion1.start();
        hiloAvion2.start();
        hiloAvion3.start();
    }
}