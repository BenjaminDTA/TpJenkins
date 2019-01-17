package Modele;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DAO.DatabaseHelper;
import DAO.ReservationDAO;
import DAO.VolDAO;

public class UI {

	private final static String retourMenu ="Retour au menu principal";
	
	public static void afficheMenuGeneral() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------  MENU  ----------------");
		System.out.println("1 : Gestion des vols");
		System.out.println("2 : Gestion des réservations");
		System.out.println("3 :	Quitter" + "\n");
		System.out.println("Entrez votre choix");
		Integer i = sc.nextInt();
		afficheMenuGeneralChoix(i);
	}

	public static void afficheMenuVol() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("----------  GESTION DES VOLS  ----------");
		System.out.println("1 : Creation d'un vol");
		System.out.println("2 : Afficher la liste des vols");
		System.out.println("3 : Quitter" + "\n");
		System.out.println("Entrez votre choix");
		Integer i = sc.nextInt();
		afficheMenuVolChoix(i);
	}

	public static void afficheMenuReservation() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("----------  GESTION DES RESERVATIONS  ----------");
		System.out.println("1 : Creation une réservation");
		System.out.println("2 : Voir les réservations d'un vol");
		System.out.println("3 : Retour");
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
			System.out.println(retourMenu);
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
			System.out.println(retourMenu);
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
			System.out.println(retourMenu);
			afficheMenuReservationChoix(i);
		}
	}

	@SuppressWarnings("resource")
	public static void afficheCreationVol() throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");

		System.out.println("N° de vol :");
		Long nVol = Long.parseLong(sc.nextLine());
		System.out.println("Type d'avion recherché : ");
		String typeavion = sc.nextLine();
		System.out.println("Ville de départ : ");
		String villeDepart = sc.nextLine();
		System.out.println("Ville d'arrivée : ");
		String villeArrivee = sc.nextLine();
		System.out.println("Nombre de place : ");
		Integer nbPlace = Integer.parseInt(sc.nextLine());
		System.out.println("Date de départ : ");
		Date dateDepart = dt.parse(sc.nextLine());
		VolDAO.createVol(new Vol(nVol, typeavion, villeDepart, villeArrivee, nbPlace, dateDepart));
		
		afficheMenuGeneral();
	

	}
	
	
	@SuppressWarnings("resource")
	public static void afficheCreationReservation() throws ParseException {
		Scanner sc = new Scanner(System.in);

		System.out.println("N° de réservation :");
		Long nResa = Long.parseLong(sc.nextLine());
		System.out.println("Nom : ");
		String nom = sc.nextLine();
		System.out.println("Prénom : ");
		String prenom = sc.nextLine();
		System.out.println("Age : ");
		Integer age = Integer.parseInt(sc.nextLine());
		ReservationDAO.createReservation(new Reservation(nResa, nom, prenom, age));
		
		afficheMenuGeneral();
	}
	
	@SuppressWarnings("unused")
	public static void afficheListeVol(){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Vol> query = em.createQuery("from Vol", Vol.class);
		List<Vol> vols = query.getResultList();

	}
	@SuppressWarnings("unused")
	public static void afficheListeReservation(){
		EntityManager em = DatabaseHelper.createEntityManager();
		TypedQuery<Reservation> query = em.createQuery("from Reservation", Reservation.class);
		List<Reservation> reservations = query.getResultList();

	}

}