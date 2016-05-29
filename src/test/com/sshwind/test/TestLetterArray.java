package com.sshwind.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sshwind.LetterArray;

public class TestLetterArray {

	@Test
	public void testIsConstructable() {
		LetterArray a = new LetterArray("ABC");
		assertTrue(a.isConstructable("abc"));
		assertTrue(a.isConstructable("bac"));
		assertTrue(a.isConstructable("ab"));
		assertTrue(a.isConstructable(""));
		assertFalse(a.isConstructable("bad"));
		assertFalse(a.isConstructable("abac"));
	}

}
