package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.models.sach;
import com.models.sachDB;
import com.models.thuthuDB;

/**
 * Servlet implementation class updatebookServlet
 */
public class updatebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatebookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idsach = Integer.parseInt(request.getParameter("masach"));
		String tensach = request.getParameter("tensach");
		String slsachstring = request.getParameter("slsach");
		int slsach = Integer.parseInt(slsachstring);
		String theloai= request.getParameter("theloai");
		
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngaynhap = currentDate.format(dateFormat);
        
        HttpSession session = request.getSession(false);
        if (session != null) {
		String email = (String)session.getAttribute("email");
		String mathuthu = thuthuDB.getMaThuthuByEmail(email);
		System.out.println(email);
		
		sach sach = new sach(idsach, tensach, slsach, ngaynhap, mathuthu, theloai);
        sachDB.updateBookById(idsach, sach);
        } else {
            
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/seebooks.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
