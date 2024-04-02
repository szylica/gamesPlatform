import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainLibraryPage implements ActionListener{
    
    //LIST OF ALL GAMES IN THE SHOP
    static ArrayList<Game> games = new ArrayList<Game>();

    IDandPasswords idandPasswords = new IDandPasswords();

    JPanel gamesPanel = new JPanel(); 

    //FLAGS
    public static String devOrUser;
    public static boolean isLogged = false;
    public static String actuallyLogged = null;

    //CONSTRUCTOR FOR MAIN PAGE FOR LOGGED OUT
    public MainLibraryPage(){

        PageForLoggedOut frame = new PageForLoggedOut();

        //FrameManager A CLASS WHICH HELPS ME TO CLOSE ALL WINDOWS WHEN I NEED IT 
        FrameManager.addFrame(frame);
        
        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(gamesPanel);
    }

    //CONSTRUCTOR FOR MAIN PAG FOR LOGGED USER
    public MainLibraryPage(String userID){
        isLogged = true;
        devOrUser = "user";
        actuallyLogged = userID;
        
        PageForUser frame = new PageForUser(userID);
        FrameManager.addFrame(frame);


        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(gamesPanel);


    }

    //Developer main page constructor
    //int devveloper variable only for recognize which contructor to use, user or dev
    public MainLibraryPage(String userID, int developer){
        isLogged = true;
        devOrUser = "dev";
        actuallyLogged = userID;
        
        PageForDev frame = new PageForDev(userID);
        FrameManager.addFrame(frame);

        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(gamesPanel);

    }

    //CREATING BUTTONS ON THE PAGE FOR ALL GAMES WHICH ARE IN THE SHOP
    public void createGameButtons() {
        for (Game game : games) {
            JButton button = new JButton(game.getName());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.initialize();
                }
            });

            button.setPreferredSize(new Dimension(150, 30));
            //setting buttons transparent
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            //
            button.setForeground(Color.WHITE);
            button.setFocusable(false);

            gamesPanel.add(button);
                
        }

    }
    public void actionPerformed(ActionEvent e){

    }
}
