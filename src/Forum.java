import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alexanderhughes on 2/11/16.
 */
public class Forum {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();
        Scanner consoleScanner = new Scanner(System.in);

        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");       //takes to backslashes to escape a functionality of | character in a String
            Post post = new Post(Integer.valueOf(columns[0]), columns[1], columns[2]);
            posts.add(post);
        }

        int replyId = -1;
        while (true) {
            //loop over posts and print the ones with the right reply id
            int id = 0;
            for (Post post : posts) {
                if (post.replyId == replyId) {
                    System.out.printf("(%d) %s by %s\n", id, post.text, post.author);
                }
                id++;
            }
            //ask the user to type a new reply id to see replies to that post
            System.out.print("Type the id of the thread you want to view: ");
            replyId = Integer.valueOf(consoleScanner.nextLine());

        }
    }
}
