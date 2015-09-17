package br.unisinos.aso.dao;

import java.util.List;

import br.unisinos.aso.model.Exam;

public class ExamDAO extends BaseDAO {
	
	public void saveExam(Exam exam){
		openConnection();
		session.save(exam);
		transaction.commit();
//		commitAndCloseConnection();
	}
	
	public List<Exam> searchExamByName(String name){
		return null;
	}
}