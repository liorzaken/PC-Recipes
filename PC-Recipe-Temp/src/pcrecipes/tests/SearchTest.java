package pcrecipes.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pcrecipes.server.Recipe;
import pcrecipes.server.Search;
import dbManager.DataBaseManager;

public class SearchTest {

	private Search search;
	private Recipe recipe1, recipe2;
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
//		add2Recipes();
		
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
/*			if(isTrue){
				if(results.size() == 2){
					isTrue = true;
				}
				else{
					isTrue = false;
				}
		}
		*/
		}
		assertTrue(isTrue);
//		delete2Recipes();
	}
	
	/*	*
		*This test searches by the answers given.
		**/
/*	@Test
	public void searchByAnswerTest() {
		search = new Search();
		add2Recipes();
		
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
			if(results.size() == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
		//delete2Recipes();
	}
	*/
	/*	*
		*This test searches by the products given, and returns empty.
		**/
/*	@Test
	public void searchByProductEmptyTest() {
		search = new Search();
		add2Recipes();
		
		search.insertProd("Four");
		
		results = search.SearchRecipes();
				
		assertTrue(results.isEmpty());
	//	delete2Recipes();
	}
	*/
	/*	*
		*This test searches by the products given.
		**/
	/*
	@Test
	public void searchByProductTest() {
		search = new Search();
		add2Recipes();
		
		search.insertProd("Two");
		
		results = search.SearchRecipes();
		
		if(results.contains(recipe2)){
			isTrue = true;
		}
		else{
			isTrue = false;
		}
		if(isTrue){
			if(results.size() == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
	//	delete2Recipes();
	}
	*/
	/*	*
		*This test searches by products and answers given.
		**/
/*	@Test
	public void searchTest() {
		search = new Search();
		add2Recipes();
		
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
			if(results.size() == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
	//	delete2Recipes();
	}
	*/
	/*	*
		*This test searches by name given.
		**/
/*	@Test
	public void searchByNameTest() {
		search = new Search();
		add2Recipes();
		
		search.SetName("Fun");
		
		results = search.SearchRecipes();
		
		if(results.contains(recipe1)){
			isTrue = true;
		}
		else{
			isTrue = false;
		}
		if(isTrue){
			if(results.size() == 1){
				isTrue = true;
			}
			else{
				isTrue = false;
			}
		}
		
		assertTrue(isTrue);
	//	delete2Recipes();
	}
	*/
	public void add2Recipes (){
		String firstprods = "One,Two";
		String firstunit = "1,2";
		String scondprods = "Three";
		String secondunit = "3";
		int[] category1 = {9, 34, 21, 3, 43};
		int[] category2 = {49, 26, 12, 2, 31};
		recipe1 = new Recipe("Fun", firstprods, firstunit, "none",category1, "sfgnbgfb rgbrgt rthbrbdfgjrn nrhn renb gr sgn.");
		recipe2 = new Recipe("Long", scondprods, secondunit, "none",category2, "dfgn njyk wef ergiug fgeruvb erkgervbkrehgbiu ergiug.");
		
		DataBaseManager.getInstance().insertNewRecipe(recipe1);
		DataBaseManager.getInstance().insertNewRecipe(recipe2);
	}


}
