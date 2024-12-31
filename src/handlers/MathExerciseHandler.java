package handlers;

import exercises.MathExercises;
import utils.ExerciseType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MathExerciseHandler extends ExerciseHandler{

    public static void handle(){
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch(exNumber){
            case 1:
                MathExercises.isAPrimeNumber();
                break;
            case 2:
                MathExercises.makeAFibonacci(0, 1, 10);
                break;
            case 3:
                MathExercises.onlyOdds(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));
                MathExercises.onlyOdds(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.MATH);
    }
}
