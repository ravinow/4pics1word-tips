package com.sshwind.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sshwind.GuessWord;
import com.sshwind.WordTemplate;

public class TestWordTemplate {

	@Test
	public void testTest() {
		assertTrue(WordTemplate.test("***", "abc"));
		assertFalse(WordTemplate.test("****", "abc"));
		assertFalse(WordTemplate.test("**", "abc"));
		assertFalse(WordTemplate.test("", "abc"));
		assertFalse(WordTemplate.test("***", ""));
		
		assertTrue(WordTemplate.test("a*c", "abc"));
		assertTrue(WordTemplate.test("abc", "abc"));
		assertFalse(WordTemplate.test("a*c", "abd"));
		assertFalse(WordTemplate.test("a**", "bbd"));
	}

}
