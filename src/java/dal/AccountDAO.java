/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Account;
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
public class AccountDAO extends DBContext {

    public ArrayList<Account> getAccountDB() {

        ArrayList<Account> accounts = new ArrayList<>();
        String sql = "Select username,password from Account";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account l = new Account();
                l.setUsername(rs.getString("username"));
                l.setPassword(rs.getString("password"));
                accounts.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public Account getAccountByUsernameAndPassword(String username, String password) {
        ArrayList<Account> accounts = getAccountDB();
        Account ac = new Account();
        for(int i=0 ; i<accounts.size() ; i++){
        if (username.equals(accounts.get(i).getUsername()) && password.equals(accounts.get(i).getPassword())) {
            ac.setUsername(username);
            ac.setPassword(password);
            return ac;
        }
        }
        return null;
    }
}
