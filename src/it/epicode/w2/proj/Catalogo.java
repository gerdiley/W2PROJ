package it.epicode.w2.proj;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.slf4j.*;

public class Catalogo {
	
	final static Logger logger = LoggerFactory.getLogger(Catalogo.class);

	static List<ArticoloDiLettura> listaArticoli = new ArrayList<ArticoloDiLettura>();
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		
		// CHIAMO FUNZIONI PER AGGIUNTA LIBRI
		listaArticoli.add(new Libro(createID(), "IL giocatore", LocalDate.ofYearDay(1900, 1), 200, "Dostojesky", "Letteratura"));
		listaArticoli.add(new Libro(createID(), "La fine e il mio inizio", LocalDate.ofYearDay(2000, 1), 200, "terzani", "Letteratura"));
		listaArticoli.add(new Libro(createID(), "Scrivo Poesie", LocalDate.ofYearDay(1970, 1), 200, "Bukowski", "Letteratura"));
		listaArticoli.add(new Rivista(createID(), "Nature", LocalDate.ofYearDay(1980, 1), 200, Periodicita.Settimanale));
		
		int scelta;
		do {
		System.out.printf("Premi un numoro : %n"
				+ "1 - per aggiungere un libro %n"
				+ "2 - per aggiungere una Rivista %n"
				+ "3 - per rimuovere un elemento dal catalogo %n"
				+ "4 - per trovare un articolo con isbn %n"
				+ "5 - per trovare un articolo tramite anno %n"
				+ "6 - per trovare un libro tramite autore %n"
				+ "7 - per scrivere l'archivio sul disco %n"
				+ "8 - per leggere l'archivio dal disco %n ");
		scelta = Integer.parseInt(in.nextLine());
		
		switch (scelta) {
		case 1:
			addLibro();
			break;
		case 2:
			addRivista();
			break;
		case 3:
			removeElement();
			break;
		case 4:
			findElementByIsbn();
			break;
		case 5:
			findElementByAnno();
			break;
		case 6:
			findLibroByAutore();
			break;
		case 7:
			scriviDisco();
			break;
		case 8:
			leggiDisco();
			break;
		default:
			
			break;
		}
		} while( scelta != 0);
		
		
		logger.info("operazioni terminate!");
		
		
		
//		logger.info("LISTA INIZIALE: "+ listaArticoli);
		
		// CHIAMO FUNZIONE PER RIMOZIONE DI UN ELEMENTO
//		removeElement("1");
		
		// CHIAMO FUNZIONI PER RICERCARE		
		
//		findElementByIsbn("3");
//	
//		findElementByAnno("1980");
//		
//		findLibroByAutore("Dostojesky");
		
       // CHIAMO FUNZIONI PER SCRIVERE/LEGGERE DISCO
//		
//		scriviDisco();
//		leggiDisco();
	}
	
