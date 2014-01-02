package pcrecipes.server;

public class Questions {
	
	private final static int MAX_ANSWERS = 101;
	private final static int NUM_OF_QUE = 18;
	private String _question;
	private int [] _answerID; // Array Of Answer`s ID
	

	
	public Questions(String questions, int ID0, int ID1, int ID2, int ID3, int ID4) {

		this._question = questions;
		this._answerID=new int[5];
		this._answerID[0] = ID0;
		this._answerID[1] = ID1;
		this._answerID[2] = ID2;
		this._answerID[3] = ID3;
		this._answerID[4] = ID4;
	}
	public Questions(){
		
	}

	public String getQuestion() {
		return _question;
	}

	public int[] getAnswerID() {
		return _answerID;
	}
	
	public Questions [] inputQuest(){
		Questions [] questionsArray=new Questions[NUM_OF_QUE];
		questionsArray[0] = new Questions("מהו סוג הבישול הרצוי?", 1,2,3,100,0);	
		questionsArray[1] = new Questions("איזה ארוחה תרצה להכין?", 4,5,6,100,0);
		questionsArray[2] = new Questions("איזה מנה תרצה להכין?", 7,8,9,100,0);
		questionsArray[3] = new Questions("בחר מהאפשרויות הבאות", 10,11,12,100,0);
		questionsArray[4] = new Questions("בחר דרגת קושי", 13,14,15,100,0);
		questionsArray[5] = new Questions("בחר סוג מטבח", 16,17,18,19,0);
		questionsArray[6] = new Questions("לאיזה אירוע אתה מבשל?", 21,22,23,100,0);
		questionsArray[7] = new Questions("לפי איזו עונה תרצה לבשל?", 24,25,26,27,0);
		questionsArray[8] = new Questions("בחר שיקול מיוחד לבשל לפיו", 20,28,30,100,0);
		questionsArray[9] = new Questions("בחר את משך זמן ההכנה", 31,32,33,100,0);
		questionsArray[10] = new Questions("מהו סוג התוספת שתרצה לארוחה?", 34,35,36,100,0);
		questionsArray[11] = new Questions("האם יש רגישות כלשהי?", 37,38,39,40,0);
		questionsArray[12] = new Questions("האם תרצה לבשל עם מצרכים לא כשרים?", 41,42,100,100,0);
		questionsArray[13] = new Questions("לכלול מתכונים הדורשים הכנה מראש(לילה לפני)?", 43,44,100,100,0);
		questionsArray[14] = new Questions("האם אתה מעוניין לבשל עם אלכוהול?", 45,46,47,100,0);
		questionsArray[15] = new Questions("על איזה בסיס תרצה שהארוחה תהיה?", 48,49,50,51,0);
		questionsArray[16] = new Questions(" מתכונים שמתאימים להכנה על ידי גילאי:", 52,53,54,55,0);
		questionsArray[17] = new Questions("", 37,38,39,40,0);
		return questionsArray;
	}
	
	public String[] inputAnswer(){
		
		String answersArray[]= new String[MAX_ANSWERS];
		answersArray[0] = "דלג שאלה";
		answersArray[1] = "אפייה";
		answersArray[2] = "טיגון";
		answersArray[3] = "בישול";
		answersArray[4] = "ארוחת בוקר";
		answersArray[5] = "ארוחת צהריים";
		answersArray[6] = "ארוחת ערב";
		answersArray[7] = "מנה ראשונה";
		answersArray[8] = "מנה עיקרית";
		answersArray[9] = "קינוח";
		answersArray[10] = "מנה בשרית";
		answersArray[11] = "מנה חלבית";
		answersArray[12] = "מנה פרווה";
		answersArray[13] = "קל";
		answersArray[14] = "בינוני";
		answersArray[15] = "קשה";
		answersArray[16] = "מטבח מזרחי";
		answersArray[17] = "מטבח איטלקי";
		answersArray[18] = "מטבח ארגנטינאי";
		answersArray[19] = "מטבח אסיאתי";
		answersArray[20] = "צמחונות";
		answersArray[21] = "יום רגיל";
		answersArray[22] = "יום שבת";
		answersArray[23] = "יום חג";
		answersArray[24] = "קיץ";
		answersArray[25] = "חורף";
		answersArray[26] = "סתיו";
		answersArray[27] = "אביב";
		answersArray[28] = "טבעונות";
		answersArray[29] = "בישול בריא";
		answersArray[30] = "מתאים לילדים";
		answersArray[31] = "פחות משעה";
		answersArray[32] = "בין שעה לשעתיים";
		answersArray[33] = "למעלה משעתיים";
		answersArray[34] = "מרקים";
		answersArray[35] = "סלטים";
		answersArray[36] = "קטניות";
		answersArray[37] = "רגישות ללקטוז";
		answersArray[38] = "רגישות לגלוטן";
		answersArray[39] = "רגישות לסוכר";
		answersArray[40] = "G6PD-רגישות ל";
		answersArray[41] = "רוצה"; // כן-רוצה לבשל עם מצרכים לא כשרים
		answersArray[42] = "לא רוצה"; // לא- לא רוצה לבשל עם מצרכים לא כשרים
		answersArray[43] = "דרוש הכנה מראש"; // כן - תכלול מתכונים הדורשים הכנה מראש
		answersArray[44] = "לא דרוש הכנה מראש"; // לא- אל תכלול מתכונים הדורשים הכנה מראש
		answersArray[45] = "רק עם יין";
		answersArray[46] = "עם כל סוגי האלכוהול";
		answersArray[47] = "לא מעוניין לבשל עם אלכוהול";
		answersArray[48] = "בסיס מתוק";
		answersArray[49] = "בסיס מלוח";
		answersArray[50] = "בסיס חריף";
		answersArray[51] = "בסיס חמוץ";
		answersArray[52] = "גן";
		answersArray[53] = "יסודי";
		answersArray[54] = "תיכון";
		answersArray[55] = "בוגר";
		answersArray[56] = "";
		answersArray[57] = "";
		answersArray[58] = "";
		answersArray[59] = "";
		answersArray[60] = "";
		answersArray[61] = "";
		answersArray[62] = "";
		answersArray[63] = "";
		answersArray[64] = "";
		answersArray[65] = "";
		answersArray[66] = "";
		answersArray[100] = ""; //empty question, must stay empty
		
		return answersArray;
	
	}
	@Override
	public String toString(){
		String str = "";
		str+=_question+",";
		
		for(int i=0; i<_answerID.length; i++)
			str+=_answerID[i]+",";
		return str;
		
	}

}
