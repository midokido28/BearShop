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
public class OrderDAO {

    public boolean insertOrder(Order order) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = " INSERT INTO tblOrder (userID, email, address, phone, totalMoney, orderDate) "
                        + " VALUES(?,?,?,?,?,?) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, order.getUserID());
                stm.setString(2, order.getEmail());
                stm.setString(3, order.getAddress());
                stm.setString(4, order.getPhone());
                stm.setString(5, order.getTotalMoney());
                stm.setString(6, order.getOrderDate());
                check = stm.executeUpdate()>0;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public int getOrder(String userID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int orderID=0;
        try {
            con=DBUtils.getConnection();
            if(con!=null){
                String sql=" SELECT TOP 1 orderID "
                        + " FROM tblOrder WHERE userID=? ORDER BY orderID DESC ";
                stm=con.prepareStatement(sql);
                stm.setString(1, userID);
                rs=stm.executeQuery();
                if(rs.next()){
                orderID=rs.getInt("orderID");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null) rs.close();
            if(stm!=null) stm.close();
            if(con!=null) con.close();
        }
            
        
        
        
        return orderID;
    }

}
