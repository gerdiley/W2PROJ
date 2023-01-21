package it.epicode.w2.proj;

import java.time.LocalDate;

public abstract class ArticoloDiLettura {
	protected String isbn;
	protected String titolo;
	protected LocalDate annoPubblicazione;
	protected int numeroPagine;
	
	public ArticoloDiLettura(String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	
	// ----------------------- GETTERS AND SETTERS ---------------------
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "ArticoloDiLettura [isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
	
}
