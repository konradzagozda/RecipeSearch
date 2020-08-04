package practice;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("File to read:");
        String fileStr = scanner.nextLine();
        RecipesRepository recipesRepo = new RecipesRepository();
        recipesRepo.readFromFile(fileStr);

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while(true) {
            String command = scanner.nextLine();
            if ( command.equals("stop")){
                break;
            }

            if (command.equals("list")){
                System.out.println(recipesRepo);
            }

            if (command.equals("find name")){
                System.out.print("Searched word: ");
                String toFind = scanner.nextLine();
                System.out.println(recipesRepo.findAllByName(toFind));
            }

            if (command.equals("find cooking time")){
                System.out.print("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());
                System.out.println(recipesRepo.findByMaxTime(maxTime));
            }

            if (command.equals("find ingredient")){
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();
                System.out.println(recipesRepo.findByIngredient(ingredient));
            }
        }

    }

}
