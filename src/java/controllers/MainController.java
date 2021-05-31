/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ProductDAO;
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
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SIGNUP_CONTROLLER = "SignupController";
    private static final String SIGUP_PAGE = "signup.jsp";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String LOAD_PRODUCT_DEFAULT = "ProductController";
    private static final String SEARCH_BY_CATE = "searchByCateServlet";
    private static final String SEARCH_BY_NAME = "searchByNameServlet";
    private static final String CHECK_QUANTITY_UNIT_PRODUCT = "checkQuantityUnitProductServlet";
    private static final String ADD_TO_CART = "addToCartServlet";
    private static final String DELETE_PRODUCT_FORM_CART = "deleProductFromCartServlet";
    private static final String UPDATE_QUANTITY_PRODUCT = "updateQuantityProductServlet";
    private static final String VIEW_CART_PAGE = "viewCart.jsp";
    private static final String PROCESS_TO_CHECKOUT = "processToCheckoutServlet";
    private static final String UPDATE_PRODUCT = "updateProductServlet";
    private static final String UPDATE_PRODUCT_PAGE = "update.jsp";
    private static final String REMOVE_PRODUCT = "removeProductServlet";
    private static final String ADD_PRODUCT = "addProductServlet";
    private static final String VIEW_HISTORY = "HistoryServlet";
    private static final String CHECK_DISCOUNT_CODE_CUSTOMER = "checkDiscountCodeCustomerServlet";
    private static final String CHECK_DISCOUNT_CODE_ADMIN = "checkDiscountCodeAdminServlet";
    private static final String CHECK_DISCOUNT = "checkDiscountServlet";
    private static final String CREATE_DISCOUNT_PAGE = "createDiscount.jsp";
    private static final String CREATE_DISCOUNT_SERVLET = "createNewDiscountServlet";

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
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOAD_PRODUCT_DEFAULT;
            } else if ("Login".equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if ("Signup".equals(action)) {
                url = SIGNUP_CONTROLLER;
            } else if ("Account".equals(action)) {
                url = SIGUP_PAGE;
            } else if ("Logout".equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if ("homePage".equals(action)) {
                url = LOAD_PRODUCT_DEFAULT;
            } else if ("searchByCate".equals(action)) {
                url = SEARCH_BY_CATE;
            } else if ("searchByName".equals(action)) {
                url = SEARCH_BY_NAME;
            } else if ("checkUnitQuantityProduct".equals(action)) {
                url = CHECK_QUANTITY_UNIT_PRODUCT;
            } else if ("addCart".equals(action)) {
                url = ADD_TO_CART;
            } else if ("deleteProductFormCart".equals(action)) {
                url = DELETE_PRODUCT_FORM_CART;
            } else if ("updateQuantityProduct".equals(action)) {
                url = UPDATE_QUANTITY_PRODUCT;
            } else if ("proceedToCheckout".equals(action)) {
                url = PROCESS_TO_CHECKOUT;
            } else if ("viewCartPage".equals(action)) {
                url = VIEW_CART_PAGE;
            } else if ("updateProductPage".equals(action)) {
                ProductDAO dao = new ProductDAO();
                request.setAttribute("PRODUCTDTO", dao.getProductByID(request.getParameter("proID")));
                url = UPDATE_PRODUCT_PAGE;
            } else if ("updateProduct".equals(action)) {
                url = UPDATE_PRODUCT;
            } else if ("removeProduct".equals(action)) {
                url = REMOVE_PRODUCT;
            } else if ("Add".equals(action)) {
                url = ADD_PRODUCT;
            } else if ("historyPage".equals(action)) {
                url = VIEW_HISTORY;
            } else if ("checkDiscountCodeCustomer".equals(action)) {
                url = CHECK_DISCOUNT_CODE_CUSTOMER;
            } else if ("checkDiscount".equals(action)) {
                url = CHECK_DISCOUNT;
            } else if ("createDiscountPage".equals(action)) {
                url = CREATE_DISCOUNT_PAGE;
            } else if ("createNewDiscount".equals(action)) {
                url = CREATE_DISCOUNT_SERVLET;
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.toString());
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
