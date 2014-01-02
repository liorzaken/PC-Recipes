package pcrecipes.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbManager.DataBaseManager;
import pcrecipes.server.Questions;
import pcrecipes.server.Recipe;

/**
 * Servlet implementation class FilterByCategoryServlet
 */
public class FilterByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilterByCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0 ,j=0, count=0;
		response.setContentType("text/html; charset=UTF-8");

		Object Item = request.getParameter("Category");

		Questions q = new Questions();
		Questions questionsArray[] = q.inputQuest();
		String[] arrayAnswer = q.inputAnswer();
		
		List<Recipe> list;
		list = DataBaseManager.getInstance().getAllRecipes();
		String str="";
		if(Item.toString() !=null)
		{
			String[] categorys = Item.toString().split(",");
			if(!list.isEmpty()){
				String[] listToReturn = new String[list.size()];
				for(Recipe item : list){
					String[] categorystr = new String[item._category.length];
					for(int g=0; g<categorystr.length; g++){
						categorystr[g] = arrayAnswer[item._category[g]];
					}
					for(i=0; i< categorystr.length ; i++ ){
						for(int k = 0; k < categorys.length; k++){
							if (categorystr[i].equals(categorys[k])){
								count++;
							}
						}
					}
					if(count==categorys.length){
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
