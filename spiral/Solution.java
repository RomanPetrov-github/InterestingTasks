package com.company.roman_petrov.spiral;

/*
   Посчитать сумму чисел по диагоналям
   в матрице размером 1039 х 1039 заполненной
   числами по спирали , начиная с 1
   Например результатом такой марицы будет 261

    49 48 47 46 45 44 43
    26 25 24 23 22 21 42
    27 10 9  8  7  20 41
    28 11 2  1  6  19 40
    29 12 3  4  5  18 39
    30 13 14 15 16 17 38
    31 32 33 34 35 36 37

   Результат вывести на экран
*/

public class Solution {

    public static void main(String[] args) {
        final int row = 1039;
        final int col = 1039;
        int counter = row*col;
        int[][] mas = new int[row][col];
        int rowStart = 0;
        int rowEnd = row - 1;
        int colStart = 0;
        int colEnd= col - 1;
        int sum = 0;

        while(counter > 0){
            for(int i = colStart; i <= colEnd; i++){
                mas[rowStart][i] = counter--;
            }
            rowStart++;
            for(int i = rowStart; i <= rowEnd; i++){
                mas[i][colEnd] = counter--;
            }
            colEnd--;
            for(int i = colEnd; i >= colStart; i--){
                mas[rowEnd][i] = counter--;
            }
            rowEnd--;
            for(int i = rowEnd; i >= rowStart; i--){
                mas[i][colStart] = counter--;
            }
            colStart++;
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(mas[i][j] + " ");
                if (mas[i][j] < 10)
                    System.out.print(" ");
                if(i == j || i + j == row - 1)
                    sum += mas[i][j];
            }
            System.out.println();
        }
        System.out.println("Сумма чисел по диагоналям = " + sum);

    }
}
