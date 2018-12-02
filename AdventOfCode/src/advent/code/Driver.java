package advent.code;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		Day1 day1 = new Day1();
		Day2 day2 = new Day2();
		
		try {
			System.out.println("Day 1 Part 1: " + day1.dayOnePart1());
			System.out.println("Day 1 Part 2: " + day1.dayOnePart2());
			System.out.println("Day 2 Part 1: " + day2.dayTwoPart1());
			System.out.println("Day 2 Part 2: " + day2.dayTwoPart2());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
