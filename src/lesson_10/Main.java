package lesson_10;

import java.util.Arrays;

public class Main {
    static int SIZE = 5;

    public static void main (String[] args) {
        String [] [] arr = {
                {"2", "5", "7", "9"},
                {"1", "4", "3", "6"},
                {"5", "3", "5", "3"},
                {"8", "4", "2", "9"}
        };
        try {
            System.out.println(sum(arr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getRow() + " " + e.getCol());
            System.out.println(arr[e.getRow()] [e.getCol]);
        }
        System.out.println("end");
    }

    static int sum(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        if (arr.length != SIZE) throw new MyArraySizeException();
        Arrays.stream(arr).filter(strings -> strings.length != SIZE).forEach(strings -> {
            throw new MyArraySizeException();
        });

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr [i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("format" + i + " " + j, i, j);
                }
            }

        }
        return sum;
    }
}

