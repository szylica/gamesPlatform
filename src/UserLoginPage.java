import java.util.HashMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLoginPage implements ActionListener{

    public static boolean isLogged = false;
    public static String actuallyLogged = null;

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
 
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public UserLoginPage(HashMap<String, String> loginInfoOriginal){ 
        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125,250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(messageLabel);
        frame.add(messageLabel);
        frame.add(loginButton);
        frame.add(resetButton);


        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()==loginButton){
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)){
                if (loginInfo.get(userID).equals(userPassword)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    isLogged = true;
                    actuallyLogged = userID;
                    MainLibraryPage mainLibraryPage = new MainLibraryPage(userID);

                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }


        }
    }

    

}
