/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.controllers;

import asm.shopping.Item;
import asm.shopping.Order;
import asm.shopping.OrderDAO;
import asm.shopping.OrderDetail;
import asm.shopping.OrderDetailDAO;
import asm.shopping.ProductDAO;
import asm.shopping.ShoppingCart;
import asm.user.UserDAO;
import asm.user.UserDTO;
import asm.user.UserError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Suki
 */
public class PayCartController extends HttpServlet {

    private static final String ERROR = "payCart.jsp";
    private static final String SUCCESS = "paysuccess.jsp";
     private static final String IAC = "IACaccount.jsp";
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String totalMoney = request.getParameter("pricecart");
            String date = request.getParameter("date");
                UserDAO udao=new UserDAO();
                String statusUser =udao.getUserStatus(userID);
            if(statusUser.equals("AC")){
                OrderDAO dao = new OrderDAO();
                Order order = new Order(userID, email, address, phone, totalMoney, date);
                boolean checkInsert = dao.insertOrder(order);
                if (checkInsert) {
                    HttpSession session = request.getSession();
                    ShoppingCart cart = (ShoppingCart) session.getAttribute("CART");
                    int orderID = dao.getOrder(userID);
                    for (Item book : cart.getCart().values()) {

                        OrderDetailDAO orderdao = new OrderDetailDAO();
                        boolean orderdetail = orderdao.addOrderDetail(orderID, book);
                        if (orderdetail) {
                            String productID=book.getID();
                            int quantity = book.getQuantity();
                            int buynum = book.getBuyNum();
                            int newquantity = quantity - buynum;
                            ProductDAO pdao = new ProductDAO();
                            pdao.updateQuantity(productID, newquantity);
                        }
                        session.removeAttribute("CART");
                        url = SUCCESS;
                    }
                }
            }else{
                url=IAC;
            }
        } catch (Exception e) {
            log("Error at PayCartController: " + e.toString());
        } finally {
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
