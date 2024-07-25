package Controller;
import java.io.Serializable;
import java.util.ArrayList;
public class Carcel implements Serializable{
    private static final long serialVersionUID = 539083232976787458L;
    
    public String nombreCarcel;
    public int numVisitasCarcel;
    public int numPPLaislamiento;
    public ArrayList<PersonaPrivadaLibertad> listPPL;

    public Carcel(String nombreCarcel, int numVisitasCarcel, int numPPLaislamiento,ArrayList<PersonaPrivadaLibertad> listPPL) {
        this.nombreCarcel = nombreCarcel;
        this.numVisitasCarcel = numVisitasCarcel;
        this.numPPLaislamiento = numPPLaislamiento;
        this.listPPL = listPPL;
    }

    public String getNombreCarcel() {
        return nombreCarcel;
    } 
    public int getNumVisitasCarcel() {
        return numVisitasCarcel;
    }
    public int getNumPPLaislamiento() {
        return numPPLaislamiento;
    }  
    public ArrayList<PersonaPrivadaLibertad> getListPPL() {
        return listPPL;
    }

    public void calcularNumVisitasCarcel(){
        int visitas = 0;
        for (int i = 0; i < listPPL.size(); i++) {
            visitas += listPPL.get(i).getLimiteVisitasSemana();
        }
        this.numVisitasCarcel = visitas;
    }
    
    public void calcularNumPPLenAislamiento(){
        int numPPLaislamiento = 0;
        for (int i = 0; i < listPPL.size(); i++) {
            if ("Aislamiento".equals(listPPL.get(i).getCastigo()))
                numPPLaislamiento++;
        }
        this.numPPLaislamiento = numPPLaislamiento;
    }
    
    public int calcularNumNacionalidadesPPLs(String nacionalidad){
        int numPPLnacionalidad = 0;
        for (int i = 0; i < listPPL.size(); i++) {
            if (nacionalidad.equals(listPPL.get(i).getNacionalidadPPL()))
                numPPLnacionalidad++;
        }
        return numPPLnacionalidad;
    }  
}
