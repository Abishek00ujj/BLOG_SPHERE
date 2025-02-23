package controller;

import java.util.*;

import Model.comment;
import Model.user;
import Model.blog;
public class blogs {
    LinkedHashMap<blog, String> blogs = new LinkedHashMap<>();
    
    LinkedHashMap<String,comment> allComments=new LinkedHashMap<>();

    public boolean add_blog(String userid, String title, String about, String content) {
        Random random = new Random();
        String blogid = Integer.toString(100000 + random.nextInt(900000));
        blogs.put(new blog(userid, title, about, content, new HashSet<user>(), new HashMap<comment, String>()), blogid);
        return true;
    }

    public ArrayList<blog> my_blogs(String id) {

        ArrayList<blog> myBlogs = new ArrayList<>();

        for (Map.Entry<blog, String> e : blogs.entrySet()) {
            if (e.getValue().equals(id)) {
                myBlogs.add(e.getKey());
            }
        }
        return myBlogs;
    }

    public ArrayList<blog> all_blogs() {
        return new ArrayList<>(blogs.keySet());
    }
    
    public boolean isBlogsAvailable()
    {
        return blogs.size()>=1;
    }
    
    public boolean addComment(String id,String blogid,String comments)
    {
        Random random = new Random();
        String commentId = Integer.toString(100000 + random.nextInt(900000));
        allComments.put(blogid,new comment(id,comments,blogid,commentId));
        return true;
    }

}
