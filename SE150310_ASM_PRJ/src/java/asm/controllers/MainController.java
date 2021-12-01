/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.controllers;

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
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH = "SearchController";
    private static final String LOGOUT = "LogoutController";
    private static final String DELETE="DeleteController";
    private static final String CONFIRM_UPDATE="UpdateController";
    private static final String CREATE="CreateController";
    
    private static final String SEARCH_PRODUCT="SearchProductController";
    private static final String ADD_TO_CART="AddtoCartController";
    private static final String VIEW_CART="viewCart.jsp";
    private static final String REMOVE_CART="RemoveCartController";
    private static final String EDIT_CART="EditCartController";
    private static final String PAY_CART="payCart.jsp";
    private static final String PAY_ORDER="PayCartController";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)) {               //Login
                url = LOGIN;
            }else if("Search".equals(action)){          //Search Account
                url=SEARCH;
            }else if("Logout".equals(action)){          //Logout
                url=LOGOUT;
            }else if("Delete".equals(action)){          //Delete
                url=DELETE;
            }else if("Confirm Update".equals(action)){  //Confirm Update
                url=CONFIRM_UPDATE; 
            }else if("Create".equals(action)){          //Create account
                url=CREATE;              
            }else if("Search Product".equals(action)){  //Search Product
                url=SEARCH_PRODUCT;
            }else if("Add to Cart".equals(action)){ // Vào Control Cart
                url=ADD_TO_CART;
            }else if("View Cart".equals(action)){   //Vào trang cart
                url=VIEW_CART;
            }else if("Remove".equals(action)){       //Xóa Item trong cart
                url=REMOVE_CART;
            }else if("Edit".equals(action)){         //Edit Cart
                url=EDIT_CART;
            }else if("Pay".equals(action)){         //Vào trang thanh toán(payCart.jsp)
                url=PAY_CART;
            }else if("Pay Cart".equals(action)){         //Vào trang thanh toán(payCart.jsp)
                url=PAY_ORDER;
            }else {
                HttpSession session= request.getSession();
                session.setAttribute("ERROR_MESSAGE", "Funtion is not available");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
