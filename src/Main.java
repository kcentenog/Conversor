
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        List conversiones = new ArrayList<Divisas>();
        Scanner teclado= new Scanner(System.in);
        int selector = 0;
        double monto = 0;
        while (selector != 13) {
            System.out.println("Seleccione el cambio que desea realizar: ");
            System.out.println("*****************************************");
            System.out.println("1. Dolares a pesos mexicanos");
            System.out.println("2. Pesos mexicanos a dolares");
            System.out.println("3. Dolares a pesos argentinos");
            System.out.println("4. Pesos argentinos a Dolares");
            System.out.println("5. Bolivianos bolivianos a dolares");
            System.out.println("6. Dolares a bolivianos bolivianos");
            System.out.println("7. Reales brasileños a dolares");
            System.out.println("8. Dolares a reales basileños");
            System.out.println("9. Pesos chilenos a dolares");
            System.out.println("10. Dolares a pesos chilenos");
            System.out.println("11. Pesos colombiano a dolares");
            System.out.println("12. Dolares a pesso colombianos");
            System.out.println("13. Salir");
            System.out.println("*****************************************");

            selector = teclado.nextInt();
            if (selector < 13 && selector > 0) {
                System.out.println("Ingrese el monto a convertir");
                monto = teclado.nextDouble();


                Consulta consulta = new Consulta();


                CambioDivisas divisas = consulta.consulta(selector);
                Divisas cambio = new Divisas(divisas);
                cambio.setMonto(monto);
                System.out.println(cambio);

                conversiones.add(cambio);


            } else if (selector == 13) {
                System.out.println("Saliendo del programa");
            } else System.out.println("Opcion no valida, intente nuevamente");

        }

        FileWriter escritura = new FileWriter("conversiones.json");

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        escritura.write(gson.toJson(conversiones));
        escritura.close();


    }
}