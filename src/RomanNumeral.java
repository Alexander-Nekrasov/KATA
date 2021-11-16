/*
      Объект типа RomanNumeral представляет собой целое число от 1 до 3999.  Он может
      быть построенным либо из целого числа, либо из строки, представляющей
      римская цифра в этом диапазоне.  Функция toString() вернет
      стандартизированное римское числовое представление числа.  Функция
      toInt() вернет число в виде значения типа int.
   */

public class RomanNumeral {

    private final int num;   // Число, представленное этой римской цифрой.

       /* Следующие массивы используются функцией toString() для построения
          стандартное римское числовое представление числа.  Для каждого i,
          число numbers[i] представлено соответствующей строкой, letters[i].
       */

    private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,
            50,   40,   10,    9,    5,    4,    1 };

    private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
            "L",  "XL",  "X",  "IX", "V",  "IV", "I" };


    public RomanNumeral(int arabic) {
        /*
        Конструктор.  Создает римское число с заданным значением int
        по параметру.  Создает исключение NumberFormatException, если арабский язык
        не в диапазоне от 1 до 3999 включительно.
        */

        if (arabic < 1)
            throw new NumberFormatException("Value of RomanNumeral must be positive.");
        if (arabic > 3999)
            throw new NumberFormatException("Value of RomanNumeral must be 3999 or less.");
        num = arabic;
    }


    public RomanNumeral(String roman) {
        /*
        Конструктор.  Создает римское число с заданным представлением.
        Например, RomanNumeral("xvii") - это 17.  Если параметр не является a
        юридической римской цифрой, отбрасывается исключение NumberFormatException.  Как верхняя, так и
        допускаются строчные буквы.
        */

        if (roman.length() == 0)
            throw new NumberFormatException("An empty string does not define a Roman numeral.");

        roman = roman.toUpperCase();  // Преобразование в прописные буквы.

        int i = 0;       // Позиция в строке, римская;
        int arabic = 0;  // Арабский цифровой эквивалент части строки, которая имеет
        // были преобразованы до сих пор.

        while (i < roman.length()) {

            char letter = roman.charAt(i);        // Буква в текущей позиции в строке.
            int number = letterToNumber(letter);  // Числовой эквивалент буквы.

            if (number < 0)
                throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");

            i++;  // Move on to next position in the string

            if (i == roman.length()) {
                // There is no letter in the string following the one we have just processed.
                // So just add the number corresponding to the single letter to arabic.
                arabic += number;
            }
            else {
                // Look at the next letter in the string.  If it has a larger Roman numeral
                // equivalent than number, then the two letters are counted together as
                // a Roman numeral with value (nextNumber - number).
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                    // Combine the two letters to get one value, and move on to next position in string.
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                    // Don't combine the letters.  Just add the value of the one letter onto the number.
                    arabic += number;
                }
            }

        }  // end while

        if (arabic > 3999)
            throw new NumberFormatException("Roman numeral must have value 3999 or less.");

        num = arabic;

    } // end constructor


    private int letterToNumber(char letter) {
        // Find the integer value of letter considered as a Roman numeral.  Return
        // -1 if letter is not a legal Roman numeral.  The letter must be upper case.
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }


    public String toString() {
        // Return the standard representation of this Roman numeral.
        String roman = "";  // The roman numeral.
        int N = num;        // N represents the part of num that still has
        //   to be converted to Roman numeral representation.
        for (int i = 0; i < numbers.length; i++) {
            while (N >= numbers[i]) {
                roman += letters[i];
                N -= numbers[i];
            }
        }
        return roman;
    }


    public int toInt() {
        // Return the value of this Roman numeral as an int.
        return num;
    }


} // end class RomanNumeral
