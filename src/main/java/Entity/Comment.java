package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Comment extends BasicClass {
    private String text;

    public Comment(Integer id, String text) {
        super(id);
        this.text = text;
    }

    public Comment(Integer id, String text, Tweet tweet) {
        super(id);
        this.text = text;
        this.tweet = tweet;
    }

    @ManyToOne
    private Tweet tweet;

//    @ManyToOne()
//    private Comment comment;
/*    @OneToMany(fetch = FetchType.EAGER,mappedBy = "comment")
    private List<Comment> commentList = new ArrayList<>();*/
//    public void addComment(Comment comment){
//        commentSet.add(comment);
//        comment.addComment(this);
//    }
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "commentSet",fetch = FetchType.EAGER)
    private Set<Comment> reply = new HashSet<>();

    @JoinTable(name = "reply",
            joinColumns = {@JoinColumn(name = "comment_id")},
            inverseJoinColumns = {@JoinColumn(name = "reploy_id")})
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Comment> commentSet = new HashSet<>();

    public void addReply(Comment comment) {
        commentSet.add(comment);
        comment.getReply().add(this);
    }

    public void removeFollower(Comment toFollow) {
        commentSet.remove(toFollow);
        toFollow.getReply().remove(this);
    }


/*    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", tweet=" + tweet +
                ", comment=" + comment +
                ", commentList=" + commentList +
                ", comment=" + comment +
                ", reply=" + reply +
                "} " + super.toString();
    }*/
}
