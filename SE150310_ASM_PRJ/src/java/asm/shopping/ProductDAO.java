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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Suki
 */
public class ProductDAO {

    public List<Product> getProduct() throws SQLException, NamingException {
        List<Product> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " Select productID, productName, description, price, statusID, createDate, image "
                        + " FROM tblProduct ";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String createDate = rs.getString("createDate");
                    String image = rs.getString("image");
                    list.add(new Product(productID, productName, description, price, quantity, createDate, image));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Product> searchProduct(String search) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " Select productID, productName, description, price, quantity, createDate, image "
                        + " FROM tblProduct "
                        + " WHERE productName like ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String createDate = rs.getString("createDate");
                    String image = rs.getString("image");
                    list.add(new Product(productID, productName, description, price, quantity, createDate, image));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;

    }
    public boolean updateQuantity(String productID, int quantity) throws SQLException{
        boolean check=false;
        Connection con=null;
        PreparedStatement stm=null;
        try{
            con=DBUtils.getConnection();
            if(con!=null){
                String sql=" UPDATE tblProduct "
                        + " SET quantity=? "
                        + " WHERE productID=? ";
                        
                stm=con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, productID );
                check= stm.executeUpdate()>0;
            }
        } catch (Exception e){
        }finally{
            if(stm!=null) stm.close();
            if(con!=null) con.close();
        }
        
        
        return check;
    }
}
