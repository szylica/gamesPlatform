import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageForDev extends JFrame implements ActionListener{


    
    JButton addGame = new JButton("Create Game");
    JLabel userIDLabel = new JLabel("hello ");


    public PageForDev(String userID){
        initialize(userID);

    }


    private void initialize(String userID){



        addGame.setBounds(50, 25, 150,25);
        addGame.setFocusable(false);
        addGame.addActionListener(this);


        userIDLabel.setBounds(2350,25, 200, 25);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
        userIDLabel.setForeground((Color.green));
        userIDLabel.setText("Hello dev " + userID);

        add(addGame);
        add(userIDLabel);

        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }


    
    public void actionPerformed(ActionEvent e) {
        CreateGamePage createGamePage = new CreateGamePage();
    }

}
