package pcrecipes.server;

//import java_cup.production;

 
public class search {
	
	static int IinsertProd=0;
	static int JinsertAnswer=0;
	final static int MAX_FILTER_PRODE=30;
	final static int MAX_FILTER_ANS=30;

	
	int [] filterProd = new int[MAX_FILTER_PRODE];
	int [] filterAns= new int[MAX_FILTER_ANS];
	
	
	public void insertProd(int id){
		filterProd[IinsertProd]=id;
		IinsertProd++;
	
	}
	
	public void insertAnswer(int id){
		filterAns[JinsertAnswer]=id;
		JinsertAnswer++;

     }
}
