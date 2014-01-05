package pcrecipes.tests;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Text;

import pcrecipes.server.Recipe;

public class TestRepository implements RecipeRepo {
	private List<Recipe> list;
	
	
	public TestRepository()
	{
		list = new ArrayList<Recipe>();
		list.add(new Recipe("One", "first,second,third", "1,2,3", "fourth", new int[]{23, 43, 10, 8, 16, 36}, new Text("gdrtjhrv t thge hggrhbdfbstdhbsrt bsr")));
		list.add(new Recipe("One2", "first2,second2,third2", "12,22,32", "fourth2", new int[]{13, 33, 2, 18, 34, 52}, new Text("ftgjrfyjb y yjyj ygdrtjhrv t thge hggrhbdfbstdhbsrt bsr")));
	}
	
	@Override
	public List<Recipe> getAllRecipes() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Recipe> getRecipeByName(String name) {
		// TODO Auto-generated method stub
		List<Recipe> result = new ArrayList<Recipe>();
		for(Recipe recipe: list)
		{
			if(recipe.get_nameRecipe() == name)
			{
				result.add(recipe);
			}
		}
		return result;
	}
	
}
