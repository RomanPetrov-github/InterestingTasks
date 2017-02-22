package com.roman_petrov.nod;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a,b;
        while(true) {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());

            if (a >= 1 && b >= 1) break;
        }
        int nod = 1;

        for (int i = 1; i <= (a > b ? a : b) ; i++) {
            if (((a % i) == 0) && ((b % i) == 0)) {
                nod = i;
            }
        }
        System.out.print(nod);
    }
}
