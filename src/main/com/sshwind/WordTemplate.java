package com.sshwind;

public class WordTemplate {
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
