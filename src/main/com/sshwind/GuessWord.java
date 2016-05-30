package com.sshwind;
import java.util.List;
import java.util.stream.Collectors;
/**
 * The main class of the program as a library, which contains only one method listWords to get the feasible words
 * @author chengchang
 *
 */
public class GuessWord {
	
	/**
	 * get feasible words from a dictionary that conform the template and can be comprised of the available letters
	 * @param template the form of words like '*****' or 'A*C'
	 * @param availableLetters all the letters that can be used to construct the word
	 * @return a list of feasible words
	 */
	public static List<Word> listWords(String template, String availableLetters) {
		LetterArray letterArray = new LetterArray(availableLetters);
		if(Dict.isEmpty())
			Dict.loadFromResource("/chn.txt");
		return Dict.stream().filter(w->
			WordTemplate.test(template, w.getWord()) && letterArray.isConstructible(w.getWord())
		).collect(Collectors.toList());
	}

}

