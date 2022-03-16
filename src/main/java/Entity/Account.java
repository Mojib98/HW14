package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Account extends BasicClass{
/*    @Id()
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;*/


    @Column(unique = true,nullable = false)
    private Integer userId;
    @Column(unique = true,nullable = false)
    private String userName;
    private Integer passCode;
   /* @OneToMany(mappedBy = "account")
    private List<Tweet> tweet;*/
    /*@ManyToMany
    @JoinTable(
            name = "follower",
           joinColumns =  @JoinColumn(name = "id "),
            inverseJoinColumns = @JoinColumn(name = "id2")
    )*/
//    private Set<Account> accounts;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following",fetch = FetchType.EAGER)
    private Set<Account> followers = new HashSet<>();

    @JoinTable(name = "followers",
            joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Account> following = new HashSet<>();

    public void addFollower(Account toFollow) {
        following.add(toFollow);
        toFollow.getFollowers().add(this);
    }

    public void removeFollower(Account toFollow) {
       boolean os= following.remove(toFollow);
        System.out.println(os);
        toFollow.getFollowers().remove(this);
    }
    public Account(Integer id, Integer userId, String userName, Integer passCode) {
        super(id);
        this.userId = userId;
        this.userName = userName;
        this.passCode = passCode;
    }
   /* @OneToMany(mappedBy = "account")
    private List<Tweet> tweet;
*/
/*    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                "} " + super.toString();
    }*/
}
