package biblioteca.GestioneLibri;

public class Rivista extends GestioneLibri {

	private Periodicita periodicita;

	public Rivista(String codiceIsbn, String titolo, int annoPublicazione, int numPagine, Periodicita periodicita) {
		super(codiceIsbn, titolo, annoPublicazione, numPagine);
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
		return "Rivista [periodicita=" + periodicita + ", toString()=" + super.toString() + "]";
	} 
	
	
	
}
	
	