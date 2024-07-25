package Controller;
import java.io.Serializable;
import java.util.ArrayList;
public class Delito implements Serializable{
    private static final long serialVersionUID = -2021215723701590304L;
    
    public String nombreDelito;
    public String gravedadDelito;
    public String conductaDelito;
    public String tipicidadDelito;
    public String antijuricidadDelito;
    public int numAgravantesDelito;
    public ArrayList<Agravantes> listagravantes;

    public Delito(String nombreDelito, String gravedadDelito, String conductaDelito, String tipicidadDelito, String antijuricidadDelito, int numAgravantesDelito, ArrayList<Agravantes> listagravantes) {
        this.nombreDelito = nombreDelito;
        this.gravedadDelito = gravedadDelito;
        this.conductaDelito = conductaDelito;
        this.tipicidadDelito = tipicidadDelito;
        this.antijuricidadDelito = antijuricidadDelito;
        this.numAgravantesDelito = numAgravantesDelito;
        this.listagravantes = listagravantes;
    }

    public String getGravedadDelito() {
        return gravedadDelito;
    }

    public String getNombreDelito() {
        return nombreDelito;
    }

    public String getConductaDelito() {
        return conductaDelito;
    }

    public String getTipicidadDelito() {
        return tipicidadDelito;
    }

    public String getAntijuricidadDelito() {
        return antijuricidadDelito;
    }

    public int getNumAgravantesDelito() {
        return numAgravantesDelito;
    }

    public ArrayList<Agravantes> getListagravantes() {
        return listagravantes;
    }
}
