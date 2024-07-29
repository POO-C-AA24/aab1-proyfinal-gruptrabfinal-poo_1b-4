package Controller;
public class PPL_TercerGrado extends PPL {
    
    public int limVisitasSemana;
    public String reduccionPena;
    public String libertadCondicional;
    public String libertadBajoFianza;
    public String prisionDomiciliaria;

    public PPL_TercerGrado(String nombre, String apellido, int edad, String genero, String nacionalidad, String fechaIngreso, int pena, String conducta, String castigo, String actividad, String rehabilitacion, String alertaFuga, int id_Delito, int limVisitasSemana, String reduccionPena, String libertadCondicional, String libertadBajoFianza, String prisionDomiciliaria) {
        super(nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, conducta, castigo, actividad, rehabilitacion, alertaFuga, id_Delito);
        this.limVisitasSemana = limVisitasSemana;
        this.reduccionPena = reduccionPena;
        this.libertadCondicional = libertadCondicional;
        this.libertadBajoFianza = libertadBajoFianza;
        this.prisionDomiciliaria = prisionDomiciliaria;
    }
    
    @Override
    public void setDelito(Delito delito) {
        super.setDelito(delito);
    }
    
    @Override
    public void asignarCastigo(int arg) {
        switch (arg) {
            case 1 -> this.castigo = "receso denegado";
            case 2 -> this.castigo = "actividades recreativas denegadas";
            case 3 -> this.castigo = "tiempo visitas reducido";
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
            case 1 -> this.actividad = "Fabricacion Productos artesanales";
            case 2 -> this.actividad = "Deportes";
        }
    }
    
    @Override
    public void asignarRehabilitacion (int arg) {
        switch (arg) {
            case 1 -> this.rehabilitacion = "mentoria de vida";
            case 2 -> this.rehabilitacion = "servicio de yoga";
        }
    }  
}