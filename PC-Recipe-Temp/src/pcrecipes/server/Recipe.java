package pcrecipes.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Recipe {
	public int IDCount = 0;
	@Persistent
	public int _id;
	@Persistent
	public String _name;
	@Persistent
	public Products _product;
	@Persistent
	public String _category;
	@Persistent
	public String _instruction;
	
	public Recipe()
	{
		
	}
	public Recipe (String name){
		_id = IDCount;
		IDCount++;
		_name = name;
		_product = null;
		_category = "";
		_instruction = "";
	}
	public Recipe (String name, String category, Products product, String instruction){
		_id = IDCount;
		IDCount++;
		_name = name;
		Products p = new Products(product.getNameProd(), product.getSwapProd());
		_product = p;
		_category = category;
		_instruction = instruction;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int id) {
		this._id = id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String name) {
		this._name = name;
	}
	public Products get_product() {
		return _product;
	}
	public void set_product(Products product) {
		this._product = product;
	}
	public String get_category() {
		return _category;
	}
	public void set_category(String category) {
		this._category = category;
	}
	public String get_instruction() {
		return _instruction;
	}
	public void set_instruction(String instruction) {
		this._instruction = instruction;
	}
	
}
