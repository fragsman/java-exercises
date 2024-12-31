package exercises;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExercises {

    /**
     * This class will contain exercises with in-out handing
     * such as reading from a file or writing to a file
     */

    public static void findWordInFile() {
        String word = "palabras";
        String file = "src/resources/archivo.txt";
        String result = null;

        try {
            DataInputStream reader = new DataInputStream(new FileInputStream(file));
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
        if(result!=null)
            System.out.println("The file contains the word '"+word+"' = "+result.contains(word));
    }
}
