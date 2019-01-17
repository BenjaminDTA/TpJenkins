package Modele;
import java.text.ParseException;


import javax.persistence.EntityManager;

import DAO.DatabaseHelper;

public class Main {

	public static void main(String[] args) throws ParseException {

		

		EntityManager em = DatabaseHelper.createEntityManager();
		em.getTransaction().begin();
		
		UI.afficheMenuGeneral();
		
		


		Reservation resa1 = new Reservation((long) 01534, "Montet", "Benjamin", 26);
		em.persist(resa1);
		em.getTransaction().commit();

		em.close();

	}

}
