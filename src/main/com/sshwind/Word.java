package com.sshwind;
/**
 * Word class represent a word and its explanation
 * @author chengchang
 *
 */
public class Word {
	
	/** the word */
	private final String word;
	
	/** the word's explanation */
	private final String explanation;
	
	/**
	 * Get the word
	 * @return
	 */
	public String getWord() {
		return word;
	}
	/**
	 * Get the word's explanation
	 * @return
	 */
	public String getExplanation() {
		return explanation;
	}
	/**
	 * Constructor, using a word and its explanation
	 * @param word
	 * @param explanation
	 */
	public Word(String word, String explanation){
		this.word = word;
		this.explanation = explanation;
	}
	/** 
	 * return the word and its explanation as string
	 */
	@Override
	public String toString(){
		if(explanation != null && !"".equals(explanation))
			return word + '\t' + explanation;
		else
			return word;
	}
	/**
	 * determine whether two words are equivalent, only based on the words, not their explanations
	 */
	@Override
	public boolean equals(Object another){
		if(another==null || !(another instanceof Word))
			return false;
		Word anotherword = (Word)another;
		if(word==null)
			return (anotherword.word==null);
		else
			return word.equals(anotherword.word);
	}
}
