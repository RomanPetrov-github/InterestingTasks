package com.company.roman_petrov.recursion;

/* Числа Фибоначчи с помощью рекурсии
Почитать про числа Фибоначчи.
Реализовать логику метода fibonacci, где n - это номер элемента в последовательности Фибоначчи.
Не создавайте статические переменные и поля класса.
*/

public class ExampleFibonacci {

    public static void main(String[] args) {
        ExampleFibonacci example = new ExampleFibonacci();

        System.out.println(example.fibonacci(9));     //34
        System.out.println(example.fibonacci(5));     //5
        System.out.println(example.fibonacci(2));     //1
        System.out.println(example.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
