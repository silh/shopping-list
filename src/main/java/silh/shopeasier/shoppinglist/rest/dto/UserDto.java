package silh.shopeasier.shoppinglist.rest.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class UserDto {
    private Long id;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='******\'" +
                '}';
    }
}
