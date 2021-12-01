/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Suki
 */
public class ShoppingCart {
    private Map<String, Item> cart;

    public ShoppingCart() {
    }

    public ShoppingCart(Map<String, Item> cart) {
        this.cart = cart;
    }

    public Map<String, Item> getCart() {
        return cart;
    }

    public void setCart(Map<String, Item> cart) {
        this.cart = cart;
    }
    public void add(Item book){
        if(this.cart==null){
            this.cart=new HashMap<>();
        }
        if(this.cart.containsKey(book.getID())){
            int currentBuyNum=this.cart.get(book.getID()).getBuyNum();
            book.setBuyNum(currentBuyNum +book.getBuyNum());
        }
        cart.put(book.getID(),book);
    }
    public void delete(String id){
        if(this.cart==null) return;
        if(this.cart.containsKey(id)) this.cart.remove(id);       
    }
    public void update(Item newBook){
        if(this.cart==null) return;
        if (this.cart.containsKey(newBook.getID())){
            this.cart.replace(newBook.getID(), newBook);
        }
    }
}
