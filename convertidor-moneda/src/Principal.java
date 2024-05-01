import com.google.gson.Gson;

import java.util.Scanner;

public class Principal {

    private final ConversionMoneda convertidor;
    private final Scanner scanner;

    public Principal(ConversionMoneda convertidor, Scanner scanner) {
        this.convertidor = convertidor;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        TasaCambio tasaCambio = new TasaCambio();
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);
        ConversionMoneda convertidor = new ConversionMoneda(tasaCambio, gson, scanner);
        Principal principal = new Principal(convertidor, scanner);
        principal.ejecutarConversor();
        convertidor.cerrarScanner();
    }

    private void mostrarMenu() {
        System.out.println("\n*************************************************");
        System.out.println("\nBIENVENIDOS AL CONVERTIDOR DE MONEDA");
        System.out.println("\n***************************************+********");
        System.out.println("1- Convertir de dólar 'USD' a sol peruano 'PEN'");
        System.out.println("2- Convertir de sol peruano 'PEN' a dolar 'USD'");
        System.out.println("3- Convertir de dólar 'USD' a peso colombiano 'COP'");
        System.out.println("4- Convertir de peso colombiano 'COP' a dólar 'USD'");
        System.out.println("5- Convertir de dólar 'USD' a real brasileño 'BRL'");
        System.out.println("6- Convertir de real brasileño 'BRL' a dólar 'USD'");
        System.out.println("7- Salir");
        System.out.println("\nEscriba la opción que desea realizar: ");
       }

    public void ejecutarConversor() {
        int opcion;
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        convertidor.convertirDolarASolPeruano();
                        break;
                    case 2:
                        convertidor.convertirSolPeruanoADolar();
                        break;
                    case 3:
                        convertidor.convertirDolarAPesoColombiano();
                        break;
                    case 4:
                        convertidor.convertirPesoColombianoADolar();
                        break;
                    case 5:
                        convertidor.convertirDolarARealBrasileno();
                        break;
                    case 6:
                        convertidor.convertirRealBrasilenoADolar();
                        break;
                    case 7:
                        System.out.println("Gracias por usar nuestros servicios");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 7");
                }
            } else {
                System.out.println("Opnción no válida. Por favor, ingrese un numero del 1 al 7");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 7);
    }
}



