package uz.pdp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "insert into users (username, password, age) values (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword1(), user.getAge());
    }

    public User findById(Integer id) {
        String sql = "select * from users where id = ?";
        return jdbcTemplate.queryForObject(sql, Mappers.USER_ROW_MAPPER, id);
    }

    public User findById2(Integer id) {
        String sql = "select * from users where id = ?";
//        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        BeanPropertyRowMapper.newInstance(User.class);
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
    }

}
