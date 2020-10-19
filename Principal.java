import java.util.Scanner;
public class Principal
{
    public static void main (String [] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de espacios que tendrá el parqueadero");
        int espacios = scan.nextInt();
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
                
                if (Sensor.sensores[espacioParqueo].getEstado() == 0){
                    String placa, marca, color;
                    int valor;
                    System.out.println("Ingrese la placa: ");
                    placa = scan.next();
                    System.out.println("Ingrese la marca: ");
                    marca = scan.next();
                    System.out.println("Ingrese el color: ");
                    color = scan.next();
                    System.out.println("Ingrese el valor comercial: ");
                    valor = scan.nextInt();

                    Vehiculo vehiculoNuevo = new Vehiculo(placa, marca, color, valor);
                    Vehiculo.vehiculos[espacioParqueo] = vehiculoNuevo;
                    Sensor.sensores[espacioParqueo].setEstado(1);
                    System.out.println(vehiculoNuevo.toString());
                } else {
                    System.out.println("El espacio "+espacioParqueo+" se encuentra ocupado");
                }
                break;
                case 3:
                System.out.println("¿En cuál espacio deseas parquear?");
                espacioParqueo = scan.nextInt();
                while (espacioParqueo >= espacios || espacioParqueo < 0){
                    System.out.println("¿En cuál espacio deseas parquear?");
                    espacioParqueo = scan.nextInt();
                }
                if (Sensor.sensores[espacioParqueo].getEstado() == 0){
                    String placa, marca, color;
                    int valor;
                    System.out.println("Ingrese la placa: ");
                    placa = scan.next();
                    System.out.println("Ingrese la marca: ");
                    marca = scan.next();
                    System.out.println("Ingrese el color: ");
                    color = scan.next();
                    System.out.println("Ingrese el valor comercial: ");
                    valor = scan.nextInt();

                    Vehiculo vehiculoNuevo = new Vehiculo(placa, marca, color, valor);
                    Vehiculo.vehiculos[espacioParqueo] = vehiculoNuevo;
                    Sensor.sensores[espacioParqueo].setEstado(1);
                    System.out.println(vehiculoNuevo.toString());
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
            System.out.println("");
            orden = scan.nextInt();
        }
        System.out.println("Fin del programa");
    }
}