package handlers;

import exercises.StringExercises;
import utils.ExerciseType;
import java.util.Scanner;

public class StringExerciseHandler extends ExerciseHandler{

    public static void handle(){
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch(exNumber){
            case 1:
                StringExercises.isAValidUrl("https://www.mundanosguild.com.ar");
                StringExercises.isAValidUrl("http://regex.com/index.php");
                StringExercises.isAValidUrl("https://glow.globant.com/dashboard/embedded;page=timeTracker.do;module=GLOW");
                StringExercises.isAValidUrl("http://simpland/");
                break;
            case 2:
                StringExercises.isPalindrome();
                break;
            case 3:
                StringExercises.revertString();
                break;
            case 4:
                StringExercises.stringManagement();
                break;
            case 5:
                StringExercises.isThereAVowel();
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.STRING);
    }
}
