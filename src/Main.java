import java.io.Reader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//
////      System.out.println(Calculator.ExpressionToRPN("10+1")); // разбери с пробелами при вводе
//
//
          String expression = new Scanner(System.in).nextLine();

//        System.out.println(NumberConvector.arabicToRoman(Calculator
//                                                        .RPNtoAnswer(Calculator
//                                                        .ExpressionToRPN(expression))));
        System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(expression)));

    }
}
