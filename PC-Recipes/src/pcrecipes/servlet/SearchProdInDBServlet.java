package pcrecipes.servlet;
//package pcrecipes.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbManager.DataBaseManager;

public class SearchProdInDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchProdInDBServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Object Item = request.getParameter("value");

		if(Item.toString() !=null)
		{
			String returnsProd="";
			returnsProd = DataBaseManager.getInstance().getProd(Item.toString());
			if(returnsProd!=null){
				response.getWriter().write(returnsProd);
			}
			else{
				response.getWriter().write("0");
			}
		}
	}
}


