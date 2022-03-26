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
                    "\tfor tweeting insert 5\n" +
                    "\tfor find user insert 6\n" +
                    "\tfor All user insert 7\n" +
                    "\tfor see your profile insert 8\n" +
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
                    Tweet tweet2 = twitterSystem.seeTweetWithId();
                    System.out.println("\nuserName :"+tweet2.getAccount().getUserName()+"" +
                            "\n\ttweet is :"+tweet2.getText()+"" +
                            "\n\t like: "+tweet2.getLikes()+"" +
                            "\n\tcomment :"+tweet2.getComments());
//                    actionForPost();
                    List<Comment> comments2 = twitterSystem.showComment();
                    comments2.forEach(System.out::println);
                    Comment comment = addReploy(tweet2);
                  //  twitterSystem.addReploye(comment);
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
                    accountApp.findByName();
                    following();
                    break;
                case 7:
                    accountApp.showAllUser();
                    following();
                    break;
                case 8:
                    profile();


            }
        }
    }

    private void actionForPost() {
        System.out.println("\tfor like insert like\n" +
                "\tfor comment insert comment\n" +
                "\t");
        String select = scanner.next();
        switch (select) {
            case "like":
                twitterSystem.like();
            case "comment":
                twitterSystem.addComment();
            case "exit":
                return;
        }
    }

    private Comment addReploy(Tweet tweet2) {
        System.out.print("insert id : ");
        int id = scanner.nextInt();
        Comment comment = twitterSystem.findById(id);
        System.out.println("please insert repolye");
        String text = scanner.next();
        System.out.println();
        Comment comment1 = new Comment(null, text, null);
//        comment.addReply(comment1);
        //  comment.addComment(comment1);
        twitterSystem.commment(comment1,comment);
        return comment;


    }

    private void following() {
        System.out.println("\tfor follow any of user please insert follow else exit ");
        String select = scanner.next().trim();
        switch (select) {
            case "follow":
                Account account2 = accountApp.myAccount();
                Account account1 = accountApp.findByName();
                account.addFollower(account1);
                accountApp.follow(account);
                break;
            case "exit":
                break;
        }

    }
    private void profile(){
        System.out.println("\tfor change password insert pass \n" +
                "\tfor see your information insert info\n" +
                "\tfor see your followin insert fllow");
        String select=scanner.next().trim();
        switch (select){
            case "pass":
                accountApp.changePassword();
                break;
            case "info":
                Account a= accountApp.myAccount();
                System.out.println("\tyour name :"+a.getUserName()+"\n\t" +
                        "you userId: "+a.getUserId()+"\n\t" +
                        "your follower : "+a.getFollowers()+"\n\t" +
                        "your following : "+a.getFollowing()
                );
                unfollowing(a);
                break;
        }
    }
    private void unfollowing(Account account2){
        System.out.println("\tfor follow any of user please insert unfollow else exit ");
        String select = scanner.next().trim();
        switch (select) {
            case "unfollow":
                Account account1 = accountApp.findByName();
                System.out.println(account1);
                account2.removeFollower(account1);
                System.out.println("\tyour name :"+account2.getUserName()+"\n\t" +
                        "you userId: "+account2.getUserId()+"\n\t" +
                        "your follower : "+account2.getFollowers()+"\n\t" +
                        "your following : "+account2.getFollowing()
                );
                accountApp.follow(account2);
                break;
            case "exit":
                break;
        }
    }

}
