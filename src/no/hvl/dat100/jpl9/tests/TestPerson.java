package no.hvl.dat100.jpl9.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPerson {

	@Test
	public void testConstructor() {
	
		long fnummer = 10069418300L;
		
		TPerson person = new TPerson("Olsen", "Ole", fnummer);
		
		assertEquals(person.getEtternamn(),"Olsen");
		assertEquals(person.getFornamn(),"Ole");
		assertEquals(person.getFodselsnummer(),fnummer);
	}

	@Test
	public void testSet() {
		TPerson person = new TPerson();
		long fnummer = 10069418300L;
		
		person.setEtternamn("Olsen");
		person.setFornamn("Ole");
		person.setFodselsnummer(fnummer);
		
		assertEquals(person.getEtternamn(),"Olsen");
		assertEquals(person.getFornamn(),"Ole");
		assertEquals(person.getFodselsnummer(),fnummer);
	}
	
	@Test
	public void testMann() {
		long fnummer = 10069418300L;
		
		TPerson person = new TPerson("Olsen", "Ole", fnummer);
		
		assertTrue(person.erMann());
	}
	
	@Test
	public void testKvinne() {
		long fnummer = 10069418200L;
		
		TPerson person = new TPerson("Olsen", "Oline", fnummer);
		
		assertTrue(person.erKvinne());
	}
	
	@Test
	public void testKjonn() {
		
		TPerson kvinne = new TPerson("Olsen", "Oline", 10069418200L);
		TPerson mann = new TPerson("Olsen", "Ole", 10069418300L);
		
		assertFalse(kvinne.erMann());
		assertTrue(kvinne.erKvinne());
		
		assertTrue(mann.erMann());
		assertFalse(mann.erKvinne());
		
	}
	
	@Test
	public void testerLik() {
		TPerson person1 = new TPerson("Olsen", "Oline", 8);
		TPerson person2 = new TPerson("Olsen", "Oline", 8);
		TPerson person3 = new TPerson("Olsen", "Oline", 7);
		
		assertFalse(person1.erLik(person3));
		assertTrue(person1.erLik(person2));
	}
	
	@Test 
	public void testtoString() {
		
		TPerson person = new TPerson("Olsen", "Ole", 10100110700L);
		
		String personstr = "10100110700\nOlsen\nOle\n";
		
		assertTrue(person.toString().equals(personstr));
		
	}	
}
