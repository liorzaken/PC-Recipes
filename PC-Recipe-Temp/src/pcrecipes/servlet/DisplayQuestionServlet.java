package pcrecipes.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcrecipes.server.Questions;

public class DisplayQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayQuestionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Questions q = new Questions();
		Questions questionsArray[] = q.inputQuest();
		String[] arrayAnswer = q.inputAnswer();
		arrayAnswer = q.inputAnswer();
		Random r = new Random();
		int i = r.nextInt(17);
		String str = "";
		str+=questionsArray[i].getQuestion()+",";
		for ( int j=0; j<questionsArray[i].getAnswerID().length; j++){
			str+=arrayAnswer[questionsArray[i].getAnswerID()[j]]+",";
		}
		response.getWriter().write(str);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
