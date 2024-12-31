package exercises;

import java.util.Arrays;

public class AlgorithmExercises {

    /**
     * This class will contain exercises with classic algorithms
     * such as mergeSort, binarySearch, etc.
     */

    public static void binarySearch(int wanted) {
        //Pre-condition for BinarySearch: The following array must be ordered in order ascending
        int[] numbers = {1, 2, 6, 7, 8, 9, 10, 11, 12, 48, 60, 70, 87, 90, 91, 92, 93, 94, 95, 96, 97, 100, 102, 111};
        boolean found = false;
        int firstIdx = 0;
        int lastIdx = numbers.length - 1;

        if (wanted < numbers[firstIdx] || wanted > numbers[lastIdx]) {
            System.out.println("number " + wanted + " wasn't found in array: " + Arrays.toString(numbers));
        } else {
            while (!found && firstIdx <= lastIdx) {
                int halfIdx = (firstIdx + lastIdx) / 2;
                if (wanted > numbers[halfIdx]) {
                    firstIdx = halfIdx + 1;
                } else if (wanted < numbers[halfIdx]) {
                    lastIdx = halfIdx - 1;
                } else {
                    found = true;
                    System.out.println("number " + wanted + " found at position " + halfIdx + " in array: " + Arrays.toString(numbers));
                }
            }
            if (!found) {
                System.out.println("number " + wanted + " wasn't found in array: " + Arrays.toString(numbers));
            }
        }
    }

    public static int[] mergeSort(int[] numbers) {
        int size = numbers.length;
        int[] sorted_final = new int[size];

        if (size > 1) { //I can still divide
            int[] left_numbers = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
            int[] right_numbers = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);

            int[] sorted_left = mergeSort(left_numbers);
            int[] sorted_right = mergeSort(right_numbers);

            int idxLeft = 0;
            int idxRight = 0;
            for (int i = 0; i < size; i++) {
                if (idxLeft > (size / 2) - 1) { //left array is empty
                    sorted_final[i] = sorted_right[idxRight];
                    idxRight++;
                } else if (idxRight > (size / 2) - 1) { //right array is empty
                    sorted_final[i] = sorted_left[idxLeft];
                    idxLeft++;
                } else //both arrays have elements, need to compare to pick the littlest element
                    if (sorted_left[idxLeft] <= sorted_right[idxRight]) {
                        sorted_final[i] = sorted_left[idxLeft];
                        idxLeft++;
                    } else {
                        sorted_final[i] = sorted_right[idxRight];
                        idxRight++;
                    }
            }
        } else //both arrays have size 1
            sorted_final = numbers;

        return sorted_final;
    }
}
