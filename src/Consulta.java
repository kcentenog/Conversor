import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {

    String direccion = "";

    CambioDivisas consulta(int selector) {
    // Con base a la seleccion del usuario lanzamos la opcion correspondiente

        switch (selector) {
            case 1:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/USD/MXN";
                break;
            case 2:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/MXN/USD";
                break;
            case 3:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/USD/ARS";
                break;
            case 4:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/ARS/USD";
                break;
            case 5:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/USD/BOB";
                break;
            case 6:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/BOB/USD";
                break;
            case 7:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/USD/BRL";
                break;
            case 8:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/BRL/USD";
                break;
            case 9:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/USD/CLP";
                break;
            case 10:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/CLP/USD";
                break;
            case 11:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/USD/COP";
                break;
            case 12:
                direccion = "https://v6.exchangerate-api.com/v6/8daa84cb31484642af55f369/pair/COP/USD";
                break;
            default:
                System.out.println(" Opcion no valida");
        }
        if (selector < 13) {
            // Utilizando la direccion proporcionada lanzamos la solicitud a nuestra API para obtener los datos actualizados

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = null;
            try {

                // Evaluamos la respuesta obtenida

                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Con la respuesta creamos una nueva instancia de nuestro record para crear el objeto correspondiente y continuar trabajando con el

            return new Gson().fromJson(response.body(), CambioDivisas.class);


        }
        return null;
}
}
