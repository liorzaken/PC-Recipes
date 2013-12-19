package pcrecipes.server;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Products {
	private static int IDCount=0;
	@Persistent
	private int _idProd;
	@Persistent
	private String _nameProd;


	public Products(String nameProd) {
		_idProd = ++IDCount;
		this._nameProd = nameProd;
	}

	public static int getIDCount() { return IDCount; }
	public int get_idProd() { return _idProd; }
	public String get_nameProd() { return _nameProd; }

	@Override
	public String toString() {
		return "Products: \n idProd=" + _idProd + "\n nameProd=" + _nameProd
				+ "\n";
	}
}