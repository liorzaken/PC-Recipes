package pcrecipes.server;

public class recipes {
	
	public recipe recipeArr[] = new recipe[6];
	
	public recipes(){
		int i=0;
		for(i=0; i<recipeArr.length; i++){
			recipeArr[i]= new recipe (i,"");
		}
		recipeArr[0].set_name("עוף בלימון");
		recipeArr[0].set_product(new Products("לימון"));
		recipeArr[1].set_name("עוגת שוקולד");
		recipeArr[2].set_name("פשטידת פטריות");
		recipeArr[3].set_name("שעועית ירוקה");
		recipeArr[3].set_product(new Products("עגבניות", "רסק עגבניות"));
		recipeArr[4].set_name("עוגיות שוקולד צ'יפס");
	}
	public recipe searchByName(String name)
	{
		recipe newRecipe = new recipe (-1,""); //-1 is for temp recipe
		int i=0;
		for(i=0; i< recipeArr.length; i++)
		{
			if(name.equals(recipeArr[i].get_name()))
			{
				newRecipe.set_name( name);
				newRecipe.set_id(recipeArr[i].get_id());
				newRecipe.set_product(recipeArr[i].get_product());
				newRecipe.set_category(recipeArr[i].get_category());
				return newRecipe;
			}
		}		
		return null;
	}
}
