package pcrecipes.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Text;

@PersistenceCapable
public class Recipe {
//	private static int IDCount = 0;
//	@Persistent
//	private int _id;
	@Persistent
	public String _nameRecipe;
	@Persistent
	public String[] _products;
	@Persistent
	public String[] _unit;
//	public ProductExtend[] _products;	
	@Persistent
	public String _swapProd;
	@Persistent
	public int[] _category;
	@Persistent
	public Text _instruction;
/*
	public Recipe(String nameRecipe, 
			ProductExtend[] products, String swapProd, int[] category,
			String instruction) {

//		this._id = ++IDCount;
		this._nameRecipe = nameRecipe;
		this._products= new ProductExtend[products.length];
		for(int i=0; i<products.length; i++)
			this._products[i] = new ProductExtend(products[i]);
		this._swapProd = swapProd;
		this._category = category;
		this._instruction = instruction;
	}
*/	
	
	public Recipe(String nameRecipe, 
			String products,String unit, String swapProd, int[] category,
			Text instruction) {

//		this._id = ++IDCount;
		this._nameRecipe = nameRecipe;
		_products =products.split(",|\n");
		_unit =unit.split(",|\n");
		
		
		this._swapProd = swapProd;
		this._category = category;
		this._instruction = instruction;
	}
	
	

//	public static int getIDCount() { return IDCount; }
//	public int get_id() { return _id; }
	public String get_nameRecipe() { return _nameRecipe; }
//	public ProductExtend[] get_Products() { return _products; }
	public String get_swapProd() { return _swapProd; }
	public int[] get_category() { return _category; }
	public Text get_instruction() { return _instruction; }
/*
	public String prodString() {
		String temp = "";
		for (int i=0; i< _products.length; i++){
			temp+= "שם המתכון: " + _products[i].get_nameProd() +"\n";
			temp+= _products[i].get_amountUnit() + " ";
		}
		
		return temp;
	}
	*/
	/*
	@Override
	public String toString() {
		return "Recipe \n nameRecipe=" + _nameRecipe
				 + "\n products="
				+ prodString() + "\n swapProd=" + _swapProd
				+ "\n category=" + Arrays.toString(_category)
				+ "\n instruction=" + _instruction + "\n";
	}
	*/
	public String CategoryStr(){
		Questions q = new Questions();
		String[] a = q.inputAnswer();
		
		String str="";
		for (int i=0; i<_category.length-1; i++)
			str+=a[_category[i]]+", ";
		str+=a[_category[_category.length-1]];
		return str;
	}
	
	
}
