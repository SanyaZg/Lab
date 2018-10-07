package com.company;

import java.util.Random; // подключение генератора рандомных чисел
import java.util.Scanner; // подключение ввода


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte section = 0;


        while (true) {

            System.out.println("Выберите номер задачи(от 1 до 7):");
            section = scan.nextByte();
            switch (section) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                default:
                    System.out.println("Неверно выбранная задача.");
                    break;

            }
        }

    }

    public static void PrintArray(int[] array) {
        int counter = 0;
        System.out.println('\t');
        System.out.println("Массив:");
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
            counter++;
            if (i != 0 && (i + 1) % 5 == 0)
                System.out.println('\n');

        }
        System.out.println();
    }

    public static int[] bubbleSorting(int[] array, int n) {
        //сортировка пузырьком
        int temp;
        Scanner scan = new Scanner(System.in);
        int arc = 0;//действие
        System.out.println("Выполнить сортировку: ");
        System.out.println("1.По возростанию");
        System.out.println("2.По убыванию");
        while (true) {
            arc = scan.nextByte();
            if (arc > 0 && arc < 3)
                break;
            System.out.println("Неверный выбор. Выберете действие");
        }
        if (arc == 1)
            for (int i = array.length - 1; i >= 0; i--)
                for (int j = 0; j < i; j++) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
        else
            for (int i = 0; i < array.length - 1; i++)
                for (int j = 0; j < i; j++) {
                    if (array[j] < array[j + 1]) {
                        temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }


        System.out.println("__________________________");
        return array;
    }


    public static int[] randArray(int[] array, int n, int MinLimit, int MaxLimit) {
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = MinLimit - random.nextInt(MaxLimit);
        }
        return array;
    }

    public static int[] randArray(int[] array, int n) {
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void task1() {
        int n = 25;
        int[] array = new int[n];
        randArray(array, n);
        System.out.println("Начальный массив:");
        PrintArray(array);
        int max = 0;
        int min = array[0];
        int maxI = 0;
        int minI = 0;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
                maxI = i;
            }
            if (array[i] < min) {
                min = array[i];
                minI = i;
            }

        }

        temp = array[maxI];
        array[maxI] = min;
        array[minI] = max;

        System.out.println("Минимальный элемент: " + min +
                " и максимальный: " + max +
                " поменялись местами.");
        PrintArray(array);
        System.out.println();
    }


    public static void task2() {
        int n = 25;
        int[] array = new int[n];
        randArray(array, n);
        System.out.println("Начальный массив:");
        PrintArray(array);
        bubbleSorting(array, n);
        PrintArray(array);
    }

    public static void task3() {
        int n = 20;
        int[] array = new int[n];
        randArray(array, n);
        PrintArray(array);
        int summ = 0;
        int mediator = 0;
        for (int i = 0; i < n; i++) {
            summ += array[i];
        }
        mediator = summ / n;
        System.out.println("Среднее значение в массиве =" + mediator);
    }

    public static void task4() {
        int n = 20;
        int[] array = new int[n];
        randArray(array, n);
        PrintArray(array);
        int numberOfEven = 0;
        int numberOfOdd = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0)
                numberOfEven++;
        }
        numberOfOdd = n - numberOfEven;
        System.out.println("Число чётных элементов в массиве " + numberOfEven +
                ",нечетных " + numberOfOdd);
    }

    public static void task5() {
        int n = 15;
        int[] array = new int[n];
        randArray(array, n, 0, 9);
        PrintArray(array);
    }

    public static void task6() {
        System.out.println("Простите, когда прочёл задание №6, задача №1 уже выводила максимальный и минимальный элементы в консоль.");
    }

    public static void task7() {
        Scanner scan = new Scanner(System.in);
        String[] str = new String[5];

        System.out.println("Заполните строки.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Запишите строку №" + (i + 1) + ":");
            str[i] = scan.next();
        }
        if (str[3].equals(str[4]))
            str[0] = str[0].concat(str[1]);
        else
            str[0] = str[0].concat(str[2]);
        System.out.println("Результат:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Строка номер " + (i + 1) + " : " + str[i]);
        }
    }


}
