package uz.pdp.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.pdp.model.Attachment;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AttachmentRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer save(Attachment attachment) {
        String sql = """
        insert into security.attachment (original_name, generated_name, size, content_type) 
        values (:original_name, :generated_name, :size, :content_type)
        """;

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("original_name", attachment.getOriginalName())
                .addValue("generated_name", attachment.getGeneratedName())
                .addValue("size", attachment.getSize())
                .addValue("content_type", attachment.getContentType());


        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, mapSqlParameterSource, keyHolder, new String[]{"id"});

        Number key = keyHolder.getKey();
        return key.intValue();
    }

    public Optional<Attachment> findById(Integer id) {
        String sql = "select * from security.attachment where id = :id";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        try {

            Attachment attachment = namedParameterJdbcTemplate.queryForObject(sql, mapSqlParameterSource, BeanPropertyRowMapper.newInstance(Attachment.class));
            return Optional.ofNullable(attachment);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
