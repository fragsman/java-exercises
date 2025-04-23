package handlers;

import exercises.SearchExercises;
import utils.ExerciseType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchExerciseHandler extends ExerciseHandler{

    public static void handle() {
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch (exNumber) {
            case 1:
                SearchExercises.firstNonRepeatedLetter();
                break;
            case 2:
                ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 6, 7, 5, 4, 3, 7, 8, 5, 4, 4, 8, 4, 2, 1, 9));
                SearchExercises.findDuplicates(numbers);
                SearchExercises.findDuplicatesUsingStreams(numbers);
                break;
            case 3:
                SearchExercises.secondLargestNumber();
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.SEARCH);
    }
}
