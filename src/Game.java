

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
    JFrame frame = new JFrame();
    JButton becomeDev = new JButton("Become Developer");
    JButton loginButton = new JButton("Log In");
    JButton registerButton = new JButton("Sign In");
    JButton addGame = new JButton("Add Game");
    JLabel userIDLabel = new JLabel("Hello ");


    public Game(){

        JPanel game = new JPanel();
        //DEV SITE
        if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "dev"){
            
            addGame.setBounds(50, 25, 150,25);
            addGame.setFocusable(false);
            addGame.addActionListener(this);

            userIDLabel.setBounds(2375,25, 100, 25);
            userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
            userIDLabel.setForeground((Color.green));
            userIDLabel.setText("Hello dev " + MainLibraryPage.actuallyLogged);

            frame.add(addGame);
        }

        //USER SITE
        if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "user"){
            becomeDev.setBounds(50, 25, 150,25);
            becomeDev.setFocusable(false);
            becomeDev.addActionListener(this);
    
            userIDLabel.setBounds(2375,25, 100, 25);
            userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
            userIDLabel.setForeground((Color.green));
            userIDLabel.setText("Hello " + MainLibraryPage.actuallyLogged);
            
            frame.add(becomeDev);
        }

        //LOGGED OUT SITE
        if(!MainLibraryPage.isLogged){
            becomeDev.setBounds(50, 25, 150,25);
            becomeDev.setFocusable(false);
            becomeDev.addActionListener(this);

        
            loginButton.setBounds(2450,25, 75, 25);
            loginButton.setFocusable(false);
            loginButton.addActionListener(this);

            registerButton.setBounds(2375,25, 75, 25);
            registerButton.setFocusable(false);
            registerButton.addActionListener(this);

            frame.add(becomeDev);
            frame.add(loginButton);
            frame.add(registerButton);
        }
        
        FrameManager.addFrame(frame);

        //THINGS ON SITE WHICH IS THE SAME FOR EVERY PROPERTIES
        frame.getContentPane().setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        frame.setVisible(true);

    }

    //GAME CONSTRUCTOR, CREATING OBJECT
    public Game(String developerG, String Game){
        developer = developerG;
        name = Game;
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
        if (e.getSource()==loginButton){
            UserLoginPage userLoginPage = new UserLoginPage();
        }

        if (e.getSource()==registerButton){
            SignInPage userSignInPage = new SignInPage();
        }

        if (e.getSource()==becomeDev){
            BecomeDevPage becomeDevPage = new BecomeDevPage();
        }

        if (e.getSource()==addGame){
            //BecomeDevPage ;
        }
    }





    
}
