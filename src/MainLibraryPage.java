import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainLibraryPage implements ActionListener{
    
    static ArrayList<Game> games = new ArrayList<Game>();

    IDandPasswords idandPasswords = new IDandPasswords();
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Log In");
    JButton registerButton = new JButton("Sign In");
    JLabel userIDLabel = new JLabel("Hello ");

    JPanel gamesPanel = new JPanel(); 


    public MainLibraryPage(){

        
        loginButton.setBounds(2450,25, 75, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(2375,25, 75, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        
        gamesPanel.setBackground(Color.blue);
        gamesPanel.setBounds(1000,200,200,750);
        gamesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        createGameButtons();


        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(gamesPanel);

        frame.getContentPane().setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void createGameButtons() {
        for (Game game : games) {
            JButton button = new JButton(game.getName());
            // Tutaj możesz dodać ActionListener dla każdego przycisku, jeśli jest potrzebny
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

    public MainLibraryPage(String userID){

        userIDLabel.setBounds(2375,25, 100, 25);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
        userIDLabel.setForeground((Color.green));
        userIDLabel.setText("Hello " + userID);

        gamesPanel.setBackground(Color.blue);
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
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==loginButton){
            UserLoginPage userLoginPage = new UserLoginPage(idandPasswords.getUserLoginInfo());
        }

        if (e.getSource()==registerButton){
            SignInPage userSignInPage = new SignInPage();
        }

    }


}
