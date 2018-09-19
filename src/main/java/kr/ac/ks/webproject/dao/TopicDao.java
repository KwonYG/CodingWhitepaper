package kr.ac.ks.webproject.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.ac.ks.webproject.dto.Topic;

@Repository
public class TopicDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Topic> rowMapper = BeanPropertyRowMapper.newInstance(Topic.class);
	
	public TopicDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("topic").usingGeneratedKeyColumns("id");
	}
	
	public Long insert(Topic topic) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(topic);
		return insertAction.executeAndReturnKey(params).longValue();
	}
}
