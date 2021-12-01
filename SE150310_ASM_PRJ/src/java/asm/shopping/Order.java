/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.shopping;

import asm.user.UserDTO;
import java.util.List;

/**
 *
 * @author Suki
 */
public class Order {
    private String userID;    
    private String email;
    private String address;
    private String phone;
    private String totalMoney;
    private String orderDate;
    

    public Order() {
    }

    public Order( String userID, String email, String address, String phone, String totalMoney, String orderDate) {
        this.userID = userID;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.totalMoney = totalMoney;
        this.orderDate = orderDate;

    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
   
    
    
}
