/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.shopping;

/**
 *
 * @author Suki
 */
public class Item {
    private String ID;
    private String Name;
    private Float ItemPrice;
    private int buyNum;
    private int quantity;
    private String image;

    public Item() {
    }

    public Item(String ID, String Name, Float ItemPrice, int buyNum, int quantity, String image) {
        this.ID = ID;
        this.Name = Name;
        this.ItemPrice = ItemPrice;
        this.buyNum = buyNum;
        this.quantity = quantity;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
 

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Float getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(Float ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

   
    
    
}
