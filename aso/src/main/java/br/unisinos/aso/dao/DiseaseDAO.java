package br.unisinos.aso.dao;

import br.unisinos.aso.model.Disease;

public class DiseaseDAO extends BaseDAO {

	public void saveDisease(Disease disease){
		openConnection();
		session.save(disease);
		transaction.commit();
//		commitAndCloseConnection();
	}
}
