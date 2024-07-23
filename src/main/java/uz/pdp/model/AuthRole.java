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
public class AuthRole {
    private Integer id;
    private String name;
    private String code;
    private List<AuthPermission> permissions;
}
