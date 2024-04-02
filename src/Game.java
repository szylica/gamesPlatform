

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
    JTextArea descriptionTextArea = new JTextArea ("");
    JLabel prizeLabel = new JLabel("");
    
    JPanel gamePanel = new JPanel();
    JPanel prizePanel = new JPanel();

    JButton buyButton = new JButton("Buy");

    public Game(String developer, String name, String description, double prize){

        this.developer = developer;
        this.name = name;
        this.description = description;
        this.prize = prize;
        
    }

    

    //INITIALIZE FDR LOGGED OUT
    public void initialize(){

        //PANEL WITH GAME INFORMATION ( TITLE, PRIZE, DESCRIPTION, DEVELOPER )
        gamePanel.setBackground(Color.gray);
        gamePanel.setBounds(550,200,1500,750);
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));

        gameDeveloperLabel.setText("Game developer: "+ this.developer);
        gameDeveloperLabel.setForeground(Color.white);
        gameDeveloperLabel.setFont(new Font(gameDeveloperLabel.getFont().getName(), Font.PLAIN, 15));

        titleLabel.setText(this.name);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));

        descriptionTextArea.setText(this.description);
        descriptionTextArea.setForeground(Color.white); //TEXT COLOR
        descriptionTextArea.setFont(new Font(descriptionTextArea.getFont().getName(), Font.PLAIN, 35)); //FONT AND TEXT SIZE
        descriptionTextArea.setLineWrap(true); //AUTOADJUSTING TEXT
        descriptionTextArea.setWrapStyleWord(true); //AUTOADJUSTING TEXT
        descriptionTextArea.setBackground(Color.gray); //BACKGROUND COLOR - GRAY
        descriptionTextArea.setEditable(false); // BLOCKING CHANGING ANYTHING IN TEXTAREA
        descriptionTextArea.setCursor(null); // HIDE CURSOR
        descriptionTextArea.setBorder(null); //BORDERLESS TEXTAREA


        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);

        gamePanel.add(gameDeveloperLabel);
        gamePanel.add(titleLabel);
        gamePanel.add(scrollPane); // Dodajemy JScrollPane z JTextArea
        gamePanel.add(Box.createRigidArea(new Dimension(0, 300)));
       
        

        prizeLabel.setFont(new Font(descriptionTextArea.getFont().getName(), Font.PLAIN, 35));
        prizeLabel.setText("Prize: "+ this.prize);
        

        prizePanel.setBackground(Color.lightGray);
        prizePanel.setBounds(1750,950,300,100);
        prizePanel.setLayout(new BoxLayout(prizePanel, BoxLayout.Y_AXIS));

        prizePanel.add(Box.createRigidArea(new Dimension(70,20)));
        prizePanel.add(prizeLabel);      

        buyButton.setBounds(1800,1030,200,40);
        buyButton.setBackground(Color.GREEN.darker());


        
        if(!MainLibraryPage.isLogged){

            PageForLoggedOut frame = new PageForLoggedOut();
            FrameManager.addFrame(frame);
            buyButton.setEnabled(false);
            buyButton.setText("Log In to buy");
            frame.add(buyButton);
            frame.add(gamePanel);
            frame.add(prizePanel);

        }
        else if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "user"){

            PageForUser frame = new PageForUser(MainLibraryPage.actuallyLogged);
            FrameManager.addFrame(frame);
            frame.add(buyButton);
            frame.add(gamePanel);
            frame.add(prizePanel);

        }
        else if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "dev"){

            PageForDev frame = new PageForDev(MainLibraryPage.actuallyLogged);
            FrameManager.addFrame(frame);
            buyButton.setEnabled(false);
            buyButton.setText("Change account to buy");
            frame.add(buyButton);
            frame.add(gamePanel);
            frame.add(prizePanel);

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
        if(e.getSource() == buyButton){
            User user = IDandPasswords.loginPasswordUser.get(MainLibraryPage.actuallyLogged).getSecondValue();
            if(user.accBalance >= this.prize){
                user.addGameToLibrary(this);
            }
        }
    }

}
