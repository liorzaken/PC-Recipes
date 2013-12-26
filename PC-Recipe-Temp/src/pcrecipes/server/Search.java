package pcrecipes.server;

//import java_cup.production;

 
public class Search {
	
	static int IinsertProd=0;
	static int JinsertAnswer=0;
	final static int MAX_FILTER_PRODE=30;
	final static int MAX_FILTER_ANS=30;

	
	String [] filterProd = new String[MAX_FILTER_PRODE];
	int [] filterAns= new int[MAX_FILTER_ANS];
	
	
	public void insertProd(String name){
		filterProd[IinsertProd]=name;
		IinsertProd++;
		System.out.println(ProdtoString());
	
	}
	
	public void insertAnswer(int id){
		filterAns[JinsertAnswer]=id;
		JinsertAnswer++;

     }
	public String ProdtoString(){
		String str = "";
		for(String item: filterProd){
			str+=item+", ";
		}
		return str;
	}
}
