package proyecto.pkg1b.sistema.de.control.carcelaria.loja;
public class PersonaPrivadaLibertad {
    
    public String nombrePPL;
    public String apellidoPPL;
    public int edadPPL;
    public String generoPPL;
    public String nacionalidadPPL;
    public String fechaIngresoPPL;
    public String identificacionPPL;
    public String numDelitoPPL;
    public String castigo;

    public PersonaPrivadaLibertad() {}
    public PersonaPrivadaLibertad(String nombrePPL, String apellidoPPL, String nacionalidadPPL, String fechaIngresoPPL, String identificacionPPL) {
        this.nombrePPL = nombrePPL;
        this.apellidoPPL = apellidoPPL;
        this.nacionalidadPPL = nacionalidadPPL;
        this.fechaIngresoPPL = fechaIngresoPPL;
        this.identificacionPPL = identificacionPPL;
    }

    public String getNombrePPL() {
        return nombrePPL;
    }

    public void setNombrePPL(String nombrePPL) {
        this.nombrePPL = nombrePPL;
    }

    public String getApellidoPPL() {
        return apellidoPPL;
    }

    public void setApellidoPPL(String apellidoPPL) {
        this.apellidoPPL = apellidoPPL;
    }

    public int getEdadPPL() {
        return edadPPL;
    }

    public void setEdadPPL(int edadPPL) {
        this.edadPPL = edadPPL;
    }

    public String getGeneroPPL() {
        return generoPPL;
    }

    public void setGeneroPPL(String generoPPL) {
        this.generoPPL = generoPPL;
    }

    public String getNacionalidadPPL() {
        return nacionalidadPPL;
    }

    public void setNacionalidadPPL(String nacionalidadPPL) {
        this.nacionalidadPPL = nacionalidadPPL;
    }

    public String getFechaIngresoPPL() {
        return fechaIngresoPPL;
    }

    public void setFechaIngresoPPL(String fechaIngresoPPL) {
        this.fechaIngresoPPL = fechaIngresoPPL;
    }

    public String getIdentificacionPPL() {
        return identificacionPPL;
    }

    public void setIdentificacionPPL(String identificacionPPL) {
        this.identificacionPPL = identificacionPPL;
    }

    public String getNumDelitoPPL() {
        return numDelitoPPL;
    }

    public void setNumDelitoPPL(String numDelitoPPL) {
        this.numDelitoPPL = numDelitoPPL;
    }

    public String getCastigo() {
        return castigo;
    }

    public void setCastigo(String castigo) {
        this.castigo = castigo;
    }
    
    
}
