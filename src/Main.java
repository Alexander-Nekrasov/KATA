import java.io.Reader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        String[] line = expression.split(" ");

        if (line.length > 3 || line.length < 3) throw new IndexOutOfBoundsException("the format of the mathematical operation does not satisfy");

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (int i = 0; i < line.length; i++) {

            try {
                if (Integer.parseInt(line[0]) > 0 && Integer.parseInt(line[0]) <= 10
                        && Integer.parseInt(line[2]) > 0 && Integer.parseInt(line[2]) <= 10) {
                    stringBuilder.append(line[i]);
                }
            } catch (Exception e) {
            }

            try {
                if (Convector.romanToArabic(line[0]) > 0 && Convector.romanToArabic(line[0]) <= 10
                        && Convector.romanToArabic(line[2]) > 0 && Convector.romanToArabic(line[2]) <= 10) {
                    stringBuilder1.append(line[i]);
                }
            } catch (Exception e) {
            }

        }
            if (!stringBuilder.isEmpty()) {
                System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN(stringBuilder.toString())));
            } else if (!stringBuilder1.isEmpty()) {
                System.out.println(Convector.arabicToRoman(Calculator
                        .RPNtoAnswer(Calculator.ExpressionToRPN(RomaToArabic.arabicExpression(expression)))));
            } else if(stringBuilder.length()==stringBuilder1.length()){
                throw new InputMismatchException("Incorrect input of values");
            }
    }

}
