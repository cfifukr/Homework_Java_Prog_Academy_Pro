package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class UserList implements Iterable<User> {
    public final List<User> users = new ArrayList<>();

    private static final UserList userList = new UserList();



    public static UserList getInstance() {
        return userList;
    }



    public synchronized void add(User m) {
        if(!users.contains(m)){
            users.add(m);
        }
    }
    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }


}
