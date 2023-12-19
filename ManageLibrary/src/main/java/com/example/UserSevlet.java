package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.models.thuthu;
import com.models.thuthuDB;

/**
 * Servlet implementation class UserSevlet
 */
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if (thuthuDB.isValidUser(email, pass) == true) {
            HttpSession session = request.getSession(true);
            session.setAttribute("email", email);
            session.setAttribute("pass", pass);
            RequestDispatcher rd = request.getRequestDispatcher("/seeinfors.jsp");
            rd.forward(request, response);
        } else {
        	HttpSession session = request.getSession(true);
            session.setAttribute("email", email);
        	RequestDispatcher rd = request.getRequestDispatcher("/logincheck.jsp");
            rd.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
