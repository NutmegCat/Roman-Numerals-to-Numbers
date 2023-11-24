//
class RomanNumeral
{
    public static void main(String[] args) 
    {
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = In.getString();

        while (hasFourInARow(romanNumeral) || hasMoreThanFourNumerals(romanNumeral)) 
        {
            System.out.println("Invalid number, try again: ");
            romanNumeral = In.getString();
        }

        int integerValue = romanToInteger(romanNumeral);

        System.out.println("Roman numeral: " + romanNumeral);
        System.out.println("Number: " + integerValue);
    }

    public static boolean hasFourInARow(String str) 
    {
        for (int i = 0; i <= str.length() - 4; i++) 
        {
            char currentChar = str.charAt(i);

            if (str.charAt(i + 1) == currentChar && str.charAt(i + 2) == currentChar && str.charAt(i + 3) == currentChar) 
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasMoreThanFourNumerals(String romanNumeral)
    {
        //State variables for array
        char[] letters = new char [romanNumeral.length()];
       
        //Index each character
        for (int i = 0 ; i < romanNumeral.length() ; ++i)
        {
            letters[i] = romanNumeral.charAt(i);
        }
        
        //Create count int
        int countI = 0;
        int countV = 0;
        int countX = 0;
        int countL = 0;
        int countC = 0;
        int countD = 0;
        int countM = 0;
        
        for (int i = 0 ; i < romanNumeral.length() ; i++)
        {
            if (letters[i] == 'I')
            {
                countI += 1;
            }
            else if (letters[i] == 'V')
            {
                countV += 1;
            }
            else if (letters[i] == 'X')
            {
                countX += 1;
            }
            else if (letters[i] == 'L')
            {
                countL += 1;
            }
            else if (letters[i] == 'C')
            {
                countC += 1;
            }
            else if (letters[i] == 'D')
            {
                countD += 1;
            }
            else if (letters[i] == 'M')
            {
                countM += 1;
            }

            if (countI >= 4 || countV >= 4 || countX >= 4 || countL >= 4 || countC >= 4 || countD >= 4 || countM >= 4)
            {
                return false;
            }
        }
        return true;
    }

    public static int romanToInteger(String roman) 
    {
        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) 
        {
            char currentSymbol = roman.charAt(i);
            int currentValue = symbolToValue(currentSymbol);

            if (currentValue < prevValue) 
            {
                result -= currentValue;
            } 
            else 
            {
                result += currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }

    public static int symbolToValue(char symbol) 
    {
        String symbols = "IVXLCDM";
        int[] values = { 1, 5, 10, 50, 100, 500, 1000 };

        int index = symbols.indexOf(symbol);
        if (index != -1) 
        {
            return values[index];
        } 
        else 
        {
            return 0;
        }
    }
}
