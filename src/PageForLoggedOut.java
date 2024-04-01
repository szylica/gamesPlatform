import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PageForLoggedOut extends JFrame implements ActionListener {

    JButton becomeDevButton = new JButton("Become developer");
    JButton loginButton = new JButton("Log In");
    JButton registerButton = new JButton("Sign In");

    public PageForLoggedOut(){
        initialize();
    }

    private void initialize(){
        becomeDevButton.setBounds(265, 55, 150,25);
        becomeDevButton.setFocusable(false);
        becomeDevButton.addActionListener(this);

        HomeButton homeButton = new HomeButton();
        
        loginButton.setBounds(2400,55, 75, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(2325,55, 75, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        add(becomeDevButton);
        add(homeButton);
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
