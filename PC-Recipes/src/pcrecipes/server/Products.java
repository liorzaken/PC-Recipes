package pcrecipes.server;
import java.util.Scanner;


public class Products {

	private String nameProd;
	private int idProd=0;
	private String swapProd;
	//public int i=0;
	
	
	/////////constructor without swap option
	public Products(String name){
		nameProd=name;
		idProd++;
		swapProd="not found";

	}
	/////////constructor with swap option
	public Products(String name, String swap){
		nameProd=name;
		idProd++;
		swapProd=swap;
	}


	public String getNaimProd()
	{
		return nameProd;
	}
	public void setNaameProd(String nameProd){
		this.nameProd=nameProd;
	}

	public int getIdProd()
	{
		return idProd;
	}
	public void setIdProd(int idProd){
		this.idProd=idProd;
	}

	public String getSwapProd()
	{
		return swapProd;
	}
	public void setSwapProd(String swapProd){
		this.swapProd=swapProd;
	}

	public String toString()
	{
		return (nameProd +"שם המוצר"+"\n" + idProd +"מספר סידורי"+"\n"+ swapProd+"תחליף" +"\n");
	}
}

