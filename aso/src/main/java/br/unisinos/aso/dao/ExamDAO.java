package br.unisinos.aso.dao;

import br.unisinos.aso.model.Exam;

public class ExamDAO extends BaseDAO {
	
	public void saveExam(Exam exam){
		openConnection();
		session.save(exam);
	}
}