package pcrecipes.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Text;
@PersistenceCapable
public class RecipeUser {
	@Persistent
	public String _nameRecipe;
	@Persistent
	public String[] _products;
	@Persistent
	public String[] _unit;	
	@Persistent
	public String _swapProd;
	@Persistent
	public Text _instruction;
	
	
	public RecipeUser(String nameRecipe, String products, String unit,
			String swapProd, Text instruction) {
		this._nameRecipe = nameRecipe;
		_products =products.split(",");
		_unit =unit.split(",");
		for(int i=0; i<_products.length; i++)
			_products[i]=_products[i].trim();
		for(int i=0; i<_unit.length; i++)
			_unit[i]=_unit[i].trim();
		
		this._swapProd = swapProd;
		this._instruction = instruction;
	}

}
