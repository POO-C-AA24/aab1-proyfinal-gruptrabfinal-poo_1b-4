package View;

import Controller.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:bd/CarcelDB.db";
        Carcel carcel = new Carcel("Centro de Privacion de Libertad Loja", 0, new ArrayList<>());
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String fechaFormateada = fechaActual.format(formatter);
        Scanner teclado = new Scanner(System.in);
        carcel.readCarcelDataBase(url);
        while (true) {
            try {
                System.out.println("==========================================================");
                System.out.println("                     MENU PRINCIPAL");
                System.out.println("==========================================================");
                System.out.println("1 ---> Ver todas las Personas privadas Libertad");
                System.out.println("2 ---> Ingresar una nueva Persona Privada Libertad");
                System.out.println("3 ---> Eliminar una Persona Privada Libertad");
                System.out.println("4 ---> Mostrar estadisticas de la Carcel - Loja");
                System.out.println("5 ---> Salir programa");
                System.out.println("==========================================================");
                int usuTeclado = teclado.nextInt();
                switch (usuTeclado) {
                    case 1:
                        while (true) {
                            try {
                                System.out.println("===============================================================================================================================================================");
                                System.out.println(" | NOMBRE  \t | APELLIDO   \t | EDAD | GENERO   | NACIONALIDAD    | FECHA INGRESO  |  CONDUCTA  |   CASTIGO   |  ACTIVIDAD  | REHABILITACION | ALERTA FUGA |");
                                System.out.println("===============================================================================================================================================================");
                                for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                    System.out.printf(" | %s  \t | %s  \t |  %d  | %-8s | %-15s |   %-10s   | %-10s | %-10s | %-10s |  %-10s   |   %-6s   |\n",
                                            carcel.listPPLs.get(i).nombre,
                                            carcel.listPPLs.get(i).apellido,
                                            carcel.listPPLs.get(i).edad,
                                            carcel.listPPLs.get(i).genero,
                                            carcel.listPPLs.get(i).nacionalidad,
                                            carcel.listPPLs.get(i).fechaIngreso,
                                            carcel.listPPLs.get(i).conducta,
                                            carcel.listPPLs.get(i).castigo,
                                            carcel.listPPLs.get(i).actividad,
                                            carcel.listPPLs.get(i).rehabilitacion,
                                            carcel.listPPLs.get(i).alertaFuga);
                                }
                                System.out.println("===============================================================================================================================================================");
                                System.out.println("==========================================================");
                                System.out.println("                       OPCIONES");
                                System.out.println("==========================================================");
                                System.out.println("1 ---> Ver informacion de un PPL en especifico");
                                System.out.println("2 ---> Asignar Conducta a un PPL");
                                System.out.println("3 ---> Asignar Castigo a un PPL");
                                System.out.println("4 ---> Asignar Actividad a un PPL");
                                System.out.println("5 ---> Asignar Rehabilitacion a un PPL");
                                System.out.println("6 ---> Encender Alerta de Fuga");
                                System.out.println("7 ---> Apagar Alerta de Fuga");
                                System.out.println("8 ---> Regresar");
                                System.out.println("==========================================================");
                                int usuTecla = teclado.nextInt();
                                switch (usuTecla) {
                                    case 1:
                                        System.out.println("==========================================================");
                                        System.out.println("              [Cual es el PPL que desea ver?]");
                                        System.out.println("==========================================================");
                                        System.out.println("-Por favor ingrese el Nombre del PPL");
                                        String nombre1 = teclado.next();
                                        System.out.println("-Por favor ingrese el Apellido del PPL");
                                        String apellido1 = teclado.next();
                                        if (carcel.existPPL(nombre1, apellido1) == true) {
                                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                                if (carcel.listPPLs.get(i).nombre.equals(nombre1) && carcel.listPPLs.get(i).apellido.equals(apellido1)) {
                                                    System.out.println("==========================================================");
                                                    System.out.println("                 INFORMACION BUSQUEDA PPL");
                                                    System.out.println("==========================================================");
                                                    System.out.println("Nombre: " + carcel.listPPLs.get(i).nombre);
                                                    System.out.println("Apellido: " + carcel.listPPLs.get(i).apellido);
                                                    System.out.println("Edad: " + carcel.listPPLs.get(i).edad);
                                                    System.out.println("Genero: " + carcel.listPPLs.get(i).genero);
                                                    System.out.println("Nacionalidad: " + carcel.listPPLs.get(i).nacionalidad);
                                                    System.out.println("Fecha de Ingreso: " + carcel.listPPLs.get(i).fechaIngreso);
                                                    System.out.println("Pena: " + carcel.listPPLs.get(i).pena + " years");
                                                    System.out.println("Conducta: " + carcel.listPPLs.get(i).conducta);
                                                    System.out.println("Castigo: " + carcel.listPPLs.get(i).castigo);
                                                    System.out.println("Actividad: " + carcel.listPPLs.get(i).actividad);
                                                    System.out.println("Rehabilitacion: " + carcel.listPPLs.get(i).rehabilitacion);
                                                    System.out.println("Alerta de Fuga: " + carcel.listPPLs.get(i).alertaFuga);
                                                    System.out.println("Calsificacion PPL: " + ((carcel.listPPLs.get(i).getClass().equals(PPL_PrimerGrado.class)) ? ("PPL Primer Grado") : ((carcel.listPPLs.get(i).getClass().equals(PPL_SegundoGrado.class)) ? ("PPL Segundo Grado") : ("PPL Segundo Grado"))));
                                                    System.out.println("==========================================================");
                                                    System.out.println("                          DELITO");
                                                    System.out.println("Nombre: " + carcel.listPPLs.get(i).delito.nombreDelito);
                                                    System.out.println("Conducta: " + carcel.listPPLs.get(i).delito.conducta);
                                                    System.out.println("Tipicidad: " + carcel.listPPLs.get(i).delito.tipicidad);
                                                    System.out.println("Antijuricidad: " + carcel.listPPLs.get(i).delito.antijuricidad);
                                                    System.out.println("==========================================================");
                                                    System.out.println("                     AGRAVANTE DELITO");
                                                    System.out.println("Nombre: " + carcel.listPPLs.get(i).delito.agravante.nombreAgravante);
                                                    System.out.println("Estado: " + carcel.listPPLs.get(i).delito.agravante.estado);
                                                    System.out.println("Descipcion: " + carcel.listPPLs.get(i).delito.agravante.descripcion);
                                                    System.out.println("==========================================================");
                                                }
                                            }
                                        } else {
                                            System.out.println("[La persona ingresada previamente no existe en la Carcel]");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("==========================================================");
                                        System.out.println("       [Cual es el PPL que desea Asignar Conducta?]");
                                        System.out.println("==========================================================");
                                        System.out.println("-Por favor ingrese el Nombre del PPL");
                                        String nombre2 = teclado.next();
                                        System.out.println("-Por favor ingrese el Apellido del PPL");
                                        String apellido2 = teclado.next();
                                        System.out.println("-Cual es la Conducta que desea Asignar al PPL");
                                        String nuevaConducta = teclado.next();
                                        if (carcel.existPPL(nombre2, apellido2) == true) {
                                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                                if (carcel.listPPLs.get(i).nombre.equals(nombre2) && carcel.listPPLs.get(i).apellido.equals(apellido2)) {
                                                    carcel.listPPLs.get(i).conducta = nuevaConducta;
                                                    carcel.updatePPLDataBaseString(url, "conducta", "id_Delito", nuevaConducta, carcel.getTablaPPL(nombre2, apellido2), nombre2, apellido2);
                                                }
                                            }
                                        } else {
                                            System.out.println("[La persona ingresada previamente no existe en la Carcel]");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("==========================================================");
                                        System.out.println("      [Cual es el PPL que desea Asignar Castigo?]");
                                        System.out.println("==========================================================");
                                        System.out.println("                          NOTA:");
                                        System.out.println("  [Dependiendo del PPL se asignara un Castigo Distinto]");
                                        System.out.println("==========================================================");
                                        System.out.println("-Por favor ingrese el Nombre del PPL");
                                        String nombre3 = teclado.next();
                                        System.out.println("-Por favor ingrese el Apellido del PPL");
                                        String apellido3 = teclado.next();
                                        if (carcel.existPPL(nombre3, apellido3) == true) {
                                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                                if (carcel.listPPLs.get(i).nombre.equals(nombre3) && carcel.listPPLs.get(i).apellido.equals(apellido3)) {
                                                    if (carcel.listPPLs.get(i).getClass().equals(PPL_PrimerGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Primer Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                     Castigos Disponibles");
                                                        System.out.println(" [1] ---> Reduccir limite horas fuera Celda");
                                                        System.out.println(" [2] ---> Reducir Racion alimenticia");
                                                        System.out.println(" [3] ---> Mantener Luces Encendidas en la noche");
                                                        System.out.println("=============================================================");
                                                        int opcionCastigo1 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarCastigo(opcionCastigo1);
                                                        switch (opcionCastigo1) {
                                                            case 1:
                                                                PPL_PrimerGrado ppl_1_P1 = (PPL_PrimerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseInt(url, "limHorasFueraCelda", "id_Delito", ppl_1_P1.limHorasFueraCelda, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 2:
                                                                PPL_PrimerGrado ppl_2_P1 = (PPL_PrimerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_2_P1.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 3:
                                                                PPL_PrimerGrado ppl_3_P1 = (PPL_PrimerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_3_P1.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                        }
                                                    } else if (carcel.listPPLs.get(i).getClass().equals(PPL_SegundoGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Segundo Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                     Castigos Disponibles");
                                                        System.out.println(" [1] ---> Asignar a Aislaiento");
                                                        System.out.println(" [2] ---> Prohibir Contacto con otros PPLs");
                                                        System.out.println(" [3] ---> Asignar Tarea");
                                                        System.out.println(" [4] ---> Reducir Dias Visita");
                                                        System.out.println("=============================================================");
                                                        int opcionCastigo2 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarCastigo(opcionCastigo2);
                                                        switch (opcionCastigo2) {
                                                            case 1:
                                                                PPL_SegundoGrado ppl_1_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_1_P2.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                carcel.updatePPLDataBaseString(url, "aislamiento", "id_Delito", ppl_1_P2.aislamiento, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 2:
                                                                PPL_SegundoGrado ppl_2_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_2_P2.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 3:
                                                                PPL_SegundoGrado ppl_3_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_3_P2.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 4:
                                                                PPL_SegundoGrado ppl_4_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseInt(url, "limVisitasSemana", "id_Delito", ppl_4_P2.limVisitasSemana, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                        }
                                                    } else if (carcel.listPPLs.get(i).getClass().equals(PPL_TercerGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Tercer Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                     Castigos Disponibles");
                                                        System.out.println(" [1] ---> Denegar Receso");
                                                        System.out.println(" [2] ---> Denegar Actividades Recreativas");
                                                        System.out.println(" [3] ---> Reducción Tiempo Visita");
                                                        System.out.println(" [4] ---> Reducir Dias Visita");
                                                        System.out.println("=============================================================");
                                                        int opcionCastigo3 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarCastigo(opcionCastigo3);
                                                        switch (opcionCastigo3) {
                                                            case 1:
                                                                PPL_TercerGrado ppl_1_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_1_P3.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 2:
                                                                PPL_TercerGrado ppl_2_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_2_P3.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 3:
                                                                PPL_TercerGrado ppl_3_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "castigo", "id_Delito", ppl_3_P3.castigo, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                            case 4:
                                                                PPL_TercerGrado ppl_4_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseInt(url, "limVisitasSemana", "id_Delito", ppl_4_P3.limVisitasSemana, carcel.getTablaPPL(nombre3, apellido3), nombre3, apellido3);
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            System.out.println("[La persona ingresada previamente no existe en la Carcel]");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("==========================================================");
                                        System.out.println("      [Cual es el PPL que desea Asignar Actividad?]");
                                        System.out.println("==========================================================");
                                        System.out.println("                          NOTA:");
                                        System.out.println(" [Dependiendo del PPL se asignara una Actividad Distinta]");
                                        System.out.println("==========================================================");
                                        System.out.println("-Por favor ingrese el Nombre del PPL");
                                        String nombre4 = teclado.next();
                                        System.out.println("-Por favor ingrese el Apellido del PPL");
                                        String apellido4 = teclado.next();
                                        if (carcel.existPPL(nombre4, apellido4) == true) {
                                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                                if (carcel.listPPLs.get(i).nombre.equals(nombre4) && carcel.listPPLs.get(i).apellido.equals(apellido4)) {
                                                    if (carcel.listPPLs.get(i).getClass().equals(PPL_PrimerGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Primer Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                     Actividades Disponibles");
                                                        System.out.println(" [1] ---> Preparacion de vida despues de prision");
                                                        System.out.println(" [2] ---> Programa de mentoria y apoyo");
                                                        System.out.println("=============================================================");
                                                        int opcionActividad1 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarActividad(opcionActividad1);
                                                        switch (opcionActividad1) {
                                                            case 1:
                                                                PPL_PrimerGrado ppl_1_P1 = (PPL_PrimerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "actividad", "id_Delito", ppl_1_P1.actividad, carcel.getTablaPPL(nombre4, apellido4), nombre4, apellido4);
                                                                break;
                                                            case 2:
                                                                PPL_PrimerGrado ppl_2_P1 = (PPL_PrimerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "actividad", "id_Delito", ppl_2_P1.actividad, carcel.getTablaPPL(nombre4, apellido4), nombre4, apellido4);
                                                                break;
                                                        }
                                                    } else if (carcel.listPPLs.get(i).getClass().equals(PPL_SegundoGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Segundo Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                     Actividades Disponibles");
                                                        System.out.println(" [1] ---> Trabajo Agricola");
                                                        System.out.println(" [2] ---> Servicio Religioso");
                                                        System.out.println("=============================================================");
                                                        int opcionActividad2 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarActividad(opcionActividad2);
                                                        switch (opcionActividad2) {
                                                            case 1:
                                                                PPL_SegundoGrado ppl_1_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "actividad", "id_Delito", ppl_1_P2.actividad, carcel.getTablaPPL(nombre4, apellido4), nombre4, apellido4);
                                                                break;
                                                            case 2:
                                                                PPL_SegundoGrado ppl_2_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "actividad", "id_Delito", ppl_2_P2.actividad, carcel.getTablaPPL(nombre4, apellido4), nombre4, apellido4);
                                                                break;
                                                        }
                                                    } else if (carcel.listPPLs.get(i).getClass().equals(PPL_TercerGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Tercer Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                     Actividades Disponibles");
                                                        System.out.println(" [1] ---> Fabricacion Productos artesanales");
                                                        System.out.println(" [2] ---> Deportes");
                                                        System.out.println("=============================================================");
                                                        int opcionActividad3 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarActividad(opcionActividad3);
                                                        switch (opcionActividad3) {
                                                            case 1:
                                                                PPL_TercerGrado ppl_1_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "actividad", "id_Delito", ppl_1_P3.actividad, carcel.getTablaPPL(nombre4, apellido4), nombre4, apellido4);
                                                                break;
                                                            case 2:
                                                                PPL_TercerGrado ppl_2_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "actividad", "id_Delito", ppl_2_P3.actividad, carcel.getTablaPPL(nombre4, apellido4), nombre4, apellido4);
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            System.out.println("[La persona ingresada previamente no existe en la Carcel]");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("==========================================================");
                                        System.out.println("   [Cual es el PPL que desea Asignar Rehabilitacion?]");
                                        System.out.println("==========================================================");
                                        System.out.println("                          NOTA:");
                                        System.out.println("  [Dependiendo del PPL se asignara una Rehabilitacion]");
                                        System.out.println("==========================================================");
                                        System.out.println("-Por favor ingrese el Nombre del PPL");
                                        String nombre5 = teclado.next();
                                        System.out.println("-Por favor ingrese el Apellido del PPL");
                                        String apellido5 = teclado.next();
                                        if (carcel.existPPL(nombre5, apellido5) == true) {
                                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                                if (carcel.listPPLs.get(i).nombre.equals(nombre5) && carcel.listPPLs.get(i).apellido.equals(apellido5)) {
                                                    if (carcel.listPPLs.get(i).getClass().equals(PPL_PrimerGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Primer Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                 Rehabilitaciones Disponibles");
                                                        System.out.println(" [1] ---> Programa de Salud Mental");
                                                        System.out.println(" [2] ---> Terapia con psiquiatra");
                                                        System.out.println("=============================================================");
                                                        int opcionRehabilitacion1 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarRehabilitacion(opcionRehabilitacion1);
                                                        switch (opcionRehabilitacion1) {
                                                            case 1:
                                                                PPL_PrimerGrado ppl_1_P1 = (PPL_PrimerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "rehabilitacion", "id_Delito", ppl_1_P1.rehabilitacion, carcel.getTablaPPL(nombre5, apellido5), nombre5, apellido5);
                                                                break;
                                                            case 2:
                                                                PPL_PrimerGrado ppl_2_P1 = (PPL_PrimerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "rehabilitacion", "id_Delito", ppl_2_P1.rehabilitacion, carcel.getTablaPPL(nombre5, apellido5), nombre5, apellido5);
                                                                break;
                                                        }
                                                    } else if (carcel.listPPLs.get(i).getClass().equals(PPL_SegundoGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Segundo Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                 Rehabilitaciones Disponibles");
                                                        System.out.println(" [1] ---> justicia restaurativa");
                                                        System.out.println(" [2] ---> Terapia con psicologo");
                                                        System.out.println("=============================================================");
                                                        int opcionRehabilitacion2 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarRehabilitacion(opcionRehabilitacion2);
                                                        switch (opcionRehabilitacion2) {
                                                            case 1:
                                                                PPL_SegundoGrado ppl_1_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "rehabilitacion", "id_Delito", ppl_1_P2.rehabilitacion, carcel.getTablaPPL(nombre5, apellido5), nombre5, apellido5);
                                                                break;
                                                            case 2:
                                                                PPL_SegundoGrado ppl_2_P2 = (PPL_SegundoGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "rehabilitacion", "id_Delito", ppl_2_P2.rehabilitacion, carcel.getTablaPPL(nombre5, apellido5), nombre5, apellido5);
                                                                break;
                                                        }
                                                    } else if (carcel.listPPLs.get(i).getClass().equals(PPL_TercerGrado.class)) {
                                                        System.out.println("-El PPL pertenece a la Clasificacion de Tercer Grado");
                                                        System.out.println("=============================================================");
                                                        System.out.println("                 Rehabilitaciones Disponibles");
                                                        System.out.println(" [1] ---> mentoria de vida");
                                                        System.out.println(" [2] ---> servicio de yoga");
                                                        System.out.println("=============================================================");
                                                        int opcionRehabilitacion3 = teclado.nextInt();
                                                        carcel.listPPLs.get(i).asignarRehabilitacion(opcionRehabilitacion3);
                                                        switch (opcionRehabilitacion3) {
                                                            case 1:
                                                                PPL_TercerGrado ppl_1_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "rehabilitacion", "id_Delito", ppl_1_P3.rehabilitacion, carcel.getTablaPPL(nombre5, apellido5), nombre5, apellido5);
                                                                break;
                                                            case 2:
                                                                PPL_TercerGrado ppl_2_P3 = (PPL_TercerGrado) carcel.listPPLs.get(i);
                                                                carcel.updatePPLDataBaseString(url, "rehabilitacion", "id_Delito", ppl_2_P3.rehabilitacion, carcel.getTablaPPL(nombre5, apellido5), nombre5, apellido5);
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            System.out.println("[La persona ingresada previamente no existe en la Carcel]");
                                        }
                                        break;
                                    case 6:
                                        System.out.println("==========================================================");
                                        System.out.println("      [Cual es el PPL que desea Asignar Alerta de Fuga?]");
                                        System.out.println("==========================================================");
                                        System.out.println("                          NOTA:");
                                        System.out.println("       [Esto Activara la Alerta de Fuga del Sistema]");
                                        System.out.println("==========================================================");
                                        System.out.println("-Por favor ingrese el Nombre del PPL");
                                        String nombre6 = teclado.next();
                                        System.out.println("-Por favor ingrese el Apellido del PPL");
                                        String apellido6 = teclado.next();
                                        if (carcel.existPPL(nombre6, apellido6) == true) {
                                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                                if (carcel.listPPLs.get(i).nombre.equals(nombre6) && carcel.listPPLs.get(i).apellido.equals(apellido6)) {
                                                    carcel.listPPLs.get(i).alertaFuga = "encendida";
                                                    carcel.updatePPLDataBaseString(url, "alertaFuga", "id_Delito", carcel.listPPLs.get(i).alertaFuga, carcel.getTablaPPL(nombre6, apellido6), nombre6, apellido6);
                                                    System.out.println(" [La Alerta de fuga del PPL se ha encendido correctamente]");
                                                }
                                            }
                                        } else {
                                            System.out.println("[La persona ingresada previamente no existe en la Carcel]");
                                        }
                                        break;
                                    case 7:
                                        if (carcel.verificarAlertaFuga()) {
                                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                                if (carcel.listPPLs.get(i).alertaFuga.equals("encendida")) {
                                                    carcel.listPPLs.get(i).alertaFuga = "apagada";
                                                    carcel.updatePPLDataBaseString(url, "alertaFuga", "id_Delito", carcel.listPPLs.get(i).alertaFuga, carcel.getTablaPPL(carcel.listPPLs.get(i).nombre, carcel.listPPLs.get(i).apellido), carcel.listPPLs.get(i).nombre, carcel.listPPLs.get(i).apellido);
                                                }
                                            }
                                        } else {
                                            System.out.println("[No hay alerta de fuga encendida]");
                                        }
                                        break;
                                    case 8:
                                        return;
                                }
                            } catch (Exception e) {
                                System.err.println("[ERROR - DATO INGRESADO]");
                                teclado.nextLine();
                            }
                        }
                    case 2:
                        System.out.println("==========================================================");
                        System.out.println(" -1. Por Favor ingrese el nombre del nuevo PPL");
                        String nombreNuevoPPL = teclado.next();
                        System.out.println(" -2. Por Favor ingrese el apellido del nuevo PPL");
                        String apellidoNuevoPPL = teclado.next();
                        System.out.println(" -3. Por Favor ingrese la edad del nuevo PPL");
                        int edadNuevoPPL = teclado.nextInt();
                        System.out.println(" -4. Por Favor ingrese el genero del nuevo PPL");
                        String generoNuevoPPL = teclado.next();
                        System.out.println(" -5. Por Favor ingrese la nacionalidad del nuevo PPL");
                        String nacionalidadNuevoPPL = teclado.next();
                        System.out.println(" -6. Por Favor ingrese la pena del nuevo PPL");
                        int penaNuevoPPL = teclado.nextInt();
                        System.out.println(" -7. Por favor ingrese el nombre del Delito");
                        String nombreDelito = null;
                        System.out.println(" -8. Por favor selecione la gravedad del Delito");
                        String gravedadDelito = null;
                        System.out.println(" [1] ---> Muy Grave");
                        System.out.println(" [2] ---> Medio Grave");
                        System.out.println(" [3] ---> Poco Grave");
                        int gravedadTecl = teclado.nextInt();
                        switch (gravedadTecl) {
                            case 1 ->
                                gravedadDelito = "muy grave";
                            case 2 ->
                                gravedadDelito = "medio grave";
                            case 3 ->
                                gravedadDelito = "poco grave";
                        }
                        System.out.println(" -9. Por favor selecione la conducta del Delito");
                        String conductaDelito = null;
                        System.out.println(" [1] ---> Accion");
                        System.out.println(" [2] ---> Omision");
                        int conductaTecl = teclado.nextInt();
                        switch (conductaTecl) {
                            case 1 ->
                                conductaDelito = "accion";
                            case 2 ->
                                conductaDelito = "omision";
                        }
                        System.out.println(" -10. Por favor selecione la tipicidad del Delito");
                        String tipicidadDelito = null;
                        System.out.println(" [1] ---> Por Consentimiento");
                        System.out.println(" [2] ---> Por Error");
                        int tipicidadTecl = teclado.nextInt();
                        switch (tipicidadTecl) {
                            case 1 ->
                                tipicidadDelito = "por consentimiento";
                            case 2 ->
                                tipicidadDelito = "por error";
                        }
                        System.out.println(" -11. Por favor selecione la antijuricidad del Delito");
                        String antijuricidadDelito = null;
                        System.out.println(" [1] ---> Legitima dDefensa");
                        System.out.println(" [2] ---> Consentimiento Presunto");
                        System.out.println(" [3] ---> Estado de Necesidad Justificante");
                        System.out.println(" [4] ---> Cumplimiento de Deber");
                        int antijuricidadTecl = teclado.nextInt();
                        switch (antijuricidadTecl) {
                            case 1 ->
                                antijuricidadDelito = "legitima defensa";
                            case 2 ->
                                antijuricidadDelito = "consentimiento presunto";
                            case 3 ->
                                antijuricidadDelito = "estado de necesidad justificante";
                            case 4 ->
                                antijuricidadDelito = "cumplimiento de deber";
                        }
                        System.out.println(" -12. Por favor selecione el agravante del Delito");
                        String agravanteDelito = null;
                        System.out.println(" [1] ---> Ejecucion con alevosia");
                        System.out.println(" [2] ---> Ejecucion mediante disfraz");
                        System.out.println(" [3] ---> Comision del delito");
                        int agravanteTecl = teclado.nextInt();
                        switch (agravanteTecl) {
                            case 1 ->
                                agravanteDelito = "Ejecucion con alevosia";
                            case 2 ->
                                agravanteDelito = "Ejecucion mediante disfraz";
                            case 3 ->
                                agravanteDelito = "Comision del delito";
                        }
                        Agravante agravanteNuevo = new Agravante(agravanteDelito, "no completado", "[Sin descripcion]", carcel.listPPLs.get(carcel.listPPLs.size() - 1).delito.id_Agravante + 1);
                        Delito delitoNuevo = new Delito(nombreDelito, gravedadDelito, conductaDelito, tipicidadDelito, antijuricidadDelito, carcel.listPPLs.get(carcel.listPPLs.size() - 1).id_Delito + 1, agravanteNuevo.id_Agravante);
                        carcel.insertNewPPLDataBase(url, nombreNuevoPPL, apellidoNuevoPPL, edadNuevoPPL, generoNuevoPPL, nacionalidadNuevoPPL, fechaFormateada, penaNuevoPPL, delitoNuevo, agravanteNuevo);
                        break;
                    case 3:
                        System.out.println("==========================================================");
                        System.out.println("      [Cual es el PPL que desea Eliminar?]");
                        System.out.println("==========================================================");
                        System.out.println("                          NOTA:");
                        System.out.println(" [Esto Eliminara al PPL del Sistema y de la Base de Datos]");
                        System.out.println("==========================================================");
                        System.out.println("-Por favor ingrese el Nombre del PPL");
                        String nombre7 = teclado.next();
                        System.out.println("-Por favor ingrese el Apellido del PPL");
                        String apellido7 = teclado.next();
                        if (carcel.existPPL(nombre7, apellido7)) {
                            for (int i = 0; i < carcel.listPPLs.size(); i++) {
                                if (carcel.listPPLs.get(i).nombre.equals(nombre7) && carcel.listPPLs.get(i).apellido.equals(apellido7)) {
                                    System.out.println(" -PPL Encontrado esta seguro de eliminar? [Si|No] ");
                                    String decisionUsu = teclado.next();
                                    if (decisionUsu.equals("Si") || decisionUsu.equals("si")) {
                                        carcel.deletePPLDataBase(url, carcel.getTablaPPL(nombre7, apellido7), nombre7, apellido7);
                                        System.out.println("EL PPL ha sido Eliminado correctamente");
                                    }
                                }
                            }
                        } else {
                            System.out.println("[La persona ingresada previamente no existe en la Carcel]");
                        }
                        break;
                    case 4:
                        System.out.println("==========================================================");
                        System.out.println("  [Estadisticas - " + carcel.nombreCarcel + "]");
                        System.out.println("==========================================================");
                        System.out.println("Numero de PPLs Hombres: " + carcel.calcularPorcHombres());
                        System.out.println("Numero de PPLs Mujeres: " + carcel.calcularPorcMujeres());
                        System.out.println("Numero de PPLs Extrangeros: " + carcel.calcularNumPPLExtrangeros());
                        System.out.println("Numero de PPLs Ecuatorianos: " + carcel.calcularNumPPLEcuatorianos());
                        System.out.println("Numero de PPLs Primer Grado: " + carcel.calcularNumPPLPrimerGrado());
                        System.out.println("Numero de PPLs Segundo Grado: " + carcel.calcularNumPPLSegundoGrado());
                        System.out.println("Numero de PPLs Tercer Grado: " + carcel.calcularNumPPLTercerGrado());
                        System.out.println("Delito Mas Comun Entre los PPLs: " + carcel.verificarDelitoComun());
                        System.out.println("==========================================================");
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.err.println("[ERROR - DATO INGRESADO]");
                teclado.nextLine();
            }
        }
    }
}