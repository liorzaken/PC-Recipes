package pcrecipes.server;

import java.util.List;

import dbManager.DataBaseManager;

//import java_cup.production;


public class Search {

	static int IinsertProd=0;
	static int JinsertAnswer=0;
	final static int MAX_FILTER_PRODE=30;
	final static int MAX_FILTER_ANS=30;


	private String [] filterProd;
	private int [] filterAns;
	private String filterByName = "";

	public Search (){
		filterProd = new String[MAX_FILTER_PRODE];
		for(int i=0; i< filterProd.length; i++)
			filterProd[i]="";
		filterAns= new int[MAX_FILTER_ANS];
	}

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
			if(item!="")
				str+=item+", ";
		}
		return str;
	}

	public List<Recipe> SearchRecipes() {

		// TODO Auto-generated method stub
		return DataBaseManager.getInstance().getAllRecipes();
	}

	public void SetName(String name) {
		// TODO Auto-generated method stub
		filterByName = name;
	}
	public String[] getFilterProd() {
		return filterProd;
	}

	public int[] getFilterAns() {
		return filterAns;
	}

	public String getFilterByName() {
		return filterByName;
	}
}
