package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "commentSet", fetch = FetchType.EAGER)
    private Set<Comment> reply = new HashSet<>();

    @JoinTable(name = "reply",
            joinColumns = {@JoinColumn(name = "comment_id")},
            inverseJoinColumns = {@JoinColumn(name = "reploy_id")})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> commentSet = new HashSet<>();

    public void addReply(Comment comment) {
        commentSet.add(comment);
        comment.getReply().add(this);
    }

    public void removeFollower(Comment toFollow) {
        commentSet.remove(toFollow);
        toFollow.getReply().remove(this);
    }


}
