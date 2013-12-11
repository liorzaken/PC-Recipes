package pcrecipes.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.Products;
import pcrecipes.server.Recipe;
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
		Object categoryR = request.getParameter("category");
		Object productsR = request.getParameter("products");
		Object productsSwapR = request.getParameter("productSwap");
		Object InstructionR = request.getParameter("Instruction");
		System.out.println("the nameR is " + nameR.toString());
		System.out.println("the categoryR is " + categoryR.toString());
		System.out.println("the productsR is " + productsR.toString());
		System.out.println("the productsSwapR is " + productsSwapR.toString());
		System.out.println("the InstructionR is " + InstructionR.toString());
		if (nameR != null && categoryR != null && productsR != null && productsSwapR != null && InstructionR != null)
		{
			Products p = new Products (productsR.toString(),productsSwapR.toString() );
			Recipe r = new Recipe(nameR.toString(), categoryR.toString(), p, InstructionR.toString());
			
			DataBaseManager.getInstance().insertNewRecipe(r);
		}
	}
}
