package dbManager;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import pcrecipes.server.Recipe;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
public final class DataBaseManager
{
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	PersistenceManager pm = PMF.get().getPersistenceManager();
	private DataBaseManager() {}
	private static DataBaseManager instance = null;
	public static DataBaseManager getInstance()
	{
		if (instance == null)
			instance = new DataBaseManager();
		return instance;
	}

	public void insertNewRecipe(Recipe r)
	{
		pm.makePersistent(r);
	}

	public List<Recipe> getRecipeByName(String nameRecipe)
	{
		System.out.println("getting Recipe " + nameRecipe);
		Query q = pm.newQuery(Recipe.class);
		q.setFilter("_nameRecipe==theNameRecipe");
		q.declareParameters("String theNameRecipe");
		return (List<Recipe>) q.execute(nameRecipe);
	}
	@SuppressWarnings("unchecked")
	public List<Recipe> getAllRecipes()
	{
		javax.jdo.Query q = pm.newQuery(Recipe.class);
		return (List<Recipe>)q.execute();
	}

	public boolean getProd(String nameProd) {
		System.out.println("getting Prod " + nameProd);
		List<Recipe> r = getAllRecipes();
		for(Recipe item: r){
			for(int i=0; i<item._products.length; i++){
				if(item._products[i].equals(nameProd)){
					return true;   
				}
			}
		}
		return false;
	}
}
