/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Partner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class PartnerDAO extends DBContext{
    public ArrayList<Partner> getPartnerDB (){
        ArrayList<Partner> partners = new ArrayList<>();
        String sql = "Select idNCC, tenNcc,diaChi,dienThoai from NhaCungCap   ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Partner p = new Partner();
                p.setIdNCC(rs.getInt("idNCC"));
                p.setNameNCC(rs.getString("tenNcc"));
                p.setDiaChi(rs.getString("diaChi"));
                p.setSdt(rs.getInt("dienThoai"));
                partners.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PartnerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partners;
    }
        public Partner getPartnerId (int pID){
        ArrayList<Partner> partners = new ArrayList<>();
        String sql = "Select idNCC, tenNcc,diaChi,dienThoai from NhaCungCap  where idNCC=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pID);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Partner p = new Partner();
                
                p.setIdNCC(rs.getInt("idNCC"));
                p.setNameNCC(rs.getString("tenNcc"));
                p.setDiaChi(rs.getString("diaChi"));
                p.setSdt(rs.getInt("dienThoai"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PartnerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
