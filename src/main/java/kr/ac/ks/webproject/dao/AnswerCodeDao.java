package kr.ac.ks.webproject.dao;

import static kr.ac.ks.webproject.sqls.AnswerCodeDaoSqls.*;

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

import kr.ac.ks.webproject.dto.AnswerCode;

@Repository
public class AnswerCodeDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<AnswerCode> rowMapper = BeanPropertyRowMapper.newInstance(AnswerCode.class);

	public AnswerCodeDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("answer_code").usingGeneratedKeyColumns("id");
	}

	public Long insert(AnswerCode answerCode) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(answerCode);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public List<AnswerCode> selectAnswerCodes(Long answerId) {
		Map<String, Long> params = new HashMap<>();

		params.put("answerId", answerId);

		return jdbc.query(SELECT_ANSWER_CODES_BY_ANSWER_ID, params, rowMapper);
	}

}
