import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageForDev extends JFrame implements ActionListener{


    
    JButton addGameButton = new JButton("Create Game");
    JButton logOutButton = new JButton("Log out");
    JButton homeButton = new JButton();
    JLabel userIDLabel = new JLabel("hello ");

    public PageForDev(String userID){
        initialize(userID);

    }


    private void initialize(String userID){

        addGameButton.setBounds(265, 55, 150,25);
        addGameButton.setFocusable(false);
        addGameButton.addActionListener(this);
        
        logOutButton.setBounds(2400, 55, 100, 25);
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);

        HomeButton homeButton = new HomeButton();

        SettingsButton settingsButton = new SettingsButton(2350, 55, 30, 30);

        userIDLabel.setBounds(2150,55, 200, 25);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
        userIDLabel.setForeground((Color.green));
        userIDLabel.setText("Hello dev " + userID);

        add(addGameButton);
        add(logOutButton);
        add(homeButton);
        add(settingsButton);
        add(userIDLabel);

        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }


    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton){
            FrameManager.closeAllFrames();
            MainLibraryPage mainLibraryPage = new MainLibraryPage(MainLibraryPage.actuallyLogged, 1);
        }
        
        if (e.getSource() == addGameButton){
            CreateGamePage createGamePage = new CreateGamePage();
        }

        if (e.getSource() == logOutButton){
            FrameManager.closeAllFrames();
            MainLibraryPage mainLibraryPage = new MainLibraryPage();
        }
    }

}
