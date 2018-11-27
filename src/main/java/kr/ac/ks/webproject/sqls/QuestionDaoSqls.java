package kr.ac.ks.webproject.sqls;

public class QuestionDaoSqls {
	public final static String SELECT_PAGING = "SELECT question.id, title, service_user.name as userName, question.create_date FROM question, service_user WHERE service_user.id = user_id ORDER BY question.id DESC limit :start, :limit;";
	public final static String SELECT_QUESTION_BY_ID = "SELECT question.id, service_user.id as userId, title, content, question.create_date, service_user.name as userName, service_user.email as userEmail FROM question, service_user WHERE service_user.id = user_id and question.id = :questionId";
	public final static String SELECT_COUNT = "SELECT count(*) FROM question";
	public final static String UPDATE = "UPDATE question SET content = :content WHERE id = :questionId";
}
