package ch09;

import java.util.*;
public class MyVoca {

	public static void main(String[] args) {
		
		Voca englishVoca = new Voca("EnglishVoca");
		VocaEx japaneseVoca = new VocaEx("JapaneseVoca");
		
		englishVoca.addWord();
		englishVoca.addWord();
		englishVoca.addWord();
		englishVoca.viewList();
		
		System.out.println("-----------------------\n");
		
		japaneseVoca.addWord();
		japaneseVoca.addWord();
		japaneseVoca.addWord();
		japaneseVoca.viewList();
	}

}

class WordSet {
	protected String word;
	protected String mean;
	
	public WordSet(String w, String m) {
		word = w;
		mean = m;
	}

	public String getWord() {
		return word;
	}

	public String getMean() {
		return mean;
	}
	
}

class WordSetEx extends WordSet {
	private String sound;

	public WordSetEx(String w, String s, String m) {
		super(w, m);
		sound = s;
	}

	public String getSound() {
		return sound;
	}
	
}

class Voca {
	Scanner scanner = new Scanner(System.in);
	
	private ArrayList<WordSet> wordsList = new ArrayList<WordSet>();
	
	protected String vocaName;
	
	public Voca(String name) {
		vocaName = name;
	}
	
	public void addWord() {
		String w, m;
		WordSet word;
		
		System.out.print("추가할 단어 : ");
		w = scanner.next();
		
		System.out.print("추가할 단어의 뜻 : ");
		m = scanner.next();
		
		word = new WordSet(w, m);
		
		wordsList.add(word);
	}

	public void viewList() {
		System.out.println(vocaName + "의 목록");
		
		for (int i = 0; i < wordsList.size(); i++) {
			System.out.println(wordsList.get(i).getWord() + " " + wordsList.get(i).getMean());
		}
		
		System.out.println("");
	}
	
}

class VocaEx extends Voca {
	private ArrayList<WordSetEx> wordsList = new ArrayList<WordSetEx>();

	public VocaEx(String name) {
		super(name);
	}
	
	@Override
	public void addWord() {
		String w, s, m;
		WordSetEx word;
		
		System.out.print("추가할 단어 : ");
		w = scanner.next();
		
		System.out.print("추가할 단어의 발음 : ");
		s = scanner.next();
		
		System.out.print("추가할 단어의 뜻 : ");
		m = scanner.next();
		
		word = new WordSetEx(w, s, m);
		
		wordsList.add(word);
	}

	@Override
	public void viewList() {
		System.out.println(vocaName + "의 목록");
		
		for (int i = 0; i < wordsList.size(); i++) {
			System.out.println(wordsList.get(i).getWord() + " " + wordsList.get(i).getSound() + " " +  wordsList.get(i).getMean());
		}
		
		System.out.println("");
	}
	
}