package App;

import Entity.Account;
import Entity.Tweet;
import Service.imp.TweetService;

import java.util.List;
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
    public void userTweet(Account account){
        List<Tweet> list = tweetService.findAllMyTweet(account);
        list.forEach(System.out::println);
    }
    public void seeAllTweet(){
        List<Tweet> list = tweetService.findAll();
        list.forEach(System.out::println);
    }
    public void seeTweetWithId(){
        System.out.print("\tplease insert id: ");
       int idT=scanner.nextInt();
        Tweet tweet = tweetService.findById(idT);
    }
    public void like(){
        System.out.println("\tplease insert tweet id for like");
        int id = scanner.nextInt();
        tweetService.like(id);
    }
    public void dislike(){
        System.out.println("\tplease insert tweet id for like");
        int id = scanner.nextInt();
        tweetService.dislike(id);
    }
    public void allTweet(){
        List<Tweet> list = tweetService.findAll();
        list.forEach(System.out::println);
    }
}
