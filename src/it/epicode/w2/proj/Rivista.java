package it.epicode.w2.proj;

import java.time.LocalDate;

public class Rivista extends ArticoloDiLettura {
	
	// ----------------------PROPRIETA--------------------------
	private Periodicita periodicita;


	
	// ----------------------- COSTRUTTORE ---------------------

	public Rivista(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);

		this.periodicita = periodicita;
	}



	public Periodicita getPeriodicita() {
		return periodicita;
	}



	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}



	@Override
	public String toString() {
		return "isbn: "+ getIsbn()  + ", "
			   + "Titolo: " + this.getTitolo() + ", "
			   + "Anno di pubblicazione" +  this.getAnnoPubblicazione() + ", "
			   + "N.Pagine" + this.getNumeroPagine() + ", "
			   + "Rivista periodicita: " + periodicita + "@";
	}
	
	
	
	
	
	
	
}
