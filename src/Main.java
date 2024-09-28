import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String x) {
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int x) {
        String intX = Integer.toString(x);
        String reverse = "";
        for (int i = intX.length() - 1; i >= 0; i--) {
            reverse = reverse + intX.charAt(i);
        }
        return reverse;
    }

    // 3. encryptThis
    public static String encryptThis(String ogword) {
        Scanner scanner = new Scanner(ogword);
        StringBuilder encryptedMessage = new StringBuilder();

        while (scanner.hasNext()) {
            String word = scanner.next();
            StringBuilder encryptedWord = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);

                if (i == 0) {
                    encryptedWord.append((int) currentChar);
                } else if (i == 1) {
                    encryptedWord.append(word.charAt(word.length() - 1));
                } else if (i == word.length() - 1) {
                    encryptedWord.append(word.charAt(1));
                } else {
                    encryptedWord.append(currentChar);
                }
            }
            encryptedMessage.append(encryptedWord).append(" ");
        }
        return encryptedMessage.toString().trim();
    }

    // 4. decipherThis
    public static String decipherThis(String encrypted) {
        Scanner scanner = new Scanner(encrypted);
        StringBuilder decryptedMessage = new StringBuilder();

        while (scanner.hasNext()) {
            String word = scanner.next();
            StringBuilder decrypted = new StringBuilder();

            int flet = inttochar(word);
            char slet = word.charAt(sletindex(word));
            char llet = word.charAt(word.length() - 1);

            decrypted.append((char) flet);
            decrypted.append(llet);

            for (int i = sletindex(word); i < word.length() - 1; i++) {
                if (i == sletindex(word)) {
                    continue;
                } else {
                    decrypted.append(word.charAt(i));
                }
            }
            decrypted.append(slet);
            decryptedMessage.append(decrypted).append(" ");
        }
        return decryptedMessage.toString().trim();
    }

    public static int inttochar(String word) {
        int charCode = 0;
        for (int i = 0; i < word.length() && Character.isDigit(word.charAt(i)); i++) {
            charCode = charCode * 10 + Character.getNumericValue(word.charAt(i));
        }
        return charCode;
    }

    public static int sletindex(String word) {
        for (int i = 1; i < word.length() - 1; i++) {
            if (Character.isLetter(word.charAt(i))) {
                return i;
            }
        }
        return 0;
    }
}