package archivioBiblioteca;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;		//OGGETTO DELLA COLLECTION
import java.util.Map;			//INTERFACCIA CHE IMPLEMENTA METODI PER L'OGGETTO

import org.apache.commons.io.FileUtils;

import biblioteca.GestioneLibri.GestioneLibri;
import biblioteca.GestioneLibri.Libro;

public class Archivio {		//COLLECTIONS MAP

	private Map <String, GestioneLibri> archivio = new HashMap<String, GestioneLibri>();	

	public void ricercaISBN (String codiceIsbn) {
		
		GestioneLibri risultato = archivio.get(codiceIsbn);		
		System.out.println(risultato);
	};
	public void ricercaAnnoPubblicazione (int annoPubblicazione) {		//QUI SI USA UNO STREAM, COME FOSSE UN OBSERVABLE DI ANGULAR, CHE PRENDE GLI OGGETTI DENTRO L'ARCHIVIO
		archivio.values().
		stream().filter(element -> annoPubblicazione==element.getAnnoPublicazione())
		.forEach(element -> System.out.println(element) );			//LAMBDA FUNCTION (->)
	};
	public void aggiungiElemento (GestioneLibri a) {
		
		archivio.put(a.getCodiceIsbn(), a);		//PRIMA SI PASSA L'OGGETTO UTILIZZANDO IL METODO, E POI a CHE è L'OGGETTO
		
	};	
	public void rimuoviElemento (String codiceIsbn) {
		archivio.remove(codiceIsbn);
		System.out.println("Elemento eliminato correttamente");
		
	};	
	public void ricercaAutore (String autore) {		//ESSENDO AUTORE PROPRIO SOLO DI LIBRO, SI USA CASTING PER TRASFORMARE L'OGGETTO IN TIPO LIBRO
		archivio.values().stream().
		filter(element ->
		element instanceof Libro). 		//FILTRA LA COLLECTION
		map(element -> (Libro)element).		//CASTA(RITRASFORMA DA ASTRATTO IN TIPO LIBRO) GLI OGGETTI FILTRATI IN OGGETTO DI TIPO LIBRO
		filter(element -> autore.equals(element.getAutore()))				//OGNI ELEMENTO DEVE AVERE AUTORE CHE GLI PASSIAMO TRAMITE IL METODO
		.forEach(element -> System.out.println(element) );			//LAMBDA FUNCTION (->)

	};	
	public void salvaFile () {		//SI UTILIZZA LIBRERIA APACHE.COMMON PER COMODITà
		File elemento = new File("Archivio/nomefile.txt");		//NOME CARTELLA CHE ANDRà A CREARE
		String dato = "";				//CREARE VARIABILE DI TIPO STRINGA
		for (GestioneLibri element : archivio.values()) {
			dato += element.toString();
		} 
		try {
			FileUtils.writeStringToFile(elemento, dato);
		} catch (IOException e) {
			e.printStackTrace();
		}
	};	
	public void caricaFile () {
		File elemento = new File("Archivio/nomefile.txt");		//NOME CARTELLA CHE ANDRà A CREARE
		try {
			String file = FileUtils.readFileToString(elemento);
			System.out.println(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
}

