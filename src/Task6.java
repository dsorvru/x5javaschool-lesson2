import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        System.out.print("Введите целое число и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip();
        scanner.close();

        if (isInteger(input)) {
            System.out.println(getDescription(input));
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

    private static String getDescription(String input) {
        String description;
        if (input.equals("0")) {
            description = "нулевое число";
        } else {

            if (input.charAt(0) == '-') {
                description = "отрицательное";
            } else {
                description = "положительное";
            }

            if (isEven(input)) {
                description += " четное";
            } else {
                description += " нечетное";
            }
            description += " число";
        }

        return description;
    }

    private static boolean isEven(String number) {
        boolean evenNumber = false;
        switch (number.charAt(number.length() - 1)) {
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
                evenNumber = true;
                break;
        }
        return evenNumber;
    }
}
