package kr.ac.ks.webproject.sqls;

public class UserDaoSqls {
	public final static String SELECT_ONE_USER_BY_SERVICE_ID = "SELECT id, service_id, password, name, email, create_date FROM service_user WHERE service_id = :serviceId";
}
