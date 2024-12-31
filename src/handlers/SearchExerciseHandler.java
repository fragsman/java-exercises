package handlers;

import exercises.SearchExercises;
import utils.ExerciseType;
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
                SearchExercises.findDuplicates();
                break;
            case 3:
                SearchExercises.secondLargestNumber();
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.SEARCH);
    }
}
