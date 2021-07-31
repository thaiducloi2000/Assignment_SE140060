/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import DAO.UserDAO;
import DTO.ProductDTO;
import DTO.UserGoogole;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author PC
 */
@WebServlet("/login-google")
public class LoginGoogleController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SHOPPING = "shopping.jsp";
    private static final long serialVersionUID = 1L;

    public LoginGoogleController() {
	super();
    }
//    private static String GOOGLE_CLIENT_ID = "400202893725-rpls0kt99p5ldga613d67mcd1k02rlcr.apps.googleusercontent.com";
//    private static String GOOGLE_CLIENT_SECRET = "E5SO_PUl_Pm3G9yeR60WF-5F";
//    private static String GOOGLE_REDIRECT_URI = "http://localhost:8080/Assignment_SE140060/login-google";
//    private static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
//    private static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
//    private static String GOOGLE_GRANT_TYPE = "authorization_code";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//	    throws ServletException, IOException {
////	response.setContentType("text/html;charset=UTF-8");
////	String url = ERROR;
////	try {
//////	    String code = request.getParameter("code");
//////	    String exchangecode = Request.Post(url)
////	    ProductDAO dao = new ProductDAO();
////	    HttpSession session = request.getSession();
////	    List<ProductDTO> list = dao.getListAllProduct();
////	    if (list != null) {
////		session.setAttribute("LIST_PRODUCT", list);
////		url = SHOPPING;
////	    }
////	} catch (Exception e) {
////	} finally {
////	    request.getRequestDispatcher(url).forward(request, response);
////	}
//    }
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
//	processRequest(request, response);
	String code = request.getParameter("code");
	if (code == null || code.isEmpty()) {
	    RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
	    dis.forward(request, response);
	} else {
	    try {
		String accessToken = UserDAO.getToken(code);
		UserGoogole googlePojo = UserDAO.getUserInfo(accessToken);
//		request.setAttribute("id", googlePojo.getId());
//		request.setAttribute("name", googlePojo.getName());
		request.setAttribute("email", googlePojo.getEmail());
		
		HttpSession session= request.getSession();
		session.setAttribute("LIST_Google", googlePojo);
		ProductDAO pro = new ProductDAO();
		List<ProductDTO> list = pro.getListAllProduct();
		if (list != null) {
		    session.setAttribute("LIST_PRODUCT", list);
		}
		RequestDispatcher dis = request.getRequestDispatcher("shopping.jsp");
		dis.forward(request, response);
	    } catch (SQLException ex) {
		Logger.getLogger(LoginGoogleController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
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
	doGet(request, response);
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
