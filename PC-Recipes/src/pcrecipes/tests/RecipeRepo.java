package pcrecipes.tests;

import java.util.List;

import pcrecipes.server.Recipe;

public interface RecipeRepo {

	List<Recipe> getAllRecipes();

	List<Recipe> getRecipeByName(String string);

}
