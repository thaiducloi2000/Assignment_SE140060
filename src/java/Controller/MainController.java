/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainController extends HttpServlet {
//    private static final String SUCCESS="index.html";

    private static final String LOGIN = "LoginController";
    private static final String HOME = "login.jsp";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH = "SearchController";
    private static final String DELETE = "DeleteController";
    private static final String Update = "update.jsp";
    private static final String CONFIRM = "UpdateController";
    private static final String CREATE = "CreateController";
    private static final String ERROR = "error.jsp";
    private static final String ADD_CONTROLLER = "AddController";
    private static final String SEARCH_PRODUCT = "SearchProController";
    private static final String Delete_Product = "DeleteProController";
    private static final String Update_Cart = "UpdateCartController";
    private static final String View_Cart_CONTROLLER = "viewCart.jsp";
    private static final String ADD_MORE = "shopping.jsp";
//    private static final String BUY = "CheckoutController";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
		url = HOME;
	    } else if ("Login".equals(action)) {
		url = LOGIN;
	    } else if ("Logout".equals(action)) {
		url = LOGOUT;
	    } else if ("Search".equals(action)) {
		url = SEARCH;
	    } else if ("Delete".equals(action)) {
		url = DELETE;
	    } else if ("Update".equals(action)) {
		url = Update;
	    } else if ("Confirm".equals(action)) {
		url = CONFIRM;
	    } else if ("Create".equals(action)) {
		url = CREATE;
	    } else if ("Add".equals(action)) {
		url = ADD_CONTROLLER;
	    } else if ("search".equals(action)) {
		url = SEARCH_PRODUCT;
	    }
	    else if ("Delete Product".equals(action)) {
		url = Delete_Product;
	    }
	    else if ("Update Cart".equals(action)) {
		url = Update_Cart;
	    }else if ("View Cart".equals(action)) {
		url = View_Cart_CONTROLLER;
	    }
	    else if ("add_more".equals(action)) {
		url = ADD_MORE;
	    }
//	    else if ("buy".equals(action)) {
//		url = BUY;
//	    }
	} catch (Exception e) {
	    e.printStackTrace();
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
