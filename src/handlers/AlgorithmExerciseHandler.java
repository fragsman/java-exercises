package handlers;

import exercises.AlgorithmExercises;
import utils.ExerciseType;
import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmExerciseHandler extends ExerciseHandler{

    public static void handle() {
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch (exNumber) {
            case 1:
                AlgorithmExercises.binarySearch(111);
                break;
            case 2:
                int[] numbers = {38, 27, 43, 10, 50};
                int[] sortedNumbers = AlgorithmExercises.mergeSort(numbers);
                System.out.println(Arrays.toString(numbers) + " sorted by Merge-Sort: " + Arrays.toString(sortedNumbers));
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.ALGORITHM);
    }
}
