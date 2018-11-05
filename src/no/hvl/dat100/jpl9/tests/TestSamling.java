package no.hvl.dat100.jpl9.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import no.hvl.dat100.jpl9.*;
public class TestSamling {

	@Test
	public void testStandardConstructor() {
		PersonSamling samling = new PersonSamling();
		
		assertEquals(0,samling.getAntall());
		assertEquals(20,samling.getSamling().length);
		
	}

	@Test
	public void testConstructor() {
		PersonSamling samling = new PersonSamling(40);
		
		assertEquals(0,samling.getAntall());
		assertEquals(40,samling.getSamling().length);
	}
	
	@Test
	public void testfinnPerson() {
		PersonSamling samling = new PersonSamling(40);
		
		Student student1 = new Student("Olsen", "Ole", 6,100,"1A");
		Student student2 = new Student("Olsen", "Oline", 7,101,"1A");
		Student student3 = new Student("Olsen", "Oline", 8,102,"1A");
		
		Person[] tabell = samling.getSamling();
		
		assertEquals(-1,samling.finnPerson(student1));
		
		tabell[0] = student1;
		tabell[1] = student2;
		
		samling.setAntall(2);
		
		assertEquals(0,samling.finnPerson(student1));
		assertEquals(1,samling.finnPerson(student2));
		assertEquals(-1,samling.finnPerson(student3));
		
		
	}
	
	@Test
	public void testfinnes() {
		PersonSamling samling = new PersonSamling(40);
		
		Student student1 = new Student("Olsen", "Ole", 6,100,"1A");
		Student student2 = new Student("Olsen", "Oline", 7,101,"1A");
		Student student3 = new Student("Olsen", "Oline", 8,102,"1A");
		
		Person[] tabell = samling.getSamling();
		
		assertFalse(samling.finnes(student1));
		
		tabell[0] = student1;
		tabell[1] = student2;
		
		samling.setAntall(2);
		
		assertTrue(samling.finnes(student1));
		assertTrue(samling.finnes(student2));
		assertFalse(samling.finnes(student3));
		
		
	}
	
	@Test 
	public void testleggTil() {
		
		PersonSamling samling = new PersonSamling(2);
		
		Student student1 = new Student("Olsen", "Ole", 6,100,"1A");
		
		Student student2 = new Student("Olsen", "Oline", 7,101,"1A");
		
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);
		
		assertTrue(samling.leggTil(student1));
		assertTrue(samling.leggTil(laerer));
		
		assertEquals(2,samling.getAntall());
		
		assertTrue(samling.finnes(student1));
		assertTrue(samling.finnes(laerer));
		
		assertFalse(samling.leggTil(student2));
				
		assertEquals(2,samling.getAntall());	
		
		assertTrue(samling.finnes(student1));
		assertTrue(samling.finnes(laerer));
		
		assertFalse(samling.finnes(student2));
		
	}
	
	@Test
	public void testutvid() {
		
		PersonSamling samling = new PersonSamling(2);
		Student student1 = new Student("Olsen", "Ole", 6,100,"1A");
		Student student2 = new Student("Olsen", "Oline", 7,101,"1A");
		
		samling.leggTil(student1);
		samling.leggTil(student2);
		
		samling.utvid();
		
		assertEquals(2,samling.getAntall());
		assertTrue(samling.finnes(student1));
		assertTrue(samling.finnes(student2));
		
		assertEquals(4, samling.getSamling().length);
		
	}
	
	@Test 
	public void testleggTilUtvid() {
		PersonSamling samling = new PersonSamling(2);
		
		Student student1 = new Student("Olsen", "Ole", 6,100,"1A");
		Student student2 = new Student("Olsen", "Oline", 7,101,"1A");
		
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);
		
		assertTrue(samling.leggTilUtvid(student1));
		assertTrue(samling.leggTilUtvid(student2));
		
		assertEquals(2,samling.getAntall());
		
		assertTrue(samling.finnes(student1));
		assertTrue(samling.finnes(student2));
		assertFalse(samling.ledigPlass());
		
		assertTrue(samling.leggTilUtvid(laerer));
		
		assertEquals(3,samling.getAntall());
		assertEquals(4,samling.getSamling().length);
		assertTrue(samling.ledigPlass());
		
		assertTrue(samling.finnes(student1));
		assertTrue(samling.finnes(laerer));
		assertTrue(samling.finnes(student2));
		
	}
	
	@Test
	public void testledigPlass() {
		
		PersonSamling samling = new PersonSamling(2);
		
		Student student1 = new Student("Olsen", "Ole", 6,100,"1A");
		Student student2 = new Student("Olsen", "Oline", 7,101,"1A");
		
		assertTrue(samling.ledigPlass());
		
		Person[] tabell = samling.getSamling();
		
		tabell[0] = student1;
		samling.setAntall(1);
		assertTrue(samling.ledigPlass());
		
		tabell[1] = student2;
		samling.setAntall(2);
		assertFalse(samling.ledigPlass());

	}
	
	@Test
	public void testslett() {
	
		PersonSamling samling = new PersonSamling(2);
		
		Student student = new Student("Olsen", "Ole", 6,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);

		samling.leggTil(student);
		samling.leggTil(laerer);
		
		assertEquals(samling.getAntall(),2);
		assertTrue(samling.finnes(student));
		assertTrue(samling.finnes(laerer));
		
		samling.slett(laerer);
		
		assertEquals(samling.getAntall(),1);
		assertTrue(samling.finnes(student));
		assertFalse(samling.finnes(laerer));
	}
	
	@Test
	public void testtoString() {
		PersonSamling samling = new PersonSamling(2);
		
		Student student = new Student("Olsen", "Ole", 6,100,"1A");
		Laerer laerer = new Laerer("Olsen", "Ole", 8,1000,7676);

		samling.leggTil(student);
		samling.leggTil(laerer);
		
		String str = "2\n" + "STUDENT\n6\nOlsen\nOle\n100\n1A\n" + 
				"LAERER\n8\nOlsen\nOle\n1000\n7676\n";
		//System.out.println(str);
		//System.out.println(samling.toString());	
		assertEquals(samling.toString(),str);
		
	}
}
