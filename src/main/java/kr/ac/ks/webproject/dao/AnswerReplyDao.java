package kr.ac.ks.webproject.dao;

import static kr.ac.ks.webproject.sqls.AnswerReplyDaoSqls.SELECT_ALL_ANSWER_REPLIES;

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

import kr.ac.ks.webproject.dto.AnswerReply;

@Repository
public class AnswerReplyDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<AnswerReply> rowMapper = BeanPropertyRowMapper.newInstance(AnswerReply.class);

	public AnswerReplyDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("answer_reply")
				.usingGeneratedKeyColumns("id");
	}

	public Long insert(AnswerReply answerReply) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(answerReply);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public List<AnswerReply> selectAllReplies() {
		Map<String, Long> params = new HashMap<>();

		return jdbc.query(SELECT_ALL_ANSWER_REPLIES, params, rowMapper);
	}
}
