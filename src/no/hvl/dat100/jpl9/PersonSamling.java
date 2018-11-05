package no.hvl.dat100.jpl9;

public class PersonSamling {
	private int antall=0;;
	private int nesteledig=0;
	private Person personer[];
	
	public PersonSamling() {
		personer=new Person[20];
		for(int i=0; i<personer.length; i++) {
			personer[i]=null;
		}
		//throw new RuntimeException("PersonSamling() constructor not implemented");
	}

	public PersonSamling(int lengde) {
		personer=new Person[lengde];
		for(int i=0; i<personer.length; i++) {
			personer[i]=null;
		}
		//throw new RuntimeException("PersonSamling() constructor not implemented");
	}

	public int getAntall() {
		int antPersoner=0;
		for(int i=0; i<personer.length; i++) {
			if(personer[i]!=null) {
				antPersoner=antPersoner+1;
			}
		}
		return antPersoner;
		//throw new RuntimeException("getAntall not implemented");
	}

	// DO NOT TOUCH - FOR TESTING PURPOSES ONLY
	public void setAntall(int antall) {
		nesteledig = antall;
	}
	
	public Person[] getSamling() {
		return this.personer;
		//throw new RuntimeException("getSamling() not implemented");
	}

	public int finnPerson(Person p) {
		int personerIndeks=-1;
		for(int i=0; i<personer.length; i++) {
			if(p.erLik(personer[i])) {
				personerIndeks=i;
			}
		}
		return personerIndeks;
		//throw new RuntimeException("finnPerson not implemented");
	}

	public boolean finnes(Person p) {
		boolean finnes=false;
		for(int i=0; i<personer.length; i++) {
			if(personer[i]!=null && personer[i].getFodselsnummer()==p.getFodselsnummer()) {
				finnes=true;
			}
		}
		return finnes;
		//throw new RuntimeException("finnes not implemented");
	}

	public boolean ledigPlass() {
		boolean ledigPlass=false;
		for(int i=0; i<personer.length; i++) {
			if(personer[i]==null) {
				ledigPlass=true;
			}
		}
		return ledigPlass;
		//throw new RuntimeException("ledigPlass not implemented");
	}

	public boolean leggTil(Person p) {
		boolean leggTil;
		boolean finnes=finnes(p);
		boolean ledigPlass=ledigPlass();
		if(finnes==false ) {
			if(ledigPlass && nesteledig<personer.length) {
					personer[nesteledig]=p;
					nesteledig=nesteledig+1;
					antall=antall+1;
					leggTil=true;
			}else {
				leggTil=false;
			}
		}else {
			leggTil=false;
		}
		return leggTil;
		
		//throw new RuntimeException("leggTil not implemented");
	}
	
	public String toString() {
		String personerTxt="";
		for(int i=0; i<personer.length; i++) {
			if(personer[i]!=null) {
				personerTxt=personerTxt+personer[i].toString();
			}
		}
		personerTxt=antall+ "\n"+ personerTxt;
		return personerTxt;		
		//throw new RuntimeException("toString not implemented");
	}

	public void utvid() {
		Person tabell1[]= new Person[personer.length*2];
		for(int i=0; i<personer.length; i++) {
			tabell1[i]=personer[i];
			tabell1[personer.length+i]=null;
		}
		personer=tabell1;
		//throw new RuntimeException("utvid not implemented");
	}

	
	public boolean leggTilUtvid(Person p) {
		boolean utvidet=false; // returnerer true om personer tabellen blir utvidet
		if(finnes(p)) {
			return utvidet;
		}
		boolean plass=leggTil(p);
		if(plass==true) {
			utvidet=true;
		}else{
			utvid();
			personer[nesteledig]=p;
			nesteledig=nesteledig+1;
			antall=antall+1;
			utvidet=true;
		}
		return utvidet;
		
		//throw new RuntimeException("leggTilUtvid not implemented");
	}

	public void slett(Person p) {
		if(finnes(p)) {
			int index=finnPerson(p);
			personer[index]=null;
			antall=antall-1;
			for(int i=index; i<personer.length-index; i++) {
				personer[index+i]=personer[index+i];
			}
			
		}else {
			System.out.println("person finnes ikke");
		}
		//throw new RuntimeException("slett not implemented");
	}
}