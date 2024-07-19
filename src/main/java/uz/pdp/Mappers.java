package uz.pdp;

import org.springframework.jdbc.core.RowMapper;

public interface Mappers {

    RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> User.builder()
            .id(rs.getInt("id"))
            .username(rs.getString("username"))
            .password1(rs.getString("password"))
            .age(rs.getInt("age"))
            .build();



}
