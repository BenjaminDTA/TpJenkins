package dao;

import javax.persistence.EntityManager;

import modele.Reservation;

public class ReservationDAO {

	public static void createReservation(Reservation resa) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(resa);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void updateReservation(Reservation resa) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(resa);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void deleteReservation(Reservation resa) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(resa);
		DatabaseHelper.commitTxAndClose(em);

	}

}
