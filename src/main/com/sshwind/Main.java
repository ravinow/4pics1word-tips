package com.sshwind;

import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Main class for the program, accessed from command line
 * @author chengchang
 *
 */
public class Main {

	/**
	 * Entrance method
	 * The program will list all the words that conform the template and can be constructed using the given letters
	 * args[0] is the word template like '***', args[1] is the available letters like 'ABC', 
	 * args[2] and args[3] are optional. If args[2] = '-dict', args[3] refers to the dictionary file to be used
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length != 2 && (args.length != 4 || !args[2].equals("-dict"))) {
			System.out.println("Usage: java -jar GuessWord.jar Word_template Available_letters [-dict file.txt]\n" +
								"Parameters:\n" + 
								"\tWord_template: Something like '***', where star represents any letter and the number of stars equals to the length of word\n" + 
								"\tAvailable_letters: Something like 'ABC', which are the available letter to form the word\n" +
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