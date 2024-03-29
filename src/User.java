

import java.util.ArrayList;

public class User extends Client {

    static int userCounter;
    double accBalance;
    ArrayList<Game> userLibrary = new ArrayList<>();
    

    public User(String name,String lastName, String login, String password){
        super(name, lastName, login, password);
        userCounter++;
    }
    
    public void addReview(Game name, int review){
        //to samo co w developerze
        if (MainLibraryPage.actuallyLogged!=null){
            name.reviewRatings.put(MainLibraryPage.actuallyLogged, review);
        }
        
    }

    public void addFunds(int founds){
        accBalance += founds;
        System.out.println(founds + "has been added to your account");
    }
    


}
