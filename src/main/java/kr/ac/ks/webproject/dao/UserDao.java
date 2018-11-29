package kr.ac.ks.webproject.dao;

import static kr.ac.ks.webproject.sqls.QuestionDaoSqls.SELECT_QUESTION_BY_ID;
import static kr.ac.ks.webproject.sqls.UserDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
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

	public Long insert(ServiceUser serviceUser) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(serviceUser);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public int deleteById(long userId) {
		Map<String, ?> params = Collections.singletonMap("userId", userId);
		return jdbc.update(DELETE_USER_BY_USER_ID, params);
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
