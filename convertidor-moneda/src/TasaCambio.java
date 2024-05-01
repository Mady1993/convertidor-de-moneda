import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TasaCambio {
    private static final String direccion = "https://v6.exchangerate-api.com/v6/2eeedd424ad155587aba62ce/latest/USD";

    public String obtenerTasasDeCambio() throws IOException {
        URL url = new URL(direccion);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("Error al obtener las tasas de cambio. Código de respuesta: " + responseCode);
        }
    }
}
