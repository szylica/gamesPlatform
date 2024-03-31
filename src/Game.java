

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import java.awt.*;




public class Game implements ActionListener{

    String developer;
    String name;
    String description;
    double prize;
    Map<String, Integer> reviewRatings = new HashMap<String, Integer>();
    ArrayList<String> categories = new ArrayList<String>();
    
    //SITE OF EVERY GAME, SAME AS MainLibraryPage BUT FOR EVERY PROPERTIES(IF LOGGED, LOGGED DEV, LOGGED USER) OTHER BUTTONS IN THE UPPER GUI 


    JLabel titleLabel = new JLabel("");
    JLabel gameDeveloperLabel = new JLabel("");
    JLabel descriptionLabel = new JLabel("");
    
    JPanel gamePanel = new JPanel();

    public Game(String developer, String name, String description, double prize){

        this.developer = developer;
        this.name = name;
        this.description = description;
        this.prize = prize;
        
        initialize();
    }

    //GAME CONSTRUCTOR, CREATING OBJECT
    public Game(String developer, String gameName){
        this.developer = developer;
        name = gameName;
    }

    //INITIALIZE FDR LOGGED OUT
    private void initialize(){

        gamePanel.setBackground(Color.blue);
        gamePanel.setBounds(550,200,1500,750);
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

        gameDeveloperLabel.setText("Game developer: "+ this.developer);
        gameDeveloperLabel.setForeground(Color.white);
        gameDeveloperLabel.setFont(new Font(gameDeveloperLabel.getFont().getName(), Font.PLAIN, 15));
        
        titleLabel.setText(this.name);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));

        descriptionLabel.setText(this.description);
        descriptionLabel.setBounds(200, 600, 1000,1000);
        descriptionLabel.setForeground(Color.white);
        descriptionLabel.setFont(new Font(descriptionLabel.getFont().getName(), Font.PLAIN, 35));

        gamePanel.add(gameDeveloperLabel);
        gamePanel.add(titleLabel);
        gamePanel.add(descriptionLabel);

        
        if(!MainLibraryPage.isLogged){

            PageForLoggedOut frame = new PageForLoggedOut();
            FrameManager.addFrame(frame);
            frame.add(gamePanel);

        }
        else if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "user"){

            PageForUser frame = new PageForUser(MainLibraryPage.actuallyLogged);
            FrameManager.addFrame(frame);
            frame.add(gamePanel);

        }
        else if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "dev"){

            PageForDev frame = new PageForDev(MainLibraryPage.actuallyLogged);
            FrameManager.addFrame(frame);
            frame.add(gamePanel);

        }

    }

    
    


    //NAME SETTER
    public void setName(String name) {
        this.name = name;
    }

    //NAME GETTER
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

    //CALCULATING AVARAGE RATING FOR THE GAME
    public double calcAvgRating(){
        int sum = 0;
        for(Map.Entry<String, Integer> entry: reviewRatings.entrySet()){
            sum += entry.getValue();
        }

        return sum/reviewRatings.size();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
