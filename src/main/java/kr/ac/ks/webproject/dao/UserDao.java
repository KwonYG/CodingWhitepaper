package kr.ac.ks.webproject.dao;

import javax.sql.DataSource;

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
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("service_user").usingGeneratedKeyColumns("id");
	}
	
	public Long insert(ServiceUser serviceUser) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(serviceUser);
		return insertAction.executeAndReturnKey(params).longValue();
	}
}
