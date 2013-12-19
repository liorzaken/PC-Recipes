package pcrecipes.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pcrecipes.server.Products;
import pcrecipes.server.Recipe;
import pcrecipes.server.ProductExtend;
import dbManager.DataBaseManager;

public class RecipeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object nameR = request.getParameter("recipeName");
		Object ansNumR = request.getParameter("ansNum");
		Object productsR = request.getParameter("products");
		Object amountUnitR = request.getParameter("amountUnit");
		Object productsSwapR = request.getParameter("productSwap");
		Object InstructionR = request.getParameter("Instruction");
		System.out.println("the nameR is " + nameR.toString());
		System.out.println("the ansNumR is " + ansNumR.toString());
		System.out.println("the productsR is " + productsR.toString());
		System.out.println("the amountUnitR is " + amountUnitR.toString());
		System.out.println("the productsSwapR is " + productsSwapR.toString());
		System.out.println("the InstructionR is " + InstructionR.toString());
		if (nameR != null && ansNumR != null && productsR != null && amountUnitR!= null && productsSwapR != null && InstructionR != null)
		{
			String [] ansStr = ansNumR.toString().split(",");
			int [] ansInt = new int[ansStr.length];
			for(int i=0; i<ansInt.length; i++){
				ansInt[i]= Integer.parseInt(ansStr[i]);
			}
			
			String[] productStr =productsR.toString().split(",|\n");
			String[] amountUnitStr =amountUnitR.toString().split(",|\n");
			ProductExtend [] p = new ProductExtend [productStr.length];
			for(int i= 0; i< p.length; i++){
				p[i] = new ProductExtend(productStr[i], amountUnitStr[i]);
			}
			
			Recipe r = new Recipe(nameR.toString(), p, productsSwapR.toString(), ansInt, InstructionR.toString());
			
			
			HttpSession session = request.getSession();
			session.setAttribute("recipeName", r.get_nameRecipe());
			
			DataBaseManager.getInstance().insertNewRecipe(r);
		}
		response.sendRedirect("RecipePage");

	}
}
