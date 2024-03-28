

public class Client {
    String name;
    String lastName;
    String login;
    String password;
    


    public Client(String name,String lastName, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = setPassword(password);
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

    public String setPassword(String passwordSet) {
        if (passwordSet.length() < 8) {
            return "Password is too short!";
        }
        else {
            return passwordSet;
        }
    }



}
