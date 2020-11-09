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
    
}
