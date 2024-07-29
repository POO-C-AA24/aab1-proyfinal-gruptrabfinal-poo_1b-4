package Model;
import java.sql.*;
import Controller.*;
public class ManagerDataBase {

    protected Connection conexionDataBase;
    protected String msjException;

    protected void setConcDB(String url) {
        try {
            this.conexionDataBase = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
}