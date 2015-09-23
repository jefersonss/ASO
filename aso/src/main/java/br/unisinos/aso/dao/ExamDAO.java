package br.unisinos.aso.dao;

import java.util.List;

import org.hibernate.Query;

import br.unisinos.aso.model.Exam;

public class ExamDAO extends BaseDAO {
	
	public void saveExam(Exam exam){
		openConnection();
		session.save(exam);
		transaction.commit();
//		commitAndCloseConnection();
	}
	
	@SuppressWarnings("unchecked")
	public List<Exam> searchExamByName(String name){
		openConnection();
		String hql = "FROM Exam E WHERE E.name LIKE :exam_name";
		Query query = session.createQuery(hql).setParameter("exam_name", name+"%");
		return query.list();
	}
}