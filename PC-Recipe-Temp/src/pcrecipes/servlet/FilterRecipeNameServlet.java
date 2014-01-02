package pcrecipes.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.Recipe;
import dbManager.DataBaseManager;

/**
 * Servlet implementation class FilterRecipeNameServlet
 */
//@WebServlet("/FilterRecipeNameServlet")
public class FilterRecipeNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilterRecipeNameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		Object RecipeItem = request.getParameter("value");
		String str="";
		if(RecipeItem.toString() !=null)
		{
			List<Recipe> list;
			list = DataBaseManager.getInstance().getAllRecipes();
			
			if(!list.isEmpty()){
				Recipe[] resultList = new Recipe[list.size()];
				for(int i=0, j=0; i<list.size() ; i++){
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
