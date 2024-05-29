import java.io.*;
import java.util.*;
import java.util.logging.FileHandler;

public class Main {

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println("Exercise: " + arg);
            switch (arg) {
                case "1":
                    revertString();
                    break;
                case "2":
                    isThereAVowel();
                    break;
                case "3":
                    isAValidUrl("https://www.mundanosguild.com.ar");
                    isAValidUrl("http://regex.com/index.php");
                    isAValidUrl("https://glow.globant.com/dashboard/embedded;page=timeTracker.do;module=GLOW");
                    isAValidUrl("http://simpland/");
                    break;
                case "4":
                    isAPrimeNumber();
                    break;
                case "5":
                    firstNonRepeatedLetter();
                    break;
                case "6":
                    makeAFibonacci(0, 1, 10);
                    break;
                case "7":
                    onlyOdds(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));
                    onlyOdds(new ArrayList<Integer>(Arrays.asList(1, 3, 8, 7)));
                    break;
                case "8":
                    isPalindrome();
                    break;
                case "9":
                    stringManagement();
                    break;
                case "10":
                    sortPeople();
                    break;
                case "11":
                    findDuplicates();
                    break;
                case "12":
                    binarySearch(111);
                    break;
                case "13":
                    int[] numbers = {38, 27, 43, 10, 50};
                    int[] sortedNumbers = mergeSort(numbers);
                    System.out.println(Arrays.toString(numbers) + " sorted by Merge-Sort: " + Arrays.toString(sortedNumbers));
                    break;
                case "14":
                    projectEgypt();
                    break;
                case "15":
                    secondLargestNumber();
                    break;
                case "16":
                    findWordInFile();
                    break;
                default:
                    System.out.println("Invalid argument");
            }
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

    public static void isThereAVowel() {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("Spiderdalaj", "TV", "Monguer", "ngl"));
        for (String word : words) {
            String processedWord = word.toLowerCase();
            System.out.println(processedWord + " contains a vowel: " + processedWord.matches(".*[aeiou].*")); //anything, a vowel of the group, and anything
        }
    }

    public static void isAValidUrl(String url) {
        //For testing in regexr.com => (http|https)?:\/\/(www.)?(\w+\.)+com(\.\w+)?(\/\w+)*[\/\w+\.;=]+
        System.out.println("Url: " + url + " is valid: " + url.matches("(http|https)?://(www.)?(\\w+\\.)+com(\\.\\w+)?(/\\w+)*[/\\w+.;=]+"));
    }

    public static void isAPrimeNumber() {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 10, 11));
        for (Integer number : numbers) {
            if (number == 0 || number == 1)
                System.out.println(number + " is not a prime number");
            else {
                int i = 2;
                while (i < number) {
                    if (number % i == 0) {
                        System.out.println(number + " is not a prime number");
                        break;
                    }
                    i++;
                }
                if (i == number)
                    System.out.println(number + " is a prime number");
            }
        }
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
    }

    public static void makeAFibonacci(int numA, int numB, int limit) {
        System.out.print(numA + ", ");
        if (limit > 0) {
            limit--;
            makeAFibonacci(numB, numA + numB, limit);
        }
    }

    public static void onlyOdds(ArrayList<Integer> numbers) {
        System.out.print("Numbers in " + numbers.toString());
        boolean allOdds = true;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                allOdds = false;
                break;
            }
        }
        if (allOdds)
            System.out.println(" contains only odds");
        else
            System.out.println(" doesn't contains only odds");
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

    public static void stringManagement() {
        String phrase = "Eras una vez un chico que queria usar su nueva silla";
        System.out.println("Before: '" + phrase + "', after: '" + phrase.replace(" ", "") + "'");
        String word = "  Enhance the world ";
        System.out.println("Before: '" + word + "', after: '" + word.trim().strip() + "'");
    }

    public static void sortPeople() {
        Person mike = new Person("Mike Gourd", 25, 75);
        Person kelly = new Person("Kelly Clarkson", 28, 55);
        Person bob = new Person("Bob Smith", 45, 92);
        Person raul = new Person("Raul Oviedo", 35, 82);
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(mike);
        people.add(kelly);
        people.add(bob);
        people.add(raul);
        Collections.sort(people);
        System.out.println("The list of people ordered by age is: ");
        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getWeight() + " " + person.getAge());
        }
    }

    public static void findDuplicates() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 6, 7, 5, 4, 3, 7, 8, 5, 4, 4, 8, 4, 2, 1, 9));
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

    public static void binarySearch(int wanted) {
        //Pre-condition for BinarySearch: The following array must be ordered in order ascending
        int[] numbers = {1, 2, 6, 7, 8, 9, 10, 11, 12, 48, 60, 70, 87, 90, 91, 92, 93, 94, 95, 96, 97, 100, 102, 111};
        boolean found = false;
        int firstIdx = 0;
        int lastIdx = numbers.length - 1;

        if (wanted < numbers[firstIdx] || wanted > numbers[lastIdx]) {
            System.out.println("number " + wanted + " wasn't found in array: " + Arrays.toString(numbers));
        } else {
            while (!found && firstIdx <= lastIdx) {
                int halfIdx = (firstIdx + lastIdx) / 2;
                if (wanted > numbers[halfIdx]) {
                    firstIdx = halfIdx + 1;
                } else if (wanted < numbers[halfIdx]) {
                    lastIdx = halfIdx - 1;
                } else {
                    found = true;
                    System.out.println("number " + wanted + " found at position " + halfIdx + " in array: " + Arrays.toString(numbers));
                }
            }
            if (!found) {
                System.out.println("number " + wanted + " wasn't found in array: " + Arrays.toString(numbers));
            }
        }
    }

    public static int[] mergeSort(int[] numbers) {
        int size = numbers.length;
        int[] sorted_final = new int[size];

        if (size > 1) { //I can still divide
            int[] left_numbers = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
            int[] right_numbers = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);

            int[] sorted_left = mergeSort(left_numbers);
            int[] sorted_right = mergeSort(right_numbers);

            int idxLeft = 0;
            int idxRight = 0;
            for (int i = 0; i < size; i++) {
                if (idxLeft > (size / 2) - 1) { //left array is empty
                    sorted_final[i] = sorted_right[idxRight];
                    idxRight++;
                } else if (idxRight > (size / 2) - 1) { //right array is empty
                    sorted_final[i] = sorted_left[idxLeft];
                    idxLeft++;
                } else //both arrays have elements, need to compare to pick the littlest element
                    if (sorted_left[idxLeft] <= sorted_right[idxRight]) {
                        sorted_final[i] = sorted_left[idxLeft];
                        idxLeft++;
                    } else {
                        sorted_final[i] = sorted_right[idxRight];
                        idxRight++;
                    }
            }
        } else //both arrays have size 1
            sorted_final = numbers;

        return sorted_final;
    }

    public static void projectEgypt() {
        System.out.println("Pattern 2");
        for (int i = 1; i <= 9; i++) {
            int blanks = 9 - i;
            for (int j = 0; j < blanks / 2; j++) {
                System.out.print("  ");
            }
            if (i % 2 == 0)
                System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("Pattern 5");
        int middle = 9;
        for (int i = 9; i >= 1; i--) {
            int blanks = i - 1;
            for (int j = 0; j < blanks; j++) {
                System.out.print("  ");
            }
            for (int j = i; j <= middle; j++) {
                System.out.print(j + " ");
            }
            for (int j = middle - 1; j > i - 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
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

    public static void findWordInFile() {
        String word = "palabras";
        String file = "src/resources/archivo.txt";
        String result = null;

        try {
            DataInputStream reader = new DataInputStream(new FileInputStream(file));
            int nBytesToRead = reader.available();
            if (nBytesToRead > 0) {
                byte[] bytes = new byte[nBytesToRead];
                reader.read(bytes);
                result = new String(bytes);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file: " + e.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(result!=null)
            System.out.println("The file contains the word '"+word+"' = "+result.contains(word));
    }
}