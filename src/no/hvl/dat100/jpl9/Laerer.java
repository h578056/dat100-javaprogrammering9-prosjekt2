package no.hvl.dat100.jpl9;

public class Laerer extends Person {
	private int maandeslonn;
	private int kontonr;
	public Laerer() {
		super();
	}

	public Laerer(String etternamn, String fornamn, long fodselsnummer, int maanedslonn, int kontonummer) {
		super(etternamn, fornamn, fodselsnummer);
		this.maandeslonn=maanedslonn;
		kontonr=kontonummer;
		//throw new RuntimeException("Laerer constructor not implemented");
	}

	public int getMaanedslonn() {
		return this.maandeslonn;
		//throw new RuntimeException("getMaanedslonn not implemented");
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maandeslonn=maanedslonn;
		//throw new RuntimeException("setMaanedslonn not implemented");
	}

	public int getKontonummer() {
		return kontonr;
		//throw new RuntimeException("getKontonummer not implemented");
	}

	public void setKontonummer(int kontonummer) {
		this.kontonr=kontonummer;
		//throw new RuntimeException("setKontonummer not implemented");
	}

	@Override
	public String toString() {
		String teacherTxt="LAERER" + "\n" + super.toString() + this.maandeslonn + "\n" + this.kontonr + "\n";
		return teacherTxt;
		//throw new RuntimeException("toString() not implemented");

	}
}
