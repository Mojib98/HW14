package Entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Account extends BasicClass {
    @Column(unique = true, nullable = false)
    private Integer userId;
    @Column(unique = true, nullable = false)
    private String userName;
    private Integer passCode;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "following", fetch = FetchType.EAGER)
    private Set<Account> followers = new HashSet<>();
    @JoinTable(name = "followers",
            joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Account> following = new HashSet<>();

    public void addFollower(Account toFollow) {
        following.add(toFollow);
        toFollow.getFollowers().add(this);
    }

    public void removeFollower(Account toFollow) {
        following.remove(toFollow);
        toFollow.getFollowers().remove(this);
    }

    public Account(Integer id, Integer userId, String userName, Integer passCode) {
        super(id);
        this.userId = userId;
        this.userName = userName;
        this.passCode = passCode;
    }

    @Override
    public String toString() {
        return  super.toString()+"\n\tAccount{" +
                "\n\tuserId=" + userId +
                "\n\t, userName='" + userName + '\'' +
                "\n} " ;
    }
}
