package View;

public class Blogs {

    public static void printBlog(String name, String title, String subject, String content)
    {
        System.out.println("--------------------------------posted by: "+name+"---------");
        System.out.println();
        System.out.println("  "+title);
        System.out.println();
        System.out.println("Subject : "+subject);
        System.out.println();
        System.out.println(content);
    }
}
