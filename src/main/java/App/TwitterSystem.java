package App;

import Entity.Account;
import Entity.Tweet;
import Service.imp.TweetService;

import java.util.Scanner;

public class TwitterSystem {
    TweetService tweetService=new TweetService();
    Scanner scanner = new Scanner(System.in);
    public void writeTweet(Account account){
        System.out.println("write your tweet ");
        String text = scanner.next();
        if (checkLengh(text)) {
            Tweet tweet = new Tweet(null, text, account);
            tweetService.add(tweet);
        }else {
            System.out.println("too long ");
        }
    }
    private boolean checkLengh(String text){
      /*  if (text.length()<=280){
            return true;
        }else {
            return false;
        }*/
        return text.length()<=280?true:false;
    }
}
