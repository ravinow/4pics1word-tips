package com.sshwind;
public class LetterArray{
	private int array[] = new int[26];
	
	private final String letters;
	
	public LetterArray(String letters){
		this.letters = letters.toUpperCase();
	}
	
	private void initArray(){
		for(int i=0;i<array.length;i++){
			array[i] = 0;
		}
		for(int i=0;i<letters.length();i++){
			array[letters.charAt(i)-'A']++;
		}
	}
	
	public boolean isConstructable(String word){
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