package uz.pdp.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import uz.pdp.model.AuthUser;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepository {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;
//    private final JdbcTemplate jdbcTemplate;

    public Integer save(AuthUser authUser) {
        String sql = "INSERT INTO auth_user (username, password, role) VALUES" +
                " (:username, :password, :role)";
//        Map<String , Object> params = Map.of(
//                "username", authUser.getUsername(),
//                "password", authUser.getPassword(),
//                "role", authUser.getRole()
//        );
//        namedJdbcTemplate.update(sql, params);
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("username", authUser.getUsername())
                .addValue("password", authUser.getPassword())
                .addValue("role", authUser.getRole());
        namedJdbcTemplate.update(sql, params);
        return 1;
    }

    public Optional<AuthUser> findByUsername(String username) {
        String sql = "SELECT * FROM auth_user WHERE username = :username";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("username", username);
        AuthUser authUser = namedJdbcTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(AuthUser.class));
        return Optional.ofNullable(authUser);
    }

}
