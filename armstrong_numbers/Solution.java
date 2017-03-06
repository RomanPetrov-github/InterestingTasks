package com.roman_petrov.armstrong_numbers;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args)
    {
        long memory0 = Runtime.getRuntime().freeMemory();
        long t0 = System.currentTimeMillis();
        getNumbers(146_511_208);
        long t1 = System.currentTimeMillis();
        long memory1 = Runtime.getRuntime().freeMemory();
        System.out.println("Прошло времени - " + (t1 - t0));
        System.out.println("Память - " + (memory1 - memory0));
    }

    public static int[] getNumbers(int N) {
        int row = 10;
        int col = 20;
        long[][] degree = new long[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                degree[i][j] = (long) Math.pow(i, j);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            int pow = 0;
            int tmp = i;
            int sum = 0;
            while (tmp != 0){
                pow++;
                tmp /= 10 ;
            }
            tmp = i;
            while (tmp != 0){
                sum += degree[tmp % 10][pow];
                tmp /= 10 ;
            }
            if (sum == i){
                list.add(sum);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
