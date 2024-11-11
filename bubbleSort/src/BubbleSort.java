import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов в массиве: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
        scanner.close();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        
        // Проход по всему массиву
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Сравнение соседних элементов
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен местами
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Если не было обменов, массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }
}