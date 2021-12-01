/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import asm.user.UserDAO;
import asm.user.UserDTO;
import asm.user.UserError;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author Suki
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private static final String ERROR = "SearchController";
    private static final String SUCCESS = "SearchController";
    private static final String LOGOUT = "LogoutController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String phone = request.getParameter("phone");
            String status = request.getParameter("statusID");

            boolean check = true;
            UserError userError = new UserError();

            if (fullName.length() > 50 || fullName.length() < 2) {
                userError.setFullNameError("fullName [2,50] !");
                check = false;
            }

            if (phone.length() > 11 || phone.length() < 8) {
                userError.setPhoneError("Phone [8,11] !");
                check = false;
            }
            if (check) {

                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, fullName, "", roleID, phone, status);
                boolean checkUpdate = dao.updateUser(user);
                if (checkUpdate) {
                    HttpSession session = request.getSession();
                    UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                    if (userID.equals(loginUser.getUserID())) {
                        url = LOGOUT;
                    } else {
                        url = SUCCESS;
                    }

                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
