
public class SimuladorAeropuertos {
    public static void main(String[] args) {
        aeropuerto aeropuerto1 = new aeropuerto(2, "Aeropuerto 1");
        aeropuerto aeropuerto2 = new aeropuerto(2, "Aeropuerto 2");
        
        avion avion1 = new avion("Avion 1", aeropuerto1, aeropuerto2);
        avion avion2 = new avion("Avion 2", aeropuerto1, aeropuerto2);
        avion avion3 = new avion("Avion 3", aeropuerto1, aeropuerto2);
        
        avion1.start();
        avion2.start();
        avion3.start();
    }
}
