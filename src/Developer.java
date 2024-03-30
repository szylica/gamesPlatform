import javax.swing.JFrame;



public class Developer extends Client {
    
    //COMPONENTS
    String company;
    String adress;
    static int developerCounter;
    

    public Developer(String name,String lastName, String login, String password, String company, String adress){
        super(name, lastName, login, password);
        this.company = company;
        this.adress = adress;
        developerCounter++;
    }

    public void createGame(String gameName){
        
        Game newGame = new Game(MainLibraryPage.actuallyLogged, gameName);

    }
}
