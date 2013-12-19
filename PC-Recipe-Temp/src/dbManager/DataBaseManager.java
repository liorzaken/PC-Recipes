package dbManager;
import java.util.List;

import javax.jdo.PersistenceManager;

import pcrecipes.server.Products;
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
   
/*	public Recipe getRecipe(String recipeName)
    {
    	System.out.println("getting Recipe" + recipeName);
    	javax.jdo.Query q = pm.newQuery(Recipe.class);
    	q.setFilter("recipeName==theName");
    	q.declareParameters("String theName");
    	return (Recipe) q.execute(recipeName);
    }
    */
    @SuppressWarnings("unchecked")
	public List<Recipe> getRecipe(String recipeName)
    {
    	System.out.println("getting Recipe" + recipeName);
    	javax.jdo.Query q = pm.newQuery(Recipe.class);
    	q.setFilter("recipeName==theName");
    	q.declareParameters("String theName");
    	return (List<Recipe>) q.execute(recipeName);
    }
    @SuppressWarnings("unchecked")
	public List<Recipe> getAllRecipes()
    {
    	javax.jdo.Query q = pm.newQuery(Recipe.class);
    	return (List<Recipe>)q.execute();
    }

	public Products getProd(String nameProd) {
    	System.out.println("getting Prod" + nameProd);
    	javax.jdo.Query q = pm.newQuery(Products.class);
    	q.setFilter("nameProd==theName");
    	q.declareParameters("String theName");
    	return (Products)q.execute(nameProd);
	}

}
