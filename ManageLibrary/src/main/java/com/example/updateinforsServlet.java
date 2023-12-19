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

import com.models.muontra;
import com.models.muontraDB;
import com.models.thuthuDB;

/**
 * Servlet implementation class updateinforsServlet
 */
public class updateinforsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateinforsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idmuontra = Integer.parseInt(request.getParameter("mamuontra"));
		String masv = request.getParameter("masv");
		int masach = Integer.parseInt(request.getParameter("masach"));
		String trangthai="Chưa trả";
		
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngaymuon = currentDate.format(dateFormat);
        
        HttpSession session = request.getSession(false);
        if (session != null) {
		String email = (String)session.getAttribute("email");
		String mathuthu = thuthuDB.getMaThuthuByEmail(email);
		System.out.println(mathuthu);
		
		muontra muontra = new muontra(idmuontra, masv, masach, mathuthu, ngaymuon, trangthai);
        muontraDB.updateMuonTra(idmuontra, muontra);
        } else {
            
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/seeinfors.jsp");
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
