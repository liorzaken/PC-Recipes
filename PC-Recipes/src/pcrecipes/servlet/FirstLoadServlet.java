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
 * Servlet implementation class FirstLoadServlet
 */

public class FirstLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		List<Recipe> list;
		list = DataBaseManager.getInstance().getAllRecipes();
		String str="";
		if(!list.isEmpty()){
		//	Recipe[] resultList = new Recipe[list.size()];
			for(int i=0; i<list.size() ; i++){
				//Recipe.insertRecipe(item.get_nameRecipe());

				str+=list.get(i).get_nameRecipe()+",";
			}
			
		
			response.getWriter().write(str);
		}		
		else
			response.getWriter().write("0");

		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
