package pcrecipes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.Products;
import pcrecipes.server.search;
import dbManager.DataBaseManager;

/**
 * Servlet implementation class FilterAnswerServlet
 */
//@WebServlet("/FilterAnswerServlet")
public class FilterAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterAnswerServlet() {
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
