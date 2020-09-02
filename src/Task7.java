import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Task7 {

    private static final int DURATION_MINUTES = 10;
    private static final char DECIMAL_SEPARATOR = '.';

    public static void main(String[] args) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(DECIMAL_SEPARATOR);
        DecimalFormat df = new DecimalFormat("#0.0#", symbols);
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(2);

        String[] codes = {"905","194", "491", "800"};
        String[] names = {"Москва", "Ростов","Краснодар","Киров"};
        BigDecimal[] pricesPerMinute = {
                BigDecimal.valueOf(4.15),
                BigDecimal.valueOf(1.98),
                BigDecimal.valueOf(2.69),
                BigDecimal.valueOf(5.00)
        };

        System.out.print("Введите код города и нажмите [enter]: ");

        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().strip();
        scanner.close();

        try {

            checkIfCodeValid(input);
            int index = indexOfCode(input, codes);
            BigDecimal cost = pricesPerMinute[index].multiply(BigDecimal.valueOf(DURATION_MINUTES));
            String description = names[index] + ". Стоимость разговора: " + df.format(cost);
            System.out.println(description);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void checkIfCodeValid(String code) throws Exception {
        if ((code == null) || (! code.matches("\\d{3}"))) {
            throw new Exception("Введен недопустимый код города");
        }
    }

    private static int indexOfCode(String code, String[] codes) throws Exception {
        for (int i = 0; i < codes.length; i++) {
            if  (code.equals(codes[i])) {
                return i;
            }
        }
        throw new Exception("Неизвестный код города.");
    }

}
