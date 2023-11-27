class RomanNumeral {
    public static void main(String[] args) {
        // Get user input
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = In.getString();

        // State variables for array
        char[] letters = new char[romanNumeral.length()];

        // Index each character
        for (int i = 0; i < romanNumeral.length(); ++i) {
            letters[i] = romanNumeral.charAt(i);
        }

        // If numeral has 4 of the same characters
        if (hasMoreThanFourNumerals(romanNumeral, letters)) {
            int integerValue = romanToInteger(romanNumeral, letters);
            System.out.println("Number: " + integerValue);
        } else {
            System.out.println("Invalid Number");
        }
    }

    public static boolean hasMoreThanFourNumerals(String romanNumeral, char[] letters) {
        // Boolean Variable
        boolean state = true;

        // Create count int
        int countI = 0;
        int countV = 0;
        int countX = 0;
        int countL = 0;
        int countC = 0;
        int countD = 0;
        int countM = 0;

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

    public static int romanToInteger(String romanNumeral, char[] letters) {
        
        // State variables for number array
        char[] numbers = new char[romanNumeral.length()];

        // Index each character
        for (int i = 0; i < romanNumeral.length(); ++i) {
               if (letters[i] == 'I') {
                numbers[i] = 1;
            } else if (letters[i] == 'V') {
                numbers[i] = 5;
            } else if (letters[i] == 'X') {
                numbers[i] = 10;
            } else if (letters[i] == 'L') {
                numbers[i] = 50;
            } else if (letters[i] == 'C') {
                numbers[i] = 100;
            } else if (letters[i] == 'D') {
                numbers[i] = 500;
            } else if (letters[i] == 'M') {
                numbers[i] = 1000;
            }         
        }

        //Compare each number to determine the roman numeral
        for (int i = 0; i < numbers.length; i++) {

        }




        int result = 0;
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