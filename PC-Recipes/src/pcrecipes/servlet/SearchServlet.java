package pcrecipes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pcrecipes.server.recipe;
import pcrecipes.server.recipes;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer= response.getWriter();
		Object Item = request.getParameter("SearchItem");
		if(Item.toString() !=null)
		{
			recipes newRecipes = new recipes ();
			recipe resultRecipe = newRecipes.searchByName(Item.toString());
			if(resultRecipe==null)
			{
				writer.write("<p>לא נמצא המתכון המבוקש</p>");
				writer.write("<p><a href="+"Main"+">לעמוד הראשי - PC-Recipes</a></p>");
			}
			else
			{	
				writer.write("<p>Id: " + resultRecipe.get_id() + "</p>");
				writer.write("<p>שם המתכון: " + resultRecipe.get_name()  + "</p>");
				writer.write("<p>קטגוריה: " + resultRecipe.get_category()  + "</p>");
				if(resultRecipe.get_product()!=null){
					writer.write("<p>מצרכים: " + resultRecipe.get_product().getNaimProd()  + "</p>");
					writer.write("<p>מצרכים חלופיים: " + resultRecipe.get_product().getSwapProd()  + "</p>");
				}
				else{
					writer.write("<p>Products: </p>");
					writer.write("<p>Swap product: </p>");
				}
				writer.write("<p><a href="+"Main"+">לעמוד הראשי - PC-Recipes</a></p>");
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object name = request.getParameter("SearchItem");
		System.out.println("The Name Is:"+name.toString());
		response.sendRedirect("recipePage");
	}
}
