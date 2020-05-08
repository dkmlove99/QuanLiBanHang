/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Employee;
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
public class EmployeeDAO  extends DBContext{
    public ArrayList<Employee> getEmployeeDB(){
         ArrayList<Employee> employees = new ArrayList<>();
         String sql = "Select idNhanVien, TenNhanVien,ngaySinh,gioiTinh,diaChi from NhanVien ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Employee e = new Employee();
                e.setIdNhanVien(rs.getInt("idNhanVien"));
                e.setNameNhanVien(rs.getString("TenNhanVien"));
                e.setNgaySinh(rs.getDate("ngaySinh"));
                e.setGioiTinh(rs.getString("gioiTinh"));
                e.setDiaChi(rs.getString("diaChi"));
                employees.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return employees;
    }
    
        public Employee getEmployeeID(int eID){
         ArrayList<Employee> employees = new ArrayList<>();
         String sql = "Select idNhanVien, TenNhanVien,ngaySinh,gioiTinh,diaChi from NhanVien where idNhanVien=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, eID);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Employee e = new Employee();
                e.setIdNhanVien(rs.getInt("idNhanVien"));
                e.setNameNhanVien(rs.getString("TenNhanVien"));
                e.setNgaySinh(rs.getDate("ngaySinh"));
                e.setGioiTinh(rs.getString("gioiTinh"));
                e.setDiaChi(rs.getString("diaChi"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
}
