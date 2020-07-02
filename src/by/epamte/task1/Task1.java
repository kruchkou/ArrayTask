package by.epamte.task1;

public class Task1 {

    private static double maxSum(double[] elementArray) {
        final int ARRAY_SIZE = elementArray.length - 1;
        double maxSum = Double.MIN_VALUE;

        for (int index = 0; index < (elementArray.length / 2); index++) {
            double sum = elementArray[index] + elementArray[ARRAY_SIZE - index];
            maxSum = maxSum > sum ? maxSum : sum;
        }

        return maxSum;
    }


    public static void main(String[] args) {
        double[] elementArray = {-16, 2, -4, 4, 6, 10, 8, -9, 5};

        double max = maxSum(elementArray);

        System.out.println("MAX = " + max);
    }
}
