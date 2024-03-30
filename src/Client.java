

public class Client {

    //COMPONENTS
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

    //NAME GETTER
    public String getName() {
        return name;
    }

    //NAME SETTER
    public void setName(String nameSet) {
        name = nameSet;
    }

    //NAME GETTER
    public String getLastName() {
        return lastName;
    }

    //LAST NAME SETTER
    public void setLastName(String lastNameSet) {
        lastName = lastNameSet;
    }
    
    //LOGIN GETTER
    public String getLogin() {
        return login;
    }
    
    //LOGIN SETTER
    public void setLogin(String loginSet) {
        login = loginSet;
    }

    //PASSWORD GETTER
    public String getPassword() {
        return password;
    }

    //PASSWORD SETTER
    public String setPassword(String passwordSet) {
        if (passwordSet.length() < 8) {
            return "Password is too short!";
        }
        else {
            this.password = passwordSet;
            return "";
        }
    }



}
