class RomanNumeral {
    public static void main(String[] args) {
        // get user input
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = In.getString();

        // if numeral has 4 of the same characters
        if (hasMoreThanFourNumerals(romanNumeral)) {
            int integerValue = romanToInteger(romanNumeral);
            System.out.println("Number: " + integerValue);
        } else {
            System.out.println("Invalid Number");
        }
    }

    public static boolean hasMoreThanFourNumerals(String romanNumeral) {
        // state variables for array
        char[] letters = new char[romanNumeral.length()];

        // index each character
        for (int i = 0; i < romanNumeral.length(); ++i) {
            letters[i] = romanNumeral.charAt(i);
        }

        // boolean Variable
        boolean state = true;

        // create count int
        int countI = 0;
        int countV = 0;
        int countX = 0;
        int countL = 0;
        int countC = 0;
        int countD = 0;
        int countM = 0;

        // counts for letters
        for (int i = 0; i < romanNumeral.length(); i++) {
            if (letters[i] == 'I') {
                countI++;
            } else if (letters[i] == 'V') {
                countV++;
            } else if (letters[i] == 'X') {
                countX++;
            } else if (letters[i] == 'L') {
                countL++;
            } else if (letters[i] == 'C') {
                countC++;
            } else if (letters[i] == 'D') {
                countD++;
            } else if (letters[i] == 'M') {
                countM++;
            }

            if (countI >= 4 || countV >= 2 || countX >= 4 || countL >= 2 || countC >= 4 || countD >= 2 || countM >= 4) {
                state = false;
                return state;
            }
        }
        return state;
    }

    // numerals to decimal numbers
    public static int romanToInteger(String roman) {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentSymbol = roman.charAt(i);
            int currentValue = symbolToValue(currentSymbol);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }

    // numerals to a value (translation)
    public static int symbolToValue(char symbol) {
        String symbols = "IVXLCDM";
        int[] values = { 1, 5, 10, 50, 100, 500, 1000 };

        int index = symbols.indexOf(symbol);
        if (index != -1) {
            return values[index];
        } else {
            return 0;
        }
    }
}