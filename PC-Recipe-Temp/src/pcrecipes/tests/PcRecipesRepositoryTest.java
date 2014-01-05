package pcrecipes.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import pcrecipes.server.Recipe;

public class PcRecipesRepositoryTest {

	@Test
	public void repositoryCanReturnAllRecipes() {
		RecipeRepo repo = new TestRepository();
		List<Recipe> result = repo.getAllRecipes();
		
		assertEquals(2, result.size());
	}

	@Test
	public void repositoryFilterByName() {
		RecipeRepo repo = new TestRepository();
		List<Recipe> result = repo.getRecipeByName("One");
		
		assertEquals("One", result.get(0).get_nameRecipe());
	}
}
