package utils;

import java.util.Collection;

public class HelperUtils {

    private static int idCounter = 1;

    private HelperUtils() {
    }

    public static boolean isEmpty(String text) {

        return text == null || text.trim().isEmpty();
    }

    public static boolean isEmpty(Collection collection) {

        return collection == null || collection.isEmpty();
    }

    public static boolean isValidText(String text) {

        return text != null && !text.trim().isEmpty();
    }

    public static boolean isValidText(
            String text,
            int minimumLength) {

        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        return text.trim().length() >= minimumLength;
    }

    public static boolean isValidText(
            String text,
            int minimumLength,
            int maximumLength) {

        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        int length = text.trim().length();

        return length >= minimumLength
                && length <= maximumLength;
    }

    public static String generateId() {

        String id = String.valueOf(idCounter);

        idCounter++;

        return id;
    }

    public static String generateId(String prefix) {

        if (prefix == null || prefix.trim().isEmpty()) {
            prefix = "ID";
        }

        String id = prefix + idCounter;

        idCounter++;

        return id;
    }

    public static boolean isPositive(int number) {

        return number > 0;
    }

    public static boolean isPositive(double number) {

        return number > 0;
    }

    public static boolean isInRange(
            int number,
            int minimum,
            int maximum) {

        return number >= minimum && number <= maximum;
    }

    public static boolean isInRange(
            double number,
            double minimum,
            double maximum) {

        return number >= minimum && number <= maximum;
    }

    public static boolean isValidAge(int age) {

        return isInRange(age, 0, 120);
    }

    public static boolean isValidPhone(String phone) {

        if (phone == null) {
            return false;
        }

        String value = phone.trim();

        return value.length() >= 8
                && value.length() <= 15;
    }

    public static boolean isOneOf(
            String value,
            Object[] allowedValues) {

        if (value == null || allowedValues == null) {
            return false;
        }

        for (Object allowedValue : allowedValues) {

            if (allowedValue != null
                    && value.equals(allowedValue.toString())) {

                return true;
            }
        }

        return false;
    }
}