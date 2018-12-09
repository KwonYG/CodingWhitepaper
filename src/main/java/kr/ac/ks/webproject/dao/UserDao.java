package kr.ac.ks.webproject.dao;

import static kr.ac.ks.webproject.sqls.UserDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.ac.ks.webproject.dto.ServiceUser;

@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ServiceUser> rowMapper = BeanPropertyRowMapper.newInstance(ServiceUser.class);

	public UserDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("service_user")
				.usingGeneratedKeyColumns("id");
	}

	public List<ServiceUser> selectAllByQuestionCount(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);

		return jdbc.query(USER_ORDER_BY_QUESTION_COUNT, params, rowMapper);
	}

	public List<ServiceUser> selectAllByAnswerCount(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);

		return jdbc.query(USER_ORDER_BY_ANSWER_COUNT, params, rowMapper);
	}

	public int selectCountUserByServiceId(String serviceId) {
		Map<String, String> params = new HashMap<>();
		params.put("serviceId", serviceId);

		return jdbc.queryForObject(GET_COUNT_USER_BY_SERVICE_ID, params, Integer.class);
	}

	public int slectCountUserByEmail(String email) {
		Map<String, String> params = new HashMap<>();
		params.put("email", email);

		return jdbc.queryForObject(GET_COUNT_USER_EMAIL_BY_EMAIL, params, Integer.class);
	}

	public Long insert(ServiceUser serviceUser) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(serviceUser);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public int deleteById(long userId) {
		Map<String, ?> params = Collections.singletonMap("userId", userId);
		return jdbc.update(DELETE_USER_BY_USER_ID, params);
	}

	public int updateQuestionCountById(long userId, int count) {
		Map<String, Object> params = new HashMap<>();
		params.put("count", count);
		params.put("userId", userId);

		return jdbc.update(UPDATE_QUESTION_COUNT_BY_ID, params);
	}

	public int updateAnswerCountById(long userId, int count) {
		Map<String, Object> params = new HashMap<>();
		params.put("count", count);
		params.put("userId", userId);

		return jdbc.update(UPDATE_ANSWER_COUNT_BY_ID, params);
	}

	public ServiceUser selectOneUserByUserId(Long userId) {
		Map<String, Long> params = new HashMap<>();
		params.put("userId", userId);

		return jdbc.queryForObject(SELELCT_ONE_USER_BY_USER_ID, params, rowMapper);
	}

	public ServiceUser selectOneUserByServiceId(String serviceId) {
		Map<String, String> params = new HashMap<>();
		params.put("serviceId", serviceId);

		try {
			return jdbc.queryForObject(SELECT_ONE_USER_BY_SERVICE_ID, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
