package handlers;

import exercises.FileExercises;
import utils.ExerciseType;
import java.util.Scanner;

public class FileExerciseHandler extends ExerciseHandler{

    public static void handle() {
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch (exNumber) {
            case 1:
                FileExercises.findWordInFile();
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.FILE);
    }
}
