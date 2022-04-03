package Entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BasicClass {
    @Id()
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Override
    public String toString() {
        return "\n\t" +
                "id=" + id;
    }
}
