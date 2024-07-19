package uz.pdp;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String password1;
    private int age;

    public static void main(String[] args) {
    }
}
