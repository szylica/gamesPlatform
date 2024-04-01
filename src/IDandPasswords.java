import java.util.HashMap;

public class IDandPasswords {
    static HashMap<String, Pair<String, Developer>> loginPasswordDev = new HashMap<>();
    static HashMap<String, Pair<String, User>> loginPasswordUser = new HashMap<>();

    protected HashMap getDevLoginInfo(){
        return loginPasswordDev;
    }

    protected HashMap getUserLoginInfo(){
        return loginPasswordUser;
    }
}
