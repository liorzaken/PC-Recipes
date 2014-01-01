package pcrecipes.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.Recipe;
import pcrecipes.server.Search;
import dbManager.DataBaseManager;

/**
 * Servlet implementation class FilterRecipeNameServlet
 */
//@WebServlet("/FilterRecipeNameServlet")
public class FilterRecipeNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterRecipeNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		Object RecipeItem = request.getParameter("value");
		String str="";
		if(RecipeItem.toString() !=null)
		{
			//Search s = new Search();

			List<Recipe> list;
			list = DataBaseManager.getInstance().getAllRecipes();
			
			if(!list.isEmpty()){
				Recipe[] resultList = new Recipe[list.size()];
				for(int i=0, j=0; i<list.size() ; i++){
					//Recipe.insertRecipe(item.get_nameRecipe());

					if(list.get(i).get_nameRecipe().contains(RecipeItem.toString())){
						resultList[j]=list.get(i);
						j++;
					}
				}
				
				for(int i=0; i<resultList.length; i++){
					if(resultList[i]!=null)
					str+=resultList[i].get_nameRecipe()+",";
				}
				response.getWriter().write(str);
			}		
			else
				response.getWriter().write("0");

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
