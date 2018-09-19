package kr.ac.ks.webproject.dao;

import static kr.ac.ks.webproject.sqls.QuestionDaoSqls.SELECT_PAGING;
import static kr.ac.ks.webproject.sqls.QuestionDaoSqls.SELECT_QUESTION_BY_ID;

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

import kr.ac.ks.webproject.dto.Question;

@Repository
public class QuestionDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Question> rowMapper = BeanPropertyRowMapper.newInstance(Question.class);
	
	public QuestionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("question").usingGeneratedKeyColumns("id");
	}
	
	public Long insert(Question question) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(question);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public List<Question> selectAll(Integer start, Integer limit){
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit",limit);
		return jdbc.query(SELECT_PAGING, params, rowMapper);
	}
	
	
	public Question selectQeustionById(Integer questionId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("questionId",questionId);
		
		return jdbc.queryForObject(SELECT_QUESTION_BY_ID, params, rowMapper);
	}
}
