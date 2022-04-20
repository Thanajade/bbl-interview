package com.bangkokbank.interview;

import java.util.Scanner;

public class MaskText {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a target: ");
        String target = sc.nextLine();
        if (target.length() > 50) {
            System.out.println("Input is too large (50)");
            System.exit(-1);
        }

        System.out.println("You have entered: " + target);

        System.out.print("Enter a mask: ");
        String mask = sc.nextLine();              //reads string

        if (mask.length() > 50) {
            System.out.println("Input is too large (50)");
            System.exit(-1);
        }

        System.out.println("You have entered: " + mask);

        String output = maskText(target, mask);
        System.out.println(output);
    }

    private static String maskText(String target, String mask) {
        int maxLength = Math.max(target.length(), mask.length());
        StringBuilder sb = new StringBuilder();

        String targetFill = maxLength == target.length() ? target : fillSpace(target, maxLength - target.length());
        String maskFill = maxLength == mask.length() ? mask : fillSpace(mask, maxLength - mask.length());

        char[] targetChars = targetFill.toCharArray();
        char[] maskChars = maskFill.toCharArray();

        for (int i = 0; i < maxLength; i++) {
            char targetChar = targetChars[i];
            char maskChar = maskChars[i];

            if (isUppercase(targetChar) && isUppercase(maskChar)) {
                sb.append(targetChar);
            } else if (isLowercase(targetChar) && isLowercase(maskChar)) {
                sb.append(maskChar);
            } else if ((isUppercase(targetChar) && isLowercase(maskChar)) || (isLowercase(targetChar) && isUppercase(maskChar))) {
                sb.append("$");
            } else {
                sb.append("#");
            }
        }
        return sb.toString();
    }

    private static Boolean isUppercase(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static Boolean isLowercase(char c) {
        return ('a' <= c && c <= 'z');
    }

    private static String fillSpace(String text, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(text);

        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
