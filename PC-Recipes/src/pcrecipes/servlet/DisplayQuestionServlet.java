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
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Object Item = request.getParameter("str");
		String[] QFinish = new String[16];
		if(Item.toString() !=null)
			QFinish = Item.toString().split(",");

		Questions q = new Questions();
		Questions questionsArray[] = q.inputQuest();
		String[] arrayAnswer = q.inputAnswer();
		arrayAnswer = q.inputAnswer();
		Random r = new Random();
		int i=r.nextInt(16)+1;
		int count =0;
		for(int j=0; j<QFinish.length ; j++){
			if (Integer.parseInt(QFinish[j])==i){
				i=r.nextInt(16)+1;
				j=0;
				count++;
			}	
			if(count==17){
				break;
			}
		}
		if(count==17){
			response.getWriter().write("0");
			return;
		}
		

		String str = "";
		str+=questionsArray[i].getQuestion()+",";
		for ( int j=0; j<questionsArray[i].getAnswerID().length; j++){
			str+=arrayAnswer[questionsArray[i].getAnswerID()[j]]+",";
		}
		str+= i + ",";
		response.getWriter().write(str);
//		System.out.println(Item.toString());
	}

}
