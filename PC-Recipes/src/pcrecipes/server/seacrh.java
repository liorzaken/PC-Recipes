package pcrecipes.server;

public class seacrh extends recipes{

	public recipe searchByName(String name){
		recipe newRecipe = new recipe (-1,"");
		int i=0;
		for(i=0; i< recipeArr.length; i++){
			if(name.equals(recipeArr[i].get_name())){
				newRecipe.set_name( name);
				newRecipe.set_id( recipeArr[i].get_id());
				return newRecipe;
			}
		
		}		
		return null;
	}
}
