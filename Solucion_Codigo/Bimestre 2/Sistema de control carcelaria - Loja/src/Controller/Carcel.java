package Controller;
import java.util.ArrayList;
public class Carcel {
    
    private String nombre;
    private int capacidad;
    private String estadoCapacidad;
    private int numeroTotalPPLs;
    private int porctjPPLsHombres;
    private int porctjPPLsMujeres;
    private int numeroPPLsExtrajeros;
    private int numeroPPLsEcuatorianos;
    private int numeroPPLsAislamiento;
    private int numeroPPLs_PrimerGrado;
    private int numeroPPLs_SegundoGrado;
    private int numeroPPLs_TercerGrado;
    private int promedioEdadPPLs;
    private String delitoMasComun;
    private ArrayList <PPL> listPPLs;
    public Carcel(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    public void verificarEstadoCapacidad(){
        
    }
    public void calcularPorcHombres(){
        for (PPL ppl: this.listPPLs) {
            if (ppl.getGenero().equals("Hombre")) {
                this.porctjPPLsHombres += 1;
            }
        }
    }
    public void calcularPorcMujeres(){
        for (PPL ppl: this.listPPLs) {
            if (ppl.getGenero().equals("Mujer")) {
                this.porctjPPLsMujeres += 1;
            }
        }
    }
    public void calcularNumPPLExtrangeros(){
        for (PPL ppl: this.listPPLs) {
            //switch()
        }
    }
    public void calcularNumPPLEcuatorianos(){
        for (PPL ppl: this.listPPLs) {
            if (ppl.getNacionalidad().equals("Ecuatoriano")) {
                this.numeroPPLsEcuatorianos += 1;
            }
        }
    }
    public void calcularNumPPLAislamiento(){
        //Terminar
        for (PPL ppl: this.listPPLs) {
            if (PPL_SegundoGrado.class.equals(ppl.getClass())) {
                this.numeroPPLsAislamiento += 1;
            }
        }
    }
    public void calcularNumPPLPrimerGrado(){
        for (PPL ppl: this.listPPLs) {
            if (PPL_PrimerGrado.class.equals(ppl.getClass())) {
                this.numeroPPLs_PrimerGrado += 1;
            }
        }
    }
    public void calcularNumPPLSegundoGrado(){
        for (PPL ppl: this.listPPLs) {
            if (PPL_SegundoGrado.class.equals(ppl.getClass())) {
                this.numeroPPLsAislamiento += 1;
            }
        }
    }
    public void calcularNumPPLTercerGrado(){
        for (PPL ppl: this.listPPLs) {
            if (PPL_TercerGrado.class.equals(ppl.getClass())) {
                this.numeroPPLsAislamiento += 1;
            }
        }
    }
    public void calcularPromedioEdades(){
        this.promedioEdadPPLs = 0;
        for (PPL ppl: this.listPPLs) {
            this.promedioEdadPPLs += ppl.getEdad();
        }
        this.promedioEdadPPLs = this.promedioEdadPPLs/this.listPPLs.size();
    }
    public void verificarDelitoComun(){
        
        /*for (PPL ppl: this.listPPLs) {
            if (ppl.getDelito().getNombreDelito().equals("Robo")) {
                
            }
        }*/
    }
}
