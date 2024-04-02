import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateGamePage implements ActionListener {

    JFrame frame = new JFrame();

    JButton createButton = new JButton("Create game");

    JTextField gameNameField = new JTextField();
    JTextArea gameDescriptionTArea = new JTextArea();
    JTextField gamePrizeField = new JTextField();

    JLabel gameNameLabel = new JLabel();
    JLabel gameDescriptionLabel = new JLabel();
    JLabel gamePrizeLabel = new JLabel();
    JLabel announcementLabel = new JLabel("");

    public CreateGamePage() {
        FrameManager.addFrame(frame);
        
        gameNameLabel.setBounds(100,100,200,25);
        gameNameLabel.setText("Game name");
        gameNameLabel.setFont(new Font(null, Font.ITALIC, 20));
        
        gameDescriptionLabel.setBounds(100,150,200,25);
        gameDescriptionLabel.setText("Game description");
        gameDescriptionLabel.setFont(new Font(null, Font.ITALIC, 20));

        gamePrizeLabel.setBounds(100,450,200,25);
        gamePrizeLabel.setText("Game prize");
        gamePrizeLabel.setFont(new Font(null, Font.ITALIC, 20));

        announcementLabel.setBounds(300, 550, 300, 25);

        gameNameField.setBounds(300,100,300,25);
        gameNameField.setFont(new Font(null, Font.ITALIC, 20));

        gameDescriptionTArea.setBounds(300,150,300,270);
        gameDescriptionTArea.setFont(new Font(null, Font.ITALIC, 15));
        gameDescriptionTArea.setLineWrap(true);
        gameDescriptionTArea.setWrapStyleWord(true);
        
        gamePrizeField.setBounds(300,450,300,25);
        gamePrizeField.setFont(new Font(null, Font.ITALIC, 20));

        createButton.setBounds(300, 500, 300, 25);
        createButton.setFocusable(false);
        createButton.addActionListener(this);
        

        frame.add(announcementLabel);
        frame.add(createButton);
        frame.add(gameNameField);
        frame.add(gameDescriptionTArea);
        frame.add(gamePrizeField);
        frame.add(gameNameLabel);
        frame.add(gameDescriptionLabel);
        frame.add(gamePrizeLabel);
        frame.add(createButton);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton){
            if (!gameNameField.getText().isEmpty() && !gamePrizeField.getText().isEmpty()){
            
                FrameManager.closeAllFrames();
                Game newGame = new Game(MainLibraryPage.actuallyLogged, gameNameField.getText(), gameDescriptionTArea.getText(), Double.parseDouble(gamePrizeField.getText()));
                newGame.initialize();
                MainLibraryPage.games.add(newGame);
            
            }
            else{
                announcementLabel.setForeground(Color.red);
                announcementLabel.setText("All fields have to be filled");
            }


        }
    }

}
