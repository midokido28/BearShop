/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.shopping;

import asm.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Suki
 */
public class OrderDetailDAO {

    public boolean addOrderDetail(int orderID, Item book) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con=DBUtils.getConnection();
            if(con!=null){
                String sql=" INSERT INTO tblOrderDetail (orderID, productID, quantity, price) "
                        + " VALUES(?,?,?,?) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1,orderID );
                stm.setString(2,book.getID());
                stm.setInt(3,book.getBuyNum());
                stm.setFloat(4, book.getItemPrice() * book.getBuyNum());
                check = stm.executeUpdate()>0;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{       
            if(stm!=null) stm.close();
            if(con!=null) con.close();
        }
        return check;
    }

    
    

    
}
