import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SettingsButton extends JButton implements ActionListener {

    SettingsButton(int x, int y, int width, int height){
        initialize(x, y, width, height);
        
    }

    private void initialize(int x, int y, int width, int height){
        ImageIcon icon = new ImageIcon(getClass().getResource("settings.png"));
        Image img = icon.getImage();

        setBounds(x,y,width,height);

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


    @Override
    public void actionPerformed(ActionEvent e) {
        FrameManager.closeAllFrames();
        SettingsPage settingsPage = new SettingsPage();

    }

}
