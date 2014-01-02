package pcrecipes.servlet;
//package pcrecipes.server;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbManager.DataBaseManager;

/**
 * Servlet implementation class FilterProdServlet
 */
//@WebServlet("/FilterProdServlet")////////למה זה עושה אדום ומה צריך להיות בתוך בסוגריים
public class FilterProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterProdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		Object Item = request.getParameter("value");

		if(Item.toString() !=null)
		{
			boolean bool=false;
			bool = DataBaseManager.getInstance().getProd(Item.toString());
			if(bool){
				response.getWriter().write("1");
			}
			else{
				response.getWriter().write("0");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}


