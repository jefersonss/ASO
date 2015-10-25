package br.unisinos.aso.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.unisinos.aso.model.Exam;
import br.unisinos.aso.model.Patient;

@Repository
public class ExamDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveExam(Exam exam){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(exam);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Exam> searchExamByName(String name){
		Session session = this.sessionFactory.openSession();
		String hql = "FROM Exam E WHERE E.name LIKE :exam_name";
		Query query = session.createQuery(hql).setParameter("exam_name", name+"%");
		List<Exam> exams = query.list();
		session.close();
		return exams;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Map<String, List<String>> retrieveVitalSignExamsEvolution(Patient patient) {
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT e.* "
				+ "FROM exam e, treat_exam te, treatment t, patient_treatment pt, patient p "
				+ "WHERE e.id = te.exam_id "
				+ "AND te.treatment_id = t.id "
				+ "AND pt.treatment_id = t.id "
				+ "AND pt.patient_id = p.id "
				+ "AND p.id = :patient_id"
				+ "AND e.name in ('Heart Rate', 'Temperature', 'Respirations', 'SPO2', 'BPS', 'BPD')";
		Query query = session.createSQLQuery(sql).setParameter("patient_id", patient.getId());
		Map<String, List<String>> examResultsByExamName = buildExamResultList(query.list());
		return examResultsByExamName;
	}

	@SuppressWarnings("rawtypes")
	private Map<String, List<String>> buildExamResultList(List queryList) {
		Map<String, List<String>> examResultMap = new HashMap<String, List<String>>();
		
		for(Object examsResultSet : queryList){
			Object[] objectArray = (Object[]) examsResultSet;
			List<String> results = examResultMap.get(objectArray[0]);
			if(null == results) results = new LinkedList<String>();
			results.add((String)objectArray[2]);
			examResultMap.put((String) objectArray[0], results);
		}
		return examResultMap;
	}
}