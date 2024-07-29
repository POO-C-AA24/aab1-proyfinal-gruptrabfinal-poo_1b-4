package Model;
import Controller.*;
import java.sql.*;
public class EliminatorDataBase extends ManagerDataBase {
    
    @Override
    protected void setConcDB(String url) {
        super.setConcDB(url);
    }
    
    public void deletePPL(String url, PPL ppl, String tipoPPL) {
        try {
            String consulta;
            setConcDB(url);
            Statement statement = conexionDataBase.createStatement();
            consulta = "DELETE from "+tipoPPL+" WHERE id_Delito = "+ppl.id_Delito;
            statement.executeUpdate(consulta);
            consulta = "DELETE from Delitos WHERE id_Delito = "+ppl.delito.id_Delito;
            statement.executeUpdate(consulta);
            consulta = "DELETE from Agravantes WHERE id_Agravante = "+ppl.delito.agravante.id_Agravante;
            statement.executeUpdate(consulta);
            statement.close();
        } catch (SQLException sqlException) {
            this.msjException = sqlException.getMessage();
        }
    }
}