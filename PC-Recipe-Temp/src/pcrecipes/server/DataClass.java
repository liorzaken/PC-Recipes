package pcrecipes.server;
// Write Answer Array
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
		questionsArray[0] = new Questions("?��� ��� ������ �����", 1,2,3,-1,0);	
		questionsArray[1] = new Questions("?���� ����� ���� �����", 4,5,6,-1,0);
		questionsArray[2] = new Questions("?���� ��� ���� �����", 7,8,9,-1,0);
		questionsArray[3] = new Questions("��� ���������� �����", 10,11,12,-1,0);
		questionsArray[4] = new Questions("��� ���� ����", 13,14,15,-1,0);
		questionsArray[5] = new Questions("��� ��� ����", 16,17,18,19,0);
		questionsArray[6] = new Questions("?����� ����� ��� ����", 21,22,23,-1,0);
		questionsArray[7] = new Questions("?��� ���� ���� ���� ����", 24,25,26,27,0);
		questionsArray[8] = new Questions("��� ����� ����� ���� ����", 20,28,30,-1,0);
		questionsArray[9] = new Questions("��� �� ��� ��� �����", 31,32,33,-1,0);
		questionsArray[10] = new Questions("?��� ��� ������ ����� ������", 34,35,36,-1,0);
		questionsArray[11] = new Questions("?��� �� ������ �����", 37,38,39,40,0);
		questionsArray[12] = new Questions("?��� ���� ���� �� ������ �� �����", 41,42,-1,-1,0);
		questionsArray[13] = new Questions("?����� ������� ������� ���� ����(���� ����)", 43,44,-1,-1,0);
		questionsArray[14] = new Questions("?��� ��� ������� ���� �� �������", 45,46,47,-1,0);
		questionsArray[15] = new Questions("?�� ���� ���� ���� ������� ����", 48,49,50,51,0);
		questionsArray[16] = new Questions(" :������� �������� ����� �� ��� �����", 52,53,54,55,0);
		questionsArray[17] = new Questions("", 37,38,39,40,0);
//-----------------------------------------------------------------------------------

//--------------------------------Answers--------------------------------------------------
		
		answersArray[0] = "��� ����";
		answersArray[1] = "�����";
		answersArray[2] = "�����";
		answersArray[3] = "�����";
		answersArray[4] = "����� ����";
		answersArray[5] = "����� ������";
		answersArray[6] = "����� ���";
		answersArray[7] = "��� ������";
		answersArray[8] = "��� ������";
		answersArray[9] = "�����";
		answersArray[10] = "��� �����";
		answersArray[11] = "��� �����";
		answersArray[12] = "��� �����";
		answersArray[13] = "��";
		answersArray[14] = "������";
		answersArray[15] = "���";
		answersArray[16] = "���� �����";
		answersArray[17] = "���� ������";
		answersArray[18] = "���� ���������";
		answersArray[19] = "���� ������";
		answersArray[20] = "�������";
		answersArray[21] = "��� ����";
		answersArray[22] = "��� ���";
		answersArray[23] = "��� ��";
		answersArray[24] = "���";
		answersArray[25] = "����";
		answersArray[26] = "����";
		answersArray[27] = "����";
		answersArray[28] = "�������";
		answersArray[29] = "����� ����";
		answersArray[30] = "����� ������";
		answersArray[31] = "���� ����";
		answersArray[32] = "��� ��� �������";
		answersArray[33] = "����� �������";
		answersArray[34] = "�����";
		answersArray[35] = "�����";
		answersArray[36] = "������";
		answersArray[37] = "������ ������";
		answersArray[38] = "������ ������";
		answersArray[39] = "������ �����";
		answersArray[40] = "G6PD-������ �";
		answersArray[41] = "��"; // ��-���� ���� �� ������ �� �����
		answersArray[42] = "��"; // ��- �� ���� ���� �� ������ �� �����
		answersArray[43] = "��"; // �� - ����� ������� ������� ���� ����
		answersArray[44] = "��"; // ��- �� ����� ������� ������� ���� ����
		answersArray[45] = "�� �� ���";
		answersArray[46] = "�� �� ���� ��������";
		answersArray[47] = "�� ������� ���� �� �������";
		answersArray[48] = "���� ����";
		answersArray[49] = "���� ����";
		answersArray[50] = "���� ����";
		answersArray[51] = "���� ����";
		answersArray[52] = "��";
		answersArray[53] = "�����";
		answersArray[54] = "�����";
		answersArray[55] = "����";
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
