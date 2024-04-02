import java.util.HashMap;

public class IDandPasswords {
    static HashMap<String, Pair<String, Developer>> loginPasswordDev = new HashMap<>();
    static HashMap<String, Pair<String, User>> loginPasswordUser = new HashMap<>();

    protected String getUserPassword(String key){
        Pair<String, User> pair = loginPasswordUser.get(key);
        if (pair != null){
            return pair.getFirstValue();
        }
        return null;
    }

    protected String getDevPassword(String key){
        Pair<String, Developer> pair = loginPasswordDev.get(key);
        if (pair != null){
            return pair.getFirstValue();
        }
        return null;
    }

    protected User getUserObject(String key){
        Pair<String, User> pair = loginPasswordUser.get(key);
        if (pair != null){
            return pair.getSecondValue();
        }
        return null;
    }

    protected Developer getDevObject(String key){
        Pair<String, Developer> pair = loginPasswordDev.get(key);
        if (pair != null){
            return pair.getSecondValue();
        }
        return null;
    }
}
