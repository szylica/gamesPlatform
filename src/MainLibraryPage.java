import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainLibraryPage implements ActionListener{
    
    static ArrayList<Game> games = new ArrayList<Game>();

    IDandPasswords idandPasswords = new IDandPasswords();
    JFrame frame = new JFrame();
    JButton becomeDev = new JButton("Become Developer");
    JButton loginButton = new JButton("Log In");
    JButton registerButton = new JButton("Sign In");
    JButton addGame = new JButton("Add Game");
    JLabel userIDLabel = new JLabel("Hello ");

    JPanel gamesPanel = new JPanel(); 

    public static String devOrUser;
    public static boolean isLogged = false;
    public static String actuallyLogged = null;

    public MainLibraryPage(){

        FrameManager.addFrame(frame);

        becomeDev.setBounds(50, 25, 150,25);
        becomeDev.setFocusable(false);
        becomeDev.addActionListener(this);

        
        loginButton.setBounds(2450,25, 75, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(2375,25, 75, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        
        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        createGameButtons();

        frame.add(becomeDev);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(gamesPanel);

        frame.getContentPane().setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public MainLibraryPage(String userID){
        FrameManager.addFrame(frame);

        becomeDev.setBounds(50, 25, 150,25);
        becomeDev.setFocusable(false);
        becomeDev.addActionListener(this);

        userIDLabel.setBounds(2375,25, 100, 25);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
        userIDLabel.setForeground((Color.green));
        userIDLabel.setText("Hello " + userID);

        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(userIDLabel);
        frame.add(gamesPanel);

        frame.getContentPane().setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);

        isLogged = true;
        devOrUser = "user";
        actuallyLogged = userID;
    }

    //Developer main page constructor
    //int devveloper variable only for recognize which contructor to use, user or dev
    public MainLibraryPage(String userID, int developer){
        FrameManager.addFrame(frame);

        addGame.setBounds(50, 25, 150,25);
        addGame.setFocusable(false);
        addGame.addActionListener(this);


        userIDLabel.setBounds(2350,25, 200, 25);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
        userIDLabel.setForeground((Color.green));
        userIDLabel.setText("Hello dev " + userID);

        gamesPanel.setBackground(Color.gray);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        createGameButtons();

        frame.add(addGame);
        frame.add(userIDLabel);
        frame.add(gamesPanel);

        frame.getContentPane().setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);

        isLogged = true;
        devOrUser = "dev";
        actuallyLogged = userID;
    }


    public void createGameButtons() {
        for (Game game : games) {
            JButton button = new JButton(game.getName());
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        
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
            CreateGamePage createGamePage = new CreateGamePage();
        }

    }


}
