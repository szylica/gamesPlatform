import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HomeButton extends JButton implements ActionListener{

    public HomeButton(){
        initialize();
    }


    private void initialize(){
        ImageIcon icon = new ImageIcon(getClass().getResource("PlayVault.png"));
        Image img = icon.getImage();

        setBounds(25,25,200,100);

        Image scaledImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);

        addActionListener(this);
        try{
        setIcon(new ImageIcon(scaledImg));
        } catch(Exception e){
            System.out.println("Immage cannot be found");
        }
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }



    public void actionPerformed(ActionEvent e) {
        if(MainLibraryPage.isLogged){
            if(MainLibraryPage.devOrUser == "dev"){
                FrameManager.closeAllFrames();
                MainLibraryPage mainLibraryPage = new MainLibraryPage(MainLibraryPage.actuallyLogged);
            }
            if(MainLibraryPage.devOrUser == "user"){
                FrameManager.closeAllFrames();
                MainLibraryPage mainLibraryPage = new MainLibraryPage(MainLibraryPage.actuallyLogged, 1);
            }

        }
        else {
            FrameManager.closeAllFrames();
            MainLibraryPage mainLibraryPage = new MainLibraryPage();
        }
        

    }
}
