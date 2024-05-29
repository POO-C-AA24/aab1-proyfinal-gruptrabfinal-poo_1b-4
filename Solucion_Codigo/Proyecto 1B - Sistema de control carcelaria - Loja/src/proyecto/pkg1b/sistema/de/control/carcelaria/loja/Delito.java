package proyecto.pkg1b.sistema.de.control.carcelaria.loja;
public class Delito {

    public String tipoDelito;
    public String penaDelito;
    public String gravedadDelito;
    public String conductaDelito;
    public String tipicidadDelito;
    public String antijuricidadDelito;

    public Delito() {}
    public Delito(String tipoDelito, String penaDelito, String gravedadDelito, String conductaDelito, String tipicidadDelito, String antijuricidadDelito) {
        this.tipoDelito = tipoDelito;
        this.penaDelito = penaDelito;
        this.gravedadDelito = gravedadDelito;
        this.conductaDelito = conductaDelito;
        this.tipicidadDelito = tipicidadDelito;
        this.antijuricidadDelito = antijuricidadDelito;
    }

    public String getTipoDelito() {
        return tipoDelito;
    }

    public void setTipoDelito(String tipoDelito) {
        this.tipoDelito = tipoDelito;
    }

    public String getPenaDelito() {
        return penaDelito;
    }

    public void setPenaDelito(String penaDelito) {
        this.penaDelito = penaDelito;
    }

    public String getGravedadDelito() {
        return gravedadDelito;
    }

    public void setGravedadDelito(String gravedadDelito) {
        this.gravedadDelito = gravedadDelito;
    }

    public String getConductaDelito() {
        return conductaDelito;
    }

    public void setConductaDelito(String conductaDelito) {
        this.conductaDelito = conductaDelito;
    }

    public String getTipicidadDelito() {
        return tipicidadDelito;
    }

    public void setTipicidadDelito(String tipicidadDelito) {
        this.tipicidadDelito = tipicidadDelito;
    }

    public String getAntijuricidadDelito() {
        return antijuricidadDelito;
    }

    public void setAntijuricidadDelito(String antijuricidadDelito) {
        this.antijuricidadDelito = antijuricidadDelito;
    }

    
}
