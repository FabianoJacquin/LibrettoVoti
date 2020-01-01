package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti punteggio da ricercare
	 * @return lista {@link Voto} aventi quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int punti){
		
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti() == punti) {
				result.add(v);
			}
		}
		
		return result;
		
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da cercare
	 * @return  il {@link Voto} corrispondente oppure {@code null} se non esistente
	 */
	public Voto cercaEsame(String nomeEsame) {
		
		/*
		for(Voto v: this.voti) {
			if (v.getCorso().equals(nomeEsame))
				return v;
		}
		*/
		
		Voto voto = new Voto(0, nomeEsame, null);
		
		//indexOf utilizza il metodo equals per eseguire il confronto
		//in questo caso utilizza equals dell'oggetto Voto che è stato
		//sovrascritto e restituisce true se il nome esame coincide
		int pos = this.voti.indexOf(voto);
		
		if (pos == -1)
			return null;
		else
			return this.voti.get(pos);

		
	}
	
	/**
	 * Dato un {@link Voto}, determina se esiste già un voto con uguale 
	 * corso e uguale punteggio
	 * @param v
	 * @return {@code true}, se ha trovato un corso e punteggio uguali,  
	 * {@code false} se non ha trovato il corso o lo ha trovato 
	 * con punteggio diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		
		 /*
		Voto trovato = this.cercaEsame(v.getCorso());
		
		if(trovato == null) {
			return false;
		} else if(trovato.getPunti() == v.getPunti()) {
			return true;
		} else {
			return false;
		}
		*/
		
		int pos = this.voti.indexOf(v);
		
		if (pos == -1) 
			return false;
		else 
			return (v.getPunti() == this.voti.get(pos).getPunti());
		 
		
	}
	
	/**
	 * Mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti esistenti
	 * Se il voto non esiste, non c'è conflito. Se esiste ed ha punteggio diverso 
	 * c'è conflitto
	 * @param v
	 * @return {@code true} se esiste ed ha un punteggio diverso, {@code false} se
	 * il voto non esiste oppure esiste ed ha punteggio uguale 
	 */
	public boolean votoConflitto(Voto v) {
		
		int pos = this.voti.indexOf(v);
		
		if (pos == -1) 
			return false;
		else 
			return (v.getPunti() != this.voti.get(pos).getPunti());
		 
	}

	@Override
	public String toString() {
		return String.format("Libretto [punti=%s]", voti);
	}

}
 