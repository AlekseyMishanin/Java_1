package ru.mylife.outher;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args){

        System.out.println(expression(2,2,2,2));
        System.out.println(comparison(5,10));
        demonstrate(0);
        System.out.println(findNegativeNumber(10));
        helloName("Оля");
        findLeapYear();
    }

    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    byte _byte = 0;
    short _short = 0;
    int _int = 0;
    long _long = 0l;

    float _float = 0.0f;
    double _double = 0.0;

    char _char = '0';

    boolean _boolean = true;

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public static int expression (int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean comparison (int a, int b) {
        return ((a + b)>10||(a + b)<=20)? true : false;
    }

    /*
    5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    */
    public static void demonstrate (int a){
        System.out.println("Число " + a + ((a>=0)? " - положительное": " - отрицательное"));
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;

    public static boolean findNegativeNumber(int a) {
        return (a<0)? true : false;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void helloName (String name){
        System.out.println("Привет, " + name + "!");
    }

    /*
    8. * Написать метод, который определяет является ли год високосным, и выводит сообщение
    в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
    public static void findLeapYear(){
        String year = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        System.out.println(((Integer.parseInt(year)%400==0)||(Integer.parseInt(year)%4==0)&&(Integer.parseInt(year)%100!=0))? "Текущий год високосный" : "Текущий год не високосный");
    }

}

