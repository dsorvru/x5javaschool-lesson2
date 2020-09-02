import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        System.out.print("Введите целое трехзначное число и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip();
        scanner.close();

        if (isThreeDigitInteger(input)) {
            System.out.println("Сумма цифр числа: " + sumDigits(input));
        } else {
            System.out.println("Ошибка: Введенное значение не является целым трехзначным числом.");
        }
    }

    private static boolean isThreeDigitInteger(String value) {
        boolean threeDigitInteger = false;
        if ((value != null) && (value.matches("-?[1-9][0-9][0-9]"))) {
            threeDigitInteger = true;
        }
        return threeDigitInteger;
    }

    private static int sumDigits(String value) {
        // берем число по модулю, иначе сумма цифр отрицательного числа будет отрицательным числом
        int intValue = Math.abs(Integer.parseInt(value));
        int sum = 0;
        while (intValue != 0) {
            sum += intValue % 10;
            intValue /=  10;
        }
        return sum;
    }
}