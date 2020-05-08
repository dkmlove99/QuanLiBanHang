/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Customer;
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
public class CustomerDAO extends DBContext {

    public ArrayList<Customer> getCustomerDB() {
        
        ArrayList<Customer> customers = new ArrayList<>();
        String sql ="select idKhach, tenKhach,diaChi,soDienThoai from KhachHang ";
        System.out.println("cus sql+ "+ sql);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Customer c = new Customer();
                c.setIdKhach(rs.getInt("idKhach"));
                System.out.println("id khach+ "+rs.getInt("idKhach"));
                c.setTenKhach(rs.getString("tenKhach"));
                c.setDiaChi(rs.getString("diaChi"));
                c.setSdt(rs.getInt("soDienThoai"));
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
    

    public Customer getCustomerDB(int id) {
        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "Select idKhach , tenKhach,diaChi,soDienThoai from KhachHang where idKhach=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setIdKhach(rs.getInt("idKhach"));
                c.setTenKhach(rs.getNString("tenKhach"));
                c.setDiaChi(rs.getNString("diaChi"));
                c.setSdt(rs.getInt("soDienThoai"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(String id, String name, String address, String phoneNumber) {
        String sql = "INSERT INTO KhachHang(idKhach,tenKhach,diaChi,soDienThoai) VALUES (" + id + ",'" + name + "', '" + address + "', " + phoneNumber + ")";
        System.out.println("insert :" + sql);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
