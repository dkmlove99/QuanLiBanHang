/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Employee;
import entity.Import;
import entity.ImportLine;
import entity.Partner;
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
public class ImportDAO extends DBContext {

    public ArrayList<Import> getImportDB() {
        ArrayList<Import> imports = new ArrayList<>();
        String sql = "SELECT        HoaDonNhapHang.idHDNhap, HoaDonNhapHang.ngayNhap, NhaCungCap.tenNcc, NhanVien.TenNhanVien, HoaDonNhapHang.totalMoney\n"
                + "FROM            HoaDonNhapHang INNER JOIN\n"
                + "                         NhaCungCap ON HoaDonNhapHang.idNCC = NhaCungCap.idNCC INNER JOIN\n"
                + "                         NhanVien ON HoaDonNhapHang.idNhanVien = NhanVien.idNhanVien";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Import i = new Import();
                i.setId(rs.getInt("idHDNhap"));
                i.setDate(rs.getDate("ngayNhap"));
                Partner p = new Partner();
                p.setNameNCC(rs.getString("tenNcc"));
                i.setPartners(p);
                Employee e = new Employee();
                e.setNameNhanVien(rs.getString("TenNhanVien"));
                i.setEmployees(e);
                i.setTotal(rs.getFloat("totalMoney"));
                imports.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return imports;
    }

    public ArrayList<ImportLine> getImportLineByIdDB(String id) {
        ArrayList<ImportLine> importLines = new ArrayList<>();
        String sql = "SELECT        HoaDonNhapHang.idHDNhap, HoaDonNhapHang.ngayNhap, NhanVien.TenNhanVien, HangHoa.tenHang, ChiTietHoaDonNhapHang.soLuong, ChiTietHoaDonNhapHang.donGia, ChiTietHoaDonNhapHang.thanhTien, \n"
                + "                         HoaDonNhapHang.totalMoney, NhaCungCap.tenNcc\n"
                + "FROM            ChiTietHoaDonNhapHang INNER JOIN\n"
                + "                         HangHoa ON ChiTietHoaDonNhapHang.idHangHoa = HangHoa.maHang INNER JOIN\n"
                + "                         HoaDonNhapHang ON ChiTietHoaDonNhapHang.idHDNhap = HoaDonNhapHang.idHDNhap INNER JOIN\n"
                + "                         NhaCungCap ON HoaDonNhapHang.idNCC = NhaCungCap.idNCC INNER JOIN\n"
                + "                         NhanVien ON HoaDonNhapHang.idNhanVien = NhanVien.idNhanVien \n"
                + "						 where HoaDonNhapHang.idHDNhap = " + id + "";
        System.out.println("import:  "+sql);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ImportLine i = new ImportLine();
                Import ip = new Import();
                ip.setId(rs.getInt("idHDNhap"));
                ip.setDate(rs.getDate("ngayNhap"));
                Employee e = new Employee();
                e.setNameNhanVien(rs.getString("TenNhanVien"));
                ip.setEmployees(e);
                i.setImports(ip);
                Product p = new Product();
                p.setNameHangHoa(rs.getString("tenHang"));
                i.setProducts(p);
                i.setQuantity(rs.getInt("soLuong"));
                i.setPrice(rs.getFloat("donGia"));
                i.setTotal(rs.getFloat("thanhTien"));
                ip.setTotal(rs.getFloat("totalMoney"));
                Partner pn = new Partner();
                pn.setNameNCC(rs.getString("tenNcc"));
                ip.setPartners(pn);
                i.setImports(ip);
                importLines.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return importLines;
    }

