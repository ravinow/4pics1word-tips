package com.sshwind.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.sshwind.GuessWord;
import com.sshwind.Word;

public class TestGuessWord {

	@Test
	public void testListWords() {
		List<Word> list = GuessWord.listWords("***", "ABC");
		
		assertNotNull(list);
		assertEquals(list.size(),3);
		
		assertEquals(list.get(0).getWord(),"abc");
		assertEquals(list.get(1).getWord(),"bac");
		assertEquals(list.get(2).getWord(),"cab");

		assertEquals(GuessWord.listWords("abc", "ABC").size(),1);
		
		assertEquals(GuessWord.listWords("", "ABC").size(),0);
		assertEquals(GuessWord.listWords("***", "DJH").size(),0);
		assertEquals(GuessWord.listWords("****", "ABC").size(),0);
		assertEquals(GuessWord.listWords("***", "").size(),0);
	}

}
