package pcrecipes.server;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Products {
	public int IDCount=0;
	@Persistent
	public String nameProd;
	@Persistent
	public int idProd;
	@Persistent
	public String swapProd;
	//public int i=0;
	
	
	/////////constructor without swap option
	public Products(String name){
		nameProd=name;
		idProd = IDCount;
		IDCount++;
		swapProd="not found";

	}
	/////////constructor with swap option
	public Products(String name, String swap){
		nameProd=name;
		idProd = IDCount;
		IDCount++;
		swapProd=swap;
	}


	public String getNameProd()
	{
		return nameProd;
	}
	public void setNameProd(String nameProd){
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

