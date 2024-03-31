import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PageForLoggedOut extends JFrame implements ActionListener {

    JButton becomeDevButton = new JButton("Become developer");
    JButton loginButton = new JButton("Log In");
    JButton registerButton = new JButton("Sing In");

    public PageForLoggedOut(){
        initialize();
    }

    private void initialize(){
        becomeDevButton.setBounds(50, 25, 150,25);
        becomeDevButton.setFocusable(false);
        becomeDevButton.addActionListener(this);

        
        loginButton.setBounds(2450,25, 75, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(2375,25, 75, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        add(becomeDevButton);
        add(loginButton);
        add(registerButton);

        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==registerButton){
            SignInPage userSignInPage = new SignInPage();
        }

        if (e.getSource()==loginButton){
            UserLoginPage userLoginPage = new UserLoginPage();
        }
        if (e.getSource() == becomeDevButton){
            BecomeDevPage becomeDevPage = new BecomeDevPage();
        }
        
    }

}
