/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OrderDao;
import DTO.CartDTO;
import DTO.OrderDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class CheckoutController extends HttpServlet {

//    private static final String ERROR = "error.jsp";
//    private static final String SUCCESS = "checkout.jsp";

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
//	String url = ERROR;
//	try {
//	    OrderDao dao=new OrderDao();
//	    HttpSession session = request.getSession();
//	    UserDTO user=(UserDTO)session.getAttribute("LIST_USER");
//	    CartDTO cart=(CartDTO)session.getAttribute("CART");
//	    long milis = System.currentTimeMillis();
//	    java.sql.Date date = new Date(milis);
//	    int count=dao.getListOrder().size();
//	    int total=0;
//	    for(int i=0;i<cart.getCart().size();i++)
//	    String orderID=("OR"+(count+1));
//	    OrderDTO order=new OrderDTO(orderID, date, total, orderID);
//	    
//	} catch (Exception e) {
//	} finally {
//	    request.getRequestDispatcher(url).forward(request, response);
//	}
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
