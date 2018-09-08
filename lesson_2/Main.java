package ru.mylife.Lesson_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	/*
	1. Задать целочисленный массив, состоящий из элементов 0 и 1.
	Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
	*/

        int arrayInt1[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrayInt1.length; i++) {
            arrayInt1[i] = (arrayInt1[i] != 0) ? 0 : 1;
        }
        task_solution(arrayInt1, 1);

    /*
    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    */

        int arrayInt2[] = new int[8];
        for (int i = 0, j = 0; i < arrayInt2.length; i++, j += 3) {
            arrayInt2[i] = j;
        }
        task_solution(arrayInt2, 2);

    /*
    3.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */

        int arrayInt3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayInt3.length; i++) {
            arrayInt3[i] = (arrayInt3[i] < 6) ? arrayInt3[i] * 2 : arrayInt3[i];
        }
        task_solution(arrayInt3, 3);

    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    */
        int arrayInt4[][] = new int[12][12];
        for (int i = 0, j = arrayInt4.length - 1; i < arrayInt4.length && j >= 0; i++, j--) {
            arrayInt4[i][i] = 1;
            arrayInt4[i][j] = 1;
        }
        task_solution(arrayInt4, 4);
    /*
    5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    */
        int arrayInt5[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min, max;
        min = max = arrayInt5[0];
        for (int i = 1; i < arrayInt5.length; i++) {
            min = min < arrayInt5[i] ? min : arrayInt5[i];
            max = max > arrayInt5[i] ? max : arrayInt5[i];
        }
        task_solution(new String("min = " + min + "\n" + "max = " + max), 5);

    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
    */
        int[] array6_1 = {1, 1, 1, 2, 1};
        int[] array6_2 = {2, 1, 1, 2, 1};
        int[] array6_3 = new int[7];
        task_solution(array6_1,6);
        System.out.println("checkBalance - " + checkBalance(array6_1));
        System.out.println("");
        task_solution(array6_2,6);
        System.out.println("checkBalance - " + checkBalance(array6_2));
        System.out.println("");
        task_solution(array6_3,6);
        System.out.println("checkBalance - " + checkBalance(array6_3));
        System.out.println("");
    /*
    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
    нельзя пользоваться вспомогательными массивами.
    */
        int arrayInt7[] = {1,2,3,4,5,6,7,8};
        task_solution(arrayInt7,7);
        driveArray(arrayInt7, 5);
        task_solution(arrayInt7,7);
    }

    public static void task_solution (int [] array, int task)
    {
        System.out.println("Task №" + task + ":");
        System.out.println(Arrays.toString(array));
        System.out.println("");
    }
    public static void task_solution (String str, int task)
    {
        System.out.println("Task №" + task + ":");
        System.out.println(str);
        System.out.println("");
    }
    public static void task_solution (int [][] array, int task)
    {
        System.out.println("Task №" + task + ":");
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println("");
    }
    public static boolean checkBalance(int[] array)
    {
        boolean flag = false;
        int start= 0, end=0;
        for (int i = 0; i < array.length; i++) {
            start += array[i];
            end=0;
            for (int j = i+1; j < array.length; j++) {
                end+=array[j];
            }
            if (start==end) {flag=true; break;}
        }
        if(start==0&&end==0) {
            System.out.println("В качестве агрумента передан пустой массив");
            flag = false;
            return flag;
        }
        else {
            return flag;
        }
    }

    /*
    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
    нельзя пользоваться вспомогательными массивами.
    */

    public static void driveArray(int[] array, int n){
        /*
        Механизм движения по массиву зависит от знака шага цикла.
        Если число положительное, то началом первого кольца будет первый элемент массива, движение слева на право.
        Если число отрицательное, то началом первого кольца будет последний элемент массива, движение справа на лево.
        */
        if(n>0) { //если шаг сдвига (n) положительный, то выполняем условие
            if(n>array.length) //если шаг сдвига превышает количество элементов в массиве, то выполняем условие
            {
                n=n%array.length; //определяем шаг сдвига, прокрутив массив по кругу n/array.length количество раз
            }
            for (int j = 0, k = j, t = 0, l = 0, step = array[j]; l < array.length; l++) {
                /*
                j - индекс объекта, подвергающегося изменению;
                k - индекс объекта, являющегося началом кольца;
                t - флаг. Нужен на первой итерации, чтобы корректно определить начало кольца и переместить j на один шаг
                l - счетчик цикла
                step - буфер, содержит значение ячейки массива, которое нужно переместить в сторону на один шаг
                */
                if (t == 0) {
                    t++; //снимаем заглушку
                }
                else {
                    if (k == j) {               //если кольцо пройдено
                        j = j + 1;              //устанавливаем начало нового кольца
                        step = array[j];        //пишем в буфер значение ячейки начала кольца
                        k = j;                  //устанавливаем новое значение конца кольца
                    }
                }
                if (j + n >= array.length) {    //если при шаге в сторону выходим за границы массива, то ...
                    j = (j + n) - array.length; //плавно перескакиваем на начало массива
                } else {
                    j = j + n;                  //сдвигаем j на один шаг. Граница массива маячит на горизонте
                }
                int f = array[j];               //пишем в локальный буфер значение ячейки массива которой присвоят новое значение на данном шаге
                array[j] = step;                //присваиваем ячейке новое значение
                step = f;                       //пишем в буфер значение ячейки, которое следует сдвинуть в сторону на след.шаге
            }
        }
        if(n<0){ //если шаг сдвига (n) отрицаетльный, то выполняем условие
            n=-1*n; //меняем шаг на положительное значение
            if(n>array.length){ //если шаг сдвига превышает количество элементов в массиве, то выполняем условие
                n=n%array.length; //определяем шаг сдвига, прокрутив массив по кругу n/array.length количество раз
            }
            for (int j = array.length-1, k = j, t = 0, l = 0, step = array[j]; l < array.length; l++) {
                /*
                j - индекс объекта, подвергающегося изменению;
                k - индекс объекта, являющегося началом кольца;
                t - флаг. Нужен на первой итерации, чтобы корректно определить начало кольца и переместить j на один шаг
                l - счетчик цикла
                step - буфер, содержит значение ячейки массива, которое нужно переместить в сторону на один шаг
                */
                if (t == 0) {
                    t++;                            //снимаем заглушку
                }
                else {
                    if (k == j) {                   //если кольцо пройдено
                        j = j - 1;                  //устанавливаем начало нового кольца
                        step = array[j];            //пишем в буфер значение ячейки начала кольца
                        k = j;                      //устанавливаем новое значение конца кольца
                    }
                }
                if (j - n <0) {                     //если при шаге в сторону выходим за границы массива, то ...
                    j = array.length + (j - n) ;    //плавно перескакиваем на конец массива
                } else {
                    j = j - n;                      //сдвигаем j на один шаг. Граница массива маячит на горизонте
                }
                int f = array[j];                   //пишем в локальный буфер значение ячейки массива которой присвоят новое значение на данном шаг
                array[j] = step;                    //присваиваем ячейке новое значение
                step = f;                           //пишем в буфер значение ячейки, которое следует сдвинуть в сторону на след.шаге
            }
        }
    }
}