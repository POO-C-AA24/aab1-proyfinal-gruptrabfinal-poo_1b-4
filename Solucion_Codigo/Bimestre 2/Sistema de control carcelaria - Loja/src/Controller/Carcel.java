package Controller;
import java.util.ArrayList;
import Model.*;
import java.util.HashMap;
import java.util.Map;
public class Carcel {

    public String nombreCarcel;
    public int capacidad;
    public String estadoCapacidad;
    public int numeroTotalPPLs;
    public int porctjPPLsHombres;
    public int porctjPPLsMujeres;
    public int numeroPPLsExtrajeros;
    public int numeroPPLsEcuatorianos;
    public int numeroPPLs_PrimerGrado;
    public int numeroPPLs_SegundoGrado;
    public int numeroPPLs_TercerGrado;
    public String delitoMasComun;
    public ArrayList<PPL> listPPLs;

    public Carcel(String nombreCarcel, int capacidad, ArrayList<PPL> listPPLs) {
        this.nombreCarcel = nombreCarcel;
        this.capacidad = capacidad;
        this.listPPLs = listPPLs;
    }

    public void updatePPLDataBaseString(String url, String columnContent, String columnReference, String content, String tablaPPL, String nombrePPL, String apellidoPPL) {
        UpdaterDateBase myUpdaterDataBase = new UpdaterDateBase();
        for (int i = 0; i < this.listPPLs.size(); i++) {
            if (this.listPPLs.get(i).nombre.equals(nombrePPL) && this.listPPLs.get(i).apellido.equals(apellidoPPL)) {
                myUpdaterDataBase.updatePPLContentString(url, this.listPPLs.get(i), columnContent, columnReference, content, tablaPPL);
            }
        }
    }

    public void updatePPLDataBaseInt(String url, String columnContent, String columnReference, int content, String tablaPPL, String nombrePPL, String apellidoPPL) {
        UpdaterDateBase myUpdaterDataBase = new UpdaterDateBase();
        for (int i = 0; i < this.listPPLs.size(); i++) {
            if (this.listPPLs.get(i).nombre.equals(nombrePPL) && this.listPPLs.get(i).apellido.equals(apellidoPPL)) {
                myUpdaterDataBase.updatePPLContentInt(url, this.listPPLs.get(i), columnContent, columnReference, content, tablaPPL);
            }
        }
    }

    public void updateAgravateDataBase(String url, String columnContent, String columnReference, String content, String nombrePPL, String apellidoPPL) {
        UpdaterDateBase myUpdaterDataBase = new UpdaterDateBase();
        for (int i = 0; i < this.listPPLs.size(); i++) {
            if (this.listPPLs.get(i).nombre.equals(nombrePPL) && this.listPPLs.get(i).apellido.equals(apellidoPPL)) {
                myUpdaterDataBase.updateAgravanteContent(url, this.listPPLs.get(i).delito.agravante, columnContent, columnReference, content);
            }
        }
    }

