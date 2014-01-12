package pcrecipes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pcrecipes.server.Message;
import dbManager.DataBaseManager;

public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddMessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object nameM = request.getParameter("nameM");
		Object mail = request.getParameter("e-mail");
		Object subjectM = request.getParameter("subjectM");
		Object textM = request.getParameter("textM");
//		System.out.println("the nameM is " + nameM.toString());
//		System.out.println("the e-mail is " + mail.toString());
//		System.out.println("the subjectM is " + subjectM.toString());
//		System.out.println("the textM is " + textM.toString());
		
		
		if (mail != null && textM!= null)
		{
			Message m = new Message(nameM.toString(), mail.toString(),subjectM.toString(), textM.toString());
			DataBaseManager.getInstance().insertNewMessage(m);
		}
		response.sendRedirect("ContactUs");
	}

}
