package HWLesson_2;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MyApp {


    public static void main(String[] args) {
        String[][] strings = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] stringsSizeIncorrect = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] stringsCharIncorrect = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1r", "2", "3", "4"}, {"1", "2", "3", "4"}};

        try {
            System.out.println("1) Массив соответствует всем требованиям задания");
            System.out.println("Cумма преобразованных из строки в int элементов массива = " + checkExceptionsMethod(strings));
        } catch (MyCustomExceptions e) {
            e.printStackTrace();
        }

        try {
            System.out.println("2) Был подан не двумерный строковый массив размером 4х4");
            System.out.println(checkExceptionsMethod(stringsSizeIncorrect));
        } catch (MyCustomExceptions e) {
            e.printStackTrace();

        }

        try {
            System.out.println("3) Массив строк не может быть преобразован в int");
            System.out.println(checkExceptionsMethod(stringsCharIncorrect));
        } catch (MyCustomExceptions e) {
            e.printStackTrace();

        }

    }

    static int checkExceptionsMethod(String[][] stringArr) throws MyCustomExceptions {
        int count = 0;
        int sum = 0;
        if (stringArr.length != 4) {
            throw new MyArraySizeException("Был подан не двумерный строковый массив размером 4х4");
        }

        for (int i = 0; i < stringArr.length; i++) {
            if (4 != stringArr[i].length)
                throw new MyArraySizeException("Был подан не двумерный строковый массив размером 4х4");
            for (int j = 0; j < stringArr[i].length; j++) {
                count++;
                try {
                    sum = sum + Integer.parseInt(stringArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("\nВ ячейке двумерного массива строк №" + count + " ([" + i + "]" + "[" + j + "])" + " нельзя значение строки преобразовать в int ");
                }
            }
        }
        return sum;
    }

}
