/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;


/**
 *
 * @author Suki
 */
public class DBUtils {      
    public static Connection getConnection() throws NamingException, SQLException, ClassNotFoundException {
        Connection conn=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=BookManagement";
        conn = DriverManager.getConnection(url, "sa", "2801");
        return conn;
    }
}
