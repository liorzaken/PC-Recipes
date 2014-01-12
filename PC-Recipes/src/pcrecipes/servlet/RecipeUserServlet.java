package pcrecipes.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.RecipeUser;

import com.google.appengine.api.datastore.Text;

import dbManager.DataBaseManager;

public class RecipeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeUserServlet() {
		super();
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
		Object nameR = request.getParameter("recipeName");
		Object productsR = request.getParameter("products");
		Object amountUnitR = request.getParameter("amountUnit");
		Object productsSwapR = request.getParameter("productSwap");
		Text InstructionR = new Text(request.getParameter("Instruction"));
//		System.out.println("the nameR is " + nameR.toString());
//		System.out.println("the productsR is " + productsR.toString());
//		System.out.println("the amountUnitR is " + amountUnitR.toString());
//		System.out.println("the productsSwapR is " + productsSwapR.toString());
//		System.out.println("the InstructionR is " + InstructionR.toString());
		if (nameR != null && productsR != null && amountUnitR!= null && productsSwapR != null && InstructionR != null)
		{
			RecipeUser r = new RecipeUser(nameR.toString(), productsR.toString(),amountUnitR.toString(), productsSwapR.toString(), InstructionR);
			DataBaseManager.getInstance().insertRecipeUser(r);
		}
		response.sendRedirect("AddRecipeUser");

	}
}
