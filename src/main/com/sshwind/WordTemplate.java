package com.sshwind;
/**
 * Class for the word template
 * @author chengchang
 *
 */
public class WordTemplate {
	/**
	 * Test whether a word conforms the template
	 * @param template the template of word
	 * @param word the word to be tested
	 * @return true if the word conforms the template
	 */
	public static boolean test(String template, String word){
		if(word.length() != template.length()) 
			return false;
		
		template = template.toLowerCase();
		word = word.toLowerCase();
		
		for(int i=0;i<word.length();i++)
			if(template.charAt(i)!='*' && template.charAt(i)!=word.charAt(i))
				return false;
		return true;
	}
}
