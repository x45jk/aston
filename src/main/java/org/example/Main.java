package org.example;
/*
Домашнее задание к Лекции 2.5
Вопросики:
1.а Нужны ли отдельные классы под MyArraySizeException и MyArrayDataException
1.б Если да, то наследовать их от Exception или от RuntimeException
2.а Правильно ли понял: суму значений ячеек массива вернуть в метод main и там вывести в консоль?
2.б Создавать копию массива или менять текущий?
2.в Проверять только типы значений char и String (без int, long и т.д.)?
2.г Выкидывать исключение только на первую ошибку или собрать данные по всем?
2.д Строку "12 какой_то_текст" не надо пытаться перевести в int?
*/

public class Main {
    public static void main(String[] args) {
        String[][] array1x1 = new String[1][1];
        String[][] numberArray4x3 = { {"1", "2", "3"},
                                      {"5", "6", "7"},
                                      {"9", "10", "11"},
                                      {"13", "14", "15"} };
        String[][] numberArray4x4 = { {"1", "2", "3", "4"},
                                      {"5", "6", "7", "8"},
                                      {"9", "10", "11", "12"},
                                      {"13", "14", "15", "16"} };


        try {
            takeTwoDimensionalStringArrayFourByFour(numberArray4x3);
        } catch (MyArraySizeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void takeTwoDimensionalStringArrayFourByFour(String[][] tdArray) throws MyArraySizeException {
        if (tdArray.length != 4)
            throw new MyArraySizeException();

        for (var x : tdArray)
            if (x.length != 4)
                throw new MyArraySizeException("At least one row has NOfour size.");
    }
}