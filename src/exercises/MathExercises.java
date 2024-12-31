package exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class MathExercises {

    /**
     * This class will contain mathematical exercises such as
     * knowing if a number is prime, replicating a fibonacci sequence, etc.
     */

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
}
