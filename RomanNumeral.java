class RomanNumeral {
    public static void main(String[] args) {
        System.out.println("Enter a Roman numeral: ");
        String romanNumeral = In.getString();

        while (hasFourInARow(romanNumeral)) {
            System.out.println("Please enter a Roman numeral without four or more of the same character in a row: ");
            romanNumeral = In.getString();
        }

        int integerValue = romanToInteger(romanNumeral);

        System.out.println("Roman numeral: " + romanNumeral);
        System.out.println("Number: " + integerValue);
    }

    public static boolean hasFourInARow(String str) {
        int consecutiveCount = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                consecutiveCount++;
                if (consecutiveCount >= 4) {
                    return true;
                }
            } else {
                consecutiveCount = 1;
            }
        }
        return false;
    }

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