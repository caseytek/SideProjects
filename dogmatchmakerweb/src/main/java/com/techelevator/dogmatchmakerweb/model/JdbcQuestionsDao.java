package com.techelevator.dogmatchmakerweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcQuestionsDao implements QuestionsDao{
	
	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcQuestionsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Questions> getAllQuestions() {
		List <Questions> questions = new ArrayList<>();
		String sql = "SELECT * FROM questions";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Questions question = new Questions();
			question.setQuestionKey(results.getString("question_key"));
			question.setQuestion(results.getString("question"));
			question.setChoice1("choice_one");
			question.setChoice2(results.getString("choice_two"));
			if(results.getString("choice_three") != null) {
				question.setChoice3(results.getString("choice_three"));
			}
			questions.add(question);
		}
		return questions;
	}

}
