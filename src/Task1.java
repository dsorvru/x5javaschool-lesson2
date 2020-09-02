import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.print("Введите целое число и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip();
        scanner.close();

        if (isInteger(input)) {
            System.out.println("Последняя цифра: " + input.charAt(input.length() - 1));
        } else {
            System.out.println("Ошибка: Введенное значение не является целым числом.");
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
