import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        System.out.print("Введите целое число и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        try {

            int value = getNumberFromUser(scanner);
            if (value > 0) {
                value++;
            }
            System.out.println("Полученное число: " + value);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getNumberFromUser(Scanner scanner) throws Exception {
        String input = scanner.nextLine().strip();
        if (! isInteger(input)) {
            throw new Exception("Введенное значение не является целым числом.");
        }

        try {
            int intValue = Integer.parseInt(input);
            return intValue;
        } catch (Exception e) {
            String msg = "Веденное число очень большое или очень маленькое."
                    + " Используйте диапазон [" + Integer.MIN_VALUE + ":" + Integer.MAX_VALUE + "].";
            throw new Exception();
        }
    }

    private static boolean isInteger(String value) {
        boolean valueIsInteger = false;
        if ((value != null) && (value.matches("0|-?[1-9][0-9]*"))) {
            valueIsInteger = true;
        }
        return valueIsInteger;
    }
}
