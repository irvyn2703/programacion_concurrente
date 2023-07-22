
public class aeropuerto {
    private int capacidad;
    private String nombre;
    
    public aeropuerto(int capacidad, String nombre) {
        this.capacidad = capacidad;
        this.nombre = nombre;
    }
    
    public synchronized void aterrizarAvion(String nombreAvion) {
        while (capacidad == 0) {
            try {
                System.out.println(nombreAvion + " solicita aterrizar en el aeropuerto [" + nombre + "]");
                wait(); // Esperar si el aeropuerto está lleno
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        capacidad--;
        System.out.println(nombreAvion + " ha aterrizado en el aeropuerto. Capacidad " + nombre + " restante: " + capacidad);
        notifyAll(); // Notificar a los aviones en espera que hay capacidad disponible
    }
    
    public synchronized void despegarAvion(String nombreAvion) {
        capacidad++;
        System.out.println(nombreAvion + " ha despegado del aeropuerto. Capacidad " + nombre + " restante: " + capacidad);
        notifyAll(); // Notificar a los aviones en espera que hay capacidad disponible
    }
}
