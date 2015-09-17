package br.unisinos.aso.dao;

import br.unisinos.aso.model.Medication;

public class MedicationDAO extends BaseDAO {

	public void save(Medication medication){
		openConnection();
		session.save(medication);
		transaction.commit();
//		commitAndCloseConnection();
	}
}