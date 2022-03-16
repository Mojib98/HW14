package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

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

    @ManyToOne()
    private Comment comment;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "comment")
    private List<Comment> commentList = new ArrayList<>();
    public void addComment(Comment comment){
        commentList.add(comment);
        comment.addComment(this);
    }
    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", comment=" +
                ", commentList=" + commentList +
                "} " + super.toString();
    }
}
