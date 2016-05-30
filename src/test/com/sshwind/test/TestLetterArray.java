package com.sshwind.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sshwind.LetterArray;

public class TestLetterArray {

	@Test
	public void testIsConstructible() {
		LetterArray a = new LetterArray("ABC");
		assertTrue(a.isConstructible("abc"));
		assertTrue(a.isConstructible("bac"));
		assertTrue(a.isConstructible("ab"));
		assertTrue(a.isConstructible(""));
		assertFalse(a.isConstructible("bad"));
		assertFalse(a.isConstructible("abac"));
	}

}
