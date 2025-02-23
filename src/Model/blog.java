package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class blog
{
    public String title;
    public String about;
    public String content;
    public String id;

    HashSet<user> likes=new HashSet<>();

    HashMap<comment,String> comments=new HashMap<>();

    public blog(String id,String title,String about,String content,HashSet<user> likes,HashMap<comment,String> comments)
    {
        this.id=id;
        this.title=title;
        this.about=about;
        this.content=content;
        this.likes=likes;
        this.comments=comments;
    }
}
