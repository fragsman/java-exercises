package exercises;

import java.util.*;


public class MathExercises {

    public static class Interval implements Comparable<Interval> {
        private int lowerInterval;
        private int upperInterval;

        public Interval(int lowerInterval, int upperInterval){
            this.lowerInterval = lowerInterval;
            this.upperInterval = upperInterval;
        }

        public int getLowerInterval() {
            return lowerInterval;
        }
        public int getUpperInterval(){
            return upperInterval;
        }

        @Override
        public int compareTo(Interval intervalCompared) {
            if(this.getLowerInterval() > intervalCompared.getLowerInterval())
                return 1;
            else
                if(this.getLowerInterval() < intervalCompared.getLowerInterval())
                    return -1;
            return 0;
        }

        public void printOnScreen(){
            System.out.print("["+getLowerInterval() +","+getUpperInterval()+"]");
        }
    }
    /**
     * This class will contain mathematical exercises such as
     * knowing if a number is prime, replicating a fibonacci sequence, etc.
     */

    public static void isAPrimeNumber() {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 10, 11));
        for (Integer number : numbers) {
            if (number == 0 || number == 1)
                System.out.println(number + " is not a prime number");
            else {
                int i = 2;
                while (i < number) {
                    if (number % i == 0) {
                        System.out.println(number + " is not a prime number");
                        break;
                    }
                    i++;
                }
                if (i == number)
                    System.out.println(number + " is a prime number");
            }
        }
    }

    public static void makeAFibonacci(int numA, int numB, int limit) {
        System.out.print(numA + ", ");
        if (limit > 0) {
            limit--;
            makeAFibonacci(numB, numA + numB, limit);
        }
    }

    public static void onlyOdds(ArrayList<Integer> numbers) {
        System.out.print("Numbers in " + numbers.toString());
        boolean allOdds = true;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                allOdds = false;
                break;
            }
        }
        if (allOdds)
            System.out.println(" contains only odds");
        else
            System.out.println(" doesn't contains only odds");
    }

    public static String resolvePolishNotation(String[] expression){
        int res, operator1, operator2;
        Stack<String> auxStack = new Stack<>();
        for(String item : expression){
            if(item.matches("[+\\-*/]")) {
                operator2 = Integer.parseInt(auxStack.pop());
                operator1 = Integer.parseInt(auxStack.pop());
                res = switch(item){
                    case "+" -> operator1 + operator2;
                    case "-" -> operator1 - operator2;
                    case "*" -> operator1 * operator2;
                    case "/" -> operator1 / operator2;
                    default -> throw new IllegalStateException("Unexpected value: " + item);
                };
                auxStack.push(String.valueOf(res));
            }else
                auxStack.push(item);
        }

        return auxStack.pop();
    }

    /*
    * Given a collection of intervals, merge all overlapping intervals.
    * For example,
    * Given [1,3],[2,6],[8,10],[15,18],
    * return [1,6],[8,10],[15,18].
     */
    public static void mergeIntervals(){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(3,4));

        Collections.sort(intervals);
        System.out.println("Intervals: ");
        for(Interval interval : intervals)
            interval.printOnScreen();

        int elements = intervals.size();
        int i = 0;
        while(i < elements){
            Interval leftInterval = intervals.get(i);
            Interval rightInterval = intervals.get(i+1);

            if(leftInterval.getUpperInterval() > rightInterval.getLowerInterval()){ //overlap
                if(leftInterval.getUpperInterval() > rightInterval.getUpperInterval()) //rightInterval fits entirely leftInterval, discard it
                    intervals.remove(rightInterval);
                else{ //only the adjacent numbers are overlapping, merge them
                    intervals.remove(leftInterval);
                    intervals.remove(rightInterval);
                    Interval mergedInterval = new Interval(leftInterval.getLowerInterval(), rightInterval.getUpperInterval());
                    intervals.add(i,mergedInterval);
                }
            }else
                elements++;
        }

        System.out.println("\nMerged Intervals: ");
        for(Interval interval : intervals)
            interval.printOnScreen();
    }
}
