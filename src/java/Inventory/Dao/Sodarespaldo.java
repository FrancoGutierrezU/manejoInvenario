/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Informatica
 */
public class Sodarespaldo {
    private int id;
    private String name;
    private String company;
    private int quantity;
    private int price;

    public Sodarespaldo(int id, String name, String company, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.quantity = quantity;
        this.price = price;
    }
    
    
    public Sodarespaldo() {
    }
    
    public ArrayList<Sodarespaldo> getSodas(){
        ArrayList<Sodarespaldo> output = new ArrayList<>();
        String query = "INSERT INTO PRODUCT(ID,NAME,COMPANY,QUANTITY,PRICE) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                output.add(new Sodarespaldo(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("company"), 
                        rs.getInt("quantity"), 
                        rs.getInt("price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sodarespaldo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

             
}
