package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class StructureExercises {

    /**
     * This class will contain structure exercises such as
     * exercises that will heavily rely on an structure for its resolution
     * like an array, matrix, map, etc.
     */

    public static void orderAMap(){
        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "Sandra");
        map.put(2, "Cassandra");
        map.put(3, "Alejandra");
        Map<Integer,String> orderedMap = new LinkedHashMap<>();
        map.putAll((x,y)->x>y);*/
    }

    public static void reverseALinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1,2,9,50,100));
        System.out.println("Original Linked List: ");
        for(Integer number : linkedList){
            System.out.print(number+", ");
        }
        LinkedList<Integer> reversedLL = linkedList.reversed();
        System.out.println("Reversed Linked List: ");
        for(Integer number : reversedLL){
            System.out.print(number+", ");
        }
    }

    /**
     * Given a matrix of int with r,c size that represent Land, where 1s is farmable land
     * and 0s not farmable. Find the biggest square (rxr) of farmable land.
     * For the example of r=5,c=6
     * 0 1 0 1 0
     * 0 1 1 1 0
     * 1 1 1 1 0
     * 1 1 1 1 1
     * 0 0 0 0 0
     * We could return the top-left position where the land starts and the bottom-right position
     * where the land ends. In this case (1,1)-(3,4)
     */
    public static void findLandToFarm(){
        int r=6,c=5;
        int[][] matrix = {
                {0,1,0,1,0},
                {0,1,1,1,0},
                {1,1,1,1,0},
                {1,1,1,1,1},
                {1,1,0,0,0},
                {1,1,1,0,0}
        };
        int max = 0;
        int currentSquareSize;
        String maxSquareCoordinates = "none";

        for(int i = 0; i<r; i++){
            if(max > r-i) //I avoid processing more rows since the max is already bigger than remaining rows
                break;
            for(int j=0; j<c; j++){
                if(max > c-j) //I avoid processing more columns since the max is already bigger than remaining columns
                    break;
                currentSquareSize = 0;
                if(matrix[i][j]!=0) {
                    currentSquareSize++;
                    boolean neighbourCells = i < r-1 && j < c-1; //Are there neighbouring cells?
                    if (neighbourCells)
                        currentSquareSize += areNeighboursCellsFarmable(currentSquareSize, matrix, r, c, i, j);

                    if (currentSquareSize > max) {
                        //Save coordinates in a string
                        int toI = i;
                        int toJ = j;
                        if(currentSquareSize>1){
                            toI = i + currentSquareSize-1;
                            toJ = j + currentSquareSize-1;
                        }
                        maxSquareCoordinates = "(" + i + "," + j + ")-(" + toI+ "," + toJ + ")";
                        max = currentSquareSize;
                    }
                }
            }
        }
        System.out.println("First and bigger farmable land coordinates: "+maxSquareCoordinates);
    }

    private static int areNeighboursCellsFarmable(int currentSquareSize, int[][] matrix, int r, int c, int endI, int endJ){
        boolean zeroesFound = false;
        int fromIdxI = endI+1, fromIdxJ=endJ+1;
        int toIdxJ = fromIdxJ-currentSquareSize;
        int toIdxI = fromIdxI-currentSquareSize;

        //Verify I found no zeros in horizontal neighbours
        for(int j=fromIdxJ; j>= toIdxJ; j--) {
            if (matrix[fromIdxI][j] == 0) {
                zeroesFound = true;
                break;
            }
        }

        //Verify I found no zeros in vertical neighbours
        for(int i=fromIdxI; i>= toIdxI; i--) {
            if (matrix[i][fromIdxJ] == 0) {
                zeroesFound = true;
                break;
            }
        }

        if(!zeroesFound){
            boolean neighbourCells = fromIdxI < r-1 && fromIdxJ < c-1; //Are there neighbouring cells?
            if (neighbourCells)
                currentSquareSize+= areNeighboursCellsFarmable(currentSquareSize, matrix, r, c,endI+1,endJ+1);
            return currentSquareSize;
        }else
            return 0;
    }
}
