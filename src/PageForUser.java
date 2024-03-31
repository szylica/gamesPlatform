import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageForUser extends JFrame implements ActionListener {

    JButton becomeDev = new JButton("Become developer");
    JLabel userIDLabel = new JLabel("hello");


    public PageForUser(String userID){
        initialize(userID);

    }

    private void initialize(String userID){
        becomeDev.setBounds(50, 25, 150,25);
        becomeDev.setFocusable(false);
        becomeDev.addActionListener(this);

        userIDLabel.setBounds(2375,25, 150, 25);
        userIDLabel.setFont(new Font(null, Font.PLAIN, 20));
        userIDLabel.setForeground((Color.green));
        userIDLabel.setText("Hello " + userID);

        add(userIDLabel);
        add(becomeDev);

        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BecomeDevPage becomeDevPage = new BecomeDevPage();
    }

}
