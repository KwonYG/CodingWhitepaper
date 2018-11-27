package kr.ac.ks.webproject.sqls;

public class AnswerCodeDaoSqls {
	public static final String SELECT_ANSWER_CODES_BY_ANSWER_ID ="SELECT id, content, answer_id FROM answer_code WHERE answer_id = :answerId;";
}
