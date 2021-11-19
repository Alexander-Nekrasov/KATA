public class RomaToArabic {
    public static void main(String[] args) {
        System.out.println(arabicExpression("Ix * x"));
    }

    public static String arabicExpression (String romanExpression){
        StringBuilder arabicExpression = new StringBuilder();
        String[] lines = romanExpression.split(" ");
        for(String n : lines){
            if(!n.equals("+") && !n.equals("-") && !n.equals("*") && !n.equals("/"))
                arabicExpression.append(Convector.romanToArabic(n));
            else if(n.equals("+")) arabicExpression.append(" + ");
            else if(n.equals("-")) arabicExpression.append(" - ");
            else if(n.equals("*")) arabicExpression.append(" * ");
            else if(n.equals("/")) arabicExpression.append(" / ");
        }

        return arabicExpression.toString();
    }
}
