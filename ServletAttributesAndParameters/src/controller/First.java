package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public First() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//Getting and displaying values of context and servlet int parameters to console.
		//ServletContext context = this.getServletContext();
		//System.out.println(context.getInitParameter("bestJavaInstitute"));
		ServletConfig config=this.getServletConfig();
		System.out.println(config.getInitParameter("url"));
		request.setAttribute("requestAttribute", "RequestAttribute");// setting attribute to request scope
		ServletContext sc = getServletContext();
		sc.setAttribute("contextAttribute", "ContextAttribute"); // setting attribute to context scope
		HttpSession session = request.getSession();
		session.setAttribute("sessionAttribute", "SessionAttribute");// setting attribute to session scope
		RequestDispatcher dispatcher = request.getRequestDispatcher("Second");
		dispatcher.forward(request, response);
	}

}
