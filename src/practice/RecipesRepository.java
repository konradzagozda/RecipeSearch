package practice;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipesRepository {
    private ArrayList<Recipe> recipes;

    public RecipesRepository() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe r){
        this.recipes.add(r);
    }

    public String toString() {
        String out = "Recipes: \n";
        for(Recipe r : recipes){
            out += r;
        }
        return out;
    }

    public boolean readFromFile(String fileStr) {
        try(Scanner fileScanner = new Scanner(Paths.get(fileStr))){
            while(fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine();
                int cookingTime = Integer.valueOf(fileScanner.nextLine());
                ArrayList<String> ingredients = new ArrayList<>();
                while(fileScanner.hasNextLine()){
                    String ingredient = fileScanner.nextLine();
                    if(ingredient.isEmpty()){
                        break;
                    }
                    ingredients.add(ingredient);
                }
                Recipe recipe = new Recipe(name, cookingTime, ingredients);
                recipes.add(recipe);
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    public RecipesRepository findAllByName(String str) {
        RecipesRepository out = new RecipesRepository();
        for(Recipe r : recipes){
            if(r.getName().toLowerCase().contains(str.toLowerCase())){
                out.add(r);
            }
        }
        return out;
    }

    public RecipesRepository findByMaxTime(int maxTime) {
        RecipesRepository out = new RecipesRepository();
        for(Recipe r : recipes){
            if(r.getCookingTime() <= maxTime ){
                out.add(r);
            }
        }
        return out;
    }

    public RecipesRepository findByIngredient(String ingredient){
        RecipesRepository out = new RecipesRepository();
        for(Recipe r : recipes){
            for (String i : r.getIngredients()){
                if (i.equalsIgnoreCase(ingredient)){
                    out.add(r);
                }
            }
        }
        return out;
    }
}

