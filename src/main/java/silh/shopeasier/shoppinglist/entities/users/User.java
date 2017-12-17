package silh.shopeasier.shoppinglist.entities.users;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "login", unique = true, length = 50)
    private String login;

    @Column(name = "password", length = 255)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getId());
    }
}