//	// ------------------- GENERATORE ISBN------------------------//
//	
//	public static String generateISBN() {
//		UUID isbn = UUID.randomUUID();
//	    return isbn.toString();
//	}
	// ------------------- GENERATORE ISBN (Alternativa)------------//
	
	private static long idCounter = 0;

	public static synchronized String createID()
	{
	    return String.valueOf(idCounter++);	}    
	

	// ------------------- AGGIUNTA ELEMENTO Libro -------------------
	public static void addLibro() {
		
		String isbn = createID();
		
		System.out.println("Inserisci titolo: ");
		String titolo = in.nextLine();
		
		System.out.println("Inserisci anno: ");
		LocalDate anno =(LocalDate.ofYearDay(Integer.parseInt(in.nextLine()), 1));
		
		System.out.println("Inserisci n.pagine: ");
		int numeroPagine = Integer.parseInt(in.nextLine());
		
		System.out.println("Inserisci autore");
		String autore = in.nextLine();
		
		System.out.println("Inserisci genere");
		String genere = in.nextLine();
		
		
		
		listaArticoli.add(new Libro(isbn, titolo, anno, numeroPagine, autore, genere));
		
		logger.info("---------libro aggiunto!------------");
		logger.info("---------lista aggiornata-----------");
		logger.info( listaArticoli.toString());

	}
	
	// ------------------- AGGIUNTA ELEMENTO RIvista -------------------
	public static void addRivista() {
		
		String isbn1 = createID();
		
		System.out.println("Inserisci titolo: ");
		String titolo1 = in.nextLine();
		
		System.out.println("Inserisci anno: ");
		LocalDate anno1 =(LocalDate.ofYearDay(Integer.parseInt(in.nextLine()), 1));
		
		System.out.println("Inserisci n.pagine: ");
		int numeroPagine1 = Integer.parseInt(in.nextLine());
		
		System.out.println("Inserisci periodicita della rivista:"
				+ "1 - Settimanale"
				+ "2 - Mensile"
				+ "3 - Semestrale");
		int scelta = Integer.parseInt(in.nextLine());
		Periodicita periodicita1 = Periodicita.Settimanale;
		
		switch (scelta) {
		case 1:
			periodicita1 = Periodicita.Settimanale;
			break;
		case 2:
			periodicita1 = Periodicita.mensile;
			break;
		case 3:
			periodicita1 = Periodicita.semestrale;
			break;
		default:
			break;
		}
		
		listaArticoli.add(new Rivista(isbn1, titolo1, anno1, numeroPagine1, periodicita1 ));
		
		logger.info("---------Rivista aggiunta!------------");
		logger.info("---------lista aggiornata-----------");
		logger.info( listaArticoli.toString());
		
	}

	// ------------------- RIMOZIONE ELEMENTO -------------------
	public static void removeElement() {
		
		System.out.println("Inserisci ISBN: ");
		String isbn = in.nextLine();
		
		listaArticoli.removeIf(l -> l.getIsbn().equals(isbn));

		logger.info("Hai rimosso il libro con ISBN " + isbn);
		logger.info("Lista aggiornata: " + listaArticoli.toString());
		
	}
	
	// ------------------- TROVA ELEMENTO by ISBN -------------------
	
	public static void findElementByIsbn() {
		
		System.out.println("Inserisci ISBN: ");
		String isbn = in.nextLine();
		
		Stream<ArticoloDiLettura> streamLibro = listaArticoli.stream().filter(l -> l.getIsbn().equals(isbn));
		streamLibro.forEach(l -> logger.info("Libro trovato tramite ISBN " + isbn + ": " + l.toString()));
	}
	
	// -------------------TROVA ELEMENTO by anno-------------------
	
	public static void findElementByAnno() {
		
		System.out.println("Inserisci anno: ");
		String anno =(in.nextLine());
		
		Stream<ArticoloDiLettura> streamAnno = listaArticoli.stream().filter(l -> l.getAnnoPubblicazione().toString().contains(anno));
		streamAnno.forEach(l -> logger.info("Libri trovati dell'anno " + anno + ": " + l.toString()));
	}
	
	// ------------------- TROVA ELEMENTO  by Autore -------------------
	
	public static void findLibroByAutore() {
		
		System.out.println("Inserisci autore: ");
		String autore = in.nextLine();
		
		Stream<Libro> streamAutore = listaArticoli.stream().filter(l -> l instanceof Libro).map(l -> (Libro) l).filter(l -> l.getAutore().equals(autore));
		streamAutore.forEach(l -> logger.info("Libri trovati dell'autore " + autore + ": " + l.toString()));
	}
	
	// ------------------- SCRIVI SU DISCO -------------------
	
	public static void scriviDisco() {
		
		File file = new File("catalogo.txt");
		
		listaArticoli.forEach(l -> {
			try {
				FileUtils.writeStringToFile(file, l.toString(), "utf-8", true);
				logger.info("Hai salvato correttamente l'archivio sul disco");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	public static void leggiDisco() throws IOException {
		File file = new File("catalogo.txt");
		String content = FileUtils.readFileToString(file, "utf-8");
		String[] segments =  content.split("@");
		
		for (int i = 0; i < segments.length; i++) {
			logger.info("LETTURA " + segments[i] );
		}
	}
	

}
