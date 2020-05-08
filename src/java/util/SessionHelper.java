/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Account;
import javax.servlet.http.HttpSession;


/**
 *
 * @author sonnt
 */
public class SessionHelper {
    public static void addAccountToSession(HttpSession session,Account account)
    {
        session.setAttribute("account", account);
    }
    
    public static Account getAccountFromSession(HttpSession session)
    {
        return (Account)session.getAttribute("account");
    }
}
