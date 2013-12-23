package pcrecipes.server;
//v
public class Questions {
	
	private String question;
	private int [] answerID; // Array Of Answer`s ID
	
	public Questions(String questions, int ID0, int ID1, int ID2, int ID3, int ID4) {

		this.question = questions;
		this.answerID[0] = ID0;
		this.answerID[1] = ID1;
		this.answerID[2] = ID2;
		this.answerID[3] = ID3;
		this.answerID[4] = ID4;
	}

	public String getQuestion() {
		return question;
	}

	public int[] getAnswerID() {
		return answerID;
	}

}
