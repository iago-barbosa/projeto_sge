/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Area;

/**
 *
 * @author aluno
 */
public class AreaDao {
    
    public List<Area> listarAreas(){
        List<Area> listaAreas = new ArrayList();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM area");
                
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Area areaAtual = new Area();
                
                areaAtual.setId_area(rs.getInt("id_area"));
                areaAtual.setNome(rs.getString("nome"));
                
                listaAreas.add(areaAtual);
                
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAreas;
    }
    
    
}
