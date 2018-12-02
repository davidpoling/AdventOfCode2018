package advent.code;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 extends AdventCode2018 {
	
	private List<String> entities;
	
	protected Day2() {
		this(PREFIX + "checksum.txt");
	}

	protected Day2(String filePath) {
		super(filePath);
		this.entities = new ArrayList<>();
	}

	@Override
	public List<String> readEntities() throws IOException {
		Files.lines(FileSystems.getDefault().getPath(this.filePath)).forEach(line -> {
			this.entities.add(line);
		});
		
		return this.entities;
	}
	
	@Override
	public int dayTwoPart1() throws IOException {
		this.entities = this.readEntities();
		int checkSum = 0;
		int twoOccurrences = 0;
		int threeOccurrences = 0;
		
		for (String entity : this.entities) {
			Map<Character, Integer> occurrences = new HashMap<>();
			char[] characters = entity.toCharArray();
			boolean foundTwo = false;
			boolean foundThree = false;
			for (int i = 0; i < characters.length; i++) {
				if (occurrences.containsKey(characters[i])) {
					occurrences.put(characters[i], occurrences.get(characters[i]) + 1);
				}
				else {
					occurrences.put(characters[i], 1);
				}
			}
			
			for (Character c : occurrences.keySet()) {
				if (occurrences.get(c) == 2 && !foundTwo) {
					twoOccurrences++;
					foundTwo = true;
				}
				if (occurrences.get(c) == 3 && !foundThree) {
					threeOccurrences++;
					foundThree = true;
				}
			}
		}
		
		if (twoOccurrences == 0) {
			return checkSum + threeOccurrences;
		}
		else if (threeOccurrences == 0) {
			return checkSum + twoOccurrences;
		}
		else {
			return twoOccurrences * threeOccurrences;
		}
	}
	
	@Override
	public String dayTwoPart2() {
		String common = "";
		
		for (int i = 0; i < this.entities.size() - 1; i++) {
			for (int j = 1; j < this.entities.size(); j++) {
				common = getCommon(this.entities.get(i), this.entities.get(j));
				if (!common.equals("")) {
					return common;
				}
			}
		}
		
		return common;
	}
	
	private String getCommon(final String s1, final String s2) {
		String common = "";
		
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i)) {
					common += s1.charAt(i);
				}
			}			
		}
		
		if (common.length() == s1.length() - 1) {
			return common;
		}
		else {
			return "";
		}
	}
}
