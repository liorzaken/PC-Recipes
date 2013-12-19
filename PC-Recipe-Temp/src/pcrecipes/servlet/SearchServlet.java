package pcrecipes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.Recipe;
import pcrecipes.server.Recipes;

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
			Recipes newRecipes = new Recipes ();
			Recipe resultRecipe = newRecipes.searchByName(Item.toString());
			if(resultRecipe==null)
			{
				writer.write("<p>לא נמצא המתכון המבוקש</p>");
				writer.write("<p><a href="+"Main"+">לעמוד הראשי - PC-Recipes</a></p>");
			}
			else
			{	
				writer.write(resultRecipe.toString());
				writer.write("<p><a href="+"Main"+">לעמוד הראשי - PC-Recipes</a></p>");
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
