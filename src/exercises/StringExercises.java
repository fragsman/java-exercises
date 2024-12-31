package exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class StringExercises {

    /**
     * This class will contain string exercises such as
     * regex analysis, word concatenation, string functions, etc.
     */

    public static void isAValidUrl(String url) {
        //For testing in regexr.com => (http|https)?:\/\/(www.)?(\w+\.)+com(\.\w+)?(\/\w+)*[\/\w+\.;=]+
        System.out.println("Url: " + url + " is valid: " + url.matches("(http|https)?://(www.)?(\\w+\\.)+com(\\.\\w+)?(/\\w+)*[/\\w+.;=]+"));
    }

    public static void isPalindrome() {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("aimemia", "fedefdef"));
        for (String word : words) {
            int j = word.length() - 1;
            boolean palindrome = true;
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(j)) {
                    palindrome = false;
                    break;
                }
                j--;
            }
            if (palindrome)
                System.out.println("The word " + word + " is Palindrome");
            else
                System.out.println("The word " + word + " is not Palindrome");
        }
    }

    public static void isThereAVowel() {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("Spiderdalaj", "TV", "Monguer", "ngl"));
        for (String word : words) {
            String processedWord = word.toLowerCase();
            System.out.println(processedWord + " contains a vowel: " + processedWord.matches(".*[aeiou].*")); //anything, a vowel of the group, and anything
        }
    }

    public static void revertString() {
        String word = "Kubernetes";
        int len = word.length() - 1;

        StringBuilder reverseWord = new StringBuilder();
        for (int i = len; i >= 0; i--) {
            reverseWord.append(word.charAt(i));
        }

        System.out.println("Original string: " + word + " - Reversed string: " + reverseWord);
    }

    public static void stringManagement() {
        String phrase = "Eras una vez un chico que queria usar su nueva silla";
        System.out.println("Before: '" + phrase + "', after: '" + phrase.replace(" ", "") + "'");
        String word = "  Enhance the world ";
        System.out.println("Before: '" + word + "', after: '" + word.trim().strip() + "'");
    }
}
