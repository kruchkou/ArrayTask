package by.epamte.task4;

public class Task4 {

    private static int elementQuantity(int number, int[] elementArray) {
        int quantity = 0;
        for (int element : elementArray) {
            quantity = element == number ? ++quantity : quantity;
        }
        return quantity;
    }

    private static int mostFrequentNums(int[] elementArray) {
        int maxQuantity = 0;
        int elemWithMaxQuantity = Integer.MAX_VALUE;

        for (int element : elementArray) {
            int elementQuantity = elementQuantity(element, elementArray);

            if (elementQuantity > maxQuantity) {
                maxQuantity = elementQuantity;
                elemWithMaxQuantity = element;

            } else if (elementQuantity == maxQuantity) {
                elemWithMaxQuantity = element < elemWithMaxQuantity ? element : elemWithMaxQuantity;
            }
        }
        return elemWithMaxQuantity;
    }


    public static void main(String[] args) {
        int[] elementArray = {-4, 2, -16, -4, -16, -16, 8, -4, 5};

        int mostFrequentElement = mostFrequentNums(elementArray);

        System.out.println("Most Frequent element: " + mostFrequentElement);

    }
}
