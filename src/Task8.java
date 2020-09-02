import java.math.BigDecimal;

public class Task8 {

    public static void main(String[] args) {
        int[] arr = {1, -10, 5, 6, 45, 23, -45, -34, 0, 32, 56, -1, 2, -2};
        System.out.println("Максимальное значение: " + maxValue(arr));
        System.out.println("Сумма положительных элементов: " + sumPositives(arr));
        System.out.println("Сумма четных отрицательных элементов: " + sumEvenNegatives(arr));
        System.out.println("Количество положительных элементов: " + countPositives(arr));
        System.out.println("Среднее арифметическое отрицательных элементов: " + averageNegatives(arr));
    }

    public static int maxValue(int[] arr) {
        if (isEmptyArray(arr)) {
            return 0;
        }

        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static int sumPositives(int[] arr) {
        if (isEmptyArray(arr)) {
            return 0;
        }

        int sum = 0;
        for (int item : arr) {
            if (item > 0) {
                sum += item;
            }
        }
        return sum;
    }

    public static int sumEvenNegatives(int[] arr) {
        if (isEmptyArray(arr)) {
            return 0;
        }

        int sum = 0;
        for (int item: arr) {
            if ((item < 0) && (item % 2 == 0)) {
                sum += item;
            }
        }
        return sum;
    }

    public static int countPositives(int[] arr) {
        if (isEmptyArray(arr)) {
            return 0;
        }

        int count = 0;
        for (int item: arr) {
            if (item > 0) {
                count++;
            }
        }
        return count;
    }

    public static BigDecimal averageNegatives(int[] arr) {
        if (isEmptyArray(arr)) {
            return BigDecimal.ZERO;
        }

        int countNegatives = 0;
        int sumNegatives = 0;
        for (int item: arr) {
            if (item < 0) {
                sumNegatives += item;
                countNegatives++;
            }
        }

        BigDecimal average;
        if (countNegatives > 0) {
            average = BigDecimal.valueOf(sumNegatives).divide(BigDecimal.valueOf(countNegatives));
        } else {
            average = BigDecimal.ZERO;
        }
        return average;
    }

    private static boolean isEmptyArray(int[] arr) {
        boolean isEmpty = false;
        if ((arr == null) || (arr.length == 0)) {
            isEmpty = true;
        }
        return isEmpty;
    }
}
