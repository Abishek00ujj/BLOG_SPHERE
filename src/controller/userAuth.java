package controller;

import java.util.LinkedHashMap;
import Model.user;
public class userAuth
{
    LinkedHashMap<String,user> users=new LinkedHashMap<String, user>();

    public boolean register(String name,String id,String password)
    {
        users.put(id,new user(name,id,password));
        return true;
    }

    public boolean login(String id,String password)
    {
        String correctPass=users.get(id).password;
        return correctPass.equals(password);
    }

    public boolean isUser(String id)
    {
        return users.containsKey(id);
    }

    public user getUser(String id)
    {
        return users.get(id);
    }

    public String getName(String id)
    {
        return users.get(id).name;
    }
}
