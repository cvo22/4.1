import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год для проверки (например, 2020): ");
        
        try {
            int year = Integer.parseInt(scanner.nextLine());
            boolean isLeapYear = checkLeapYear(year);
            
            if (isLeapYear) {
                System.out.println(year + " является високосным годом.");
            } else {
                System.out.println(year + " не является високосным годом.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введено неверное значение. Пожалуйста, введите целое число для года.");
        } finally {
            scanner.close();
        }
    }

    public static boolean checkLeapYear(int year) {
        // Год является високосным, если:
        // 1. Делится на 4, но не делится на 100
        // 2. Делится на 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
