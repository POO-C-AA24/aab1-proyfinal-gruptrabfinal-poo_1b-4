package Controller;
import java.io.Serializable;
import java.util.ArrayList;
public class PersonaPrivadaLibertad implements Serializable{
    //private static final long serialVersionUID = -8748671010360955959L;
    
    public String nombrePPL;
    public String apellidoPPL;
    public int edadPPL;
    public String generoPPL;
    public String nacionalidadPPL;
    public String fechaIngresoPPL;
    public int numeroDelitosPPL;
    public int penaPPL;
    public String castigo;
    public int limiteVisitasSemana;
    public ArrayList<Delito> listDelitos;

    public PersonaPrivadaLibertad(String nombrePPL, String apellidoPPL, int edadPPL, String generoPPL, String nacionalidadPPL, String fechaIngresoPPL, int numeroDelitosPPL, int penaPPL, String castigo, int limiteVisitasSemana, ArrayList<Delito> listDelitos) {
        this.nombrePPL = nombrePPL;
        this.apellidoPPL = apellidoPPL;
        this.edadPPL = edadPPL;
        this.generoPPL = generoPPL;
        this.nacionalidadPPL = nacionalidadPPL;
        this.fechaIngresoPPL = fechaIngresoPPL;
        this.numeroDelitosPPL = numeroDelitosPPL;
        this.penaPPL = penaPPL;
        this.castigo = castigo;
        this.limiteVisitasSemana = limiteVisitasSemana;
        this.listDelitos = listDelitos;
    }

    public void setCastigo(String castigo) {
        this.castigo = castigo;
    }
    public String getNombrePPL() {
        return nombrePPL;
    }

    public String getApellidoPPL() {
        return apellidoPPL;
    }

    public String getNacionalidadPPL() {
        return nacionalidadPPL;
    }

    public String getFechaIngresoPPL() {
        return fechaIngresoPPL;
    }

    public int getNumeroDelitosPPL() {
        return numeroDelitosPPL;
    }

    public int getPenaPPL() {
        return penaPPL;
    }

    public int getEdadPPL() {
        return edadPPL;
    }

    public String getGeneroPPL() {
        return generoPPL;
    }

    public String getCastigo() {
        return castigo;
    }

    public int getLimiteVisitasSemana() {
        return limiteVisitasSemana;
    }

    public ArrayList<Delito> getListDelitos() {
        return listDelitos;
    }
    
    public void aumentarPenaPPL(int aumentoPena){
        this.penaPPL += aumentoPena;
    }
    public void reducirDiasVisitaPPL(int opcion){
        if (opcion == 1) {
            this.limiteVisitasSemana -= 1;
        }else if (opcion == 2) {
            this.limiteVisitasSemana -=2;
        }
    }    
}
