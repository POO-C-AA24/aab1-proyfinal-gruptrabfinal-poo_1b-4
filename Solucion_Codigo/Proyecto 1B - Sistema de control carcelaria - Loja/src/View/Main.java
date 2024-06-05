package View;
import Controller.*;
import Model.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        String nombreArchivoPPL = "Carcel.dat";
        Scanner teclado = new Scanner(System.in);
        LecturaCarcel lectCarcel = new LecturaCarcel();
        lectCarcel.leerArchivo(nombreArchivoPPL); 

        Carcel carcel = lectCarcel.getCarcel();
        //System.out.println(carcel);
        while(true){
            System.out.println("==================================================");
            System.out.println("                       MENU");
            System.out.println("1 ---> Ver todas personas privadas libertad");
            System.out.println("2 ---> Ver informacion de un PPL en especifico");
            System.out.println("3 ---> Manejar agravantes PPL");
            System.out.println("4 ---> Asignar castigo a un PPL");    
            System.out.println("5 ---> Mostrar estadisticas de la Carcel - Loja");
            System.out.println("6 ---> Salir programa");
            System.out.println("==================================================");
            int usuTeclado = teclado.nextInt();
            if (usuTeclado < 7){
                switch (usuTeclado) {
                    case 1:
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("[NOMBRE]    \t [APELLIDO]   \t [NACIONALIDAD]     \t [FECHA INGRESO]          \t [NUMERO DELITOS]    \t  [PENA]\n");
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            System.out.printf("[%s]    \t [%s]   \t [%s]     \t [%s]          \t [%d delitos]    \t [%d years]\n",
                                    carcel.getListPPL().get(i).getNombrePPL(),
                                    carcel.getListPPL().get(i).getApellidoPPL(),
                                    carcel.getListPPL().get(i).getNacionalidadPPL(),
                                    carcel.getListPPL().get(i).getFechaIngresoPPL(),
                                    carcel.getListPPL().get(i).getNumeroDelitosPPL(),
                                    carcel.getListPPL().get(i).getPenaPPL());
                        }
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("-------------------------------");
                        System.out.println("[NOMBRES]    \t [APELLIDOS]\n");
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            System.out.printf("[%s]    \t [%s]\n",
                                    carcel.getListPPL().get(i).getNombrePPL(),
                                    carcel.getListPPL().get(i).getApellidoPPL());
                        }
                        System.out.println("-------------------------------");
                        System.out.println("\n        [Cual de todos los PPLs necesita ver su informacion?]\n");
                        boolean busquedaPPL = false;
                        System.out.println("Ingresar nombre del PPL");
                        String nombrePPL = teclado.next();
                        System.out.println("Ingresar apellido del PPL");
                        String apellidoPPL = teclado.next();
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            if (carcel.getListPPL().get(i).getNombrePPL().equals(nombrePPL) && carcel.getListPPL().get(i).getApellidoPPL().equals(apellidoPPL)) {
                                System.out.println("--------------------------------- [INFORMACION PPL] --------------------------------");
                                System.out.println("Nombre: "+carcel.getListPPL().get(i).getNombrePPL());
                                System.out.println("Apellido: "+carcel.getListPPL().get(i).getApellidoPPL());
                                System.out.println("Edad: "+carcel.getListPPL().get(i).getEdadPPL());
                                System.out.println("Genero: "+carcel.getListPPL().get(i).getGeneroPPL());
                                System.out.println("Nacionalidad: "+carcel.getListPPL().get(i).getNacionalidadPPL());
                                System.out.println("Fecha Ingreso: "+carcel.getListPPL().get(i).getFechaIngresoPPL());
                                System.out.println("Numero Delitos: "+carcel.getListPPL().get(i).getNumeroDelitosPPL());
                                System.out.println("Pena: "+carcel.getListPPL().get(i).getPenaPPL()+" years");
                                System.out.println("Castigo: "+carcel.getListPPL().get(i).getCastigo());
                                System.out.println("Limite Visitas: "+carcel.getListPPL().get(i).getLimiteVisitasSemana());
                                System.out.println("------------------------------------------------------------------------------------");
                                System.out.print("  [DELITOS]   \t\t [GRAVEDAD]     \t [CONDUCTA] \t[NUMERO AGRAVANTES]\n\n");
                                for (int j = 0; j < carcel.getListPPL().get(i).getListDelitos().size(); j++) {
                                    System.out.printf("  %-10s    \t [%s]     \t [%s] \t [%d agravantes]\n",
                                            carcel.getListPPL().get(i).getListDelitos().get(j).getNombreDelito(),
                                            carcel.getListPPL().get(i).getListDelitos().get(j).getGravedadDelito(),
                                            carcel.getListPPL().get(i).getListDelitos().get(j).getConductaDelito(),
                                            carcel.getListPPL().get(i).getListDelitos().get(j).getNumAgravantesDelito());
                                }  
                                System.out.println("------------------------------------------------------------------------------------");
                                busquedaPPL = true;
                            }    
                        }
                        if (busquedaPPL == false) 
                            System.out.println("[PPL NO EXISTE]");   
                        break;
                    case 3:
                        System.out.println("-------------------------------");
                        System.out.println("[NOMBRES]    \t [APELLIDOS]\n");
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            System.out.printf("[%s]    \t [%s]\n",
                                    carcel.getListPPL().get(i).getNombrePPL(),
                                    carcel.getListPPL().get(i).getApellidoPPL());
                        }
                        System.out.println("-------------------------------");
                        System.out.println("\n        [Cual de todos los PPLs desea manejar agravantes?]\n");
                        boolean busquedaPPL2 = false;
                        System.out.println("Ingresar nombre del PPL");
                        String nombrePPL2 = teclado.next();
                        System.out.println("Ingresar apellido del PPL");
                        String apellidoPPL2 = teclado.next();
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            if (carcel.getListPPL().get(i).getNombrePPL().equals(nombrePPL2) && carcel.getListPPL().get(i).getApellidoPPL().equals(apellidoPPL2)) {
                                System.out.println("--------------------------------- [AGRAVANTES PPL] --------------------------------");
                                System.out.println("Nombre: "+carcel.getListPPL().get(i).getNombrePPL());
                                System.out.println("Apellido: "+carcel.getListPPL().get(i).getApellidoPPL());
                                System.out.println("Numero Delitos: "+carcel.getListPPL().get(i).getNumeroDelitosPPL());
                                System.out.println("Pena: "+carcel.getListPPL().get(i).getPenaPPL()+" years");
                                System.out.println("------------------------------------------------------------------------------------");
                                for (int j = 0; j < carcel.getListPPL().get(i).getListDelitos().size(); j++) {
                                    System.out.println("Nombre Delito: "+carcel.getListPPL().get(i).getListDelitos().get(j).getNombreDelito());
                                    System.out.println("Gravedad Delito: "+carcel.getListPPL().get(i).getListDelitos().get(j).getGravedadDelito());
                                    System.out.println("Conducta Delito: "+carcel.getListPPL().get(i).getListDelitos().get(j).getConductaDelito());
                                    System.out.println("Tipicidad Delito: "+carcel.getListPPL().get(i).getListDelitos().get(j).getTipicidadDelito());
                                    System.out.println("Antijuricidad Delito: "+carcel.getListPPL().get(i).getListDelitos().get(j).getAntijuricidadDelito());
                                    String s1 = "AGRAVANTES", s2 = "ESTADO";
                                    System.out.printf("\n  %-20s \t\t\t  %s \n\n",s1,s2);
                                    for (int k = 0; k < carcel.getListPPL().get(i).getListDelitos().get(j).getListagravantes().size(); k++) {
                                        System.out.printf(" [%-20s] \t\t [%s]\n",
                                                carcel.getListPPL().get(i).getListDelitos().get(j).getListagravantes().get(k).getNombreAgravante(),
                                                carcel.getListPPL().get(i).getListDelitos().get(j).getListagravantes().get(k).getEstadoAgravante());
                                    }
                                    System.out.println("------------------------------------------------------------------------------------");
                                }
                                busquedaPPL2 = true;
                                System.out.println("\nDesea Ingrementar la pena del PPL?  [Si|No]");
                                String usuIn = teclado.next();
                                if ("Si".equals(usuIn)) {
                                    System.out.println("Cuandos years deseea aumentarle al PPL?");
                                    int aumentoYears = teclado.nextInt();
                                    carcel.getListPPL().get(i).aumentarPenaPPL(aumentoYears);
                                    System.out.println(" [La pena del PPL se ha aumentado correctamente!] \n");
                                }
                            }
                        }
                        if (busquedaPPL2 == false) 
                            System.out.println("[PPL NO EXISTE]");
                        break;
                    case 4:
                        System.out.println("-------------------------------");
                        System.out.println("[NOMBRES]    \t [APELLIDOS]\n");
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            System.out.printf("[%s]    \t [%s]\n",
                                    carcel.getListPPL().get(i).getNombrePPL(),
                                    carcel.getListPPL().get(i).getApellidoPPL());
                        }
                        System.out.println("-------------------------------");
                        System.out.println("\n        [Cual de todos los PPLs desea asignarle un castigo?]\n");
                        boolean busquedaPPL3 = false;
                        System.out.println("Ingresar nombre del PPL");
                        String nombrePPL3 = teclado.next();
                        System.out.println("Ingresar apellido del PPL");
                        String apellidoPPL3 = teclado.next();
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            if (carcel.getListPPL().get(i).getNombrePPL().equals(nombrePPL3) && carcel.getListPPL().get(i).getApellidoPPL().equals(apellidoPPL3)) {
                                System.out.println("------------------------------- [ASIGNAR CASTIGO PPL] -------------------------------");
                                System.out.println("\nCual de los siguientes castigos desea asignar?");
                                System.out.println("1 ----> Aislamiento");
                                System.out.println("2 ----> Reducir dias de Visitas");
                                System.out.println("3 ----> Receso denegado");
                                int usuIn2 = teclado.nextInt();
                                if (usuIn2 == 1) {
                                    carcel.getListPPL().get(i).setCastigo("Aislamiento");
                                    System.out.println("\n        Se ha asignado el castigo correctamente");
                                }else if (usuIn2 == 2) {
                                    System.out.println("Cuantos dias desea reducir (seleccione una opcion)");
                                    System.out.println("1 ----> reducir un dias por semana?");
                                    System.out.println("2 ----> reducir dos dias por semana?");
                                    int opcion = teclado.nextInt();
                                    carcel.getListPPL().get(i).reducirDiasVisitaPPL(opcion);
                                    System.out.println("\n        Se ha asignado el castigo correctamente");
                                }else if (usuIn2 == 3) {
                                    carcel.getListPPL().get(i).setCastigo("Receso denegado");
                                    System.out.println("\n        Se ha asignado el castigo correctamente");
                                }
                                System.out.println("------------------------------------------------------------------------------------");
                                busquedaPPL3 = true;
                            }    
                        }
                        if (busquedaPPL3 == false) 
                            System.out.println("[PPL NO EXISTE]");
                        break;
                    case 5:
                        System.out.println("---------------------------- [Estadisticas del "+carcel.getNombreCarcel()+"] ------------------------------");
                        carcel.calcularNumVisitasCarcel();
                        carcel.calcularNumPPLenAislamiento();
                        String nacionalidades[] = {"ecuatoriano/a","peruano/a","venezolano/a","colombiano/a"};
                        int numEcuatorianos = carcel.calcularNumNacionalidadesPPLs(nacionalidades[0]);
                        int numPeruanos = carcel.calcularNumNacionalidadesPPLs(nacionalidades[1]);
                        int numColombianos = carcel.calcularNumNacionalidadesPPLs(nacionalidades[2]);
                        int numVenezolanos = carcel.calcularNumNacionalidadesPPLs(nacionalidades[3]);
                        System.out.println("Numero visitas carcel por Semana: "+carcel.getNumVisitasCarcel());
                        System.out.println("Numero PPLs en Aislamiento: "+ carcel.getNumPPLaislamiento());
                        System.out.println("Numero PPLs Ecuatorianos: "+numEcuatorianos);
                        System.out.println("Numero PPLs Peruanos: "+numPeruanos);
                        System.out.println("Numero PPLs Colombianos: "+numColombianos);
                        System.out.println("Numero PPLs Venezolanos: "+numVenezolanos);
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("[NOMBRE]    \t [APELLIDO]   \t [NACIONALIDAD]     \t [FECHA INGRESO]          \t [NUMERO DELITOS]    \t  [PENA]\n");
                        for (int i = 0; i < carcel.getListPPL().size(); i++) {
                            System.out.printf("[%s]    \t [%s]   \t [%s]     \t [%s]          \t [%d delitos]    \t [%d years]\n",
                                    carcel.getListPPL().get(i).getNombrePPL(),
                                    carcel.getListPPL().get(i).getApellidoPPL(),
                                    carcel.getListPPL().get(i).getNacionalidadPPL(),
                                    carcel.getListPPL().get(i).getFechaIngresoPPL(),
                                    carcel.getListPPL().get(i).getNumeroDelitosPPL(),
                                    carcel.getListPPL().get(i).getPenaPPL());
                        }
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        break;
                    default:     
                        return;
                }
            }else {
                System.out.println("Error - Dato ingresado");
            }
        }
    }
}
