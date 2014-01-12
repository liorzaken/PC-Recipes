package pcrecipes.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.Recipe;
import dbManager.DataBaseManager;

public class FilterRecipeByProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilterRecipeByProdServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0 ,j=0, countMatchProd=0;
		response.setContentType("text/html; charset=UTF-8");
		Object prodObj = request.getParameter("Prod");
		
		List<Recipe> listRecipes;
		listRecipes = DataBaseManager.getInstance().getAllRecipes();
		String str="";
		if(prodObj.toString() != null)
		{
			String[] p = prodObj.toString().split(",");
			if(!listRecipes.isEmpty()){
				String[] matchRecipes = new String[listRecipes.size()*3];
				for(Recipe r : listRecipes)
				{			
					for(i=0; i < p.length ; i++ )
					{
						int found=0;
						for(int k = 0; k < r._products.length; k++)
						{
							if (r._products[k].contains(p[i])){
								countMatchProd++;
								found=1;
								break;
							}
						}
						if(found==0){
							if (r._swapProd.contains(p[i])){
								countMatchProd++;
							}
						}
						found=0;
						if(countMatchProd==p.length)
							break;
					}

					if(countMatchProd == p.length){
						matchRecipes[j] = r._nameRecipe;
						j++;
					}
					countMatchProd=0;
				}
		
				int x=0;

				for(x=0; x<matchRecipes.length; x++){
					if(matchRecipes[x]!=null)
						str+=matchRecipes[x]+",";
				}
				
				System.out.println("product: " +str);
				response.getWriter().write(str);
			}
			else
				response.getWriter().write("0");
		}
		else{
			response.getWriter().write("0");
		}
	}
}