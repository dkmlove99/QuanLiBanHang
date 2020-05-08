/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Customer;
import entity.Order;
import entity.OrderLine;
import entity.Product;
import java.sql.Date;
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
public class OrderDAO extends DBContext {

    public ArrayList<Order> getOderDB() {
        ArrayList<Order> orders = new ArrayList<>();

        String sql = "SELECT        HoaDonBan.idHDBan, HoaDonBan.ngayBan, KhachHang.tenKhach, HoaDonBan.tongTien\n"
                + "FROM            HoaDonBan INNER JOIN\n"
                + "                         KhachHang ON HoaDonBan.idKhach = KhachHang.idKhach";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("idHDBan"));
                o.setDate(rs.getDate("ngayBan"));
                Customer c = new Customer();
                c.setTenKhach(rs.getString("tenKhach"));
                o.setCustomer(c);
                o.setTotal(rs.getFloat("tongTien"));
                //  ol.setTotal(rs.getFloat("tongTien"));
                // System.out.println("total: "+ ol.getTotal());            
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public ArrayList<Order> getOrderByDateDB(Date date) {
        ArrayList<Order> orders = new ArrayList<>();
        
        String sql = "SELECT        HoaDonBan.idHDBan, HoaDonBan.ngayBan, KhachHang.tenKhach, HoaDonBan.tongTien\n"
                + "                FROM            HoaDonBan INNER JOIN\n"
                + "                                        KhachHang ON HoaDonBan.idKhach = KhachHang.idKhach\n"
                + "										where  HoaDonBan.ngayBan='" + date + "'";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("idHDBan"));
                o.setDate(rs.getDate("ngayBan"));
                Customer c = new Customer();
                c.setTenKhach(rs.getString("tenKhach"));
                o.setCustomer(c);
                o.setTotal(rs.getFloat("tongTien"));
                //  ol.setTotal(rs.getFloat("tongTien"));
                // System.out.println("total: "+ ol.getTotal());            
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public int count() {
        String sql = "SELECT COUNT(*) as rownum FROM ChiTietHoaDonBanHang";
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

    public OrderLine getOderByID(String id) {
        ArrayList<OrderLine> orders = new ArrayList<>();
        String sql = "SELECT        HoaDonBan.idHDBan, HangHoa.tenHang, ChiTietHoaDonBanHang.soLuong, ChiTietHoaDonBanHang.thanhTien, ChiTietHoaDonBanHang.giamGia\n"
                + "FROM            ChiTietHoaDonBanHang INNER JOIN\n"
                + "                         HangHoa ON ChiTietHoaDonBanHang.idHangHoa = HangHoa.maHang INNER JOIN\n"
                + "                         HoaDonBan ON ChiTietHoaDonBanHang.idHDBan = HoaDonBan.idHDBan \n"
                + "\n"
                + "						 where HoaDonBan.idHDBan = " + id + "";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OrderLine ol = new OrderLine();
                Order o = new Order();
                o.setId(rs.getInt("idHDBan"));
                ol.setOrder(o);
                Product p = new Product();
                p.setNameHangHoa(rs.getString("tenHang"));
                ol.setProduct(p);
                ol.setQuantity(rs.getInt("soLuong"));
                ol.setTotal(rs.getFloat("thanhTien"));
                ol.setDisscount(rs.getFloat("giamGia"));
                return ol;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<OrderLine> getOderLineByIdOder(String id) {
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        String sql = "SELECT    HangHoa.tenHang, ChiTietHoaDonBanHang.soLuong, ChiTietHoaDonBanHang.thanhTien, HoaDonBan.tongTien, ChiTietHoaDonBanHang.giamGia, KhachHang.tenKhach, HoaDonBan.ngayBan\n"
                + "FROM            ChiTietHoaDonBanHang INNER JOIN\n"
                + "                         HangHoa ON ChiTietHoaDonBanHang.idHangHoa = HangHoa.maHang INNER JOIN\n"
                + "                         HoaDonBan ON ChiTietHoaDonBanHang.idHDBan = HoaDonBan.idHDBan INNER JOIN\n"
                + "                         KhachHang ON HoaDonBan.idKhach = KhachHang.idKhach where  ChiTietHoaDonBanHang.idHDBan=" + id + "";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OrderLine o = new OrderLine();
                Product p = new Product();
                p.setNameHangHoa(rs.getString("tenHang"));
                o.setProduct(p);
                o.setQuantity(rs.getInt("soLuong"));
                o.setPrice(rs.getFloat("thanhTien"));

                Order or = new Order();
                or.setTotal(rs.getFloat("tongTien"));
                o.setOrder(or);
                o.setDisscount(rs.getFloat("giamGia"));
                Customer c = new Customer();
                c.setTenKhach(rs.getString("tenKhach"));
                or.setCustomer(c);
                or.setDate(rs.getDate("ngayBan"));
                o.setOrder(or);
                orderLines.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderLines;
    }

    public ArrayList<Order> searchOrder(String name, String sdt, Date dateT, Date dateF) {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = null;
        if (dateT != null && dateF != null) {
            sql = "  SELECT        HoaDonBan.idHDBan, HoaDonBan.ngayBan, KhachHang.tenKhach, HoaDonBan.tongTien\n"
                    + "                FROM            HoaDonBan INNER JOIN\n"
                    + "                                         KhachHang ON HoaDonBan.idKhach = KhachHang.idKhach "
                    + "where KhachHang.tenKhach like '%"+name+"%' and KhachHang.soDienThoai like'%"+sdt+"%' and ngayBan >= '"+dateT+"' and  ngayBan <= '"+dateF+"'";
        }else if(dateF != null && dateT==null){
            sql = "  SELECT        HoaDonBan.idHDBan, HoaDonBan.ngayBan, KhachHang.tenKhach, HoaDonBan.tongTien\n"
                    + "                FROM            HoaDonBan INNER JOIN\n"
                    + "                                         KhachHang ON HoaDonBan.idKhach = KhachHang.idKhach "
                    + "where KhachHang.tenKhach like '%"+name+"%' and KhachHang.soDienThoai like'%"+sdt+"%' and  ngayBan <= '"+dateF+"'";
        }else if(dateF == null && dateT!=null){
            sql = "  SELECT        HoaDonBan.idHDBan, HoaDonBan.ngayBan, KhachHang.tenKhach, HoaDonBan.tongTien\n"
                    + "                FROM            HoaDonBan INNER JOIN\n"
                    + "                                         KhachHang ON HoaDonBan.idKhach = KhachHang.idKhach "
                    + "where KhachHang.tenKhach like '%"+name+"%' and KhachHang.soDienThoai like'%"+sdt+"%' and ngayBan >= '"+dateT+"'";
        }else if(dateF == null && dateT==null){
            sql = "  SELECT        HoaDonBan.idHDBan, HoaDonBan.ngayBan, KhachHang.tenKhach, HoaDonBan.tongTien\n"
                    + "                FROM            HoaDonBan INNER JOIN\n"
                    + "                                         KhachHang ON HoaDonBan.idKhach = KhachHang.idKhach "
                    + "where KhachHang.tenKhach like '%"+name+"%' and KhachHang.soDienThoai like'%"+sdt+"%'";
        }
        System.out.println(sql);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("idHDBan"));
                o.setDate(rs.getDate("ngayBan"));
                Customer c = new Customer();
                c.setTenKhach(rs.getString("tenKhach"));
                o.setCustomer(c);
                o.setTotal(rs.getFloat("tongTien"));
                //  ol.setTotal(rs.getFloat("tongTien"));
                // System.out.println("total: "+ ol.getTotal());            
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
}
