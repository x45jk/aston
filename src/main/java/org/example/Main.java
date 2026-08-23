package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Домашнее задание к Лекции 2.5 =====");

/*        String[][] numberArray4x4 = { {"1", "2", "3", "4"},
                                      {"5", "6", "7", "8"},
                                      {"9", "10", "11", "12"},
                                      {"13", "14", "15", "16"} };
        String[][] array1x1 = new String[1][1];
        String[][] numberArray4x3 = { {"1", "2", "3"},
                                      {"5", "6", "7"},
                                      {"9", "10", "11"},
                                      {"13", "14", "15"} };*/
        String[][] incorrectArray4x4 = { {"1", "2", "3", "4"},
                                         {"5", "6", "7", "8"},
                                         {"9", "10O", "11", "12"},
                                         {"13", "14", "15", "16"} };

        // tasks 1-3
        System.out.println("--- Tasks 1-3 ---");
        try {
            int num = getMatrixSum(incorrectArray4x4);
            System.out.println("Result: " + num);
        } catch (MyArraySizeException e) { System.out.println("Size error: " + e.getMessage());
        } catch (MyArrayDataException e) { System.out.println("Data error: " + e.getMessage()); }

        // task 4
        System.out.println("\n--- Task 4 ---");
        try {
            char[] arr = {'q', 'w', 'e', 'r', 't'};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception class: " + e.getClass().getName());
            System.out.println("Message:         " + e.getMessage());
            System.out.println("Stack trace:");
            for (StackTraceElement el : e.getStackTrace()) {
                System.out.println("  - " + el);
            }
        }
    }

    static int getMatrixSum(String[][] tdArray) throws MyArraySizeException {
        int sum = 0;

        if (tdArray.length != 4)
            throw new MyArraySizeException();

        for (var x : tdArray)
            if (x.length != 4)
                throw new MyArraySizeException("At least one row has NOfour size.");

        for (int i = 0; i < tdArray.length; i++)
            for (int j = 0; j < tdArray[i].length; j++)
                if (tdArray[i][j] != null && !tdArray[i][j].isEmpty() && tdArray[i][j].matches("\\d+"))
                    sum += Integer.parseInt(tdArray[i][j]);
                else
                    throw new MyArrayDataException(i, j);

        return sum;
    }
}