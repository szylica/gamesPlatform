import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInPage implements ActionListener{

    //declare every element on Sign In Page
    JFrame frame = new JFrame();
    JButton registerButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JTextField userNameField = new JTextField();
    JTextField userLastNameField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JPasswordField userPasswordConfirmField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userNameLabel = new JLabel("Name:");
    JLabel userLastNameLabel = new JLabel("Last name:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel userPasswordConfirmLabel = new JLabel("Confirm password:");
    JLabel messageLabel = new JLabel();

    public SignInPage(){ 
        //Labels settings on Sign In Page
        userIDLabel.setBounds(50, 50, 75, 25);
        userNameLabel.setBounds(50, 100, 75,25);
        userLastNameLabel.setBounds(50, 150, 75, 25);
        userPasswordLabel.setBounds(50, 200, 75, 25);
        userPasswordConfirmLabel.setBounds(50, 250, 75, 25);

        messageLabel.setBounds(125,250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        //Fields settings on Sign In Page
        userIDField.setBounds(125, 50, 200, 25);
        userNameField.setBounds(125, 100, 200, 25);
        userLastNameField.setBounds(125, 150, 200, 25);
        userPasswordField.setBounds(125, 200, 200, 25);
        userPasswordConfirmField.setBounds(125, 250, 200, 25);
        
        //Buttons settings on Sign In Page
        registerButton.setBounds(125, 300, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        resetButton.setBounds(225, 300, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        //Adding everything to  Sign In Page Frame 
        frame.add(userIDLabel);
        frame.add(userNameLabel);
        frame.add(userLastNameLabel);
        frame.add(userPasswordLabel);
        frame.add(userPasswordConfirmLabel);
        
        frame.add(userIDField);
        frame.add(userNameField);
        frame.add(userLastNameField);
        frame.add(userPasswordField);
        frame.add(userPasswordConfirmField);
        frame.add(messageLabel);
        frame.add(messageLabel);
        frame.add(registerButton);
        frame.add(resetButton);

        //Frame settings
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        
        //reset button functionality
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userNameField.setText("");
            userLastNameField.setText("");
            userPasswordField.setText("");
            userPasswordConfirmField.setText("");

        }

        if (e.getSource()==registerButton){

            //
            String userID = userIDField.getText();
            String userName = userNameField.getText();
            String userLastName = userLastNameField.getText();
            System.out.println("Password:"+ userPasswordField.getPassword().toString());
            System.out.println("confirm Password:"+ userPasswordConfirmField.getPassword().toString());
            
            //testing if passwords are the same
            if(userPasswordField.getPassword().equals(userPasswordConfirmField.getPassword())){
                String userPassword = String.valueOf(userPasswordField.getPassword());
                User aa = new User(userName, userLastName, userID, userPassword);
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Login successful");
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("passwords are not the same");
            }

            


            
        }
        
    }
    
}
