package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tweet extends BasicClass {
 /*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/
    @Column(length = 280,nullable = false)
    private String text;
//    @ColumnDefault("0"
    @Column(columnDefinition = "integer default 0")
    private Integer likes=0;
    @ColumnDefault("0")
    private Integer dislike=0;
    @ManyToOne()
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
/*  @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                ", likes=" + likes +
                ", dislike=" + dislike +
                ", account=" + account +

                "} " + super.toString();
    }*/


}
