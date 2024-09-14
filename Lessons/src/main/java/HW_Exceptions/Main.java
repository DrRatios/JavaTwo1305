package HW_Exceptions;

public class Main {
    public static void main(String[] args) {
        String[][] strings = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] stringsSizeIncorrect = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] stringsCharIncorrect = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1r", "2", "3", "4"}, {"1", "2", "3", "4"}};

        try {
            method(stringsCharIncorrect);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException ex) {
            ex.printStackTrace();
        }
    }

    public static void method(String[][] arrStr) {
        int sum = 0;
        if (arrStr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr[i].length; j++) {
                try {
                    sum += (int) Integer.parseInt(arrStr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }

            }
        }
        System.out.println(sum);
    }
}
