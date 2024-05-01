import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class ConversionMoneda {
    private final TasaCambio tasaCambio;
    private final Gson gson;
    private final Scanner scanner;

    public ConversionMoneda(TasaCambio tasaCambio, Gson gson, Scanner scanner) {
        this.tasaCambio = tasaCambio;
        this.gson = gson;
        this.scanner = scanner;
    }

    private String obtenerRespuestaAPI() throws IOException {
        return tasaCambio.obtenerTasasDeCambio();
    }

    private void error(IOException e) {
        System.out.println("Error al obtener las tasas de cambio:" + e.getMessage());
    }

    public void convertirDolarASolPeruano() {
        try {
            String jsonResponse = obtenerRespuestaAPI();
            RespuestaTasaCambio respuesta = gson.fromJson(jsonResponse, RespuestaTasaCambio.class);

            if (respuesta != null && respuesta.getConversion_rates() != null) {
                double tasaDeCambio = respuesta.getConversion_rates().get("PEN");
                System.out.println("Ingrese el monto en dólares: ");
                double montoDolares = scanner.nextDouble();
                double montoSoles = montoDolares * tasaDeCambio;
                System.out.printf("El monto en sol peruano es: %.2f PEN\n", montoSoles);
            } else {
                System.out.println("Error de respuesta del servidor");
            }
        } catch (IOException e) {
            error(e);
        }
    }

    public void convertirSolPeruanoADolar() {
        try {
            String jsonResponse = obtenerRespuestaAPI();
            RespuestaTasaCambio respuesta = gson.fromJson(jsonResponse, RespuestaTasaCambio.class);

            if (respuesta != null && respuesta.getConversion_rates() != null) {
                double tasaDeCambio = respuesta.getConversion_rates().get("PEN");
                System.out.println("Ingrese el monto en Soles Peruanos:");
                double montoSoles = scanner.nextDouble();
                double montoDolares = montoSoles / tasaDeCambio;
                System.out.printf("El monto en dólares: %.2f USD\n", montoDolares);
            } else {
                System.out.println("La respuesta de la API no contiene tasas de cambio válidas.");
            }
        } catch (IOException e) {
            error(e);
        }
    }

    public void convertirDolarAPesoColombiano() {
        try {
            String jsonResponse = obtenerRespuestaAPI();
            RespuestaTasaCambio respuesta = gson.fromJson(jsonResponse, RespuestaTasaCambio.class);

            if (respuesta != null && respuesta.getConversion_rates() != null) {
                double tasaDeCambio = respuesta.getConversion_rates().get("COP");
                System.out.println("Ingrese el monto en dólares:");
                double montoDolares = scanner.nextDouble();
                double montoPesosColombianos = montoDolares * tasaDeCambio;
                System.out.printf("El monto en pesos colombianos es: %.2f COP\n", montoPesosColombianos);
            } else {
                System.out.println("La respuesta de la API no contiene tasas de cambio válidas.");
            }
        } catch (IOException e) {
            error(e);
        }
    }

    public void convertirPesoColombianoADolar() {
        try {
            String jsonResponse = obtenerRespuestaAPI();
            RespuestaTasaCambio respuesta = gson.fromJson(jsonResponse, RespuestaTasaCambio.class);

            if (respuesta != null && respuesta.getConversion_rates() != null) {
                double tasaDeCambio = respuesta.getConversion_rates().get("COP");
                System.out.println("Ingrese el monto en pesos colombianos:");
                double montoPesosColombianos = scanner.nextDouble();
                double montoDolares = montoPesosColombianos / tasaDeCambio;
                System.out.printf("El monto en dólares es: %.2f USD\n", montoDolares);
            } else {
                System.out.println("La respuesta de la API no contiene tasas de cambio válidas.");
            }
        } catch (IOException e) {
            error(e);
        }
    }

    public void convertirDolarARealBrasileno() {
        try {
            String jsonResponse = obtenerRespuestaAPI();
            RespuestaTasaCambio respuesta = gson.fromJson(jsonResponse, RespuestaTasaCambio.class);

            if (respuesta != null && respuesta.getConversion_rates() != null) {
                double tasaDeCambio = respuesta.getConversion_rates().get("BRL");
                System.out.println("Ingrese el monto en dolares:");
                double montoDolares = scanner.nextDouble();
                double montoRealBrasileno = montoDolares * tasaDeCambio;
                System.out.printf("El monto en reales brasileños es: %.2f BRL\n", montoRealBrasileno);
            } else {
                System.out.println("La respuesta de la API no contiene tasas de cambio válidas.");
            }
        } catch (IOException e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }

    public void convertirRealBrasilenoADolar() {
        try {
            String jsonResponse = obtenerRespuestaAPI();
            RespuestaTasaCambio respuesta = gson.fromJson(jsonResponse, RespuestaTasaCambio.class);

            if (respuesta != null && respuesta.getConversion_rates() != null) {
                double tasaDeCambio = respuesta.getConversion_rates().get("BRL");
                System.out.println("Ingrese el monto en real Brasileño:");
                double montoRealBrasileno = scanner.nextDouble();
                double montoDolares = montoRealBrasileno / tasaDeCambio;
                System.out.printf("El monto en dólares es: %.2f USD\n", montoDolares);
            } else {
                System.out.println("La respuesta de la API no contiene tasas de cambio válidas.");
            }
        } catch (IOException e) {
            error(e);
        }
    }

    public void cerrarScanner() {
        scanner.close();
    }

}
