package Modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DAO.DatabaseHelper;
import DAO.ReservationDAO;
import DAO.VolDAO;

public class UI {

	private final static String RetourMenu ="RetourMenu au menu principal";
	private final static Logger Logger = LoggerFactory.getLogger(UI.class);
	
	public static void afficheMenuGeneral() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Logger.info("----------------  MENU  ----------------");
		Logger.info("1 : Gestion des vols");
		Logger.info("2 : Gestion des réservations");
		Logger.info("3 :	Quitter" + "\n");
		Logger.info("Entrez votre choix");
		Integer i = sc.nextInt();
		afficheMenuGeneralChoix(i);
	}

	public static void afficheMenuVol() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Logger.info("----------  GESTION DES VOLS  ----------");
		Logger.info("1 : Creation d'un vol");
		Logger.info("2 : Afficher la liste des vols");
		Logger.info("3 : Quitter" + "\n");
		Logger.info("Entrez votre choix");
		Integer i = sc.nextInt();
		afficheMenuVolChoix(i);
	}

	public static void afficheMenuReservation() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Logger.info("----------  GESTION DES RESERVATIONS  ----------");
		Logger.info("1 : Creation une réservation");
		Logger.info("2 : Voir les réservations d'un vol");
		Logger.info("3 : Retour");
		Integer i = sc.nextInt();
		afficheMenuReservationChoix(i);
	}

	public static void afficheMenuGeneralChoix(Integer i) throws ParseException {
		switch (i) {
		case 1:
			afficheMenuVol();
			break;
		case 2:
			afficheMenuReservation();
			break;
		case 3:
			afficheMenuGeneral();
			break;
		default:
			Logger.info(RetourMenu);
			afficheMenuGeneral();

		}
	}

	public static void afficheMenuVolChoix(Integer i) throws ParseException {
		switch (i) {
		case 1:
			afficheCreationVol();

			break;
		case 2:
			afficheListeVol();
			break;
		case 3:
			afficheMenuGeneral();
			break;
		default:
			Logger.info(RetourMenu);
			afficheMenuVolChoix(i);
		}
	}

	public static void afficheMenuReservationChoix(Integer i) throws ParseException {
		switch (i) {
		case 1:
			afficheCreationReservation();
			break;
		case 2:
			afficheListeReservation();
			break;
		case 3:
			afficheMenuGeneral();
			break;
		default:
			Logger.info(RetourMenu);
			afficheMenuReservationChoix(i);
		}
	}

	
	public static void afficheCreationVol() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");

		Logger.info("N° de vol :");
		Long nVol = Long.parseLong(sc.nextLine());
		Logger.info("Type d'avion recherché : ");
		String typeavion = sc.nextLine();
		Logger.info("Ville de départ : ");
		String villeDepart = sc.nextLine();
		Logger.info("Ville d'arrivée : ");
		String villeArrivee = sc.nextLine();
		Logger.info("Nombre de place : ");
		Integer nbPlace = Integer.parseInt(sc.nextLine());
		Logger.info("Date de départ : ");
		Date dateDepart = dt.parse(sc.nextLine());
		VolDAO.createVol(new Vol(nVol, typeavion, villeDepart, villeArrivee, nbPlace, dateDepart));
		
		afficheMenuGeneral();
	

	}
	
	
	
	public static void afficheCreationReservation() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		Logger.info("N° de réservation :");
		Long nResa = Long.parseLong(sc.nextLine());
		Logger.info("Nom : ");
		String nom = sc.nextLine();
		Logger.info("Prénom : ");
		String prenom = sc.nextLine();
		Logger.info("Age : ");
		Integer age = Integer.parseInt(sc.nextLine());
		ReservationDAO.createReservation(new Reservation(nResa, nom, prenom, age));
		
		afficheMenuGeneral();
	}
	
	
	public static void afficheListeVol(){
		
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from Vol", Vol.class);
		query.getResultList();

	}
	
	public static void afficheListeReservation(){
		
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("from Reservation", Reservation.class);
		query.getResultList();

	}

}