/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Statistical;
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
public class StatisticalDAO extends DBContext {

    public ArrayList<Statistical> getStatisticalByDateDB(Date date) {
        ArrayList<Statistical> statisticals = new ArrayList<>();
        String sql = "SELECT        HoaDonBan.ngayBan, HangHoa.giaNhap, ChiTietHoaDonBanHang.thanhTien\n" +
"FROM            ChiTietHoaDonBanHang INNER JOIN\n" +
"                         HangHoa ON ChiTietHoaDonBanHang.idHangHoa = HangHoa.maHang INNER JOIN\n" +
"                         HoaDonBan ON ChiTietHoaDonBanHang.idHDBan = HoaDonBan.idHDBan \n" +
"						 where  HoaDonBan.ngayBan='"+date+"'";
        System.out.println("   :::"+sql);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Statistical s = new Statistical();
                s.setDate(rs.getDate("ngayBan"));
                s.setPriceIn(rs.getFloat("giaNhap"));
                s.setTotal(rs.getFloat("thanhTien"));
                statisticals.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statisticals;
    }
}