    public void readCarcelDataBase(String url) {
        ReaderDataBase myReaderDataBase = new ReaderDataBase(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        myReaderDataBase.readDataBase(url);
        this.listPPLs = myReaderDataBase.getListPPLs();
    }

    public boolean deletePPLDataBase(String url, String tablaPPL, String nombrePPL, String apellidoPPL) {
        EliminatorDataBase myEliminatorDataBase = new EliminatorDataBase();
        for (int i = 0; i < this.listPPLs.size(); i++) {
            if (this.listPPLs.get(i).nombre.equals(nombrePPL) && this.listPPLs.get(i).apellido.equals(apellidoPPL)) {
                myEliminatorDataBase.deletePPL(url, this.listPPLs.get(i), tablaPPL);
                this.listPPLs.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean insertNewPPLDataBase(String url, String nombre, String apellido, int edad, String genero, String nacionalidad, String fechaIngreso, int pena, Delito delito, Agravante agravante) {
        InserterDataBase myInserterDataBase = new InserterDataBase();
        boolean inserted = false;
        if (delito.gravedad.equals("muy grave")) {
            PPL_PrimerGrado ppl_P1 = new PPL_PrimerGrado(nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, "moderada", "no asignado", "no asignado", "no asignado", "apagada", this.listPPLs.get(this.listPPLs.size() - 1).id_Delito + 1, 24, 2, "Areas de servicio", "bajo");
            myInserterDataBase.insertPPL_PrimerGrado(ppl_P1, url);
            myInserterDataBase.insertDelito(delito, url);
            myInserterDataBase.insertAgravante(agravante, url);
            delito.setAgravante(agravante);
            ppl_P1.setDelito(delito);
            this.listPPLs.add(ppl_P1);
            inserted = true;
        } else if (delito.gravedad.equals("medio grave")) {
            PPL_SegundoGrado ppl_P2 = new PPL_SegundoGrado(nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, "moderada", "no asignado", "no asignado", "no asignado", "apagada", this.listPPLs.get(this.listPPLs.size() - 1).id_Delito + 1, 2, "no asignado");
            myInserterDataBase.insertPPL_SegundoGrado(ppl_P2, url);
            myInserterDataBase.insertDelito(delito, url);
            myInserterDataBase.insertAgravante(agravante, url);
            delito.setAgravante(agravante);
            ppl_P2.setDelito(delito);
            this.listPPLs.add(ppl_P2);
            inserted = true;
        } else if (delito.gravedad.equals("poco grave")) {
            PPL_TercerGrado ppl_P3 = new PPL_TercerGrado(nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, "moderada", "no asignado", "no asignado", "no asignado", "apagada", this.listPPLs.get(this.listPPLs.size() - 1).id_Delito + 1, 4, "no disponible", "no disponible", "no disponible", "no disponible");
            myInserterDataBase.insertPPL_TercerGrado(ppl_P3, url);
            myInserterDataBase.insertDelito(delito, url);
            myInserterDataBase.insertAgravante(agravante, url);
            delito.setAgravante(agravante);
            ppl_P3.setDelito(delito);
            this.listPPLs.add(ppl_P3);
            inserted = true;
        }
        return inserted;
    }

    public String getTablaPPL(String nombrePPL, String apellidoPPL) {
        String tabla = null;
        for (int i = 0; i < this.listPPLs.size(); i++) {
            if (this.listPPLs.get(i).nombre.equals(nombrePPL) && this.listPPLs.get(i).apellido.equals(apellidoPPL)) {
                if (this.listPPLs.get(i).getClass().equals(PPL_PrimerGrado.class)) {
                    tabla = "PPLs_PrimerGrado";
                } else if (this.listPPLs.get(i).getClass().equals(PPL_SegundoGrado.class)) {
                    tabla = "PPLs_SegundoGrado";
                } else if (this.listPPLs.get(i).getClass().equals(PPL_TercerGrado.class)) {
                    tabla = "PPLs_TercerGrado";
                }
            }
        }
        return tabla;
    }

    public boolean existPPL(String nombrePPL, String apellidoPPL) {
        for (int i = 0; i < this.listPPLs.size(); i++) {
            if (this.listPPLs.get(i).nombre.equals(nombrePPL) && this.listPPLs.get(i).apellido.equals(apellidoPPL)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarAlertaFuga() {
        for (int i = 0; i < this.listPPLs.size(); i++) {
            if (this.listPPLs.get(i).alertaFuga.equals("encendida")) {
                return true;
            }
        }
        return false;
    }

    public void verificarEstadoCapacidad() {
        //tres tipos de estados de capacidad.
    }

    public int calcularPorcHombres() {
        for (PPL ppl : this.listPPLs) {
            if (ppl.genero.equals("hombre")) {
                this.porctjPPLsHombres += 1;
            }
        }
        return this.porctjPPLsHombres;
    }

    public int calcularPorcMujeres() {
        for (PPL ppl : this.listPPLs) {
            if (ppl.genero.equals("mujer")) {
                this.porctjPPLsMujeres += 1;
            }
        }
        return this.porctjPPLsMujeres;
    }

    public int calcularNumPPLExtrangeros() {
        for (PPL ppl : this.listPPLs) {
            if (!ppl.nacionalidad.equalsIgnoreCase("ecuatoriano/a")) {
                this.numeroPPLsExtrajeros += 1;
            }
        }
        return this.numeroPPLsExtrajeros;
    }

    public int calcularNumPPLEcuatorianos() {
        for (PPL ppl : this.listPPLs) {
            if (ppl.nacionalidad.equals("ecuatoriano/a")) {
                this.numeroPPLsEcuatorianos += 1;
            }
        }
        return this.numeroPPLsEcuatorianos;
    }

    public int calcularNumPPLPrimerGrado() {
        for (PPL ppl : this.listPPLs) {
            if (PPL_PrimerGrado.class.equals(ppl.getClass())) {
                this.numeroPPLs_PrimerGrado += 1;
            }
        }
        return this.numeroPPLs_PrimerGrado;
    }

    public int calcularNumPPLSegundoGrado() {
        for (PPL ppl : this.listPPLs) {
            if (PPL_SegundoGrado.class.equals(ppl.getClass())) {
                this.numeroPPLs_SegundoGrado += 1;
            }
        }
        return this.numeroPPLs_SegundoGrado;
    }

    public int calcularNumPPLTercerGrado() {
        for (PPL ppl : this.listPPLs) {
            if (PPL_TercerGrado.class.equals(ppl.getClass())) {
                this.numeroPPLs_TercerGrado += 1;
            }
        }
        return this.numeroPPLs_TercerGrado;
    }

    public String verificarDelitoComun() {
        if (this.listPPLs == null || this.listPPLs.isEmpty()) {
            return null;
        }
        Map<String, Integer> contadorDelitos = new HashMap<>();
        for (PPL ppl : this.listPPLs) {
            String delito = ppl.delito.nombreDelito;
            contadorDelitos.put(delito, contadorDelitos.getOrDefault(delito, 0) + 1);
        }
        this.delitoMasComun = null;
        int maxRepeticiones = 0;
        for (Map.Entry<String, Integer> entry : contadorDelitos.entrySet()) {
            if (entry.getValue() > maxRepeticiones) {
                this.delitoMasComun = entry.getKey();
                maxRepeticiones = entry.getValue();
            }
        }
        return this.delitoMasComun;
    }
}