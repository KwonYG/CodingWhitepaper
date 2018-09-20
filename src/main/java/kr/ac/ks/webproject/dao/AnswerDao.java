package kr.ac.ks.webproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.ac.ks.webproject.sqls.AnswerDaoSqls.*;

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

	public List<Answer> selectAnswers(Integer questionId) {
		Map<String, Integer> params = new HashMap<>();

		params.put("questionId", questionId);

		return jdbc.query(SELECT_ANSWERS_BY_QUESTION_ID, params, rowMapper);
	}
}
