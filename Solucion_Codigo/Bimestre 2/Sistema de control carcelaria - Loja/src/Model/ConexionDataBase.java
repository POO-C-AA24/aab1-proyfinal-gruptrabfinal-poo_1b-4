package Model;
import java.sql.*;
import java.util.ArrayList;
import Controller.*;
public class ConexionDataBase {
    
    public Connection conexionDataBase;
    public ArrayList <PPL> listPPLs;
    public String msjException;
    
    public void setConcDB(String url) {     //Establecer conexion Base de Datos
        try {
            this.conexionDataBase = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
    
    public ArrayList <PPL> getListPPLs() {   //Leer base de Datos
        listPPLs = new ArrayList <PPL>();
        try {
            setConcDB(" ");         // Direccion de la Base de Datos
            Statement statement = conexionDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from #############");
            while (resultSet.next()) {
                /*listPPLs.add(new Estudiante(resultSet.getString(""),
                                                  resultSet.getDouble(""),
                                                  resultSet.getDouble(""),
                                                  resultSet.getDouble(""), 
                                                  resultSet.getString("")) );*/
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
        return listPPLs;
    }
    
    public void insertPPLs(PPL ppl) {     //Insertar nuevo PPL
        /*try {
            setConcDB("");
            Statement statement = concDB.createStatement();
            String strInsertEst = String.format("insert into Estudiante(nombreEst, nota1, nota2, promedio, estado) "
                                               + "values('%s', %d, %d, %d, '%s')", estudiante.nombreEst, (int) estudiante.nota1,
                                                    (int) estudiante.nota2, (int) estudiante.promedio,estudiante.estado);
            statement.executeUpdate(strInsertEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }*/
    }
}
