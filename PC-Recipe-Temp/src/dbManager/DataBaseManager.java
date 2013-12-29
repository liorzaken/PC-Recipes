package dbManager;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
    
    public void deleteRecipe(Recipe r)
    {
    	pm.deletePersistent(r);
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

	public List<Products> getProd(String nameProd) {
    	System.out.println("getting Prod" + nameProd);
    	Query q = pm.newQuery(Products.class);
    	q.setFilter("_nameProd==theNameProd");
    	q.declareParameters("String theNameProd");
    	return (List<Products>)q.execute(nameProd);
	}
	

}
