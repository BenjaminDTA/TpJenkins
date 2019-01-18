package dao;

import javax.persistence.EntityManager;

import modele.Vol;

public class VolDAO {
	private VolDAO() {
	}

	private static VolDAO deuxStance;

	public static VolDAO getInstance() {
		if (deuxStance == null) {
			deuxStance = new VolDAO();
		}
		return deuxStance;
	}

	public void createVol(Vol vol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(vol);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void updateVol(Vol vol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(vol);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void deleteVol(Vol vol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(vol);
		DatabaseHelper.commitTxAndClose(em);
	}

}
