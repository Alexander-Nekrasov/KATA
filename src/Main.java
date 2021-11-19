import java.io.Reader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        String[] line = expression.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < line.length; i++) {
                if(!line[i].contains("+")&&!line[i].contains("-")&&!line[i].contains("*")&&!line[i].contains("/"))
                    stringBuilder.append(line[i]);
        }
        if (Integer.parseInt(stringBuilder.toString())<=1010) {
            System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(expression)));
        } else throw new InputMismatchException("The number is not on the interval 1 - 10");

            // Результат чисел
            // System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(expression)));



        //Результат римский
        //System.out.println(Convector.arabicToRoman(Calculator
         //       .RPNtoAnswer(Calculator.ExpressionToRPN(RomaToArabic.arabicExpression(expression)))));
    }

}
