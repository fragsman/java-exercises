package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchExercises {

    /**
     * This class will contain search exercises such as
     * finding a word or a character in a string or a number in an array,
     * analyzing if a string or an array of numbers contains certain elements, etc.
     */

    public static void findDuplicates(ArrayList<Integer> numbers) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Integer number : numbers) {
            if (countMap.containsKey(number)) {
                countMap.put(number, countMap.get(number) + 1);
            } else {
                countMap.put(number, 1);
            }
        }
        if (!countMap.isEmpty()) {
            countMap.forEach((k, v) -> {
                if (v > 1)
                    System.out.println("number " + k + ", repeats " + v + " times");
            });
        } else
            System.out.println("There are no duplicates in " + numbers.toString());
    }

    public static void findDuplicatesUsingStreams(ArrayList<Integer> numbers){
        numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(),HashMap::new,Collectors.counting()))
                .forEach((k,v) -> {
                    if(v>1)
                        System.out.println("Number "+k+" repeats itself "+v+" times");
                });
    }

    public static void firstNonRepeatedLetter() {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("aabccdbeef", "aaxxjdccdj"));
        for (String word : words) {
            int len = word.length();
            boolean found = false;
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                for (int j = 0; j < len; j++) {
                    if (c == word.charAt(j) && i != j) {
                        break;
                    } else if (j == len - 1) {
                        System.out.println("The first non repeated character in " + word + " is: " + c);
                        found = true;
                    }
                }
                if (found)
                    break;
            }
            if (!found)
                System.out.println("There are no non-repeated characters in " + word);
        }
        firstNonRepeatedLetterUsingStreams(); //Made by ChatGPT
    }

    public static void firstNonRepeatedLetterUsingStreams(){
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("aabccdbeef", "aaxxjdccdj"));
        for(String word : words){
            Map<Character,Long> map = word.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.groupingBy(Function.identity(),HashMap::new,Collectors.counting()));
            char primeraNoRepetida = '\0'; // carácter nulo por si no hay ninguno
            for (char c : word.toCharArray()) {
                if (map.get(c) == 1) {
                    primeraNoRepetida = c;
                    break;
                }
            }
            if (primeraNoRepetida != '\0') {
                System.out.println("La primera letra no repetida en \"" + word + "\" es: " + primeraNoRepetida);
            } else {
                System.out.println("No hay letras no repetidas en \"" + word + "\"");
            }
        }
    }

    public static void secondLargestNumber() {
        int[] numbers = {1, 2, 5, 999, 6, 90, 100, 400, 3, 500}; //Second largest number is 400
        int maxAct = 0, maxAnt = 0;
        for (int num : numbers) {
            if (num > maxAct) {
                maxAnt = maxAct;
                maxAct = num;
            } else if (num > maxAnt) {
                maxAnt = num;
            }
        }
        System.out.println("The second largest number in: " + Arrays.toString(numbers) + "  is: " + maxAnt);
    }
}
