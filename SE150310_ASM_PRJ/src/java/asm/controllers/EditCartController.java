/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.controllers;

import asm.shopping.Item;
import asm.shopping.Product;
import asm.shopping.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Suki
 */
public class EditCartController extends HttpServlet {
    private static final String ERROR="error.jsp";
    private static final String SUCCESS="viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            String id=request.getParameter("itemid");
            int newBuyNum=Integer.parseInt(request.getParameter("buynum"));
            HttpSession session= request.getSession();
            ShoppingCart cart=(ShoppingCart) session.getAttribute("CART");
            Item book=null;
            if(cart!=null){
                for(Item dto: cart.getCart().values()){
                    if(dto.getID().equals(id)){
                        String name=dto.getName();
                        float price=dto.getItemPrice();
                        int quantity=dto.getQuantity();
                        String image=dto.getImage();
                        book=new Item(id, name, price, newBuyNum, quantity,image);
                        break;
                    }
                }
                cart.update(book);
                session.setAttribute("CART", cart);
                url=SUCCESS;
            }
     
            
            
        } catch (Exception e) {
            log("Error at EditCartController: " + e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
