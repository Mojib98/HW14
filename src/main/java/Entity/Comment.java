package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @ManyToOne
    private Comment comment;
    @OneToMany(mappedBy = "comment")
    private List<Comment> commentList;

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", tweet=" + tweet +
                ", comment=" + comment +
                ", commentList=" + commentList +
                "} " + super.toString();
    }
}
