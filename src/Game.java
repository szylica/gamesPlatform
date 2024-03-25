package library;

import java.util.ArrayList;
import java.util.HashMap;


public class Game {

    String developer;
    String name;
    HashMap<User, Integer> reviewRatings = new HashMap<User, Integer>();
    ArrayList<String> categories = new ArrayList<String>();
    

    public Game(String developerG, String Game){
        developer = developerG;
        name = Game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategories(String category) {
        while (category != "end") {
            categories.add(category);
            System.out.println("Category " + category + " has been added to game " + name);
        }
    
    }

    public void deleteCategories(String category) {
        while (category != "end") {
            if (categories.contains(category)){
                categories.remove(category);
            }
            else {
                System.out.println("There is no category " + category + "attached to game " + name);
            }
        }
    }

    public double calcAvgRating(){
        int sum = 0;
        for(int i = 0; i < reviewRatings.size(); i++){
            sum += reviewRatings.get(i);
        }

        return sum/reviewRatings.size();
    }





    
}
