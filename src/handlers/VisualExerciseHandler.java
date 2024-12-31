package handlers;

import exercises.VisualExercises;
import utils.ExerciseType;
import java.util.Scanner;

public class VisualExerciseHandler extends ExerciseHandler{

    public static void handle() {
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch (exNumber) {
            case 1:
                VisualExercises.projectEgypt();
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.VISUAL);
    }
}
