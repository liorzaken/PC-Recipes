package pcrecipes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntersectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IntersectionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0 ,j=0, k=0;
		response.setContentType("text/html; charset=UTF-8");
		Object prod = request.getParameter("prodVal");
		Object category = request.getParameter("catVal");
		Object name = request.getParameter("nameVal");
		String intersectionStr = "";
		
		System.out.println("prod: " +prod);
		System.out.println("category: " +category);
		System.out.println("name: " +name);
		if(name.toString().length()==0)
		{
			if(prod.toString().length()==0 && category.toString().length()==0)
			{
				System.out.println("all");
				response.getWriter().write("all");
				return;
			}
			else if(prod.toString().length()!=0 && category.toString().length()==0)
			{
				System.out.println("prod");
				response.getWriter().write("prod");
				return;
			}
			else if(prod.toString().length()==0 && category.toString().length()!=0)
			{
				System.out.println("category");
				response.getWriter().write("category");
				return;

			}
			else if(prod.toString().length()!=0 && category.toString().length()!=0)
			{
				String[] recipeProd = prod.toString().split(",");
				String[] recipeCategory = category.toString().split(",");
				intersectionStr = "";

				for(i=0; i < recipeCategory.length; i++){
					for(j=0; j < recipeProd.length; j++){
						if(recipeCategory[i].equals(recipeProd[j])){
							intersectionStr += recipeCategory[i]+",";
						}
					}
				}
				System.out.println("prod+category: "+intersectionStr);
				response.getWriter().write(intersectionStr);
				return;
			}
		}
		else if(name.toString().length()!=0){
			if(prod.toString().length()==0 && category.toString().length()==0)
			{
				System.out.println("name");
				response.getWriter().write("name");
				return;
			}
			else if(prod.toString().length()!=0 && category.toString().length()==0)
			{
				//Intersect name and products
				String[] recipeProd = prod.toString().split(",");
				String[] recipeByName = name.toString().split(",");
				intersectionStr = "";

				for(i=0; i < recipeByName.length; i++){
					for(j=0; j < recipeProd.length; j++){
						if(recipeByName[i].equals(recipeProd[j])){
							intersectionStr += recipeByName[i]+",";
						}
					}
				}
				System.out.println("name+prod: " + intersectionStr);
				response.getWriter().write(intersectionStr);
				return;
			}
			else if(prod.toString().length()==0 && category.toString().length()!=0)
			{
				//Intersect name and category
				String[] recipeCategory = category.toString().split(",");
				String[] recipeByName = name.toString().split(",");
				intersectionStr = "";

				for(i=0; i < recipeByName.length; i++){
					for(j=0; j < recipeCategory.length; j++){
						if(recipeByName[i].equals(recipeCategory[j])){
							intersectionStr += recipeByName[i]+",";
						}
					}
				}
				System.out.println("name+category: "+intersectionStr);
				response.getWriter().write(intersectionStr);
				return;

			}
			else if(prod.toString().length()!=0 && category.toString().length()!=0)
			{
				//intersect all arrays
				String[] recipeProd = prod.toString().split(",");
				String[] recipeCategory = category.toString().split(",");
				String[] recipeByName = name.toString().split(",");
				intersectionStr = "";

				for(i=0; i < recipeByName.length; i++){
					for(j=0; j < recipeProd.length; j++){
						for(k=0; k < recipeCategory.length; k++){
							if(recipeByName[i].equals(recipeCategory[k])  &&  recipeByName[i].equals(recipeProd[j])){
								intersectionStr += recipeByName[i]+",";
							}
						}
					}
				}
				System.out.println("together: "+intersectionStr);
				response.getWriter().write(intersectionStr);
				return;
			}
		}
		System.out.println("null");
		response.getWriter().write(intersectionStr);
		
	}

}
