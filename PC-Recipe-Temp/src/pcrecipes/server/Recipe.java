package pcrecipes.server;

import java.util.Arrays;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Recipe {
	private static int IDCount = 0;
	@Persistent
	private int _id;
	@Persistent
	private String _nameRecipe;
	@Persistent
	private ProductExtend[] _products;	
	@Persistent
	private String _swapProd;
	@Persistent
	private int[] _category;
	@Persistent
	private String _instruction;

	public Recipe(String nameRecipe, 
			ProductExtend[] products, String swapProd, int[] category,
			String instruction) {

		this._id = ++IDCount;
		this._nameRecipe = nameRecipe;
		this._products = products;
		this._swapProd = swapProd;
		this._category = category;
		this._instruction = instruction;
	}

	public static int getIDCount() { return IDCount; }
	public int get_id() { return _id; }
	public String get_nameRecipe() { return _nameRecipe; }
	public ProductExtend[] get_Products() { return _products; }
	public String get_swapProd() { return _swapProd; }
	public int[] get_category() { return _category; }
	public String get_instruction() { return _instruction; }

	public String prodString() {
		String temp = "";
		for (int i=0; i< _products.length; i++){
			temp+= "שם המתכון: " + _products[i].get_prod().get_nameProd() +"\n";
			temp+= _products[i].get_amountUnit() + " ";
		}
		
		return temp;
	}
	@Override
	public String toString() {
		return "Recipe \n id=" + _id + "\n nameRecipe=" + _nameRecipe
				 + "\n products="
				+ prodString() + "\n swapProd=" + _swapProd
				+ "\n category=" + Arrays.toString(_category)
				+ "\n instruction=" + _instruction + "\n";
	}
	public String CategoryStr(){
		String str="";
		for (int i=0; i<_category.length-1; i++)
			str+=_category[i]+", ";
		str+=_category[_category.length-1];
		return str;
	}
	
	
}
