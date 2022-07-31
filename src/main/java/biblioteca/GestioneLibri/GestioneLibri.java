package biblioteca.GestioneLibri;

public abstract class GestioneLibri {

	private String codiceIsbn;
	private String titolo;
	private int annoPublicazione;
	private int numPagine;
	public GestioneLibri(String codiceIsbn, String titolo, int annoPublicazione, int numPagine) {
		this.codiceIsbn = codiceIsbn;
		this.titolo = titolo;
		this.annoPublicazione = annoPublicazione;
		this.numPagine = numPagine;
	}
	public String getCodiceIsbn() {
		return codiceIsbn;
	}
	public void setCodiceIsbn(String codiceIsbn) {
		this.codiceIsbn = codiceIsbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnnoPublicazione() {
		return annoPublicazione;
	}
	public void setAnnoPublicazione(int annoPublicazione) {
		this.annoPublicazione = annoPublicazione;
	}
	public int getNumPagine() {
		return numPagine;
	}
	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}
	
	//PER TRANSFORMARE VARIABILI IN STRINGHE E FARLE LEGGERE IN CONSOLE
	@Override
	public String toString() {
		return "GestioneLibri [codiceIsbn=" + codiceIsbn + ", titolo=" + titolo + ", annoPublicazione="
				+ annoPublicazione + ", numPagine=" + numPagine + "]";
	}
	
	
	
	
}
