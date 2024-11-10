import com.heman.resumeparser.ResumeParser;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to the resume file.");
            return;
        }
        try {
            Map<String, Integer> wordCountMap = ResumeParser.parseResume(args[0]);
            ResumeParser.printWordCounts(wordCountMap);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}