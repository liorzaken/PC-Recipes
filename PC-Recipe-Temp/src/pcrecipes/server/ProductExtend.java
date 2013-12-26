package pcrecipes.server;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import dbManager.DataBaseManager;
@PersistenceCapable
public class ProductExtend {
	@Persistent
	private Products _prod;
	@Persistent
	private String _amountUnit;



	public ProductExtend(String nameProd, String amountUnit) {
		_prod = new Products(nameProd);
		_amountUnit = amountUnit;
	}
	
	public Products get_prod() {
		return _prod;
	}

	public String get_amountUnit() {
		return _amountUnit;
	}

}
