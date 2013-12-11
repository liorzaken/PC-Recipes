package dbManager;
import java.util.List;

import javax.jdo.PersistenceManager;

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
    @SuppressWarnings("unchecked")
	public List<Recipe> getRecipe(String name)
    {
    	System.out.println("getting Recipe" + name);
    	javax.jdo.Query q = pm.newQuery(Recipe.class);
    	q.setFilter("name==theName");
    	q.declareParameters("String theName");
    	return (List<Recipe>)q.execute(name);
    }
    @SuppressWarnings("unchecked")
	public List<Recipe> getAllRecipes()
    {
    	javax.jdo.Query q = pm.newQuery(Recipe.class);
    	return (List<Recipe>)q.execute();
    }

}
