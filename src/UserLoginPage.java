import java.util.HashMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLoginPage implements ActionListener{

    

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JCheckBox devAccCheckBox = new JCheckBox();
    

    public UserLoginPage(){ 
        FrameManager.addFrame(frame);

        devAccCheckBox.setText("Developer Account");
        devAccCheckBox.setFocusable(false);
        devAccCheckBox.setBounds(125, 200, 200, 25);
        
        //label settings
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125,250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 250, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        resetButton.setBounds(225, 250, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(devAccCheckBox);
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
        if(e.getSource()==loginButton && devAccCheckBox.isSelected()){
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());
            if (IDandPasswords.loginDev.containsKey(userID)){
                if (IDandPasswords.loginDev.get(userID).equals(userPassword)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    MainLibraryPage.isLogged = true;
                    MainLibraryPage.actuallyLogged = userID;
                    MainLibraryPage.devOrUser = "dev";
                    FrameManager.closeAllFrames();
                    MainLibraryPage mainLibraryPage = new MainLibraryPage(userID, 1);

                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
        }
        if(e.getSource()==loginButton && !devAccCheckBox.isSelected()){
            String userID = userIDField.getText();
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if (IDandPasswords.loginUser.containsKey(userID)){
                if (IDandPasswords.loginUser.get(userID).equals(userPassword)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    MainLibraryPage.isLogged = true;
                    MainLibraryPage.actuallyLogged = userID;
                    MainLibraryPage.devOrUser = "user";
                    FrameManager.closeAllFrames();
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
        else{
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Something is wrong");
        }
    }
}
    


