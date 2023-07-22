import java.util.Random;

public class avion extends Thread{
    public int inicioAleatorio = 5000;
    public int finalAleatorio = 10000;
    Random random = new Random();
    private String nombreAvion;
    private aeropuerto aeropuertoOrigen;
    private aeropuerto aeropuerto2;
    // si origen es true significa que se dirige al aeropuerto origen
    private boolean origen = true;
    // si volando es true significa que esta volanto (no, enserio)
    private boolean volando = true;
    
    public avion(String nombreAvion, aeropuerto aeropuertoOrigen, aeropuerto aeropuertoDestino) {
        this.nombreAvion = nombreAvion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuerto2 = aeropuertoDestino;
    }
    
    @Override
    public void run() {
        while (true) {
            if (volando == true) {
                if (origen == true) {
                    try {
                        Thread.sleep(random.nextInt(finalAleatorio - inicioAleatorio) + inicioAleatorio);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aeropuertoOrigen.aterrizarAvion(nombreAvion);
                    volando = false;
                }else{
                    try {
                        Thread.sleep(random.nextInt(finalAleatorio - inicioAleatorio) + inicioAleatorio);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aeropuerto2.aterrizarAvion(nombreAvion);
                    volando = false;
                }
            }else{
                if (origen == true) {
                    try {
                        Thread.sleep(random.nextInt(finalAleatorio - inicioAleatorio) + inicioAleatorio);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aeropuertoOrigen.despegarAvion(nombreAvion);
                    origen = false;
                    volando = true;
                }else{
                    try {
                        Thread.sleep(random.nextInt(finalAleatorio - inicioAleatorio) + inicioAleatorio);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    aeropuerto2.despegarAvion(nombreAvion);
                    origen = true;
                    volando = true;
                }
            }
        }
    }
}
