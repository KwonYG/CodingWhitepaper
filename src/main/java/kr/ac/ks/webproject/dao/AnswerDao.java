package kr.ac.ks.webproject.dao;

import static kr.ac.ks.webproject.sqls.AnswerDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.ac.ks.webproject.dto.Answer;

@Repository
public class AnswerDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Answer> rowMapper = BeanPropertyRowMapper.newInstance(Answer.class);

	public AnswerDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("answer").usingGeneratedKeyColumns("id");
	}

	public Long insert(Answer answer) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(answer);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int deleteAnswerById(Long answerId) {
		Map<String, ?> params = Collections.singletonMap("answerId", answerId);
		return jdbc.update(DELETE_ANSWER_BY_ID, params);
	}

	public List<Answer> selectAnswers(Long questionId) {
		Map<String, Long> params = new HashMap<>();

		params.put("questionId", questionId);

		return jdbc.query(SELECT_ANSWERS_BY_QUESTION_ID, params, rowMapper);
	}

	public Answer selectOneAnswer(Long answerId) {
		Map<String, Long> params = new HashMap<>();

		params.put("answerId", answerId);

		return jdbc.queryForObject(SELECT_ONE_ANSWER_BY_ANSWER_ID, params, rowMapper);
	}
}
