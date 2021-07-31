/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DTO.UserDTO;
import DTO.UserError;
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
public class CreateController extends HttpServlet {

    private static final String SUCCESS = "login.jsp";
    private static final String ERROR = "register_Page.jsp";

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
	UserError error = new UserError("", "", "", "", "", "");
	try {
	    String userID = request.getParameter("userID");
	    String userName = request.getParameter("userName");
	    String password = request.getParameter("password");
	    String confirm = request.getParameter("confirm");
	    String address = request.getParameter("address");
	    String phone = request.getParameter("phone");
	    String gender = request.getParameter("sex");
//	    UserError error=new UserError("", "", "", "", "", "");
	    boolean flag = true;
	    if (userID.length() < 1 || userID.length() > 10) {
		flag = false;
		error.setUserIDError("User ID must be less than 10 digit and can not null !");
	    }
	    if (userName.length() < 1 || userName.length() > 30) {
		flag = false;
		error.setUserNameError("User Name must be less than 30 digit and can not null !");
	    }
	    if (!password.equals(confirm)) {
		flag = false;
		error.setPasswordError("Password confirm must be the same with password !");
	    }
	    if (address.length() < 2 || address.length() > 50) {
		flag = false;
		error.setAddressError("Address must be more than 2 digit and less than 50 !");
	    }
	    if (!phone.matches("[0-9]{10}")) {
		flag = false;
		error.setPhoneError("Phone Number must have 10 digit !");
	    }
	    if (!gender.matches("Male") && !gender.matches("Female")) {
		flag = false;
		error.setSexError("Gender Must be Male or Female");
	    }
	    if (flag) {
		UserDTO user = new UserDTO(userID, userName, password, address, phone, gender, "Ctm");
		UserDAO dao = new UserDAO();
		dao.Insert(user);
		url = SUCCESS;
	    } else {
		request.setAttribute("ERROR", error);
	    }
	} catch (Exception e) {
	    log("ERROR at CreateController : " + e.toString());
	    if (e.toString().contains("duplicate")) {
		error.setUserIDError("Duplicate !!!");
		request.setAttribute("ERROR", error);
	    }
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
