package com.sshwind;
import java.util.List;
import java.util.stream.Collectors;

public class GuessWord {
	
	public static List<Word> listWords(String template, String availableLetters) {
		LetterArray letterArray = new LetterArray(availableLetters);
		if(Dict.isEmpty())
			Dict.loadFromResource("/chn.txt");
		return Dict.stream().filter(w->
			WordTemplate.test(template, w.getWord()) && letterArray.isConstructable(w.getWord())
		).collect(Collectors.toList());
	}

}

