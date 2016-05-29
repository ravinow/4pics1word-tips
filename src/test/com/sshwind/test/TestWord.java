package com.sshwind.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sshwind.Word;

public class TestWord {

	@Test
	public void testAll() {
		Word w = new Word("abc","exp");
		Word w2 = new Word("abc","exp2");
		
		assertEquals(w.getWord(),"abc");
		assertEquals(w.getExplanation(),"exp");
		assertEquals(w,w2);
		assertNotEquals(w,null);
		assertNotEquals(w,"abc");
		assertEquals(w.toString(),"abc\texp");
	}
	
}
