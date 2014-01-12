package pcrecipes.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.Text;

import pcrecipes.server.Recipe;
import dbManager.DataBaseManager;

public class RecipeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeManager() {
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
		Object categoryR = request.getParameter("category");
		Object productsR = request.getParameter("products");
		Object amountUnitR = request.getParameter("amountUnit");
		Object productsSwapR = request.getParameter("productSwap");
		Text InstructionR = new Text(request.getParameter("Instruction"));
//		System.out.println("the nameR is " + nameR.toString());
//		System.out.println("the categoryR is " + categoryR.toString());
//		System.out.println("the productsR is " + productsR.toString());
//		System.out.println("the amountUnitR is " + amountUnitR.toString());
//		System.out.println("the productsSwapR is " + productsSwapR.toString());
//		System.out.println("the InstructionR is " + InstructionR.toString());
		if (nameR != null && categoryR != null && productsR != null && amountUnitR!= null && productsSwapR != null && InstructionR != null)
		{
			String [] categorystrR = categoryR.toString().split(",");
			for(int i=0; i<categorystrR.length; i++)
				categorystrR[i]=categorystrR[i].trim();
			int [] categoryInt = new int[categorystrR.length];
			for(int i=0; i<categoryInt.length; i++){
				categoryInt[i]= Integer.parseInt(categorystrR[i]);
			}
			Recipe r = new Recipe(nameR.toString(), productsR.toString(),amountUnitR.toString(), productsSwapR.toString(), categoryInt, InstructionR);
			
			HttpSession session = request.getSession();
			session.setAttribute("nameRecipe", nameR.toString());
			
			DataBaseManager.getInstance().insertNewRecipe(r);
		}
		response.sendRedirect("RecipePage");

	}
}
