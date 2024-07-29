package Model;
import java.sql.*;
import java.util.ArrayList;
import Controller.*;
public class ReaderDataBase extends ManagerDataBase {
    
    private ArrayList<PPL> listPPLs;
    private ArrayList<Delito> listDelitos;
    private ArrayList<Agravante> listAgravantes;

    public ReaderDataBase(ArrayList<PPL> listPPLs, ArrayList<Delito> listDelitos, ArrayList<Agravante> listAgravantes) {
        this.listPPLs = listPPLs;
        this.listDelitos = listDelitos;
        this.listAgravantes = listAgravantes;
    }
    
    public ArrayList<PPL> getListPPLs() {
        return listPPLs;
    }
    
    @Override
    protected void setConcDB(String url) {
        super.setConcDB(url);
    }
    
    public void readDataBase(String url) {
        readAgravantes(url);
        readDelitos(url);
        read_PPLsPrimerGrado(url);
        read_PPLsSegundoGrado(url);
        read_PPLsTercerGrado(url);
        linkedCarcel();
    }
    
    private void readAgravantes(String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Agravantes");
            while (resultSet.next()) {
                this.listAgravantes.add(new Agravante(
                        resultSet.getString("nombreAgravante"),
                        resultSet.getString("estado"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("id_Agravante"))
                );
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }

    private void readDelitos(String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Delitos");
            while (resultSet.next()) {
                this.listDelitos.add(new Delito(
                        resultSet.getString("nombreDelito"),
                        resultSet.getString("gravedad"),
                        resultSet.getString("conducta"),
                        resultSet.getString("tipicidad"),
                        resultSet.getString("antijuricidad"),
                        resultSet.getInt("id_Delito"),
                        resultSet.getInt("id_Agravante"))
                );
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }

    private void read_PPLsPrimerGrado(String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PPLs_PrimerGrado");
            while (resultSet.next()) {
                this.listPPLs.add(new PPL_PrimerGrado(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("edad"),
                        resultSet.getString("genero"),
                        resultSet.getString("nacionalidad"),
                        resultSet.getString("fechaIngreso"),
                        resultSet.getInt("pena"),
                        resultSet.getString("conducta"),
                        resultSet.getString("castigo"),
                        resultSet.getString("actividad"),
                        resultSet.getString("rehabilitacion"),
                        resultSet.getString("alertaFuga"),
                        resultSet.getInt("id_Delito"),
                        resultSet.getInt("numHorasVigilancia"),
                        resultSet.getInt("limHorasFueraCelda"),
                        resultSet.getString("restriccionLugar"),
                        resultSet.getString("riesgoFuga")));
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }

    private void read_PPLsSegundoGrado(String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PPLs_SegundoGrado");
            while (resultSet.next()) {
                this.listPPLs.add(new PPL_SegundoGrado(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("edad"),
                        resultSet.getString("genero"),
                        resultSet.getString("nacionalidad"),
                        resultSet.getString("fechaIngreso"),
                        resultSet.getInt("pena"),
                        resultSet.getString("conducta"),
                        resultSet.getString("castigo"),
                        resultSet.getString("actividad"),
                        resultSet.getString("rehabilitacion"),
                        resultSet.getString("alertaFuga"),
                        resultSet.getInt("id_Delito"),
                        resultSet.getInt("limVisitasSemana"),
                        resultSet.getString("aislamiento")));
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }

    private void read_PPLsTercerGrado(String url) {
        try {
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PPLs_TercerGrado");
            while (resultSet.next()) {
                this.listPPLs.add(new PPL_TercerGrado(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("edad"),
                        resultSet.getString("genero"),
                        resultSet.getString("nacionalidad"),
                        resultSet.getString("fechaIngreso"),
                        resultSet.getInt("pena"),
                        resultSet.getString("conducta"),
                        resultSet.getString("castigo"),
                        resultSet.getString("actividad"),
                        resultSet.getString("rehabilitacion"),
                        resultSet.getString("alertaFuga"),
                        resultSet.getInt("id_Delito"),
                        resultSet.getInt("limVisitasSemana"),
                        resultSet.getString("reduccionPena"),
                        resultSet.getString("libertadCondicional"),
                        resultSet.getString("libertadBajoFianza"),
                        resultSet.getString("prisionDomiciliaria")));
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }

    private void linkedCarcel() {
        for (int i = 0; i < this.listDelitos.size(); i++) {
            for (int j = 0; j < this.listAgravantes.size(); j++) {
                if (this.listDelitos.get(i).id_Agravante == this.listAgravantes.get(j).id_Agravante) {
                    this.listDelitos.get(i).setAgravante(this.listAgravantes.get(j));
                }
            }
        }
        for (int i = 0; i < this.listPPLs.size(); i++) {
            for (int j = 0; j < this.listDelitos.size(); j++) {
                if (this.listPPLs.get(i).id_Delito == this.listDelitos.get(j).id_Delito) {
                    this.listPPLs.get(i).setDelito(this.listDelitos.get(j));
                }
            }
        }
    }
}