import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class allRecipes{
    private Map<String,recipe> allData;

    public allRecipes(){
    this.allData = new HashMap<String, recipe>();
    }

    public void SeeAllRecipes(Scanner k){
        if(allData.isEmpty()){
            System.out.print("no recipes so far.");
            return;
        }
        for (String key : allData.keySet()){
            System.out.print(key + "\n");
        }
        System.out.print("Please enter the title exactly as given that you wish to view.\n");
        String input = k.nextLine();
        System.out.print(allData.get(input).toString() +"\n");
    }

    private Set<String> createSet(String given){
        Set<String> trimmed = new HashSet<String>();
		String[] splitlines = given.split(",");
		for(String x:splitlines){
			if(!(x.trim().isEmpty())){
				trimmed.add(x.trim());
			}
		}
		return trimmed;
	}

    public void addRecipe(Scanner k){
        System.out.print("What is the title of your recipe?\n");
        String title = k.nextLine();
        System.out.print("Please give a description of your recipe.\n");
        String description = k.nextLine();
        System.out.print("How long does this recipe take to cook?\n");
        String time = k.nextLine();
        System.out.print("Please list the ingredients needed seperating each one with a comma.\n");
        String toSplit = k.nextLine();
        Set<String> toAdd = createSet(toSplit);
        System.out.print("Please give instructions\n");
        String intruct = k.nextLine();

        recipe complete = new recipe(description, time, toAdd, intruct);
        allData.put(title, complete);
        System.out.print("Recipe added!\n\n");
    }

    public void ingredientSearch(Scanner k){
        System.out.print("Please list all the ingedients that you are looking to use (seperating each one with a comma)\n");
        String given = k.nextLine();
        Set<String> usersSet = createSet(given);
        for (String current : allData.keySet()){
            Set<String> inMap = allData.get(current).getIngred();
            double similarity = ingredientsSearch.jaccardIndex(usersSet,inMap);
            if (similarity > 0.5){
                System.out.print("\n"+current +"\n");
            }
        }
        System.out.print("These are the best matches! Please enter the title exactly as given that you wish to view.\n");
        String input = k.nextLine();
        System.out.print(allData.get(input).toString() +"\n");
    }

    public void removeOne(Scanner k){
        System.out.print("Here are all the current recipes:\n");
        for (String key : allData.keySet()){
            System.out.print(key + "\n");
        }
        System.out.print("Which would you like to remove. Please enter the exact title\n");
        String toRemove = k.nextLine();
        allData.remove(toRemove);
        System.out.print("Recipe removed!\n");
    }
}