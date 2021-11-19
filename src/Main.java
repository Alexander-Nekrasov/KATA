import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();



            // Результат чисел
            System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(expression)));



        //Результат римский
        //System.out.println(Convector.arabicToRoman(Calculator
         //       .RPNtoAnswer(Calculator.ExpressionToRPN(RomaToArabic.arabicExpression(expression)))));
    }
}
