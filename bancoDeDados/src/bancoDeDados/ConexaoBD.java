package bancoDeDados;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
	 
	 private String jdbcURL; 
     private String username; 
     private String password; 
     private Connection conect; 
     
     
     ConexaoBD(){
    	 jdbcURL = "jdbc:postgresql://localhost:5432/teste3uni";
    	 username = "postgres";
    	 password = "postgres";
    	 
    	 try {
    		 //Class.forName("org.postgresql.Driver");
        	 conect = DriverManager.getConnection(jdbcURL, username, password);
             System.out.println("Conectado com sucesso ao server!");
         } catch (SQLException e) {   
        	 System.out.println("Erro ao conectar com o POSTGRESQL!");
             e.printStackTrace(); 
         }
     
     }
     
     public int executaSQL(String sql) {
    	 try {
			System.out.println();
			Statement stm = conect.createStatement();
			int res = stm.executeUpdate(sql);
			//conect.close();
			return res;
    	 } catch (Exception e) {
			System.out.println();
			e.printStackTrace();
			return 0;
    	 }
     }
     
     public ResultSet executaBusca(String sql) {
    	 try {
			Statement stm = conect.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
     }
     
     public void fechaBD() throws SQLException {
    	 conect.close();
    	 return;
     }
    
}

