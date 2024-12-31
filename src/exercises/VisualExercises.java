package exercises;

public class VisualExercises {

    /**
     * This class will contain visual exercises such as
     * printing on screen a specific figure using the STDOUT (console)
     */

    public static void projectEgypt() {
        System.out.println("Pattern 2");
        for (int i = 1; i <= 9; i++) {
            int blanks = 9 - i;
            for (int j = 0; j < blanks / 2; j++) {
                System.out.print("  ");
            }
            if (i % 2 == 0)
                System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("Pattern 5");
        int middle = 9;
        for (int i = 9; i >= 1; i--) {
            int blanks = i - 1;
            for (int j = 0; j < blanks; j++) {
                System.out.print("  ");
            }
            for (int j = i; j <= middle; j++) {
                System.out.print(j + " ");
            }
            for (int j = middle - 1; j > i - 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
