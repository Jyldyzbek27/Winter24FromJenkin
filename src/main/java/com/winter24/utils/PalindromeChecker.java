package com.winter24.utils;
public class PalindromeChecker {

    // Метод для проверки, является ли строка палиндромом
    public static boolean isPalindrome(String str) {
        // Убираем все пробелы и приводим строку к нижнему регистру
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();

        int length = cleanStr.length();

        // Используем цикл for для проверки символов с начала и конца строки
        for (int i = 0; i < length / 2; i++) {
            if (cleanStr.charAt(i) != cleanStr.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testStrings = {
                "A man a plan a canal Panama",
                "racecar",
                "hello",
                "Was it a car or a cat I saw",
                "No lemon no melon"
        };

        for (String testStr : testStrings) {
            System.out.println("\"" + testStr + "\" is "
                    + (isPalindrome(testStr) ? "a palindrome." : "not a palindrome."));
        }
    }
}
