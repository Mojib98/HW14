package App;

import Entity.Account;
import Entity.Comment;
import Entity.Tweet;
import Service.imp.CommentService;
import Service.imp.TweetService;

import java.util.List;
import java.util.Scanner;

public class TwitterSystem {
    int idT;
    TweetService tweetService=new TweetService();
    Scanner scanner = new Scanner(System.in);
    CommentService commentService = new CommentService();
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
    public Tweet seeTweetWithId(){
        System.out.print("\tplease insert id: ");
        this.idT=scanner.nextInt();
        Tweet tweet = tweetService.findById(idT);
        return tweet;
    }
    public void like(){
        System.out.println("\tif like any tweet" +
                " please insert id for like \n" +
                "\t else insert 0");

        int id = scanner.nextInt();
        if (id == 0){
            return;
        }
        tweetService.like(id);
    }
    public void dislike(){
        System.out.println("\tplease insert tweet id for like");
        int id = scanner.nextInt();
        tweetService.dislike(id);
    }
    public void allTweet(){
        List<Tweet> list = tweetService.findAll();
        list.stream().forEach(System.out::println);
    }
    public void addComment(){
        System.out.println("\tplease insert id tweet\n");
        int idT = scanner.nextInt();
        Tweet tweet = tweetService.findById(idT);
        System.out.println("please add Comment");
        String text = scanner.next();
        Comment comment = new Comment(null,text,tweet);
        commentService.addComment(comment);
    }
    public List<Comment> showComment(){
        List<Comment> comments = null;
        comments=commentService.findAll(this.idT);
        return comments;
    }
    public Comment findById(Integer id){
        return commentService.findById(id);
    }
    public void addReploye(Comment comment){
        commentService.reply(comment);
    }
}
