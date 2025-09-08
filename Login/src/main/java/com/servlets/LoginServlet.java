package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
Connection con = null;

		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		 HttpSession session=request.getSession();
		 RequestDispatcher dispatcher=null;
		
		String url = "jdbc:mysql://localhost:3306/industry";

		String un = "root";
		String pwd = "8118";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, un, pwd);
			PreparedStatement pstmt=con.prepareStatement("select * from employee where email=? and password=? ;");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet res=pstmt.executeQuery();
			if(res.next())
			{
				session.setAttribute("name", res.getString("name"));
				dispatcher=request.getRequestDispatcher("index.jsp");
				
			}
			else
			{
				request.setAttribute("status", "failed");
				dispatcher=request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
		}
		
		 catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		
		
		
		
	}

	

}
