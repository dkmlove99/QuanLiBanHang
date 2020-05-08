/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Product;
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
public class ProductDAO extends DBContext {

    public ArrayList<Product> getProductDB() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "Select maHang,tenHang,giaNhap,giaBan,soLuong from HangHoa";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setIdHangHoa(rs.getInt("maHang"));
                p.setNameHangHoa(rs.getString("tenHang"));
                p.setGiaNhap(rs.getFloat("giaNhap"));
                p.setGiaBan(rs.getFloat("giaBan"));
                p.setSoLuong(rs.getInt("soLuong"));
                System.out.println(p.getIdHangHoa() + p.getNameHangHoa() + p.getGiaNhap() + p.getGiaBan() + p.getSoLuong());
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getProductID(int pid) {
        String sql = "Select maHang,tenHang,giaNhap,giaBan,soLuong from HangHoa where maHang='"+pid+"'";
        System.out.println("sql: "+sql);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("result: "+sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setIdHangHoa(rs.getInt("maHang"));
                p.setNameHangHoa(rs.getString("tenHang"));
                p.setGiaNhap(rs.getFloat("giaNhap"));
                p.setGiaBan(rs.getFloat("giaBan"));
                p.setSoLuong(rs.getInt("soLuong"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> getProductPaging(int pageindex, int pagesize) {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT maHang,tenHang,giaNhap,giaBan,soLuong FROM \n"
                + "        	(SELECT *,ROW_NUMBER() OVER (ORDER BY maHang ASC) as row_num FROM  HangHoa) tblHangHoa\n"
                + "        WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pageindex);
            ps.setInt(4, pagesize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setIdHangHoa(rs.getInt("maHang"));
                p.setNameHangHoa(rs.getString("tenHang"));
                p.setGiaNhap(rs.getFloat("giaNhap"));
                p.setGiaBan(rs.getFloat("giaBan"));
                p.setSoLuong(rs.getInt("soLuong"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public int count() {
        String sql = "SELECT COUNT(*) as rownum FROM HangHoa";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("rownum");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public ArrayList<Product> getProductByName(String name) {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "select * from HangHoa where tenHang like '%?%'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setIdHangHoa(rs.getInt("maHang"));
                p.setNameHangHoa(rs.getString("tenHang"));
                p.setGiaNhap(rs.getFloat("giaNhap"));
                p.setGiaBan(rs.getFloat("giaBan"));
                p.setSoLuong(rs.getInt("soLuong"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

}
