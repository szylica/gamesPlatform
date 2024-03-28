import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args){
        
 
        

        //UserLoginPage xpp = new UserLoginPage(idandPasswords.getUserLoginInfo());
        //SignInPage xpp = new SignInPage();
        MainLibraryPage.games.add(new Game("aa","hahaah"));
        MainLibraryPage.games.add(new Game("aaa","chuj"));
        MainLibraryPage.games.add(new Game("aaaa","wiedzmin"));
        MainLibraryPage.games.forEach((n) -> System.out.println(n)); 
        

        IDandPasswords idandPasswords = new IDandPasswords();
        MainLibraryPage aaa = new MainLibraryPage();
        }

    }
   
