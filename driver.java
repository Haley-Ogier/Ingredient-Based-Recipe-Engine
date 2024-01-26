// this program is going to give users a menu of things to do, from there they will select one
// options will be get a random recipe, add a recipe, search for a recipe, remove a recipe, and quit
// we can use a similarit detector from other projects for searching 

import java.util.Scanner;

public class driver{
public static void main(String[] args) {
    boolean quit = false;
    allRecipes current = new allRecipes();
    Scanner input = new Scanner(System.in);
    while(quit == false){
        System.out.print("\nChoose from the menu below: \n"+
                            "A) see all recipes \n" +
                            "B) add a recipe \n" +
                            "C) search for a recipe by ingedience \n" +
                            "D) remove a recipe \n" +
                            "Q) quit \n");
        String letter = input.nextLine();
        letter = letter.toUpperCase();
        switch (letter) {
            case "A":
              current.SeeAllRecipes(input);
              break;
            case "B":
              current.addRecipe(input);
              break;
            case "C":
              current.ingredientSearch(input);
              break;
            case "D":
              current.removeOne(input);
              break;
            case "Q":
              quit = true;
              break;
            default: 
              System.out.print("invalid");

        }

    }
    input.close();
}
}