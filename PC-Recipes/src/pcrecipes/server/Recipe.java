package pcrecipes.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Text;

@PersistenceCapable
public class Recipe {
	@Persistent
	public String _nameRecipe;
	@Persistent
	public String[] _products;
	@Persistent
	public String[] _unit;	
	@Persistent
	public String _swapProd;
	@Persistent
	public int[] _category;
	@Persistent
	public Text _instruction;

	
	public Recipe(String nameRecipe, 
			String products,String unit, String swapProd, int[] category,
			Text instruction) {

		this._nameRecipe = nameRecipe;
		_products =products.split(",");
		_unit =unit.split(",");
		
		for(int i=0; i<_products.length; i++)
			_products[i]=_products[i].trim();
		for(int i=0; i<_unit.length; i++)
			_unit[i]=_unit[i].trim();
		
		this._swapProd = swapProd;
		this._category = category;
		this._instruction = instruction;
	}
	
	public String get_nameRecipe() { return _nameRecipe; }
	public String get_swapProd() { return _swapProd; }
	public int[] get_category() { return _category; }
	public Text get_instruction() { return _instruction; }

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
