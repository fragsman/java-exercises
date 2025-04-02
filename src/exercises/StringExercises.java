package exercises;

import java.util.*;

public class StringExercises {

    /**
     * This class will contain string exercises such as
     * regex analysis, word concatenation, string functions, etc.
     */

    public static void isAValidUrl(String url) {
        //For testing in regexr.com => (http|https)?:\/\/(www.)?(\w+\.)+com(\.\w+)?(\/\w+)*[\/\w+\.;=]+
        System.out.println("Url: " + url + " is valid: " + url.matches("(http|https)?://(www.)?(\\w+\\.)+com(\\.\\w+)?(/\\w+)*[/\\w+.;=]+"));
    }

    public static void isIsomorphic(String s, String t){
        /*
         * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.
         * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
         */
        System.out.print("S="+s+" and T="+t+" are isomorphic ");
        if(s.length()!=t.length()){
            System.out.println("NO");
        }else{
            //Maybe, analyze
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            for (int i = 0; i < sChars.length; i++){
                s=s.replace(sChars[i],tChars[i]);
            }
            System.out.print("(replaced S string '"+s+"'): ");

            if(s.equals(t)){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
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

    public static void sumCharacters(String name){
        String letters = "abcdefghijklmnñopqrstuwxyz";
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i<26; i++){
            map.put(String.valueOf(letters.charAt(i)),i+1);
        }

        name = name.toLowerCase();
        int lenOfName = name.length();
        int sum = 0;
        for(int i=0; i<lenOfName; i++){
            char c = name.charAt(i);
            sum+= map.get(String.valueOf(c));
        }

        System.out.println("The sum of the values for the letters in "+ name+" is: "+sum);
    }
}
