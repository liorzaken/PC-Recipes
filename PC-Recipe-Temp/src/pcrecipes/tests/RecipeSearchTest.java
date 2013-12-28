package pcrecipes.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import pcrecipes.server.Search;
import pcrecipes.server.ProductExtend;
import pcrecipes.server.Recipe;

import dbManager.DataBaseManager;

public class RecipeSearchTest {
	private Search search;
	private Recipe recipe1, recipe2;
	//private Products one, two, three;
	private ProductExtend first, second, third;
	//private List<Recipe> list;
	private List<Recipe> results;
	private Boolean isTrue;
	
	/*	*
		*This test will always succeed.
		**/
	@Test
	public void searchPassTest() {
	}
	
	/*	*
		*This test will always fail.
		**/
	/*@Test
	public void searchFailTest() {
		fail();
	}*/
	
	/*	*
		*This test searches for all recipes.
		**/
	@Test
	public void searchAllTest() {
		search = new Search();
		first = new ProductExtend("One", 1);
		second = new ProductExtend("Two", 2);
		third = new ProductExtend("Three", 3);
		ProductExtend[] prodList1 = {first, third};
		ProductExtend[] prodList2 = {second};
		int[] category1 = {9, 34, 21, 3, 43};
		int[] category2 = {49, 26, 12, 2, 31};
		recipe1 = new Recipe("Fun", prodList1, second.get_prod().get_nameProd(), category1, "sfgnbgfb rgbrgt rthbrbdfgjrn nrhn renb gr sgn.");
		recipe2 = new Recipe("Long", prodList2, first.get_prod().get_nameProd(), category2, "dfgn njyk wef ergiug fgeruvb erkgervbkrehgbiu ergiug.");
		
		DataBaseManager.getInstance().insertNewRecipe(recipe1);
		DataBaseManager.getInstance().insertNewRecipe(recipe2);
		
		results = search.SearchAllRecipes();
		
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
				if(results.size == 2){
					isTrue = true;
				}
				else{
					isTrue = false;
				}
		}
		}
		assertTrue(isTrue);
	}
	
	/*	*
		*This test searches by the answers given.
		**/
	@Test
	public void searchByAnswerTest() {
		search = new Search();
		first = new ProductExtend("One", 1);
		second = new ProductExtend("Two", 2);
		third = new ProductExtend("Three", 3);
		ProductExtend[] prodList1 = {first, third};
		ProductExtend[] prodList2 = {second};
		int[] category1 = {9, 34, 21, 3, 43};
		int[] category2 = {49, 26, 12, 2, 31};
		recipe1 = new Recipe("Fun", prodList1, second.get_prod().get_nameProd(), category1, "sfgnbgfb rgbrgt rthbrbdfgjrn nrhn renb gr sgn.");
		recipe2 = new Recipe("Long", prodList2, first.get_prod().get_nameProd(), category2, "dfgn njyk wef ergiug fgeruvb erkgervbkrehgbiu ergiug.");
		
		DataBaseManager.getInstance().insertNewRecipe(recipe1);
		DataBaseManager.getInstance().insertNewRecipe(recipe2);
		
		search.insertAnswer(9);
		search.insertAnswer(21);
		
		results = search.SearchRecipes();
		
		if(results.contains(recipe1)){
			isTrue = true;
		}
		else{
			isTrue = false;
		}
		if(isTrue){
			if(results.size == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
	}
	
	/*	*
		*This test searches by the products given, and returns empty.
		**/
	@Test
	public void searchByProductEmptyTest() {
		search = new Search();
		first = new ProductExtend("One", 1);
		second = new ProductExtend("Two", 2);
		third = new ProductExtend("Three", 3);
		ProductExtend[] prodList1 = {first, third};
		ProductExtend[] prodList2 = {second};
		int[] category1 = {9, 34, 21, 3, 43};
		int[] category2 = {49, 26, 12, 2, 31};
		recipe1 = new Recipe("Fun", prodList1, second.get_prod().get_nameProd(), category1, "sfgnbgfb rgbrgt rthbrbdfgjrn nrhn renb gr sgn.");
		recipe2 = new Recipe("Long", prodList2, first.get_prod().get_nameProd(), category2, "dfgn njyk wef ergiug fgeruvb erkgervbkrehgbiu ergiug.");
		
		DataBaseManager.getInstance().insertNewRecipe(recipe1);
		DataBaseManager.getInstance().insertNewRecipe(recipe2);
		
		search.insertProd("Four");
		
		results = search.SearchRecipes();
				
		assertTrue(results.isEmpty());
	}
	
	/*	*
		*This test searches by the products given.
		**/
	@Test
	public void searchByProductTest() {
		search = new Search();
		first = new ProductExtend("One", 1);
		second = new ProductExtend("Two", 2);
		third = new ProductExtend("Three", 3);
		ProductExtend[] prodList1 = {first, third};
		ProductExtend[] prodList2 = {second};
		int[] category1 = {9, 34, 21, 3, 43};
		int[] category2 = {49, 26, 12, 2, 31};
		recipe1 = new Recipe("Fun", prodList1, second.get_prod().get_nameProd(), category1, "sfgnbgfb rgbrgt rthbrbdfgjrn nrhn renb gr sgn.");
		recipe2 = new Recipe("Long", prodList2, first.get_prod().get_nameProd(), category2, "dfgn njyk wef ergiug fgeruvb erkgervbkrehgbiu ergiug.");
		
		DataBaseManager.getInstance().insertNewRecipe(recipe1);
		DataBaseManager.getInstance().insertNewRecipe(recipe2);
		
		search.insertProd("Two");
		
		results = search.SearchRecipes();
		
		if(results.contains(recipe2)){
			isTrue = true;
		}
		else{
			isTrue = false;
		}
		if(isTrue){
			if(results.size == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
	}
	
	/*	*
		*This test searches by products and answers given.
		**/
	@Test
	public void searchTest() {
		search = new Search();
		first = new ProductExtend("One", 1);
		second = new ProductExtend("Two", 2);
		third = new ProductExtend("Three", 3);
		ProductExtend[] prodList1 = {first, third};
		ProductExtend[] prodList2 = {second};
		int[] category1 = {9, 34, 21, 3, 43};
		int[] category2 = {49, 26, 12, 2, 31};
		recipe1 = new Recipe("Fun", prodList1, second.get_prod().get_nameProd(), category1, "sfgnbgfb rgbrgt rthbrbdfgjrn nrhn renb gr sgn.");
		recipe2 = new Recipe("Long", prodList2, first.get_prod().get_nameProd(), category2, "dfgn njyk wef ergiug fgeruvb erkgervbkrehgbiu ergiug.");
		
		DataBaseManager.getInstance().insertNewRecipe(recipe1);
		DataBaseManager.getInstance().insertNewRecipe(recipe2);
		
		search.insertProd("Two");
		search.insertAnswer(26);
		search.insertAnswer(2);
		
		results = search.SearchRecipes();
		
		if(results.contains(recipe2)){
			isTrue = true;
		}
		else{
			isTrue = false;
		}
		if(isTrue){
			if(results.size == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
	}
	
	/*	*
		*This test searches by name given.
		**/
	@Test
	public void searchByNameTest() {
		search = new Search();
		first = new ProductExtend("One", 1);
		second = new ProductExtend("Two", 2);
		third = new ProductExtend("Three", 3);
		ProductExtend[] prodList1 = {first, third};
		ProductExtend[] prodList2 = {second};
		int[] category1 = {9, 34, 21, 3, 43};
		int[] category2 = {49, 26, 12, 2, 31};
		recipe1 = new Recipe("Fun", prodList1, second.get_prod().get_nameProd(), category1, "sfgnbgfb rgbrgt rthbrbdfgjrn nrhn renb gr sgn.");
		recipe2 = new Recipe("Long", prodList2, first.get_prod().get_nameProd(), category2, "dfgn njyk wef ergiug fgeruvb erkgervbkrehgbiu ergiug.");
		
		DataBaseManager.getInstance().insertNewRecipe(recipe1);
		DataBaseManager.getInstance().insertNewRecipe(recipe2);
		
		search.insertName("Fun");
		
		results = search.SearchRecipes();
		
		if(results.contains(recipe1)){
			isTrue = true;
		}
		else{
			isTrue = false;
		}
		if(isTrue){
			if(results.size == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
	}
}