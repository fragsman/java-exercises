package exercises;

import java.util.Arrays;
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
}
