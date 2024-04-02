import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPage implements ActionListener {

    public SettingsPage(){
        initialize();
    }

    public void initialize(){


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.gray);
        leftPanel.setBounds(550,200,750,750);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.gray);
        rightPanel.setBounds(1300,200,750,750);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        
        if(!MainLibraryPage.isLogged){

            PageForLoggedOut frame = new PageForLoggedOut();
            FrameManager.addFrame(frame);
            //frame.add(settingsPanel);

        }
        else if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "user"){

            JLabel messageLabel = new JLabel();
            messageLabel.setBounds(1200,800,300,50);
            messageLabel.setFont(new Font(messageLabel.getFont().getName(), Font.PLAIN, 30));

            //left panel(LABELS)
            JLabel nameLabel = new JLabel("Name");
            nameLabel.setForeground(Color.white);
            nameLabel.setFont(new Font(nameLabel.getFont().getName(), Font.PLAIN, 30));
        
            JLabel lastNameLabel = new JLabel("Last Name");
            lastNameLabel.setForeground(Color.white);
            lastNameLabel.setFont(new Font(lastNameLabel.getFont().getName(), Font.PLAIN, 30));

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setForeground(Color.white);
            passwordLabel.setFont(new Font(passwordLabel.getFont().getName(), Font.PLAIN, 30));

            leftPanel.add(Box.createRigidArea(new Dimension(50,80)));
            leftPanel.add(nameLabel);
            leftPanel.add(Box.createRigidArea(new Dimension(50,80)));
            leftPanel.add(lastNameLabel);
            leftPanel.add(Box.createRigidArea(new Dimension(50,80)));
            leftPanel.add(passwordLabel);


            //right panel(textfields)
            JTextField nameTextField = new JTextField();
            nameTextField.setMaximumSize(new Dimension(500, 40)); 

            JTextField lastNameTextField = new JTextField();
            lastNameTextField.setMaximumSize(new Dimension(500, 40));

            JTextField passwordTextField = new JTextField();
            passwordTextField.setMaximumSize(new Dimension(500, 40));

            rightPanel.add(Box.createRigidArea(new Dimension(0,75)));
            rightPanel.add(nameTextField);
            rightPanel.add(Box.createRigidArea(new Dimension(0,75)));
            rightPanel.add(lastNameTextField);
            rightPanel.add(Box.createRigidArea(new Dimension(0,75)));
            rightPanel.add(passwordTextField);

            JButton saveButton = new JButton("Save");
            saveButton.setBounds(1200,700,100,50);
            saveButton.setFocusable(false);

            //SAVING CHANGES BUTTON
            saveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!passwordTextField.getText().isEmpty()){
                        IDandPasswords.loginPasswordUser.get(MainLibraryPage.actuallyLogged).setFirstValue(passwordTextField.getText());
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Changes has been saved");
                    }
                    if(!nameTextField.getText().isEmpty()){
                        //getting user as object from IDandPasswords and setting him new name 
                        IDandPasswords.loginPasswordUser.get(MainLibraryPage.actuallyLogged).getSecondValue().setName(nameTextField.getText());
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Changes has been saved");
                    }
                    if(!lastNameTextField.getText().isEmpty()){
                        //getting user as object from IDandPasswords and setting him new last name 
                        IDandPasswords.loginPasswordUser.get(MainLibraryPage.actuallyLogged).getSecondValue().setLastName(lastNameTextField.getText());
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Changes has been saved");
                    }
                    
                }
            });

            PageForUser frame = new PageForUser(MainLibraryPage.actuallyLogged);
            FrameManager.addFrame(frame);
            //frame.add(settingsPanel);
            frame.add(messageLabel);
            frame.add(saveButton);
            frame.add(leftPanel);
            frame.add(rightPanel);

        }
        else if (MainLibraryPage.isLogged && MainLibraryPage.devOrUser == "dev"){

            PageForDev frame = new PageForDev(MainLibraryPage.actuallyLogged);
            FrameManager.addFrame(frame);
            //frame.add(settingsPanel);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
