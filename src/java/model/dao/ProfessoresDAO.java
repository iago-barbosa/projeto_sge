
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfessoresDAO {
    
    public boolean logar(String cpf, String senha) {
        
        boolean very = false;
        
        try{
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("SELECT * FROM professores WHERE cpf = ? AND senha = ?");
            
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                very = true;
                
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return very;
    }
    
}
