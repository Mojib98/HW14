package App;

import Entity.Account;
import Entity.Comment;
import Entity.Tweet;

import java.util.List;
import java.util.Scanner;

public class App {
    AccountApp accountApp = new AccountApp();
    TwitterSystem twitterSystem = new TwitterSystem();
    Scanner scanner = new Scanner(System.in);
    Account account;

    public void menu() {
        System.out.println("\t\tWelcome\n" +
                "\t\tfor singUp insert 1\n" +
                "\t\telse insert any key to continue\n");
        int section = scanner.nextInt();
        if (section == 1) {
            accountApp.singUp();
        } else {
            if (accountApp.logIn()) {
                menuUser();
            }
        }
    }

    private void menuUser() {
        boolean isRun = true;
        this.account = accountApp.myAccount();
        while (isRun) {
            System.out.println("\tfor see your tweet insert 1\n" +
                    "\tfor see All tweet insert 2\n" +
                    "\tfor see tweet whit id insert 3\n" +
                    "\tfor see tweet for userName insert 4\n" +
                    "\tfor tweeting insert 5\t" +
                    "");
            int section = scanner.nextInt();
            switch (section) {
                case 1:
                    System.out.println(account);
                    twitterSystem.userTweet(this.account);
                    break;
                case 2:
                    twitterSystem.allTweet();
                    actionForPost();
                    break;
                case 3:
                  Tweet tweet2= twitterSystem.seeTweetWithId();
                    System.out.println(tweet2);
//                    actionForPost();
                    List<Comment> comments2=twitterSystem.showComment();
                    comments2.forEach(System.out::println);
                  Comment comment=  addReploy(tweet2);
                  twitterSystem.addReploye(comment);
                    break;
                case 4:
                    Account account1 = accountApp.findByName();
                    twitterSystem.userTweet(account1);
                    actionForPost();
                    break;
                case 5:
                    twitterSystem.writeTweet(this.account);
                    break;
                case 6:
            }
        }
    }
    private void actionForPost(){
        System.out.println("\tfor like insert like\n" +
                "\tfor comment insert comment\n" +
                "\t");
        String select=scanner.next();
        switch (select){
            case "like":
                twitterSystem.like();
            case "comment":
                twitterSystem.addComment();
            case "exit":
                return;
        }
    }
    private Comment addReploy(Tweet tweet2){
        System.out.print("insert id : ");
        int id = scanner.nextInt();
        Comment comment=twitterSystem.findById(id);
        System.out.println("please insert repolye");
        String text = scanner.next();
        System.out.println();
        Comment comment1 = new Comment(null,text,null);
        comment.addComment(comment1);
      //  comment.addComment(comment1);
        return comment;


    }


}
