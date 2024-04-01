import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BecomeDevPage implements ActionListener{

    //declare every element on Sign In Page
    JFrame frame = new JFrame("Become developer");

    JButton registerButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField devIDField = new JTextField();
    JTextField devNameField = new JTextField();
    JTextField devLastNameField = new JTextField();
    JTextField devCompanyField = new JTextField();
    JTextField devAddressField = new JTextField();

    JPasswordField devPasswordField = new JPasswordField();
    JPasswordField devPasswordConfirmField = new JPasswordField();

    JLabel devIDLabel = new JLabel("userID:");
    JLabel devNameLabel = new JLabel("Name:");
    JLabel devLastNameLabel = new JLabel("Last name:");
    JLabel devCompanyLabel = new JLabel("Company:");
    JLabel devAddressLabel = new JLabel("Adress:");
    JLabel devPasswordLabel = new JLabel("Password:");
    JLabel devPasswordConfirmLabel = new JLabel("Confirm password:");
    JLabel messageLabel = new JLabel();

    public BecomeDevPage(){ 
        FrameManager.addFrame(frame);
        //Labels settings on Sign In Page
        devIDLabel.setBounds(50, 25, 75, 25);
        devNameLabel.setBounds(50, 75, 75,25);
        devLastNameLabel.setBounds(50, 125, 75, 25);
        devCompanyLabel.setBounds(50, 175, 75, 25);
        devAddressLabel.setBounds(50, 225, 75, 25);
        devPasswordLabel.setBounds(50, 275, 75, 25);
        devPasswordConfirmLabel.setBounds(50, 325, 75, 25);

        messageLabel.setBounds(125,250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        //Fields settings on Sign In Page
        devIDField.setBounds(125, 25, 200, 25);
        devNameField.setBounds(125, 75, 200, 25);
        devLastNameField.setBounds(125, 125, 200, 25);
        devCompanyField.setBounds(125, 175, 200, 25);
        devAddressField.setBounds(125, 225, 200, 25);
        devPasswordField.setBounds(125, 275, 200, 25);
        devPasswordConfirmField.setBounds(125, 325, 200, 25);
        
        //Buttons settings on Sign In Page
        registerButton.setBounds(125, 375, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        resetButton.setBounds(225, 375, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        //Adding everything to  Sign In Page Frame 
        frame.add(devIDLabel);
        frame.add(devNameLabel);
        frame.add(devLastNameLabel);
        frame.add(devCompanyLabel);
        frame.add(devAddressLabel);
        frame.add(devPasswordLabel);
        frame.add(devPasswordConfirmLabel);
        
        frame.add(devIDField);
        frame.add(devNameField);
        frame.add(devLastNameField);
        frame.add(devCompanyField);
        frame.add(devAddressField);
        frame.add(devPasswordField);
        frame.add(devPasswordConfirmField);
        frame.add(messageLabel);
        frame.add(messageLabel);
        frame.add(registerButton);
        frame.add(resetButton);

        //Frame settings
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        
        //reset button functionality
        if(e.getSource()==resetButton){
            devIDField.setText("");
            devNameField.setText("");
            devLastNameField.setText("");
            devPasswordField.setText("");
            devPasswordConfirmField.setText("");

        }

        if (e.getSource()==registerButton){

            //
            String devID = devIDField.getText();
            String devName = devNameField.getText();
            String devLastName = devLastNameField.getText();
            String devCompany = devCompanyField.getText();
            String devAddress = devAddressField.getText();
        
            
            //testing if passwords are the same
            if(Arrays.equals(devPasswordField.getPassword(), devPasswordConfirmField.getPassword())){

                String devPassword = String.valueOf(devPasswordField.getPassword());

                //CLOSING ALL EXISTING WINDOWS(FRAMES)
                FrameManager.closeAllFrames();

                Developer aa = new Developer(devName, devLastName, devID, devPassword, devCompany, devAddress);

                //ANNOUNCEMENT
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Login successful");


                //CHANGING GLOBAL VARIABLES
                MainLibraryPage.isLogged = true;
                MainLibraryPage.actuallyLogged = devID;
                MainLibraryPage.devOrUser = "dev";

                //OPENING MAIN WINDOW
                MainLibraryPage mainLibraryPage = new MainLibraryPage(devID, 1);

                //PUTTING INFO ABOUT DEVELOPER TO DATABASE
                IDandPasswords.loginPasswordDev.put(devID, new Pair<>(devPassword, aa));
                
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("passwords are not the same");
            }

            


            
        }
        
    }
    
}
