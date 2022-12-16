import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuilder answer_string = new StringBuilder();
        Scanner scan_lab = new Scanner(System.in);
        Pattern splitter = Pattern.compile("[^_]+");
        int score = 0;
        int number = 0;

        System.out.print("Размерность массива: ");
        try {
            number = scan_lab.nextInt();
        } catch (Exception e) {
            System.out.print("Ошибка. Введите целое значение!");
            System.exit(-1);
        }

        double[] source_array = new double[number];

        System.out.print("Массив: ");
        for (int n = 0; n < number; n++) {
            try {
                source_array[n] = scan_lab.nextDouble();
            }
            catch (Exception err) {
                System.out.println("Ошибка. Введите число!");
                System.exit(-1);
            }
        }

        double last_value = source_array[0];

        for (double piece : source_array) {
            if (last_value <= piece) {
                answer_string.append(piece).append("_");
                last_value = piece;
                score += 1;
            }
        }

        double[] organized_array = new double[score];
        Matcher valid = splitter.matcher(answer_string.toString());

        int l = 0;
        while (valid.find()){
            organized_array[l] = Double.parseDouble(valid.group());
            l++;
        }
        System.out.printf("Исходный массив: %s\n", format_arrays(source_array));
        System.out.printf("Массив после обработки: %s", format_arrays(organized_array));
    }

    private static String format_arrays(double[] paste_array) {
        StringBuilder result_string = new StringBuilder();
        for (double item : paste_array) {
            result_string.append(item).append(" ");
        }

        return result_string.toString();
    }
}
