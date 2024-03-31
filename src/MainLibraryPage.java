import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainLibraryPage implements ActionListener{
    
    static ArrayList<Game> games = new ArrayList<Game>();

    IDandPasswords idandPasswords = new IDandPasswords();

    JPanel gamesPanel = new JPanel(); 

    public static String devOrUser;
    public static boolean isLogged = false;
    public static String actuallyLogged = null;

    public MainLibraryPage(){


        PageForLoggedOut frame = new PageForLoggedOut();
        FrameManager.addFrame(frame);
        
        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(gamesPanel);
    }


    public MainLibraryPage(String userID){
        
        PageForUser frame = new PageForUser(userID);
        FrameManager.addFrame(frame);


        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(gamesPanel);


        isLogged = true;
        devOrUser = "user";
        actuallyLogged = userID;
    }

    //Developer main page constructor
    //int devveloper variable only for recognize which contructor to use, user or dev
    public MainLibraryPage(String userID, int developer){
        PageForDev frame = new PageForDev(userID);
        FrameManager.addFrame(frame);

        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(gamesPanel);

        frame.setLayout(null);

        isLogged = true;
        devOrUser = "dev";
        actuallyLogged = userID;
    }


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
