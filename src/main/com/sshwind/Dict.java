package com.sshwind;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dict {

	private static Map<String,Word> words;
	
	public static boolean isEmpty(){
		return (words==null || words.size()==0);
	}
	
	public static void loadFromFile(String dictfile){
		try {
			load(Files.lines(Paths.get(dictfile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadFromResource(String path){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(Dict.class.getResourceAsStream(path)))){
			load(br.lines());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void load(Stream<String> stream){
		words = new HashMap<>(stream.map(s->
			(s.indexOf('\t') >= 0) ?
				new Word(s.substring(0,s.indexOf('\t')),s.substring(s.indexOf('\t')+1)) : new Word(s,"")
		).collect(Collectors.toMap(Word::getWord, UnaryOperator.identity())));
	}
	
	public static boolean contains(String word){
		return words.containsKey(word);
	}
	
	public static String getExplanation(String word){
		return words.get(word).getExplanation();
	}
	
	public static Stream<Word> stream(){
		return words.values().stream();
	}
}
