package no.hvl.dat100.jpl9;

public class Student extends Person {
	private int studentnr;
	private String klasse;

	public Student() {
		super();
	}

	public Student(String etternamn, String fornamn, long fodselsnummer, int studentnummer, String klasse) {
		setEtternamn(etternamn);
		setFornamn(fornamn);
		setFodselsnummer(fodselsnummer);
		studentnr=studentnummer;
		this.klasse=klasse;
		//throw new RuntimeException("Student constructor not implemented");
	}

	public int getStudentnummer() {
		return this.studentnr;
		//throw new RuntimeException("getStudentnummer not implemented");
	}

	public void setStudentnummer(int studentnummer) {
		this.studentnr=studentnummer;
		//throw new RuntimeException("setStudentnummer not implemented");
	}

	public String getKlasse() {
		return this.klasse;
		//throw new RuntimeException("getKlasse not implemented");
	}

	public void setKlasse(String klasse) {
		this.klasse=klasse;
		//throw new RuntimeException("setKlasse not implemented");
	}

	@Override
	public String toString() {
		String studentTxt="STUDENT" + "\n"+ super.toString() + this.studentnr + "\n" + this.klasse +"\n";
		return studentTxt;
		//throw new RuntimeException("toString not implemented");

	}
}
