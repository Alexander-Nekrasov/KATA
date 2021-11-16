import java.util.Scanner;

public class CalculatorArabic {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberFirst = getInt();
        int numberSecond = getInt();
        char operation = getOperation();
        int result = calculation(numberFirst,numberSecond,operation);

        System.out.println("Результат операции: " + result);
    }

    public static int getInt(){
        System.out.println("Введите число:");

        int number;

        if (scanner.hasNext()){
            number = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.nextInt();
            number = getInt();
        }

        return number;
    }

    public static char getOperation(){
        System.out.println("Введите операцию: ");

        char operation;

        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }

        return operation;
    }

    public static int calculation(int numberFirst, int numberSecond, char operation){
        int result = 0;

        switch (operation){
            case '+':
                result = numberFirst + numberSecond;
                break;
            case '-':
                result = numberFirst - numberSecond;
                break;
            case '*':
                result = numberFirst * numberSecond;
                break;
            case '/':
                result = numberFirst / numberSecond;
                break;
        }

        return result;
    }
}
