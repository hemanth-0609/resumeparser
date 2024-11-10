package com.heman.resumeparser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ResumeParser {

    private static Set<String> TECHNICAL_TERMS;
    private static Set<String> STOP_WORDS;

    static {
        try {
            loadTermsFromProperties("tech-words-config.properties");
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
            TECHNICAL_TERMS = Set.of(); // Default to empty set if loading fails
            STOP_WORDS = Set.of();
        }
    }

    /**
     * Loads technical terms and stop words from a properties file.
     *
     * @param filePath The path to the properties file.
     * @throws IOException If an I/O error occurs.
     */
    private static void loadTermsFromProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        }

        TECHNICAL_TERMS = Arrays.stream(properties.getProperty("technical.terms", "")
                .split(",")).map(String::trim).collect(Collectors.toSet());

        STOP_WORDS = Arrays.stream(properties.getProperty("stop.words", "")
                .split(",")).map(String::trim).collect(Collectors.toSet());
    }

    /**
     * Reads the resume from a file, identifies technical words, and counts their occurrences.
     *
     * @param filePath The path to the resume file.
     * @return A map with technical words as keys and their occurrence counts as values.
     * @throws IOException If an I/O error occurs.
     */
    public static Map<String, Integer> parseResume(String filePath) throws IOException {
        System.out.println(filePath);
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.println(TECHNICAL_TERMS);

        Map<String, Integer> wordCountMap = new HashMap<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (TECHNICAL_TERMS.contains(word) && !STOP_WORDS.contains(word)) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println(wordCountMap);
        return wordCountMap;
    }

    /**
     * Prints the word count map in a formatted way.
     *
     * @param wordCountMap The map with word counts.
     */
    public static void printWordCounts(Map<String, Integer> wordCountMap) {
        wordCountMap.forEach((word, count) -> System.out.println(word + ": " + count));
    }

}
