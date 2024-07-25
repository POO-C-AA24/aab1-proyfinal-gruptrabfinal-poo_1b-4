package Controller;
public abstract class PPL {
    
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String nacionalidad;
    private String fechaIngreso;
    private int pena;
    private String conducta;
    private String castigo;
    private String actividad;
    private String rehabilitacion;
    private Delito delito;
    private int id_Delito;

    public PPL(String nombre, String apellido, int edad, String genero, String nacionalidad, String fechaIngreso, int pena, String castigo, String actividad, String rehabilitacion, Delito delito, int id_Delito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.pena = pena;
        this.castigo = castigo;
        this.actividad = actividad;
        this.rehabilitacion = rehabilitacion;
        this.delito = delito;
        this.id_Delito = id_Delito;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public int getPena() {
        return pena;
    }

    public String getConducta() {
        return conducta;
    }

    public String getCastigo() {
        return castigo;
    }

    public String getActividad() {
        return actividad;
    }

    public String getRehabilitacion() {
        return rehabilitacion;
    }

    public Delito getDelito() {
        return delito;
    }

    public int getId_Delito() {
        return id_Delito;
    }
    
    
    
    
    public void aumentarPena(int aumentoPena) { 
        
    }
    
    public void asignarCastigo() {      //Metodo polimorfico
        
    }
    
    public void asignarActividad() {     //Metodo polimorfico
        
    }
    
    public void asignarRehilitacion () {  //Metodo polimorfico
        
    }
}
