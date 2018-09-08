package ru.mylife.cross_zero;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Объявлены переменные, соответствующие заданиям 1, 2, 3, 4.
Созданы объекты типа задание 1, 2, 3, 4.
Через объект вызывается метод, запускающий игру.
*/
public class Main {
    public static void main(String[] args) {
        Task_1 task1 = new Task_1();
        Task_2 task2 = new Task_2();
        Task_3 task3 = new Task_3();
        Task_4 task4 = new Task_4();

        boolean gameOver = false;
        while(!gameOver) metka: {
            try {
                System.out.println("Выберите игру нажав цифру 1, или 2, или 3, или 4 для проверки задания 1,2,3,4:");
                switch ((new Scanner(System.in)).nextInt()) {
                    case 1:
                        task1.playGame();
                        break;
                    case 2:
                        task2.playGame();
                        break;
                    case 3:
                        task3.playGame();
                        break;
                    case 4:
                        task4.playGame();
                        break;
                    default:
                        System.out.println("Некорректный выбор.");
                        break;
                }
                System.out.println("Перейти к следующией игре? Да(1)/Нет(0)");
                if ((new Scanner(System.in)).nextInt() == 0) {
                    gameOver = true;
                }
            } catch (InputMismatchException exc)
            {
                System.out.println(exc.toString());
                System.out.println("Сейсей будьте повниметельнее. Жмите только на цифру: или 1, или 2, или 3, или 4");
                break metka;
            }
        }
    }
}
