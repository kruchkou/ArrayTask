package by.epamte.task5;

public class Task5 {

    private static int maxEvenMinOddSum(int[] elementArray) {
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int index = 0; index < elementArray.length; index++) {
            if (index % 2 == 0) {
                minOdd = elementArray[index] < minOdd ? elementArray[index] : minOdd;
            }
            else {
                maxEven = elementArray[index] > maxEven ? elementArray[index] : maxEven;
            }
        }
        return maxEven + minOdd;
    }


    public static void main(String[] args) {
        int[] elementArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Sum = " + maxEvenMinOddSum(elementArray));
    }
}
