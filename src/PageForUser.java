import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageForUser extends JFrame implements ActionListener {

    JButton logOutButton = new JButton("Log out");
    JButton becomeDevButton = new JButton("Become developer");
    JLabel userIDLabel = new JLabel("hello");
    JLabel userBalance = new JLabel("");

    public PageForUser(String userID){
        initialize(userID);

    }

    private void initialize(String userID){
        becomeDevButton.setBounds(265, 55, 150,25);
        becomeDevButton.setFocusable(false);
        becomeDevButton.addActionListener(this);

        logOutButton.setBounds(2400, 55, 100, 25);
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);

        HomeButton homeButton = new HomeButton();

        SettingsButton settingsButton = new SettingsButton(2350, 55, 30, 30);

        userIDLabel.setBounds(2200,55, 150, 25);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
        userIDLabel.setForeground((Color.green));
        userIDLabel.setText("Hello " + userID);

        userBalance.setBounds(2100,55, 150, 25);
        userBalance.setFont(new Font(null, Font.PLAIN, 20));
        userBalance.setForeground((Color.white));
        userBalance.setText("Balance: " + IDandPasswords.loginPasswordUser.get(MainLibraryPage.actuallyLogged).getSecondValue().accBalance);

        
        add(becomeDevButton);
        add(logOutButton);
        add(homeButton);
        add(settingsButton);
        add(userIDLabel);

        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logOutButton){
            FrameManager.closeAllFrames();
            MainLibraryPage mainLibraryPage = new MainLibraryPage();
        }
        if (e.getSource() == becomeDevButton){
            BecomeDevPage becomeDevPage = new BecomeDevPage();
        }

    }


}
