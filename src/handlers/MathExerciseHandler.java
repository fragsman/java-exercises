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
                MathExercises.onlyOdds(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));
                MathExercises.onlyOdds(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));
                break;
            case 4:
                //String[] expression = new String[]{"3","4","*"};//result=12
                //String[] expression = new String[]{"3","4","+","5","6","+","*"};//result=77
                String[] expression = new String[]{"4","2","5","*","+","1","3","2","*","+","/"};//result2
                System.out.println("Eval: Reverse Polish Notation for:");
                printStringArray(expression);

                System.out.println("Result: "+MathExercises.resolvePolishNotation(expression));
                break;
            case 5:
                MathExercises.mergeIntervals();
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.MATH);
    }
}
