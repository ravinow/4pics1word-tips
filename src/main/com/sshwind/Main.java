package com.sshwind;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 2 && (args.length != 4 || !args[2].equals("-dict"))) {
			System.out.println("Usage: java -jar GuessWord.jar Word_template Available_letters [-dict file.txt]\n" +
								"Parameters:\n" + 
								"\tWord_template: Something like '*****', where star represents any letter and the number of stars equals to the length of word\n" + 
								"\tAvailable_letters: Something like 'DKERJIOWUD', which are the available letter to form the word\n" +
								"\t-dict file.txt: use file.txt as dictionary instead of the default chn.txt\n" +
								"Returns:\n"+
								"\tConformed words from dictionary");
			return;
		}
		
		String template = args[0];
		String letters = args[1];
		
		if(args.length == 4){
			if(!Files.exists(Paths.get(args[3]))){
				System.err.println("File " + args[3] + " does not exist!");
				return;
			}
			Dict.loadFromFile(args[3]);		
		}
		
		GuessWord.listWords(template, letters)
			.forEach(System.out::println);
	}
	
}