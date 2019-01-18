package DAO;

import javax.persistence.EntityManager;

import Modele.Vol;

public class VolDAO {
		private VolDAO() {
		super();
	}
		
	public static void createVol(Vol vol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(vol);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void updateVol (Vol vol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(vol);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void deleteVol(Vol vol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(vol);
		DatabaseHelper.commitTxAndClose(em);
	}


}
