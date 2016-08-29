package io.github.walterinsh.springh2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

import java.util.List;

/**
 * Created by Walter on 8/21/16.
 */
public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void save(String student) {
        if (StringUtils.isBlank(student)) {
            throw new IllegalArgumentException();
        }
        jdbcTemplate.update("insert into student(name) values(?)", student);
    }

    public String getName(int id){
        List<String> result = jdbcTemplate.query("select name from student where id = ?", new SingleColumnRowMapper<String>(), id);
        return result.isEmpty()?null: result.get(0);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
