class RomanNumeral {
    public static void main(String[] args) {
        System.out.println("Enter a Roman numeral: ");
        String romanNumeral = In.getString();
        int integerValue = romanToInteger(romanNumeral);

        System.out.println("Roman numeral: " + romanNumeral);
        System.out.println("Number: " + integerValue);
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
        int [] values = {1, 5, 10, 50, 100, 500, 1000};

        int index = symbols.indexOf(symbol);
        if (index != -1) {
            return values[index];
        } else {
            return 0;
        }
    }
}