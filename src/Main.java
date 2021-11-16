public class Main {
    public static void main(String[] args) {

        System.out.println(Calculator.ExpressionToRPN("10+1")); // разбери с пробелами при вводе
        System.out.println(Calculator.RPNtoAnswer(Calculator.ExpressionToRPN("10+1")));
    }
}
