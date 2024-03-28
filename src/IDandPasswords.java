import java.util.HashMap;

public class IDandPasswords {
    static HashMap<String, String> loginDev = new HashMap<String, String>();
    static HashMap<String, String> loginUser = new HashMap<String, String>();

    IDandPasswords(){
        loginUser.put("Bro","pizza");
    }

    protected HashMap getDevLoginInfo(){
        return loginDev;
    }

    protected HashMap getUserLoginInfo(){
        return loginUser;
    }
}
