package Controller;
public abstract class PPL {
    
    public String nombre;
    public String apellido;
    public int edad;
    public String genero;
    public String nacionalidad;
    public String fechaIngreso;
    public int pena;
    public String conducta;
    public String castigo;
    public String actividad;
    public String rehabilitacion;
    public String alertaFuga;
    public Delito delito;
    public int id_Delito;

    public PPL(String nombre, String apellido, int edad, String genero, String nacionalidad, String fechaIngreso, int pena, String conducta, String castigo, String actividad, String rehabilitacion, String alertaFuga, int id_Delito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.pena = pena;
        this.conducta = conducta;
        this.castigo = castigo;
        this.actividad = actividad;
        this.rehabilitacion = rehabilitacion;
        this.alertaFuga = alertaFuga;
        this.id_Delito = id_Delito;
    }

    public void setDelito(Delito delito) {
        this.delito = delito;
    }
    
    public void aumentarPena(int aumentoPena) { 
        
    }
    
    abstract public void asignarCastigo(int arg);
    abstract public void asignarActividad(int arg);
    abstract public void asignarRehabilitacion (int arg);
    
}
