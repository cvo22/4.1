import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1. Вычислить сложный процент");
        System.out.println("2. Найти необходимый процент для достижения заданного числа");
        System.out.print("Введите номер действия (1 или 2): ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                calculateCompoundInterest(scanner);
                break;
            case 2:
                calculateRequiredRate(scanner);
                break;
            default:
                System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
        }
        
        scanner.close();
    }

    private static void calculateCompoundInterest(Scanner scanner) {
        System.out.print("Введите начальную сумму (число1): ");
        double principal = scanner.nextDouble();
        
        System.out.print("Введите процент (в виде десятичной дроби, например, 0.05 для 5%): ");
        double rate = scanner.nextDouble();
        
        System.out.print("Введите количество периодов: ");
        int periods = scanner.nextInt();
        
        double amount = principal * Math.pow(1 + rate, periods);
        System.out.printf("Сумма после %d периодов составит: %.2f%n", periods, amount);
    }

    private static void calculateRequiredRate(Scanner scanner) {
        System.out.print("Введите начальную сумму (число1): ");
        double principal = scanner.nextDouble();
        
        System.out.print("Введите конечную сумму (число2): ");
        double amount = scanner.nextDouble();
        
        System.out.print("Введите количество периодов: ");
        int periods = scanner.nextInt();
        
        // Формула для нахождения необходимого процента
        double requiredRate = Math.pow(amount / principal, 1.0 / periods) - 1;
        System.out.printf("Необходимый процент для достижения %.2f от %.2f за %d периодов составит: %.2f (или %.2f%%)%n",
                amount, principal, periods, requiredRate, requiredRate * 100);
    }
}