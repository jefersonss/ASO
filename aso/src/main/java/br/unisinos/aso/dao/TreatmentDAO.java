package br.unisinos.aso.dao;

import br.unisinos.aso.model.Treatment;

public class TreatmentDAO extends BaseDAO {

	public void save(Treatment treatment){
		openConnection();
		session.save(treatment);
		transaction.commit();
//		commitAndCloseConnection();
	}
}