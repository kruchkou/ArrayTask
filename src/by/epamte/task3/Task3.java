package by.epamte.task3;

public class Task3 {

    private static int randomNum(int fromNum, int toNum) {
        return fromNum + (int) (Math.random() * toNum);
    }

    private static boolean isOpened(int[] lockRow) {
        final int CORRECT_SUM = 10;
        int sumOfTree = lockRow[0] + lockRow[1] + lockRow[2];
        int prevNumIndex = 0;

        if (sumOfTree != 10) {
            return false;
        }

        for (int index = 3; index < lockRow.length; index++) {
            sumOfTree -= lockRow[prevNumIndex];
            sumOfTree += lockRow[index];
            prevNumIndex++;

            if (sumOfTree != CORRECT_SUM) {
                return false;
            }
        }

        return true;
    }

    private static boolean rollDice(int diceNum, int firstDicePos, int secondDicePos, int[] lockRow) {
        for (int num = 1; num <= 6; num++) {
            if (diceNum != firstDicePos && diceNum != secondDicePos) {
                lockRow[diceNum] = num;
            }
            if(isOpened(lockRow)) {
                return true;
            }
            if (diceNum != 0) {
                if (rollDice(diceNum - 1, firstDicePos, secondDicePos, lockRow)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String arrayToString(int[] array) {
        StringBuilder answer = new StringBuilder();
        for (int num : array) {
            answer.append(num + " ");
        }
        return answer.toString();
    }

    private static String unlock(int firstDicePos, int secondDicePos, int[] lockRow) {
        boolean isOpened = rollDice(lockRow.length-1, firstDicePos, secondDicePos, lockRow);

        if (isOpened) {
            return arrayToString(lockRow);
        }

        return "The lock can't be opened.";
    }

    public static void main(String[] args) {
        final int LOCK_SIZE = 10;
        int[] lockRow = new int[LOCK_SIZE];
        int firstDicePos = randomNum(0, LOCK_SIZE-1);
        int secondDicePos;

        do {
            secondDicePos = randomNum(0, LOCK_SIZE-1);
        } while (firstDicePos == secondDicePos);

        lockRow[firstDicePos] = randomNum(1, 6);
        lockRow[secondDicePos] = randomNum(1, 6);

        System.out.println(arrayToString(lockRow));
        System.out.println(unlock(firstDicePos, secondDicePos, lockRow));
    }
}