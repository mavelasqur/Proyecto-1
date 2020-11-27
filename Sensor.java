public class Sensor
{
    // Atributos
    public static Sensor[] sensores;
    private int estado;

    // Métodos
    public Sensor(){
    }

    public Sensor(int e){
        this.estado = e;
    }

    public void setEstado(int e){
        this.estado = e;
    }

    public int getEstado(){
        return this.estado;
    }

    public String toString(){
        if (this.estado == 1){
            return "("+this.estado+"-Ocupado)";
        } else {
            return "("+this.estado+"-Libre)";
        }
    }

    public static String sensorLibre(){
        String libre = "Sensores libres: ";
        for (int i = 0; i < sensores.length; i++){
            if (sensores[i] != null && sensores[i].getEstado() == 0){
                libre = libre +" "+ i;
            }
        }
        return libre;
    }

    public static String sensoresEstado(){
        String estadoS = "";
        // Definiendo estado del sensor
        for (int i = 0; i < sensores.length; i++){
            estadoS = estadoS + "Sensor "+ i + sensores[i].toString()+"  ";
        }
        return estadoS;
    }

    public static int buscarVehiculo(int p){
        int status=0;
        if(sensores[p]==null){
            status=1;
        }else {
            status=0;
        }
        return status;
    }

    public static String desactivarSensor(int i){
        int status = Sensor.sensores[i].getEstado();
        if(status==0){
            Sensor.sensores[i]=null;
            Vehiculo.vehiculos[i]=null;
        }
        return "Cambio realizado con exito.";
    }
}