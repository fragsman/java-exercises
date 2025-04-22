package handlers;

import exercises.ObjectExercises;
import utils.ExerciseType;
import java.util.Scanner;

public class ObjectExerciseHandler extends ExerciseHandler{

    public static void handle(){
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch(exNumber) {
            case 1:
                ObjectExercises.sortPeople();
                break;
            case 2:
                ObjectExercises.lambdaExpressionExamples();
                break;
            case 3:
                ObjectExercises.streamExamples();
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.OBJECT);
    }
}
