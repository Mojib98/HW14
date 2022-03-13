package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
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
    @ColumnDefault("0")
    private Integer like;
    private Integer dislike;
    @ManyToOne
    private Account account;

    public Tweet(Integer id, String text, Account account) {
        super(id);
        this.text = text;
        this.account = account;
    }

    public Tweet(Integer id, String text) {
        super(id);
        this.text = text;
    }
}
