import java.text.ParseException;
import java.util.TimeZone;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;
public class Vehiculo
{
    //Atributos
    public static Vehiculo[] vehiculos;
    public static int cantidad=0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;
    private String date;
    private Date fecha;
    private String tipoVehiculo;
    //Métodos
    public Vehiculo(){
    }

    public Vehiculo(String p, String m, String c, String d, String t){
        //Vehiculo Vehiculo= new Vehiculo(p,m,c,30000000);
        this(p,m,c,d,t,30000000);
    }

    public Vehiculo(String p, String m, String c, String d, String t,int v ){
        this.placa=p;
        this.marca=m;
        this.color=c;
        this.date=d;
        this.valorComercial=v;
        this.fecha=new Date();
        this.tipoVehiculo=t;
        this.cantidad=cantidad+1;
    }

    public String getPlaca(){
        return this.placa;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getColor(){
        return this.color;
    }

    public int getValorComercial(){
        return this.valorComercial;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setPlaca(String p){
        this.placa=p;
    }

    public void setMarca(String m){
        this.marca=m;
    }

    public void setColor(String c){
        this.color=c;
    }

    public void setValorComercial(int v){
        this.valorComercial=v;
    }

    public String gettipoVehiculo(){
        return this.tipoVehiculo;
    }

    public void settipovehiculo(String t){
        this.tipoVehiculo=t;
    }

    public void setDate(String d){
        this.date=d;
    }

    public String getDate(){
        return this.date;
    }

    public String toString(){
        return "placa: "+ this.placa+", marca: "+this.marca+", color: "+this.color+", valor comercial: "+this.valorComercial+"Fecha de ingreso: "+this.date+"Tipo de vehiculo: "+this.tipoVehiculo; 
    }

    public static String toStringVehiculos(){
        String placa;
        String marca;
        String color;
        int valorComercial;
        String date;
        String tipoVehiculo;
        String mensaje="";
        // Creando cadena con la información de todos los vehiculos
        for(int i=0; i<vehiculos.length; i++){
            if(vehiculos[i]!=null){
                placa=vehiculos[i].getPlaca();
                marca=vehiculos[i].getMarca();
                color=vehiculos[i].getColor();
                valorComercial=vehiculos[i].getValorComercial();
                tipoVehiculo=vehiculos[i].gettipoVehiculo();
                date=vehiculos[i].getDate();
                mensaje=mensaje+"Vehiculo "+i+":(placa: "+placa+", marca: "+marca+", color: "+color+", valor comercial: "+valorComercial+"Fecha de ingreso: "+date+"Tipo de vehiculo: "+tipoVehiculo+")";
            }
        }
        return mensaje;
    }

    public static int cantidadVehiculo(){
        return cantidad;
    }

    public static String colorVehiculo(String colorV){
        String placa;
        String marca;
        String color;
        int valorComercial;
        String mensaje="";
        // Creando cadena de los vehiculos del mismo color
        for(int i=0; i<vehiculos.length; i++){
            if(vehiculos[i]!=null && vehiculos[i].getColor().equalsIgnoreCase(colorV)){
                placa=vehiculos[i].getPlaca();
                marca=vehiculos[i].getMarca();
                color=vehiculos[i].getColor();
                valorComercial=vehiculos[i].getValorComercial();
                mensaje=mensaje+"Vehiculo "+i+":(placa: "+placa+", marca: "+marca+", color: "+color+", valor comercial: "+valorComercial+") ";
            }
        }
        return mensaje;
    }

    public static String valorComercialV(){
        // Creando arreglo de vehiculos
        Vehiculo[] vehiculosValor = new Vehiculo[vehiculos.length];
        // Guardando los vehiculos en el arreglo 
        for (int v = 0; v < vehiculos.length; v++){
            vehiculosValor[v] = vehiculos[v];
        }
        // Ordenandolos por valor comercial
        Vehiculo temporal;
        int posMinimo;
        for (int i = 0; i < vehiculosValor.length-1; i++){
            posMinimo = i;
            for (int j = i+1; j < vehiculosValor.length; j++){
                if (vehiculosValor[j] != null && vehiculosValor[posMinimo] != null && vehiculosValor[j].getValorComercial() < vehiculosValor[posMinimo].getValorComercial()){
                    posMinimo = j; 
                }
            }
            temporal = vehiculosValor[i];
            vehiculosValor[i] = vehiculosValor[posMinimo];
            vehiculosValor[posMinimo] = temporal;
        }
        // Creando la cadena con la información de todos los vehiculos ordenados
        String placa;
        String marca;
        String color;
        int valorComercial;
        String mensaje="";
        for(int i=0; i<vehiculosValor.length; i++){
            if(vehiculos[i]!=null){
                placa=vehiculosValor[i].getPlaca();
                marca=vehiculosValor[i].getMarca();
                color=vehiculosValor[i].getColor();
                valorComercial=vehiculosValor[i].getValorComercial();
                mensaje=mensaje+"Vehiculo: (placa: "+placa+", marca: "+marca+", color: "+color+", valor comercial: "+valorComercial+") ";
            }
        }
        return mensaje;
    }

    public static void escribeArchivo()throws IOException{
        String placa;
        String marca;
        String color;
        int valorComercial;
        String date;
        String tipoVehiculo;
        String mensaje="";
        FileWriter writer=new FileWriter("D:\\Vehiculos.txt");
        for(int i=0; i<vehiculos.length;i++){
            if(vehiculos[i]!=null){
                placa=vehiculos[i].getPlaca();
                marca=vehiculos[i].getMarca();
                color=vehiculos[i].getColor();
                valorComercial=vehiculos[i].getValorComercial();
                tipoVehiculo=vehiculos[i].gettipoVehiculo();
                date=vehiculos[i].getDate();
                mensaje=mensaje+"Vehiculo "+i+":(placa: "+placa+", marca: "+marca+", color: "+color+", valor comercial: "+valorComercial+"Fecha de ingreso: "+date+"Tipo de vehiculo: "+tipoVehiculo+")";
            }
        }
        System.out.println(mensaje);
        writer.write(mensaje);
        writer.flush();
        writer.close();
    }
}