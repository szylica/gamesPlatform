

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;


public class Game {

    String developer;
    String name;
    String description;
    double prize;
    Map<String, Integer> reviewRatings = new HashMap<String, Integer>();
    ArrayList<String> categories = new ArrayList<String>();
    JFrame frame = new JFrame();


    public Game(){
        

    }

    public Game(String developerG, String Game){
        developer = developerG;
        name = Game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
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
        for(Map.Entry<String, Integer> entry: reviewRatings.entrySet()){
            sum += entry.getValue();
        }

        return sum/reviewRatings.size();
    }





    
}
