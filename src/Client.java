package library;

public class Client {
    String name;
    String lastName;
    String login;
    String password;


    public Client(String nameC,String lastNameC, String loginC, String passwordC) {
        name = nameC;
        lastName = lastNameC;
        login = loginC;
        password = passwordC;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameSet) {
        name = nameSet;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastNameSet) {
        lastName = lastNameSet;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String loginSet) {
        login = loginSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordSet) {
        if (passwordSet.length() < 8) {
            System.out.println("Password is too short!");
        }
        else{
            password = passwordSet;
        }
    }



}
