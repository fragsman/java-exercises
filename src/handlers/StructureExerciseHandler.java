package handlers;

import exercises.StructureExercises;
import utils.ExerciseType;
import java.util.Scanner;

public class StructureExerciseHandler extends ExerciseHandler{

    public static void handle() {
        displayAvailableExercises();

        Scanner scanner;
        scanner = new Scanner(System.in);
        int exNumber = scanner.nextInt();
        switch (exNumber) {
            case 1:
                StructureExercises.orderAMap();
                break;
            case 2:
                StructureExercises.reverseALinkedList();
                break;
            case 3:
                StructureExercises.findLandToFarm();
                break;
            default:
                System.out.println("Invalid argument");
        }
    }

    public static void displayAvailableExercises(){
        getExerciseList(ExerciseType.STRUCTURE);
    }
}
