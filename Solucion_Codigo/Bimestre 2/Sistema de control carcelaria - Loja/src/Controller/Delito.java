package Controller;
public class Delito {
    
    public String nombreDelito;
    public String gravedad;
    public String conducta;
    public String tipicidad;
    public String antijuricidad;
    public Agravante agravante;
    public int id_Delito;
    public int id_Agravante;

    public Delito(String nombreDelito, String gravedad, String conducta, String tipicidad, String antijuricidad, int id_Delito, int id_Agravante) {
        this.nombreDelito = nombreDelito;
        this.gravedad = gravedad;
        this.conducta = conducta;
        this.tipicidad = tipicidad;
        this.antijuricidad = antijuricidad;
        this.id_Delito = id_Delito;
        this.id_Agravante = id_Agravante;
    }

    public void setAgravante(Agravante agravante) {
        this.agravante = agravante;
    }
}
