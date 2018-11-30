/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.Dao;

import DTO.SodatDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Max
 */
public class Soda {

    private static final DbConnection con = DbConnection.saberEstado();

    public boolean Create(SodatDTO c){
        String query = "INSERT INTO SODA(ID,NAME,COMPANY,QUANTITY,PRICE,) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(query);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(5, c.getCompany());            
            ps.setInt(3, c.getQuantity());
            ps.setInt(4, c.getPrice());
        
            if(ps.executeUpdate() > 0){
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Soda.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public boolean Delete(Object key){
        String query = "DELETE FROM SODA WHERE ID = ?";
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(query);
            ps.setString(1, key.toString());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Soda.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    
    
    public SodatDTO Read(Object key){
        SodatDTO p = null;
        String query = "SELECT * FROM SODA WHERE ID = ?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.getCnn().prepareStatement(query);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            while(rs.next()){
               p = new SodatDTO(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(3)), rs.getString(5));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(Soda.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return p;
    }
    
    public ArrayList<SodatDTO> ReadAll(){
        String query = "SELECT * FROM SODA";
        PreparedStatement ps;
        ArrayList<SodatDTO> soda = new ArrayList<SodatDTO>();
        ResultSet rs;
        try {
            ps = con.getCnn().prepareCall(query);
            rs = ps.executeQuery();
            while(rs.next()){
                soda.add(new SodatDTO(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)),Integer.parseInt(rs.getString(5)));
            }
            return soda;
        } catch (SQLException ex) {
            Logger.getLogger(Soda.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return soda;

    }
    public Soda() {
    }



    
}
