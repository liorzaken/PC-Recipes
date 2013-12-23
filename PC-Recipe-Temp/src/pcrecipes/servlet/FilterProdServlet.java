package pcrecipes.servlet;
//package pcrecipes.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbManager.DataBaseManager;
import pcrecipes.server.Products;
import pcrecipes.server.Recipe;
import pcrecipes.server.Recipes;
import pcrecipes.server.search;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Object Item = request.getParameter("addItem");
		
		
		if(Item.toString() !=null)
		{
			Products prode = DataBaseManager.getInstance().getProd(Item.toString());
			
			//if(prode!=null) 
				
			search p = new search();
			p.insertProd(prode.get_idProd());
			
		}
		
	}
}


