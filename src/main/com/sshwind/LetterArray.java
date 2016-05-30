package com.sshwind;
/**
 * The class used to determine whether a word can be constructed by given letters
 * @author chengchang
 *
 */
public class LetterArray{
	/** the letter array, the value of which is the number of corresponding letters given */
	private int array[] = new int[26];
	
	/** given letters */
	private final String letters;
	
	/**
	 * Constructor, pass the available letters 
	 * @param letters available letters like 'DKJHAEIU'
	 */
	public LetterArray(String letters){
		this.letters = letters.toUpperCase();
	}
	/**
	 * Initialize the array using given letters
	 */
	private void initArray(){
		for(int i=0;i<array.length;i++){
			array[i] = 0;
		}
		for(int i=0;i<letters.length();i++){
			array[letters.charAt(i)-'A']++;
		}
	}
	/**
	 * The main method, determine whether a word can be constructed using given letters or not
	 * @param word the word to be tested
	 * @return true if it is constructible
	 */
	public boolean isConstructible(String word){
		String ucword = word.toUpperCase();
		initArray();
		for(int i=0;i<ucword.length();i++){
			int j = ucword.charAt(i)-'A';
			if(j < 0 || j >= 26) return false;
			if(array[j] > 0){
				array[j]--;
			}else{
				return false;
			}
		}
		return true;
	}
}