import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lab_3 = new Scanner(System.in);

        System.out.println("Размерность массива: ");
        int measure = lab_3.nextInt();
        if (measure <= 0) {
            System.out.println("Размер массива должен быть положительным!");
            System.exit(-1);
        }

        System.out.println("Массив: ");
        float numbers [] = new float[measure];

        for (int n = 0; n < measure; n++) {
            numbers [n] = lab_3.nextFloat();
        }

        System.out.print("Исходный массив: ");
        for (int n = 0; n < measure; n++) {
            System.out.print(numbers[n] + " ");
        }

        System.out.println();
        System.out.print("Массив после обработки: " + numbers[0] + " ");
        int k = 1;
        for (int n = 0; n < measure; n++) {
            for (int j = 1; j<measure+1; j++) {
                k++;

                System.out.print((numbers[n] + numbers[j]) / k + " ");
                numbers[n] += numbers[j];
            }
        }
    }
}