import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        System.out.print("Введите три целых числа, отделяя их друг от друга символом пробел, и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        try {

            int[] values = getNumbersFromUser(scanner, 3);
            System.out.println("Наименьшее из чисел: " + minValue(values));

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int[] getNumbersFromUser(Scanner scanner, int requestedNumbers) throws Exception {
        String input = scanner.nextLine().strip();
        String[] splittedInput = input.split("\\s+");
        if (splittedInput.length != requestedNumbers) {
            throw new Exception("Введено неверное количество чисел.");
        }

        int[] numbers = new int[splittedInput.length];
        for (int i = 0; i < splittedInput.length; i++) {
            numbers[i] = StringToInteger(splittedInput[i]);
        }
        return numbers;
    }

    private static int StringToInteger(String value) throws Exception {
        if (!isInteger(value)) {
            throw new Exception("\"" + value + "\" не является целым числом.");
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            String msg = "Число \"" + value + "\" очень большое или очень маленькое."
                    + " Используйте диапазон [" + Integer.MIN_VALUE + ":" + Integer.MAX_VALUE + "].";
            throw new Exception(msg);
        }
    }

    private static boolean isInteger(String value) {
        boolean valueIsInteger = false;
        if ((value != null) && (value.matches("0|-?[1-9][0-9]*"))) {
            valueIsInteger = true;
        }
        return valueIsInteger;
    }

    public static int minValue(int[] arr) {
        if (isEmptyArray(arr)) {
            return 0;
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ( arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static boolean isEmptyArray(int[] arr) {
        boolean isEmpty = false;
        if ((arr == null) || (arr.length == 0)) {
            isEmpty = true;
        }
        return isEmpty;
    }
}
