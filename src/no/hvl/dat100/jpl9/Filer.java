package no.hvl.dat100.jpl9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Filer {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jpl9/";

	private static String STUDENT = "STUDENT";
	private static String LAERER = "LAERER";

	public boolean skriv(PersonSamling samling, String filnavn) {

		boolean skrevet = true;
		PrintWriter writer = null;
		// TODO
		try {
			writer= new PrintWriter(filnavn);
			writer.print(samling.toString());
			writer.close();
			return skrevet;
		} catch (FileNotFoundException e) {
			System.out.println("fil ikke skrive fil");
			e.printStackTrace();
			skrevet=false;
			return skrevet;
		}
		
		//throw new RuntimeException("skriv not implemented");

	}
	public Student opprettStudent(Scanner leser) {
		Student st=new Student();	
		st.setFodselsnummer(Long.parseLong(leser.nextLine()));
		st.setEtternamn(leser.nextLine());
		st.setFornamn(leser.nextLine());
		st.setStudentnummer(Integer.parseInt(leser.nextLine()));
		st.setKlasse(leser.nextLine());
		return st;
	}
	
	public Laerer opprettLaerer(Scanner leser) {
		Laerer lr=new Laerer();
		lr.setFodselsnummer(Long.parseLong(leser.nextLine()));
		lr.setEtternamn(leser.nextLine());
		lr.setFornamn(leser.nextLine());
		lr.setMaanedslonn(Integer.parseInt(leser.nextLine()));
		lr.setKontonummer(Integer.parseInt(leser.nextLine()));
		return lr;
	}

	public PersonSamling les(String filnavn) {

		PersonSamling samling= new PersonSamling();

		// TODO
		try {
			File fil= new File(filnavn);
			Scanner leser= new Scanner(fil);
			while(leser.hasNextLine()){
				String line=leser.nextLine();
				if(line.equals("STUDENT")) {
					Student st=opprettStudent(leser);
					samling.leggTil(st);
				}else if(line.equals("LAERER")) {
					Laerer lr= opprettLaerer(leser);
					samling.leggTil(lr);
				}
			}
			leser.close();
			return samling;
			}
			catch (FileNotFoundException e) {
				System.out.println("fil ikke funnet");
				return samling;
			}
		//throw new RuntimeException("les not implemented");
	}
}
