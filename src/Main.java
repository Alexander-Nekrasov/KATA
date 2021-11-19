import java.io.Reader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        String[] line = expression.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (int i=0; i < line.length; i++) {

            if ( Convector.romanToArabic(line[0])>0 && Convector.romanToArabic(line[0])<=10
                    && Convector.romanToArabic(line[2])>0 && Convector.romanToArabic (line[2])<=10){
                stringBuilder1.append( line[i]);
            } else if(Integer.parseInt(line[0])>0 && Integer.parseInt(line[0])<=10 // с парсингом проблема
                    && Integer.parseInt(line[2])>0 && Integer.parseInt(line[2])<=10) {
//                if (!line[i].contains("+") && !line[i].contains("-")
//                        && !line[i].contains("*") && !line[i].contains("/"))
                    stringBuilder.append(line[i]);
            } else
            {throw new InputMismatchException("The number is not on the interval 1 - 10");}
        }

            if(stringBuilder.length()>0){
        System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(stringBuilder.toString())));}
             else if(stringBuilder1.length()>0) {
                System.out.println(Convector.arabicToRoman(Calculator
                       .RPNtoAnswer(Calculator.ExpressionToRPN(RomaToArabic.arabicExpression(expression)))));
            }


            // Результат чисел
            // System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(expression)));



        //Результат римский
        //System.out.println(Convector.arabicToRoman(Calculator
         //       .RPNtoAnswer(Calculator.ExpressionToRPN(RomaToArabic.arabicExpression(expression)))));
    }

}
