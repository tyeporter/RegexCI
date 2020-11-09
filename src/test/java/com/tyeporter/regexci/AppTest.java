package com.tyeporter.regexci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class AppTest {

	@Test
	public void testForLetters() {
		int matches = findMatches("at", "cat, hat, bat, bob");

		assertEquals(3, matches);
	}

	@Test
	public void testForNumbers() {
		int matches = findMatches("512", "512-111-1111, 512-222-2222, 412-333-3333");

		assertEquals(2, matches);
	}

	@Test
	public void testForAnyNonDigit() {
		boolean matchFound = findMatch("\\D", "98&262");

		assertTrue(matchFound);
	}

	@Test 
	public void testForAnyDigit() {
		boolean matchFound = findMatch("\\d", "tyeporter_4@gmail.com");

		assertTrue(matchFound);
	}

	@Test
	public void testForPeriod() {
		int matches = findMatchForEach("\\.", new String[]{
			"This is a sentence.",
			"is a frament",
			"This is another sentence."
		});

		assertEquals(3, matches);
	}

	// =========================================================
    // HELPER METHODS
    // =========================================================

    private static int findMatches(String regex, String input) {
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(input);

    	int matches = 0;

    	while (matcher.find()) {
    		matches++;
    	}

    	return matches;
    }

    private static boolean findMatch(String regex, String input) {
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(input);

    	return matcher.find();
    }

    private static int findMatchForEach(String regex, String[] inputs) {
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher;

    	int matches = 0;
    	for (String input : inputs) {
    		matcher = pattern.matcher(input);
    		if (matcher.find()) {
    			matches++;
    		}
    	}

    	return matches;
    }
    
}
