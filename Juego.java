import java.util.Scanner;
public class Juego
{
    private Bicho[][] bichos;

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Si quieres iniciar el juego ingresa 1");
        int ini = scan.nextInt();
        if (ini == 1){
            Juego nuevo = new Juego();
        }
    }

    public Juego(){
        Scanner scan = new Scanner(System.in);
        this.bichos = new Bicho[2][2];
        int f = 0;
        int c = 0;
        int aleatorio1 = (int)(Math.random()*3+1);
        System.out.println("Se crearán "+aleatorio1+" bichos");
        int numBichos = 0;
        for (int i = 0; i < bichos.length; i++){
            for (int j = 0; j < bichos[0].length; j++){
                if (numBichos != aleatorio1){
                    double aleatorio = Math.random();
                    int aleatorio2;
                    if (aleatorio < 0.5){
                        aleatorio2 = 1;
                    } else {
                        aleatorio2 = 2;
                    }
                    if (aleatorio2 == 1){
                        bichos[i][j] = new BichoNormal();
                    }
                    if (aleatorio2 == 2){
                        bichos[i][j] = new BichoAlien();
                    }
                    numBichos++;
                }
            }
        }
        // Mostrar tablero de juego
        for (int i = 0; i < bichos.length; i++){
            for (int j = 0; j < bichos[0].length; j++){
                if (bichos[i][j] != null){
                    if (bichos[i][j].getSalud() == 10){
                        System.out.print("| BN-10 |");
                    }
                    if (bichos[i][j].getSalud() == 20){
                        System.out.print("| BA-20 |");
                    }
                } else {
                    System.out.print("|       |");
                }
            }
            System.out.println();
        }
        // Iniciando juego
        while (true){ // se ejecuta siempre
            boolean todosMuertos = true;
            for (int i = 0; i < bichos.length; i++){
                for (int j = 0; j < bichos[0].length; j++){
                    if (bichos[i][j] != null){
                        if (bichos[i][j].getSalud() > 0){
                            todosMuertos = false;
                        }
                    }
                }
            }
            if (todosMuertos == true){
                break;
            }
            System.out.println("¿Cual bicho quieres matar?");
            System.out.println("Número de fila: ");
            int nF = scan.nextInt();
            System.out.println("Número de columna: ");
            int nC = scan.nextInt();
            if (nF >= bichos.length || nC >= bichos[0].length || nF < 0 || nC < 0){
                System.out.println("El bicho no existe");
            } else if (bichos[nF][nC] == null){
                System.out.println("El bicho no existe");
            }else{
                if (bichos[nF][nC].getSalud() > 0){
                    bichos[nF][nC].setSalud(bichos[nF][nC].getSalud()-5); 
                } else {
                    System.out.println("El bicho ya está muerto");
                }
            }
            for (int i = 0; i < bichos.length; i++){
                for (int j = 0; j < bichos[0].length; j++){
                    if (bichos[i][j] != null){
                        System.out.println("La salud del bicho en la fila "+i+" columna "+j+" es: "+bichos[i][j].getSalud());
                    }
                }
            }
        }
    }
}
