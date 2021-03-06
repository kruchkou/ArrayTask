package by.epamte.task2;

public class Task2 {

    private static int minElem(int[] elementArray) {
        int minElement = Integer.MAX_VALUE;
        for (int element : elementArray) {
            minElement = element < minElement ? element : minElement;
        }
        return minElement;
    }

    private static int elementQuantity(int number, int[] elementArray) {
        int quantity = 0;
        for (int element : elementArray) {
            quantity = element == number ? ++quantity : quantity;
        }
        return quantity;
    }

    private static int[] arrayWithoutMinElem(int[] elementArray) {
        int[] resultArray;
        int resultArrayIndex = 0;
        int minElem = minElem(elementArray);
        resultArray = new int[elementArray.length - elementQuantity(minElem, elementArray)];

        for (int element : elementArray) {
            if (element == minElem) {
                continue;
            }
            resultArray[resultArrayIndex++] = element;
        }

        return resultArray;
    }


    public static void main(String[] args) {
        int[] elementArray = {4, 2, -4, -4, 6, 10, 8, -4, 5};
        int[] arrayWithoutMinElem = arrayWithoutMinElem(elementArray);
        StringBuilder result = new StringBuilder();

        for (int elem : arrayWithoutMinElem) {
            result.append(elem).append(" ");
        }
        System.out.println(result);
    }
}
