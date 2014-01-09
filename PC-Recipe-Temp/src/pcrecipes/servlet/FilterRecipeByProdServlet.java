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
 * Servlet implementation class FilterReciepeByProd
 */
public class FilterRecipeByProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterRecipeByProdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0 ,j=0, count=0;
		response.setContentType("text/html; charset=UTF-8");
		Object Item = request.getParameter("Prod");


		System.out.println(Item.toString());
		List<Recipe> list;
		list = DataBaseManager.getInstance().getAllRecipes();
		String str="";
		if(Item.toString() !=null)
		{
			String[] products = Item.toString().split(",");
			if(!list.isEmpty()){
				String[] listToReturn = new String[list.size()];
				for(Recipe item : list){
					for(i=0; i< item._products.length ; i++ ){
						for(int k = 0; k < products.length; k++){
							if (item._products[i].contains(products[k])){
								count++;
							}
						}
					}
					if(count==products.length){
						listToReturn[j]=item._nameRecipe;
						j++;
					}
					count=0;
					//response.getWriter().write(listToReturn);
					//break;
				}

				int x=0;

				for(x=0; x<listToReturn.length; x++){
					if(listToReturn[x]!=null)
						str+=listToReturn[x]+",";
				}
				response.getWriter().write(str);
			}
			else
				response.getWriter().write("0");
		}
		else{
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