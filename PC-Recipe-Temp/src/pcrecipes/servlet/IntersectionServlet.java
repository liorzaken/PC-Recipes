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
 * Servlet implementation class IntersectionServlet
 */
public class IntersectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IntersectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0 ,j=0;
		response.setContentType("text/html; charset=UTF-8");
		Object prodVal1 = request.getParameter("prodVal");
		Object catVal1 = request.getParameter("catVal");
		if(prodVal1.toString().length()==0 && catVal1.toString().length()==0)
		{
			response.getWriter().write("1");
		}
		else	if(prodVal1.toString().length()!=0 && catVal1.toString().length()==0)
		{
			response.getWriter().write("2");
		}
		else	if(prodVal1.toString().length()==0 && catVal1.toString().length()!=0)
		{
			response.getWriter().write("3");
	
		}
		else	if(prodVal1.toString().length()!=0 && catVal1.toString().length()!=0)
		{
			String[] recipeProd = prodVal1.toString().split(",");
			String[] recipeCategory = catVal1.toString().split(",");
			String intersectionStr = "";
			
			for(i=0; i < recipeCategory.length; i++){
				for(j=0; j < recipeProd.length; j++){
					if(recipeCategory[i].equals(recipeProd[j])){
						intersectionStr += recipeCategory[i]+",";
					}
				}
			}
			response.getWriter().write(intersectionStr);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
