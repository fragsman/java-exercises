package handlers;

import utils.ExerciseType;

public class ExerciseHandler {

    /**
     * For now the objective of this class will be reading from the README.md
     * the exercise descriptions to avoid having to update that information everywhere
     */

    public static void getExerciseList(ExerciseType exType){
        System.out.println("Please choose one of the following available exercises");
        //Read from the README.md file

        //Lookup for the section I want depending on the exType
        switch(exType){
            case ExerciseType.ALGORITHM -> System.out.println("Algorithm ex. types");
            case ExerciseType.FILE -> System.out.println("File ex. types");
            case ExerciseType.MATH -> System.out.println("Math ex. math");
            case ExerciseType.OBJECT -> System.out.println("Object ex. types");
            case ExerciseType.SEARCH -> System.out.println("Search ex. types");
            case ExerciseType.STRING -> System.out.println("String ex. types");
            case ExerciseType.STRUCTURE -> System.out.println("Structure ex. types");
            case ExerciseType.VISUAL -> System.out.println("Visual ex. types");
        }
        //Print on screen the list of exercises

        //Todo: complete reading from the README.md
    }
}
