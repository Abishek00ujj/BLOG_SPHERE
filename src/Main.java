import View.Blogs;
import controller.blogs;
import controller.userAuth;
import Model.user;
import java.sql.SQLOutput;
import java.util.*;

import Model.blog;


public class Main {
    public static void main(String[] args)
    {
        int LoginFlag=0;

        user userData=null;
        userAuth userauth=new userAuth();
        blogs blog=new blogs();
        Scanner sc=new Scanner(System.in);
        System.out.println("BLOG-SPHERE");
        System.out.println("ENTER 1 TO START!");
        int w=Integer.parseInt(sc.nextLine());

        if(w!=1)
        {
            System.out.println("Sorry try again later!");
        }


        while(true) {
            if (LoginFlag != 1 && userData==null) {
                System.out.println("1.REGISTER");
                System.out.println("2.LOGIN");
                System.out.println("Please choose an option!");
                int x = Integer.parseInt(sc.nextLine());
                if (x == 1) {
                    System.out.println("-------------------------REGISTER------------------------------");

                    System.out.println("ENTER YOUR NAME: ");
                    String name = sc.nextLine();
                    System.out.println("ENTER YOUR PHONE NUMBER: ");
                    String phoneno = sc.nextLine();
                    System.out.println("ENTER YOUR PASSWORD: ");
                    String password1 = sc.nextLine();
                    System.out.println("RE-ENTER YOUR PASSWORD: ");
                    String password2 = sc.nextLine();
                    if (!password2.equals(password1)) {
                        System.out.println("Passwords not matched!");
                        System.out.println("Please try again later");
                    } else {
                        if (userauth.register(name, phoneno, password1)) {
                            System.out.println("USER REGISTERED SUCCUESSFULLY!");
                        } else {
                            System.out.println("Sorry, some technical error, please try again later");
                        }
                    }
                } else if (x == 2) {
                     System.out.println("-------------------------LOGIN--------------------------------");
                    System.out.println("ENTER YOUR PHONE NUMBER : ");
                    String phoneno = sc.nextLine();
                    System.out.println("ENTER YOUR PASSWORD : ");
                    String password = sc.nextLine();
                    if (!userauth.isUser(phoneno)) {
                        System.out.println("User not found!");
                        break;
                    }
                    if (userauth.login(phoneno, password)) {
                        System.out.println("USER LOGGED IN SUCCUESSFULLY!");
                        userData = userauth.getUser(phoneno);
                        LoginFlag = 1;
                    }
                }
            }
            else
            {
                    System.out.println("---------------------------BLOG-SPHERE------------------------");
                    System.out.println();
                    System.out.println("-----------------------------------Logged in as "+userData.name);
                System.out.println("1.addBlog");
                System.out.println("2.view all blogs");
                System.out.println("3.view my blogs");
                System.out.println("4.Logout");
                int option=Integer.parseInt(sc.nextLine());

                if(option==1) {
                    System.out.println("--------------------------blog writing area-----------------------------");

                    System.out.println("ENTER THE TITLE: ");

                    String title = sc.nextLine();
                    System.out.println("ENTER THE SUBJECT: ");
                    String subject = sc.nextLine();

                    System.out.println("ENTER THE CONTENT: ");
                    String content = sc.nextLine();

                    if (title.isEmpty() && subject.isEmpty() && content.isEmpty()) {
                        System.out.println("Please fill all the columns");
                        break;
                    }

                    System.out.println("THIS IS DEMO: ");
                    Blogs.printBlog(userData.name,title,subject,content);
                    System.out.println();
                    System.out.println("Are you sure>> want to post this blog as your post!");
                    System.out.println("Press/type CONFIRM to post.");

                    String confirm=sc.nextLine();
                    if(!confirm.toLowerCase().equals("confirm"))
                    {
                        System.out.println("Please try again later");
                        System.out.println("Blog posting failed!");
                    }
                    else {
                        if (blog.add_blog(userData.id, title, subject, content)) {
                            System.out.println("Blog is posting........");
                            System.out.println();
                            System.out.println("Blog is posted successfully!");
                        }
                    }
                }
                else if(option==2)
                {
                    if(blog.isBlogsAvailable())
                    {
                        ArrayList<blog> Allblogs=blog.all_blogs();
                        for(blog b:Allblogs)
                        {
                            String name=userauth.getName(b.id);
                            Blogs.printBlog(name,b.title,b.about,b.content);
                        }
                    }
                    else
                    {
                        System.out.println("Sorry no blogs available");
                    }
                }
                else if(option==3) {
                    if (blog.isBlogsAvailable()) {
                        ArrayList<blog> Allblogs = blog.my_blogs(userData.id);
                        for (blog b : Allblogs) {
                            String name = userauth.getName(b.id);
                            Blogs.printBlog(name, b.title, b.about, b.content);
                        }
                    } else {
                        System.out.println("Sorry no blogs available");
                    }
                }
                else if(option==4)
                {
                    System.out.println("------------------------------------LOGOUT------------------------------------------");

                    System.out.println("Are you sure want to logout");
                    System.out.println("Type Confirm to logout..");

                    System.out.println();

                    String confirm=sc.nextLine();
                    if(confirm.toLowerCase().equals("confirm"))
                    {
                        System.out.println(userData.name+" is Logging out.....");
                        userData=null;
                        LoginFlag=0;
                        System.out.println();
                    }
                }
            }
        }
    }
}