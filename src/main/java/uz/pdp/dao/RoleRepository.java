package uz.pdp.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import uz.pdp.model.AuthRole;
import uz.pdp.model.AuthUser;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleRepository {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;


    public List<AuthRole> findByUserId(Integer userId) {
        System.out.println("userId = " + userId);
        String sql = """
                select ar.* from security.user_role ur
                join security.auth_role ar on ar.id = ur.role_id
                where ur.user_id = :userId""";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId);
        try {
            return namedJdbcTemplate.query(sql, params, BeanPropertyRowMapper.newInstance(AuthRole.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
