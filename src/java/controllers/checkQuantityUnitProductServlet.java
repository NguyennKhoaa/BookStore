/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import cart.CartObject;
import daos.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khoa Nguyễn
 */
@WebServlet(name = "checkQuantityUnitProductServlet", urlPatterns = {"/checkQuantityUnitProductServlet"})
public class checkQuantityUnitProductServlet extends HttpServlet {

    private static final String ADD_TO_CART = "addToCartServlet";
    private static final String UPDATE_QUANTITY_PRODUCT = "updateQuantityProductServlet";

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
        
        String actionPrimary = request.getParameter("actionPrimary");
        String proID = request.getParameter("proID");
        HttpSession session = request.getSession();
        String url = UPDATE_QUANTITY_PRODUCT;
        try {
            ProductDAO dao = new ProductDAO();
            CartObject cart = (CartObject) session.getAttribute("CART");
            int quantityDB = dao.getQuantityProductByID(proID);
            if ("addCart".equals(actionPrimary)) {
                url = ADD_TO_CART;
                if (cart != null) {
                    if (cart.getCartProduct().containsKey(proID.trim())) {                    
                        if (cart.getCartProduct().get(proID.trim()).getQuantity() >= quantityDB) {
                            request.setAttribute("OUT_OF_STOCK", "This ProductID: " + proID.trim() + " only has maximum of: " + quantityDB
                                    + ".Please add another product!!!");
                            request.setAttribute("productIDError", proID);
                        }
                    }
                }
            } else {
                int proQuantity = Integer.parseInt(request.getParameter("proQuantity"));
                if (cart != null) {
                    if (cart.getCartProduct().containsKey(proID.trim())) {
                        if (proQuantity > quantityDB) {
                            request.setAttribute("OUT_OF_STOCK", "This ProductID: " + proID.trim() + " only has maximum of: " + quantityDB);
                            request.setAttribute("productIDError", proID.trim());
                            if (quantityDB <= 0) {
                                request.setAttribute("OUT_OF_STOCK", "This ProductID: " + proID.trim() + " is out of stock. Please Remove this product.");
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            log("SQLEx at checkQuantityUnitProductServlet: " + ex.getMessage());
        } catch (NamingException ex) {
            log("NamingEx at checkQuantityUnitProductServlet: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
