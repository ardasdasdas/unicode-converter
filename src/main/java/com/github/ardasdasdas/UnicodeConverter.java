package com.github.ardasdasdas;

public class UnicodeConverter
{
    public static String convertToUnicode(String input) {
        StringBuilder unicodeStr = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c > 127)
            {
                String charAscii = String.format("%04x", (int)c);
                unicodeStr.append("\\u").append(charAscii);
            }
            else {
                unicodeStr.append(c);
            }
        }
        return unicodeStr.toString();
    }

    public static String convertFromUnicode(String unicodeStr) {
        StringBuilder original = new StringBuilder();

        for (int i = 0; i < unicodeStr.length(); i++) {
            char c = unicodeStr.charAt(i);
            if (c == '\\' && i + 1 < unicodeStr.length() && unicodeStr.charAt(i + 1) == 'u') {
                String hex = unicodeStr.substring(i + 2, i + 6);
                int code = Integer.parseInt(hex, 16);
                original.append((char) code);
                i += 5;
            } else {
                original.append(c);
            }
        }

        return original.toString();
    }
}
