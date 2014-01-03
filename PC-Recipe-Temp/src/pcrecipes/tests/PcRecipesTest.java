package pcrecipes.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.appengine.api.datastore.Text;

import pcrecipes.server.Recipe;


public class PcRecipesTest {
	/*
	*This test will always succeed.
	*/
	@Test
	public void searchPassTest() {
		
	}
	
	/*
	*This test will always fail.
	*/
	/*@Test
	public void searchFailTest() {
		fail();
	}*/
	
	/*
	*This tests the creation of a new recipe.
	*/
	@Test
	public void recipeCreateTest() {
		int[] category = {23, 43, 10, 8, 16, 36};
		
		Recipe recipe = new Recipe("One", "first,second,third", "1,2,3", "fourth", category, new Text("gdrtjhrv t thge hggrhbdfbstdhbsrt bsr"));
		
		assertEquals(recipe.get_nameRecipe(), "One");
		assertArrayEquals(recipe.get_category(), category);
		assertEquals(recipe.get_swapProd(), "fourth");
		assertEquals(recipe.get_instruction(), new Text("gdrtjhrv t thge hggrhbdfbstdhbsrt bsr"));
	}
	
	/*
	*This test searches for all recipes.
	*/
	/*@Test
	public void searchTest() {
		HttpServletRequest request = mock(HttpServletRequest.class);       
	    HttpServletResponse response = mock(HttpServletResponse.class);
	    
		when(request.getParameter("value")).thenReturn("One");
		
		//search = new Search();
		//	add2Recipes();
		
		FilterProdServlet filterProdServlet = new FilterProdServlet();
		filterProdServlet.doGet(request, response);
		
		results = search.SearchRecipes();
		for(Recipe item : results){
			System.out.println(item.toString());
		}
		if(results.contains(recipe1)){
			isTrue = true;
		}
		else{
			isTrue = false;
		}
		if(isTrue){
			if(results.contains(recipe2)){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		if(isTrue){
				if(results.size() == 2){
					isTrue = true;
				}
				else{
					isTrue = false;
				}
		}
			 
		}
		assertTrue(isTrue);
		//	delete2Recipes();
	}*/
}
