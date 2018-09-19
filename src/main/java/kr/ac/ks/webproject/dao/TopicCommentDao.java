package kr.ac.ks.webproject.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.ac.ks.webproject.dto.TopicComment;

@Repository
public class TopicCommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<TopicComment> rowMapper = BeanPropertyRowMapper.newInstance(TopicComment.class);
	
	public TopicCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("topic_comment").usingGeneratedKeyColumns("id");
	}
	
	public Long insert(TopicComment topicComment) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(topicComment);
		return insertAction.executeAndReturnKey(params).longValue();
	}
}
