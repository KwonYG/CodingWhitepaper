package kr.ac.ks.webproject.sqls;

public class AnswerDaoSqls {
	public static final String SELECT_ANSWERS_BY_QUESTION_ID ="SELECT answer.id, user_id, content, question_id, answer.create_date, name as userName, email as userEmail FROM answer, service_user WHERE service_user.id = user_id and question_id = :questionId ORDER BY answer.create_date;";
	public static final String SELECT_ONE_ANSWER_BY_ANSWER_ID ="SELECT answer.id, service_user.id as userId, content, question_id, answer.create_date, name as userName, email as userEmail FROM answer, service_user WHERE service_user.id = user_id and answer.id = :answerId;";
}
