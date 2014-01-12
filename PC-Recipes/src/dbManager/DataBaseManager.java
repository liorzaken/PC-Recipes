package dbManager;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import pcrecipes.server.Message;
import pcrecipes.server.Recipe;
import pcrecipes.server.RecipeUser;

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
	@SuppressWarnings("unchecked")
	public List<Recipe> getRecipeByName(String nameRecipe)
	{
//		System.out.println("getting Recipe " + nameRecipe);
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
	public String getProd(String nameProd) {
//		System.out.println("getting Prod " + nameProd);
		List<Recipe> r = getAllRecipes();
		String p[]=new String[r.size()*3];
		int j=0;
		for(Recipe item: r){
			for(int i=0; i<item._products.length; i++){
				if(item._products[i].contains(nameProd)){
					p[j]= item._products[i];  
					j++;
					break;
				}
			}
			if(item._swapProd.contains(nameProd)){
				
				p[j]= nameProd;  
				j++;
			}
		}
		if(p[0]==null)
			return null;
		String minLength = p[0];
		
		for(int i=1; i < j; i++){
			if(p[i].length() < minLength.length())
				minLength=p[i];
		}
		return minLength;
	}

	public void insertNewMessage(Message m) {
		pm.makePersistent(m);

	}

	public void insertRecipeUser(RecipeUser r) {
		pm.makePersistent(r);

	}
}
