import java.util.Scanner;

public class PolyalphabeticCipher {

    public static void main(String[] args) {
        // Get input string and key value from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String inputString = scanner.nextLine();
        System.out.print("Enter the key value (an integer): ");
        int key = scanner.nextInt();
        scanner.close();

        // Encrypt the input string using the polyalphabetic cipher
        String encryptedString = polyalphabeticCipher(inputString, key);

        // Print the encrypted string without spaces
        System.out.println("Encrypted string: " + encryptedString);
    }

    public static String removeSpecialCharsAndNumbers(String inputString) {
        // Define special characters and numbers
        String specialCharsAndNumbers = "0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        // Remove special characters and numbers from the input string
        StringBuilder cleanedString = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (specialCharsAndNumbers.indexOf(c) == -1) {
                cleanedString.append(c);
            }
        }

        return cleanedString.toString();
    }

    public static String polyalphabeticCipher(String inputString, int key) {
        // Define the alphabet for both uppercase and lowercase letters
        String uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz";

        // Remove special characters and numbers from the input string
        String cleanedString = removeSpecialCharsAndNumbers(inputString);

        // Initialize the output string
        StringBuilder outputString = new StringBuilder();

        // Iterate over each character in the input string
        for (char charInCleanedString : cleanedString.toCharArray()) {
            if (Character.isUpperCase(charInCleanedString)) {
                // Find the index of the character in the uppercase alphabet
                int index = uppercaseAlphabet.indexOf(charInCleanedString);

                // Shift the character by the key value
                int shiftedIndex = (index + key) % 26;

                // Add the shifted character to the output string (maintaining case)
                outputString.append(uppercaseAlphabet.charAt(shiftedIndex));
            } else if (Character.isLowerCase(charInCleanedString)) {
                // Find the index of the character in the lowercase alphabet
                int index = lowercaseAlphabet.indexOf(charInCleanedString);

                // Shift the character by the key value
                int shiftedIndex = (index + key) % 26;

                // Add the shifted character to the output string (maintaining case)
                outputString.append(lowercaseAlphabet.charAt(shiftedIndex));
            }
        }

        return outputString.toString();
    }
}
