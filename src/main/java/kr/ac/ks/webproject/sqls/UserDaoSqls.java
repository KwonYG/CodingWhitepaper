package kr.ac.ks.webproject.sqls;

public class UserDaoSqls {
	public final static String SELECT_ONE_USER_BY_SERVICE_ID = "SELECT id, service_id, password, name, email, question_count, answer_count, create_date FROM service_user WHERE service_id = :serviceId";
	public final static String SELELCT_ONE_USER_BY_USER_ID = "SELECT id, service_id, password, name, email, question_count, answer_count, create_date FROM service_user WHERE id = :userId;";
	
	public final static String DELETE_USER_BY_USER_ID = "DELETE FROM service_user WHERE id = :userId;";
	
	public final static String USER_ORDER_BY_QUESTION_COUNT = "SELECT id, service_id, name, email, question_count, answer_count FROM service_user ORDER BY question_count DESC limit :start, :limit;";
	public final static String USER_ORDER_BY_ANSWER_COUNT = "SELECT id, service_id, name, email, question_count, answer_count FROM service_user ORDER BY answer_count DESC limit :start, :limit;";
	
	public final static String UPDATE_QUESTION_COUNT_BY_ID = "UPDATE service_user SET question_count = :count WHERE id = :userId;";
	public final static String UPDATE_ANSWER_COUNT_BY_ID = "UPDATE service_user SET answer_count = :count WHERE id = :userId;";
	
	public final static String GET_COUNT_USER_BY_SERVICE_ID = "SELECT COUNT(*) FROM service_user WHERE service_id = :serviceId;";
	public final static String GET_COUNT_USER_EMAIL_BY_EMAIL = "SELECT COUNT(*) FROM service_user WHERE email = :email;";
}
