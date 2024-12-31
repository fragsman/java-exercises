import handlers.SearchExerciseHandler;

import java.util.*;
import handlers.*;
import utils.ExerciseType;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please choose one of the following Exercise Types and press ENTER");
        ExerciseType[] possibleValues = ExerciseType.values();
        int i = 1;
        for (Object obj : possibleValues) {
            System.out.println(i + " - " + obj.toString());
            i++;
        }
        Scanner scanner;
        scanner = new Scanner(System.in);
        int exType = scanner.nextInt();

        switch (exType) {
            case 1:
                AlgorithmExerciseHandler.handle();
                break;
            case 2:
                FileExerciseHandler.handle();
                break;
            case 3:
                MathExerciseHandler.handle();
                break;
            case 4:
                ObjectExerciseHandler.handle();
                break;
            case 5:
                SearchExerciseHandler.handle();
                break;
            case 6:
                StringExerciseHandler.handle();
                break;
            case 7:
                StructureExerciseHandler.handle();
                break;
            case 8:
                VisualExerciseHandler.handle();
                break;
            default:
                System.out.println("Invalid argument");
        }
    }
}