package it.epicode.w2.proj;

import java.time.LocalDate;

public class Libro extends ArticoloDiLettura{
	
    // ----------------------PROPRIETA--------------------------	
	
	private String autore;
	private String genere;
	
    // ----------------------- COSTRUTTORE ---------------------
	
	public Libro(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);

		this.autore = autore;
		this.genere = genere;
	}

	// ----------------------- GETTERS AND SETTERS ---------------------
	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "isbn: "+ getIsbn() + ", "
				+ "Titolo: " + getTitolo()+ ", "
				+ "genere: " + getGenere() + ", "
				+ "Anno di Pubblicazione: " + getAnnoPubblicazione() + ", "
				+ "N. Pagine: " + getNumeroPagine() + "@";
	}
	
	
	 
	
	
	
	
	
	
}
