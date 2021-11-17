import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
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
//        System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(expression)));
        char sim = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<expression.length(); i++) {
            sim = expression.charAt(i);
            if(getPriority(sim)==0){
                stringBuilder.append(sim);
            }
        }
        System.out.print(NumberConvector.romanToArabic(stringBuilder.toString()));


    }

    private static int getPriority(char token){
        if(token == '*' || token == '/' ) return 3;
        else if(token == '+' || token == '-') return 2;
        else if(token == ' ') return 1;
        else return 0;
    }
}
