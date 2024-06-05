package Controller;
import java.io.Serializable;
public class Agravantes implements Serializable{
    private static final long serialVersionUID = -1787596724299124113L;
    
    public String nombreAgravante;
    public String estadoAgravante;

    public Agravantes(String nombreAgravante, String estadoAgravante) {
        this.nombreAgravante = nombreAgravante;
        this.estadoAgravante = estadoAgravante;
    }

    public String getNombreAgravante() {
        return nombreAgravante;
    }
    public String getEstadoAgravante() {
        return estadoAgravante;
    }    
}
