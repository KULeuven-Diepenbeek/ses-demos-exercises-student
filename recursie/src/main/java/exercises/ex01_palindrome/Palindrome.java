package exercises.ex01_palindrome;

public class Palindrome {
    public static boolean isPalindrome(String string) {
        if (string.length() <= 1) return true;

        var first = string.charAt(0);
        var last = string.charAt(string.length() - 1);
        if (first == last) {
            return isPalindrome(
                    string.substring(1,
                            string.length() - 1));
        }
        return false;

    }
}
