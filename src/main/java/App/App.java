package App;

import Entity.Account;

import java.util.Scanner;

public class App {
    AccountApp accountApp = new AccountApp();
    TwitterSystem twitterSystem = new TwitterSystem();
    Scanner scanner = new Scanner(System.in);
    Account account;
    public void menu(){
        System.out.println("\t\tWelcome\n" +
                "\t\tfor singUp insert 1\n" +
                "\t\telse insert any key to continue\n");
        int section = scanner.nextInt();
        if (section==1){
            accountApp.singUp();
        }else {
            if (accountApp.logIn()){
                menuUser();
            }
        }
    }
    private void menuUser(){
        boolean isRun=true;
        this.account = accountApp.myAccount();
        while (isRun){
            System.out.println("\tfor see your tweet insert 1\n" +
                    "\tfor see All tweet insert 2\n" +
                    "\tfor see tweet whit id insert 3\n" +
                    "\tfor see tweet for userName insert 4\n" +
                    "\tfor tweeting insert 5\t" +
                    "");
            int section = scanner.nextInt();
            switch (section){
                case 1:
                    System.out.println(account);
                    twitterSystem.userTweet(this.account);
                    break;
                case 2:
                   twitterSystem.allTweet();
                   break;
                case 3:
                    twitterSystem.seeTweetWithId();
                    break;
                case 4:
                    Account account1= accountApp.findByName();
                    twitterSystem.userTweet(account1);
                    break;
                case 5:
                    twitterSystem.writeTweet(this.account);
                    break;
                case 6:
            }
        }
    }
}
