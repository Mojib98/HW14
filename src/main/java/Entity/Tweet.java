package Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tweet extends BasicClass {
    @Column(length = 280,nullable = false)
    private String text;
    @Column(columnDefinition = "integer default 0")
    private Integer likes=0;
    @ColumnDefault("0")
    private Integer dislike=0;
    @ManyToOne(fetch =FetchType.EAGER)
    private Account account;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "tweet")
    private List<Comment> comments ;
    public Tweet(Integer id, String text, Account account) {
        super(id);
        this.text = text;
        this.account = account;
    }
    public Tweet(Integer id, String text) {
        super(id);
        this.text = text;
    }

    @Override
    public String toString() {
        return  super.toString()+"\n\tTweet{" +
                "\n\ttext='" + text + '\'' +
                "\n\t, likes=" + likes +
                "\n\t, account=" + account +
                "\n\t, comments=" + comments +
                "} " ;
    }
}
