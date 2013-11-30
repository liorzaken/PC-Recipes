package pcrecipes.server;

public class recipe {
	private int _id;
	private String _name;
	private Products _product;
	private String _category;

	public recipe (int id, String name){
		_id = id;
		_name = name;
		_product = null;
		_category = "";
	}
	public recipe (int id, String name,String category){
		_id = id;
		_name = name;
		_product = null;
		_category = category;
	}
	public recipe (int id, String name, Products product){
		_id = id;
		_name = name;
		_product = product;
		_category = "";
	}
	public recipe (int id, String name, String category, Products product){
		_id = id;
		_name = name;
		_product = product;
		_category = category;
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
	
	
}
