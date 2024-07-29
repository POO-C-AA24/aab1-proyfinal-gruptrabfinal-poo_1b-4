package Model;
import Controller.*;
import java.sql.*;
public class InserterDataBase extends ManagerDataBase {
    
    public void insertPPL_PrimerGrado(PPL_PrimerGrado ppl, String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            String insertPPL = String.format("insert into PPLs_PrimerGrado (nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, conducta, castigo, actividad, rehabilitacion, alertaFuga, id_Delito, numHorasVigilancia, limHorasFueraCelda, restriccionLugar, riesgoFuga) "
                    + "values('%s', '%s', %d, '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s')",
                    ppl.nombre,
                    ppl.apellido,
                    ppl.edad,
                    ppl.genero,
                    ppl.nacionalidad,
                    ppl.fechaIngreso,
                    ppl.pena,
                    ppl.conducta,
                    ppl.castigo,
                    ppl.actividad,
                    ppl.rehabilitacion,
                    ppl.alertaFuga,
                    ppl.id_Delito,
                    ppl.numHorasVigilancia,
                    ppl.limHorasFueraCelda,
                    ppl.restriccionLugar,
                    ppl.riesgoFuga);
            statement.executeUpdate(insertPPL);
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
    
    public void insertPPL_SegundoGrado(PPL_SegundoGrado ppl, String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            String insertPPL = String.format("insert into PPLs_SegundoGrado (nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, conducta, castigo, actividad, rehabilitacion, alertaFuga, id_Delito, limVisitasSemana, aislamiento) "
                    + "values('%s', '%s', %d, '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', %d, %d, '%s')",
                    ppl.nombre,
                    ppl.apellido,
                    ppl.edad,
                    ppl.genero,
                    ppl.nacionalidad,
                    ppl.fechaIngreso,
                    ppl.pena,
                    ppl.conducta,
                    ppl.castigo,
                    ppl.actividad,
                    ppl.rehabilitacion,
                    ppl.alertaFuga,
                    ppl.id_Delito,
                    ppl.limVisitasSemana,
                    ppl.aislamiento);
            statement.executeUpdate(insertPPL);
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
    
    public void insertPPL_TercerGrado(PPL_TercerGrado ppl, String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            String insertPPL = String.format("insert into PPLs_TercerGrado (nombre, apellido, edad, genero, nacionalidad, fechaIngreso, pena, conducta, castigo, actividad, rehabilitacion, alertaFuga, id_Delito, limVisitasSemana, reduccionPena, libertadCondicional, libertadBajoFianza, prisionDomiciliaria) "
                    + "values('%s', '%s', %d, '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', '%s', '%s')",
                    ppl.nombre,
                    ppl.apellido,
                    ppl.edad,
                    ppl.genero,
                    ppl.nacionalidad,
                    ppl.fechaIngreso,
                    ppl.pena,
                    ppl.conducta,
                    ppl.castigo,
                    ppl.actividad,
                    ppl.rehabilitacion,
                    ppl.alertaFuga,
                    ppl.id_Delito,
                    ppl.limVisitasSemana,
                    ppl.reduccionPena,
                    ppl.libertadCondicional,
                    ppl.libertadBajoFianza,
                    ppl.prisionDomiciliaria);
            statement.executeUpdate(insertPPL);
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
    
    public void insertDelito(Delito delito, String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            String insertPPL = String.format("insert into Delitos (nombreDelito, gravedad, conducta, tipicidad, antijuricidad, id_Delito, id_Agravante) "
                    + "values('%s', '%s', '%s', '%s', '%s', %d, %d)",
                    delito.nombreDelito,
                    delito.gravedad,
                    delito.conducta,
                    delito.tipicidad,
                    delito.antijuricidad,
                    delito.id_Delito,
                    delito.id_Agravante);
            statement.executeUpdate(insertPPL);
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
    
    public void insertAgravante(Agravante agravante, String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            String insertPPL = String.format("insert into Agravantes (nombreAgravante, estado, descripcion, id_Agravante) "
                    + "values('%s', '%s', '%s', %d)",
                    agravante.nombreAgravante,
                    agravante.estado,
                    agravante.descripcion,
                    agravante.id_Agravante); 
            statement.executeUpdate(insertPPL);
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
}