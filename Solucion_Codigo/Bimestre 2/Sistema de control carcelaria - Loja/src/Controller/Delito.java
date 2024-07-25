package Controller;
public class Delito {
    
    private String nombreDelito;
    private String gravedadDelito;
    private String conductaDelito;
    private String tipicidadDelito;
    private String antijuricidadDelito;
    private Agravante agravante;
    private int id_Delito;
    private int id_Agravante;

    public Delito(String nombreDelito, String gravedadDelito, String conductaDelito, String tipicidadDelito, String antijuricidadDelito, Agravante agravante, int id_Delito, int id_Agravante) {
        this.nombreDelito = nombreDelito;
        this.gravedadDelito = gravedadDelito;
        this.conductaDelito = conductaDelito;
        this.tipicidadDelito = tipicidadDelito;
        this.antijuricidadDelito = antijuricidadDelito;
        this.agravante = agravante;
        this.id_Delito = id_Delito;
        this.id_Agravante = id_Agravante;
    }  
}
