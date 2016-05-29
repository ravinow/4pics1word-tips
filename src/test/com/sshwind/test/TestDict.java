package com.sshwind.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sshwind.Dict;

public class TestDict {

	@Test
	public void testAll() {
		/* testIsEmpty */
		assertTrue(Dict.isEmpty());
		
		/* testLoadFromFile */
		Dict.loadFromFile("dictionaries/chn.txt");
		
		assertFalse(Dict.isEmpty());
		
		/* testLoadFromResource */
		Dict.loadFromResource("/chn.txt");
		
		assertFalse(Dict.isEmpty());
		
		/* testContains */
		assertTrue(Dict.contains("good"));
		assertFalse(Dict.contains("123"));
		
		/* testGetExplanation */
		assertEquals(Dict.getExplanation("good"),"n.好,好事,慷慨的行为,好处,利益adj.优良的,上等的,虔诚的,愉快的,慈善的,好心的,有益的");
		
		/* testStream */
		assertEquals(Dict.stream().filter(s->s.getWord().equals("good")).count(),1);
	}
	
}
