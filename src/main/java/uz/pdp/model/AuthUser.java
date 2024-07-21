package uz.pdp.model;

import lombok.*;

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
    private String role;

}
