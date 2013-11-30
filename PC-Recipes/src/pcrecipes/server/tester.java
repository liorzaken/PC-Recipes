package pcrecipes.server;

public class tester{
	public static void main(String[] args) {
		recipes newRecipes = new recipes ();
		recipe resultRecipe = newRecipes.searchByName("שעועית ירוקה");
		if(resultRecipe==null)
			System.out.println("לא נמצא המתכון המבוקש");
		else{
			System.out.println("Id: " + resultRecipe.get_id());
			System.out.println("Name: " + resultRecipe.get_name());
			System.out.println("Category: " + resultRecipe.get_category());
			System.out.println("Products: " + resultRecipe.get_product().getNaimProd());
			System.out.println("Swap product: " + resultRecipe.get_product().getSwapProd());
		}
	}
}
