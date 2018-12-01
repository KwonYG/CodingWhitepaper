package kr.ac.ks.webproject.sqls;

public class AnswerReplyDaoSqls {
	public static final String SELECT_ALL_ANSWER_REPLIES= "SELECT answer_reply.id, user_id, service_user.name as userName, service_user.email as userEmali, answer_id, content, answer_reply.create_date FROM answer_reply, service_user WHERE service_user.id = user_id;";
}
