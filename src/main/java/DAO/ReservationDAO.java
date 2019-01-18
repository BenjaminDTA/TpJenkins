package dao;

import javax.persistence.EntityManager;

import modele.Reservation;

public class ReservationDAO {

	private ReservationDAO() {
	}

	private static ReservationDAO INSTANCE = new ReservationDAO();

	public static ReservationDAO getInstance() {
		return INSTANCE;
	}

	public void createReservation(Reservation resa) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(resa);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void updateReservation(Reservation resa) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(resa);
		DatabaseHelper.commitTxAndClose(em);
	}

	public void deleteReservation(Reservation resa) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(resa);
		DatabaseHelper.commitTxAndClose(em);

	}

}
