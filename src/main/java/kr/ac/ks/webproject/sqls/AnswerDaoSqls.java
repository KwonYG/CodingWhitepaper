package kr.ac.ks.webproject.sqls;

public class AnswerDaoSqls {
	public static final String SELECT_ANSWERS_BY_QUESTION_ID ="SELECT id, content, create_date, user_name, user_email FROM answer WHERE question_id = :questionId;";
}
