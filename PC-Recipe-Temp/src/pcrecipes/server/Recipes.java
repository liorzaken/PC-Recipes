package pcrecipes.server;

public class Recipes {
	
	public Recipe recipeArr[] = new Recipe[4];
	
	public Recipes(){
/*		int i=0;
		for(i=0; i<recipeArr.length; i++){
			recipeArr[i]= new Recipe ("");
		}
		recipeArr[0].set_name("עוף בלימון");
		recipeArr[0].set_product(new Products("לימון"));
		recipeArr[1].set_name("עוגת שוקולד");
		recipeArr[2].set_name("פשטידת פטריות");
		recipeArr[3].set_name("שעועית ירוקה");
		recipeArr[3].set_product(new Products("עגבניות", "רסק עגבניות"));
		recipeArr[4].set_name("עוגיות שוקולד צ'יפס");
*/	
		int[] tempcategory0 = {1, 12, 7};
		Products temp01 = new Products("חזה עוף", "קילו", 1);
		Products temp02 = new Products("לימון", "יחידות", 2);
		Products [] tempProd0 = {temp01, temp02};
		recipeArr[0] = new Recipe("עוף בלימון", 0, tempProd0, "ניתן להחליף את חזה העוף בכרעיים", 
				tempcategory0 , "1. לחתוך את העוף לקוביות\n 2. לערבב הכל יחד\n 3. לשים בתנור לשעה\n");
		
		int[] tempcategory1 = {3, 10, 6};
		Products temp11 = new Products("קמח", "כוסות", 3);
		Products temp12 = new Products("ביצים", "יחידות", 2);
		Products temp13 = new Products("סוכר", "כוסות", 1.5);
		Products [] tempProd1 = {temp11, temp12, temp13};
		recipeArr[1] = new Recipe("עוגת שוקולד", 1, tempProd1, "ניתן להשתמש בסוכר חום במקום סוכר לבן", 
				tempcategory1 , "1. לשים את כל המצרכים בקערה גדולה\n 2. לערבב במיקסר הכל יחד\n 3. לשים בתבנית ובתנור לשעה\n");
		
		int[] tempcategory2 = {0, 4, 18};
		Products temp21 = new Products("שעועית ירוקה", "קילו", 0.8);
		Products temp22 = new Products("רסק עגבניות", "קופסאות", 2);
		Products temp23 = new Products("בצל", "יחידות", 1);
		Products [] tempProd2 = {temp21, temp22, temp23};
		recipeArr[2] = new Recipe("שעועית ירוקה", 2, tempProd2, "ניתן להשתמש בשעועית צהובה", 
				tempcategory2 , "1. לקצוץ את הבצל ולטגן עד הזהבה\n 2. להוסיף את השעועית ולטגן דקה-שתיים\n 3. להוסיף רסק עגבניות וטגן תוך כדי ערבוב עוד מספר דקות\n");
		
		int[] tempcategory3 = {2, 3, 6};
		Products temp31 = new Products("תפוח אדמה", "יחידות", 5);
		Products temp32 = new Products("בצל", "יחידות", 1);
		Products temp33 = new Products("שמן זית", "כפות", 3);
		Products temp34 = new Products("מלח", "כפית", 1);
		Products [] tempProd3 = {temp31, temp32, temp33, temp34};
		recipeArr[3] = new Recipe("תפוחי אדמה בתנור", 3, tempProd3, "", 
				tempcategory3 , "1. לחתוך את תפוחי האדמה והבצל לקוביות\n 2.  לערבב הכל יחד עם השמן והמלח\n 3. לשים בתבנית ובתנור לשעה ורבע\n");
	}

	public Recipe searchByName(String name)
	{
		Recipe newRecipe;
		int i=0;
		for(i=0; i< recipeArr.length; i++)
		{
			if(name.equals(recipeArr[i].get_nameRecipe()))
			{
				newRecipe = new Recipe(recipeArr[i].get_nameRecipe(), recipeArr[i].get_PreparationTime(), recipeArr[i].get_products(), recipeArr[i].get_swapProd(), recipeArr[i].get_category(), recipeArr[i].get_instruction());
				return newRecipe;
			}
		}		
		return null;
	}
}
