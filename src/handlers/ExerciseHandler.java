package handlers;

import utils.ExerciseType;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExerciseHandler {

    /**
     * For now the objective of this class will be reading from the README.md
     * the exercise descriptions to avoid having to update that information everywhere
     */

    public static void getExerciseList(ExerciseType exType){
        System.out.println("Please choose one of the following available exercises");

        //I will read from the README.md file to avoid maintaining the list in multiple places
        String rawFileContent = getFileContent();

        /*
        Raw content processing:
        I divide the content using the exType titles and keeping the second [1] part
        Then, again, I divide the content using '+' sign and getting the first [0] part
         */
        String listOfExercises = switch (exType) {
            case ExerciseType.ALGORITHM -> rawFileContent.split("Algorithm Exercises")[1].split("\\+")[0];
            case ExerciseType.FILE -> rawFileContent.split("File Exercises")[1].split("\\+")[0];
            case ExerciseType.MATH -> rawFileContent.split("Math Exercises")[1].split("\\+")[0];
            case ExerciseType.OBJECT -> rawFileContent.split("Object Exercises")[1].split("\\+")[0];
            case ExerciseType.SEARCH -> rawFileContent.split("Search Exercises")[1].split("\\+")[0];
            case ExerciseType.STRING -> rawFileContent.split("String Exercises")[1].split("\\+")[0];
            case ExerciseType.STRUCTURE -> rawFileContent.split("Structure Exercises")[1].split("\\+")[0];
            case ExerciseType.VISUAL -> rawFileContent.split("Visual Exercises")[1].split("\\+")[0];
        };

        System.out.println(listOfExercises);
    }

    private static String getFileContent(){
        String result = "";
        try {
            DataInputStream reader = new DataInputStream(new FileInputStream("README.md"));
            int nBytesToRead = reader.available();
            if (nBytesToRead > 0) {
                byte[] bytes = new byte[nBytesToRead];
                reader.read(bytes);
                result = new String(bytes);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file: " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
