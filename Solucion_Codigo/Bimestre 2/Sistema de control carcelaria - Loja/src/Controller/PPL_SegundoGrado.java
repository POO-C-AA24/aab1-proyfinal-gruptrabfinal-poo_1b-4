package Controller;
public class PPL_SegundoGrado extends PPL {
    
    public int limVisitasSemana;
    public String aislamiento;

    public PPL_SegundoGrado(String nombre, String apellido, int edad, String genero, String nacionalidad, String fechaIngreso, int pena, String conducta, String castigo, String actividad, String rehabilitacion, String alertaFuga, int id_Delito, int limVisitasSemana, String aislamiento) {
        super(nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, conducta, castigo, actividad, rehabilitacion, alertaFuga, id_Delito);
        this.limVisitasSemana = limVisitasSemana;
        this.aislamiento = aislamiento;
    }
    
    @Override
    public void setDelito(Delito delito) {
        super.setDelito(delito);
    }
    
    @Override
    public void asignarCastigo(int arg) {
        switch (arg) {
            case 1 -> {
                this.castigo = "en aislamiento";
                this.aislamiento = "Asignado";
            }
            case 2 -> this.castigo = "prohibicion contacto con otros reclusos";
            case 3 -> this.castigo = "tarea asignada";
            case 4 -> {
                if (this.limVisitasSemana > 0){
                    this.limVisitasSemana--;
                }
            }
        }
        
    }
    
    @Override
    public void asignarActividad(int arg) {
        switch (arg) {
            case 1 -> this.actividad = "Trabajo Agricola";
            case 2 -> this.actividad = "Servicio Religioso";
        }
    }
    
    @Override
    public void asignarRehabilitacion (int arg) {
        switch (arg) {
            case 1 -> this.rehabilitacion = "justicia restaurativa";
            case 2 -> this.rehabilitacion = "Terapia con psicologo";
        }
    }  
}