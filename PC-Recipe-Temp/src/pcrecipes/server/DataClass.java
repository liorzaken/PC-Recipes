package pcrecipes.server;
// Write Answer Array v
public class DataClass 
{
	private final static int MAX_ANSWERS = 200;
	private final static int NUM_OF_QUE = 10;
	int [] answerIDArray = new int[MAX_ANSWERS];
	public static Questions questionsArray[] = new Questions[NUM_OF_QUE];
	private static String answersArray[]= new String[MAX_ANSWERS];

	public DataClass () // Constructor
	{
	}
	
	public static void main(String[] args) 
	{
//--------------------------------Questions---------------------------------------
		
		// 0 Is To Ignore The Question , And -1 Empty Answer		
		questionsArray[0] = new Questions("?מהו סוג הבישול הרצוי", 1,2,3,-1,0);	
		questionsArray[1] = new Questions("?איזה ארוחה תרצה להכין", 4,5,6,-1,0);
		questionsArray[2] = new Questions("?איזה מנה תרצה להכין", 7,8,9,-1,0);
		questionsArray[3] = new Questions("בחר מהאפשרויות הבאות", 10,11,12,-1,0);
		questionsArray[4] = new Questions("בחר דרגת קושי", 13,14,15,-1,0);
		questionsArray[5] = new Questions("בחר סוג מטבח", 16,17,18,19,0);
		questionsArray[6] = new Questions("?לאיזה אירוע אתה מבשל", 21,22,23,-1,0);
		questionsArray[7] = new Questions("?לפי איזו עונה תרצה לבשל", 24,25,26,27,0);
		questionsArray[8] = new Questions("בחר שיקול מיוחד לבשל לפיו", 20,28,30,-1,0);
		questionsArray[9] = new Questions("בחר את משך זמן ההכנה", 31,32,33,-1,0);
		questionsArray[10] = new Questions("?מהו סוג התוספת שתרצה לארוחה", 34,35,36,-1,0);
		questionsArray[11] = new Questions("?האם יש רגישות כלשהי", 37,38,39,40,0);
		questionsArray[12] = new Questions("?האם תרצה לבשל עם מצרכים לא כשרים", 41,42,-1,-1,0);
		questionsArray[13] = new Questions("?לכלול מתכונים הדורשים הכנה מראש(לילה לפני)", 43,44,-1,-1,0);
		questionsArray[14] = new Questions("?האם אתה מעוניין לבשל עם אלכוהול", 45,46,47,-1,0);
		questionsArray[15] = new Questions("?על איזה בסיס תרצה שהארוחה תהיה", 48,49,50,51,0);
		questionsArray[16] = new Questions(" :מתכונים שמתאימים להכנה על ידי גילאי", 52,53,54,55,0);
		
//-----------------------------------------------------------------------------------

//--------------------------------Answers--------------------------------------------------
		
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
		answersArray[41] = "כן"; // כן-רוצה לבשל עם מצרכים לא כשרים
		answersArray[42] = "לא"; // לא- לא רוצה לבשל עם מצרכים לא כשרים
		answersArray[43] = "כן"; // כן - תכלול מתכונים הדורשים הכנה מראש
		answersArray[44] = "לא"; // לא- אל תכלול מתכונים הדורשים הכנה מראש
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
		answersArray[67] = "";
		
//-----------------------------------------------------------------------------------

	}
}
