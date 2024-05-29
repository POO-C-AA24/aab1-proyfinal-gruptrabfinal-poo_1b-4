package proyecto.pkg1b.sistema.de.control.carcelaria.loja;
import java.io.*;
import java.util.*;
public class Main_SistemaDeControlCarcelariaLoja {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String archivoPPLs = "informacionPPL.csv", archivoDelitos = "delitos.csv", archivoEstadisticas = "estadisticasCarcelLoja.csv";
        System.out.println("Bienvenido al Sistema de Control Carcelaria - Loja");
        while(true){
            int usuTeclado = 0;
            System.out.println("--------------------------------------------------");
            System.out.println("                       MENU");
            System.out.println("1 ---> Ver todas personas privadas libertad");
            System.out.println("2 ---> Ver informacion de un PPL en especifico");
            System.out.println("3 ---> Asignar castigo a un PPL");
            System.out.println("4 ---> Generar estadisticas de la Carcel - Loja");
            System.out.println("6 ---> Salir programa");
            System.out.println("--------------------------------------------------");
            if (usuTeclado < 5){
                switch (usuTeclado) {
                    case 1:
                        System.out.println("opcion 1");
                        break;
                    case 2:
                        System.out.println("opcion 2");
                        break;
                    case 3:
                        System.out.println("opcion 3");
                        break;
                    case 4:
                        System.out.println("opcion 4");
                        break;
                    case 5:
                        System.out.println("opcion 5");
                        break;
                    case 6:
                        return;
                }
            }else {
                System.out.println("Error - Dato ingresado");
            }
        } 
    }
    public static void leerArchivo (String nombreArchivo) {
        try (BufferedReader myBufferReader = new BufferedReader(new FileReader(nombreArchivo))){
            String line = myBufferReader.readLine();
            while (line != null) {
                line = myBufferReader.readLine();
                String dataSplit[] = line.split(";");
                if (nombreArchivo == "informacionPPL.csv"){
                    // Variables
                    // Constructor
                }else if (nombreArchivo == "delitos.csv"){
                    // Variables
                    // Constructor 
                }
            }
        } catch (Exception e) {
            System.out.println("Error en leer archivo");
        }
    }
}
