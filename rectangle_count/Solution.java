package com.roman_petrov.rectangle_count;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] mas = new byte[][]{
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(mas);
        System.out.println("count = " + count);
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                if ((a[i][j] == 1) && (i==0?true:a[i-1][j]==0) && (j==0?true:a[i][j-1]==0)){
                    count++;
                }
            }
        }
        return count;
    }
}
