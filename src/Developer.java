public class Developer extends Client {
    
    String company;
    static int developerCounter;


    public Developer(String name,String lastName, String login, String password){
        super(name, lastName, login, password);
        developerCounter++;
    }

    public void createGame(String gameName){
        //nie wie który developer 
        Game newGame = new Game(Developer.getName(), String gameName);

    }
}
