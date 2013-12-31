package pcrecipes.servlet;
//package pcrecipes.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbManager.DataBaseManager;
import pcrecipes.server.Products;
import pcrecipes.server.Recipe;
import pcrecipes.server.Search;

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
			Search s = new Search();
			
			List<Products> list;
			list = DataBaseManager.getInstance().getProd(Item.toString());
			if(!list.isEmpty())
				for(Products item:list){
					s.insertProd(item.get_nameProd());
					response.getWriter().write(item.get_nameProd());
					break;
				}
			else{
				response.getWriter().write("0");
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}
}


