package com.sshwind;

public class Word {
	
	private final String word;
	private final String explanation;
	
	public String getWord() {
		return word;
	}
	public String getExplanation() {
		return explanation;
	}
	
	public Word(String word, String explanation){
		this.word = word;
		this.explanation = explanation;
	}
	@Override
	public String toString(){
		if(explanation != null && !"".equals(explanation))
			return word + '\t' + explanation;
		else
			return word;
	}
}
