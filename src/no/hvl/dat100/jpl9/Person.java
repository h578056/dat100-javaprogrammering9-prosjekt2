package no.hvl.dat100.jpl9;

import javax.xml.bind.ParseConversionEvent;

public abstract class Person {
	private long fodselsnr;
	private String fornavn;
	private String etternavn;
	
	public Person() {
		
	}

	public Person(String etternamn, String fornamn, long fodselsnummer) {
		this.fodselsnr=fodselsnummer;
		this.fornavn=fornamn;
		this.etternavn=etternamn;
		//throw new RuntimeException("Person constructor not implemented");
	}

	public String getEtternamn() {
		return this.etternavn;
		//throw new RuntimeException("getEtternamn not implemented");
	}

	public void setEtternamn(String etternamn) {
		this.etternavn=etternamn;
		//throw new RuntimeException("setEtternamn not implemented");
	}

	public String getFornamn() {
		return this.fornavn;
		//throw new RuntimeException("getFornamn not implemented");
	}

	public void setFornamn(String fornamn) {
		this.fornavn=fornamn;
		//throw new RuntimeException("setFornamn not implemented");
	}

	public void setFodselsnummer(long fodselsnummer) {
		this.fodselsnr=fodselsnummer;
		//throw new RuntimeException("setFodselsnummer not implemented");
	}

	public long getFodselsnummer() {
		return this.fodselsnr;
		//throw new RuntimeException("getFodselsnummer not implemented");
	}

	public boolean erLik(Person person) {
		boolean erLikedan=false;
		if(person!=null && this.fodselsnr==person.getFodselsnummer()) {
			erLikedan=true;
		}else {
			erLikedan=false;
		}
		return erLikedan;
		//throw new RuntimeException("erLik not implemented");
	}

	public boolean erKvinne() {
		boolean erKvinne=false;
		String fodselsnrTxt=Long.toString(this.fodselsnr);
		String tredjeSisteNrTxt=fodselsnrTxt.substring(8, 9);
		int tredjeSisteNr=Integer.parseInt(tredjeSisteNrTxt);
		if(tredjeSisteNr%2==0) {
			erKvinne=true;
		}else {
			erKvinne=false;
		}
		return erKvinne;
		//throw new RuntimeException("erKvinne not implemented");
	}

	public boolean erMann() {
		boolean erMann=false;
		String fodselsnrTxt=Long.toString(this.fodselsnr);
		String tredjeSisteNrTxt=fodselsnrTxt.substring(8, 9);
		int tredjeSisteNr=Integer.parseInt(tredjeSisteNrTxt);
		if(tredjeSisteNr%2==0) {
			erMann=false;
		}else {
			erMann=true;
		}
		return erMann;
		//throw new RuntimeException("erMann not implemented");
	}

	@Override
	public String toString() {
		String personTxt= this.fodselsnr + "\n" + this.etternavn+ "\n" + this.fornavn + "\n";
		return personTxt;
		//throw new RuntimeException("toString not implemented");
	}
}
