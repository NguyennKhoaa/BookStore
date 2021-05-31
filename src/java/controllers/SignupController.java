/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.UserDAO;
import dtos.UserDTO;
import dtos.UserErrorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Khoa Nguyễn
 */
@WebServlet(name = "SignupController", urlPatterns = {"/SignupController"})
public class SignupController extends HttpServlet {
    private final String ERROR = "signup.jsp";
    private final String SUCCESS = "login.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR;
        boolean check = false;
        UserErrorDTO error = new UserErrorDTO("", "", "", "", "", "", "");
        try{
            String userID = request.getParameter("userID");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            
            if(userID.length() <3 || userID.length() > 10){
                check = true;
                error.setUserIDError("User ID must be in [3...10]!");
            }
            if(!name.matches("^[a-zA-Z ]+$")){
                check = true;
                error.setNameError("Full name can not be number.");
            }else if(name.length() < 2 || name.length() > 50){
                check = true;
                error.setNameError("Full name must be in [2...50]!");
            }
            if(address.length() <5 || address.length() > 200){
                check = true;
                error.setAddressError("Address must not exceed 200 characters");
            }
            if(phone.matches("^[a-zA-Z ]+$")){
                check = true;
                error.setNameError("Phone can not be letter.");
            } else if(!phone.matches("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$")){
                check = true;
                error.setPhoneError("Phone must be 10 characters");
            }
            if(!confirm.equals(password)){ 
                check = true;
                error.setConfirmError("Confirm not match!");
            }
            if(check){
                request.setAttribute("ERROR_USER", error);
            } else {
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, name, address, phone, "GU", password);
                dao.insert(user);
                url = SUCCESS;
            }
            
        } catch (Exception e) {
            if(e.toString().contains("duplicate")){
                error.setUserIDError("User ID is existed!");
                request.setAttribute("ERROR_USER", error);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
