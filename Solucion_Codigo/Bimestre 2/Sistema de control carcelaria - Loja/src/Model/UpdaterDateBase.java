package Model;
import Controller.*;
import java.sql.*;
public class UpdaterDateBase extends ManagerDataBase {
    
    @Override
    protected void setConcDB(String url) {
        super.setConcDB(url);
    }
    
    public void updatePPLContentString(String url, PPL ppl ,String columnContent, String columnReference, String content, String tablaPPL) {
        try {
            String consulta;
            setConcDB(url);
            consulta = "UPDATE "+tablaPPL+" SET "+columnContent+" = ? WHERE ["+columnReference+"] = ?";
            PreparedStatement preparedStatement = conexionDataBase.prepareStatement(consulta);
            preparedStatement.setString(1, content);
            preparedStatement.setInt(2, ppl.id_Delito);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
    
    public void updatePPLContentInt(String url, PPL ppl ,String columnContent, String columnReference, int content, String tablaPPL) {
        try {
            String consulta;
            setConcDB(url);
            consulta = "UPDATE "+tablaPPL+" SET "+columnContent+" = ? WHERE ["+columnReference+"] = ?";
            PreparedStatement preparedStatement = conexionDataBase.prepareStatement(consulta);
            preparedStatement.setInt(1, content);
            preparedStatement.setInt(2, ppl.id_Delito);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
    
    public void updateAgravanteContent(String url, Agravante agravante ,String columnContent, String columnReference, String content) {
        try {
            String consulta;
            setConcDB(url);
            consulta = "UPDATE Agravantes SET "+columnContent+" = ? WHERE ["+columnReference+"] = ?";
            PreparedStatement preparedStatement = conexionDataBase.prepareStatement(consulta);
            preparedStatement.setString(1, content);
            preparedStatement.setInt(2, agravante.id_Agravante);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
            System.out.println(this.msjException);
        }
    }
}