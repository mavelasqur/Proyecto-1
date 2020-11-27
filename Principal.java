import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
public class Principal
{
    public static void main (String [] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        Date date= new Date();
        DateFormat hourdateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
        String fec=hourdateFormat.format(date);
        System.out.println("Ingrese la cantidad de espacios que tendrá el parqueadero");
        int espacios = scan.nextInt();
        System.out.println("Ingrese el valor por hora de parqueo de motos: ");
        int precioMoto=scan.nextInt();
        System.out.println("Ingrese el valor por hora de parqueo de Carros: ");
        int precioCarro=scan.nextInt();
        while (espacios <= 0){
            System.out.println("Ingrese la cantidad de espacios que tendrá el parqueadero");
            espacios = scan.nextInt();
        }
        Vehiculo.vehiculos = new Vehiculo[espacios];
        Sensor.sensores = new Sensor[espacios];
        // Asignando estado libre a todos los sensores
        for (int i = 0; i < Sensor.sensores.length; i++){
            Sensor.sensores[i] = new Sensor(0);
        }
        System.out.println("");
        System.out.println("Qué desea hacer: ");
        System.out.println("0. Terminar ejecución");
        System.out.println("1. Imprimir sensores libres");
        System.out.println("2. o 3. Espacio en el que desea parquear");
        System.out.println("4. Información todos los vehiculos");
        System.out.println("5. Cantidad de vehiculos hasta el momento");
        System.out.println("6. Estado del sensor");
        System.out.println("7. Estado de todos los sensores");
        System.out.println("8. Información de todos los vehiculos por color");
        System.out.println("9. Vehiculos en orden por valor comercial");
        System.out.println("10. Desactivar un espacio");
        System.out.println("11. Imprimir un archivo");
        System.out.println("");
        int orden = scan.nextInt();
        while (orden != 0){
            switch(orden){
                case 1:
                System.out.println(Sensor.sensorLibre());
                break;
                case 2:
                System.out.println("¿En cuál espacio deseas parquear?");
                int espacioParqueo = scan.nextInt();
                System.out.println(espacioParqueo);
                System.out.println("Ingrese el numero 1 si esta en un carro, de lo contrario un 2 para una moto: ");
                int tipoVehiculo=scan.nextInt();
                String tipoVehiculoString="Moto";
                //Validación tipo vehiculo es permitido.
                if(tipoVehiculo > 2 && tipoVehiculo<=1){
                    System.out.println("El tipo de vehiculo registrado no esta disponible");
                    break;
                }else 
                if(tipoVehiculo==1){
                    tipoVehiculoString="Carro";
                }
                //Buscar espacio
                if (Sensor.buscarVehiculo(espacioParqueo) == 0){
                    String placa, marca, color,tipo;
                    int valor;
                    System.out.println("Ingrese la placa: ");
                    placa = scan.next();
                    System.out.println("Ingrese la marca: ");
                    marca = scan.next();
                    System.out.println("Ingrese el color: ");
                    color = scan.next();
                    String fecha=hourdateFormat.format(date);

                    Vehiculo vehiculoNuevo = new Vehiculo(placa, marca, color,fecha,tipoVehiculoString);
                    Vehiculo.vehiculos[espacioParqueo] = vehiculoNuevo;
                    System.out.println(""+placa);
                    Sensor.sensores[espacioParqueo].setEstado(1);
                    System.out.println(vehiculoNuevo.toString());
                } else {
                    System.out.println("El espacio "+espacioParqueo+" se encuentra ocupado");
                }
                break;
                case 3:
                System.out.println("¿En cuál espacio deseas parquear?");
                espacioParqueo = scan.nextInt();
                System.out.println("Ingrese el numero 1 si esta en un carro, de lo contrario un 2 para una moto: ");
                tipoVehiculo=0;
                while (espacioParqueo >= espacios || espacioParqueo < 0){
                    System.out.println("¿En cuál espacio deseas parquear?");
                    espacioParqueo = scan.nextInt();
                }
                if (Sensor.sensores[espacioParqueo].getEstado() == 0){
                    if(tipoVehiculo==1){
                        String placa, marca, color,tipo;
                        int valor;
                        System.out.println("Ingrese la placa: ");
                        placa = scan.next();
                        System.out.println("Ingrese la marca: ");
                        marca = scan.next();
                        System.out.println("Ingrese el color: ");
                        color = scan.next();
                        System.out.println("Ingrese el valor comercial: ");
                        valor = scan.nextInt();
                        String fecha=hourdateFormat.format(date);

                        Vehiculo vehiculoNuevo = new Vehiculo(placa, marca, color,fecha,"Carro",valor);
                        Vehiculo.vehiculos[espacioParqueo] = vehiculoNuevo;
                        Sensor.sensores[espacioParqueo].setEstado(1);
                        System.out.println(vehiculoNuevo.toString());
                    }else if(tipoVehiculo==2){
                        String placa, marca, color,tipo;
                        int valor;
                        System.out.println("Ingrese la placa: ");
                        placa = scan.next();
                        System.out.println("Ingrese la marca: ");
                        marca = scan.next();
                        System.out.println("Ingrese el color: ");
                        color = scan.next();
                        System.out.println("Ingrese el valor comercial: ");
                        valor = scan.nextInt();
                        String fecha=hourdateFormat.format(date);

                        Vehiculo vehiculoNuevo = new Vehiculo(placa, marca, color,fecha,"Moto",valor);
                        Vehiculo.vehiculos[espacioParqueo] = vehiculoNuevo;
                        Sensor.sensores[espacioParqueo].setEstado(1);
                        System.out.println(vehiculoNuevo.toString());
                    }
                } else {
                    System.out.println("El espacio "+espacioParqueo+" se encuentra ocupado");
                }
                break;
                case 4:
                System.out.println("Información de todos los vehiculos: ");
                System.out.println(Vehiculo.toStringVehiculos());
                break;
                case 5:
                System.out.println("Cantidad de vehiculos creados: "+Vehiculo.cantidadVehiculo());
                break;
                case 6:
                System.out.println("Ingrese número del espacio: ");
                int numEspacio = scan.nextInt();
                while (numEspacio >= espacios || numEspacio < 0){
                    System.out.println("Ingrese número del espacio: ");
                    numEspacio = scan.nextInt();
                }
                System.out.println(Sensor.sensores[numEspacio].toString());
                break;
                case 7:
                System.out.println("Estado de los sensores: ");
                System.out.println(Sensor.sensoresEstado());
                break;
                case 8:
                System.out.println("Ingrese el color");
                String colorV = scan.next();
                System.out.println("Vehiculos de color "+colorV+": ");
                System.out.println(Vehiculo.colorVehiculo(colorV));
                break;
                case 9:
                System.out.println("Vehiculos ordenados por valor comercial: ");
                System.out.println(Vehiculo.valorComercialV());
                break;
                case 10:
                int espacio=scan.nextInt();
                if(Sensor.buscarVehiculo(espacio)==0){
                    Date fecha=new Date();
                    DateFormat Format= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
                    String fechaf=hourdateFormat.format(fecha);
                    Date primeraFecha=Vehiculo.vehiculos[espacio].getFecha();
                    double primerTiempo=primeraFecha.getTime();
                    double tiempo=(fecha.getTime()-primerTiempo)/3600000;
                    double total;
                    if (Vehiculo.vehiculos[espacio].gettipoVehiculo().equals("Carro")){
                        total=tiempo*precioCarro;
                    }else{
                        total=tiempo*precioMoto;
                    }
                    System.out.println("El valor a pagar es: "+total);
                    System.out.println("El tiempo transcurrido es de: "+tiempo);
                    Sensor.desactivarSensor(espacio);
                    System.out.println("El sensor se ha desactivado exitosamente");
                }
                break;
                case 11:
                try{
                    Vehiculo.escribeArchivo();
                }catch (IOException i){
                    System.out.println("Se ha producido un error al escribir el archivo");
                }
                default:
                System.out.println("Comando incorrecto");
                break;
            }
            System.out.println("");
            System.out.println("Qué desea hacer: ");
            System.out.println("0. Terminar ejecución");
            System.out.println("1. Imprimir sensores libres");
            System.out.println("2. o 3. Espacio en el que desea parquear");
            System.out.println("4. Información todos los vehiculos");
            System.out.println("5. Cantidad de vehiculos hasta el momento");
            System.out.println("6. Estado del sensor");
            System.out.println("7. Estado de todos los sensores");
            System.out.println("8. Información de todos los vehiculos por color");
            System.out.println("9. Vehiculos en orden por valor comercial");
            System.out.println("10. Desactivar un espacio");
            System.out.println("11. Imprimir un archivo");
            System.out.println("");
            orden = scan.nextInt();
        }
        System.out.println("Fin del programa");
    }
}