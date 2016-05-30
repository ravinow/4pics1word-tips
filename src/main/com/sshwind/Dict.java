package com.sshwind;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Dict contains the words loaded from dictionary file and have basic query functions
 * @author chengchang
 *
 */
public class Dict {

	/** the hashmap of dictionary words */
	private static Map<String,Word> words;
	
	/**
	 * whether the dictionary is empty or not
	 * @return true if the dictionary is empty
	 */
	public static boolean isEmpty(){
		return (words==null || words.size()==0);
	}
	/**
	 * load dictionary from external text file
	 * @param dictfile the path of the text file
	 */
	public static void loadFromFile(String dictfile){
		try {
			load(Files.lines(Paths.get(dictfile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * load dictionary from internal resource text file
	 * @param path the path of the resource
	 */
	public static void loadFromResource(String path){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(Dict.class.getResourceAsStream(path)))){
			load(br.lines());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * load dictionary from a stream of lines
	 * @param stream
	 */
	private static void load(Stream<String> stream){
		words = new HashMap<>(stream.map(s->
			(s.indexOf('\t') >= 0) ?
				new Word(s.substring(0,s.indexOf('\t')),s.substring(s.indexOf('\t')+1)) : new Word(s,"")
		).collect(Collectors.toMap(Word::getWord, UnaryOperator.identity())));
	}
	/**
	 * whether the dictionary contains a word
	 * @param word the word to query
	 * @return
	 */
	public static boolean contains(String word){
		return words.containsKey(word);
	}
	/**
	 * get the explanation for a word
	 * @param word the word to query
	 * @return its explanation
	 */
	public static String getExplanation(String word){
		return words.get(word).getExplanation();
	}
	/**
	 * get a stream for the words in the dictionary
	 * @return
	 */
	public static Stream<Word> stream(){
		return words.values().stream();
	}
}
