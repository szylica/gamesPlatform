import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    
    
    public static void main(String[] args){
        
        
        

        //UserLoginPage xpp = new UserLoginPage(idandPasswords.getUserLoginInfo());
        //SignInPage xpp = new SignInPage();
        MainLibraryPage.games.add(new Game("aa","hahaah"));
        MainLibraryPage.games.add(new Game("aaa","chuj"));
        MainLibraryPage.games.add(new Game("aaaa","wiedzmin"));
        MainLibraryPage.games.add(new Game("aaaa","wiedzmin3"));
        
        

        IDandPasswords idandPasswords = new IDandPasswords();
        MainLibraryPage aaa = new MainLibraryPage();
    }


}
   
