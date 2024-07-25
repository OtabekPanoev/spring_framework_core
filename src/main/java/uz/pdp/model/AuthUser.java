package uz.pdp.model;

import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AuthUser {
    private Integer id;
    private String username;
    private String password;
    private List<AuthRole> roles;
    private boolean isEnabled;

}