    public ArrayList<Import> searchImportDB(String name, String sdt, Date dateT, Date dateF,String nguoiNhap) {
        ArrayList<Import> imports = new ArrayList<>();
        String sql = null;
        if (dateT != null && dateF != null) {
            sql = "SELECT        HoaDonNhapHang.idHDNhap, HoaDonNhapHang.ngayNhap, NhaCungCap.tenNcc, NhanVien.TenNhanVien, HoaDonNhapHang.totalMoney\n"
                    + "FROM            HoaDonNhapHang INNER JOIN\n"
                    + "                         NhaCungCap ON HoaDonNhapHang.idNCC = NhaCungCap.idNCC INNER JOIN\n"
                    + "                         NhanVien ON HoaDonNhapHang.idNhanVien = NhanVien.idNhanVien \n"
                    + "			 where NhanVien.TenNhanVien like '%"+nguoiNhap+"%'  and NhaCungCap.tenNcc like '%" + name + "%' and NhaCungCap.dienThoai like'%" + sdt + "%' and ngayNhap >= '" + dateT + "' and  ngayNhap <= '" + dateF + "'";
        } else if (dateF != null && dateT == null) {
            sql = "SELECT        HoaDonNhapHang.idHDNhap, HoaDonNhapHang.ngayNhap, NhaCungCap.tenNcc, NhanVien.TenNhanVien, HoaDonNhapHang.totalMoney\n"
                    + "FROM            HoaDonNhapHang INNER JOIN\n"
                    + "                         NhaCungCap ON HoaDonNhapHang.idNCC = NhaCungCap.idNCC INNER JOIN\n"
                    + "                         NhanVien ON HoaDonNhapHang.idNhanVien = NhanVien.idNhanVien \n"
                    + "			 where NhanVien.TenNhanVien like '%"+nguoiNhap+"%'  and NhaCungCap.tenNcc like '%" + name + "%' and NhaCungCap.dienThoai like'%" + sdt + "%' and  ngayNhap <= '" + dateF + "'";
        } else if (dateF == null && dateT != null) {
            sql = "SELECT        HoaDonNhapHang.idHDNhap, HoaDonNhapHang.ngayNhap, NhaCungCap.tenNcc, NhanVien.TenNhanVien, HoaDonNhapHang.totalMoney\n"
                    + "FROM            HoaDonNhapHang INNER JOIN\n"
                    + "                         NhaCungCap ON HoaDonNhapHang.idNCC = NhaCungCap.idNCC INNER JOIN\n"
                    + "                         NhanVien ON HoaDonNhapHang.idNhanVien = NhanVien.idNhanVien \n"
                    + "			 where NhanVien.TenNhanVien like '%"+nguoiNhap+"%'  and NhaCungCap.tenNcc like '%" + name + "%' and NhaCungCap.dienThoai like'%" + sdt + "%' and ngayNhap >= '" + dateT + "'";
        } else if (dateF == null && dateT == null) {
            sql ="SELECT        HoaDonNhapHang.idHDNhap, HoaDonNhapHang.ngayNhap, NhaCungCap.tenNcc, NhanVien.TenNhanVien, HoaDonNhapHang.totalMoney\n"
                    + "FROM            HoaDonNhapHang INNER JOIN\n"
                    + "                         NhaCungCap ON HoaDonNhapHang.idNCC = NhaCungCap.idNCC INNER JOIN\n"
                    + "                         NhanVien ON HoaDonNhapHang.idNhanVien = NhanVien.idNhanVien \n"
                    + "			 where NhanVien.TenNhanVien like '%"+nguoiNhap+"%'  and NhaCungCap.tenNcc like '%" + name + "%' and NhaCungCap.dienThoai like'%" + sdt + "%'";
        }
        System.out.println(sql);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Import i = new Import();
                i.setId(rs.getInt("idHDNhap"));
                i.setDate(rs.getDate("ngayNhap"));
                Partner p = new Partner();
                p.setNameNCC(rs.getString("tenNcc"));
                i.setPartners(p);
                Employee e = new Employee();
                e.setNameNhanVien(rs.getString("TenNhanVien"));
                i.setEmployees(e);
                i.setTotal(rs.getFloat("totalMoney"));
                imports.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return imports;
    }
}
