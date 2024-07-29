package Controller;
public class PPL_PrimerGrado extends PPL {

    public int numHorasVigilancia;
    public int limHorasFueraCelda;
    public String restriccionLugar;
    public String riesgoFuga;

    public PPL_PrimerGrado(String nombre, String apellido, int edad, String genero, String nacionalidad, String fechaIngreso, int pena, String conducta, String castigo, String actividad, String rehabilitacion, String alertaFuga, int id_Delito, int numHorasVigilancia, int limHorasFueraCelda, String restriccionLugar, String riesgoFuga) {
        super(nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, conducta, castigo, actividad, rehabilitacion, alertaFuga, id_Delito);
        this.numHorasVigilancia = numHorasVigilancia;
        this.limHorasFueraCelda = limHorasFueraCelda;
        this.restriccionLugar = restriccionLugar;
        this.riesgoFuga = riesgoFuga;
    }

    @Override
    public void setDelito(Delito delito) {
        super.setDelito(delito);
    }

    @Override
    public void asignarCastigo(int arg) {
        switch (arg) {
            case 1 -> {
                if (this.limHorasFueraCelda > 0) {
                    this.limHorasFueraCelda--;
                }
            }
            case 2 -> this.castigo = "Racion Alimenticia Reducida";
            case 3 -> this.castigo = "Luces Encendidas en la noche";
        }
    }

    @Override
    public void asignarActividad(int arg) {
        switch (arg) {
            case 1 -> this.actividad = "Preparacion de vida despues de prision";
            case 2 -> this.actividad = "Programa de mentoria y apoyo";
        }
    }

    @Override
    public void asignarRehabilitacion(int arg) {
        switch (arg) {
            case 1 -> this.rehabilitacion = "Programa de Salud Mental";
            case 2 -> this.rehabilitacion = "Terapia con psiquiatra";
        }
    }
}
