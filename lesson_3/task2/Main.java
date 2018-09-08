package ru.mylife.lessons_3;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomInt {

    /*
    1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается
    3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное
    пользователем число чем загаданное, или меньше. После победы или проигрыша выводится запрос –
    «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    */

    public static void main(String[] args) throws InputMismatchException {
        for (int j = 0;;j=1) {
            Scanner scanner = new Scanner(System.in);                               //создаем объект сканера
            if(j==1) {                                                              //проверяем была ли игра сыграна хотя бы 1 раз
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                int continueGame = scanner.nextInt();                               //получаем ответ пользователя
                if(continueGame!=1&&continueGame!=0) {continue;}                    //если значение != 1 и != 0, снова задаем вопрос
                if(continueGame==0) {break;}                                        //если значение ==0, завершаем игру
            }
            int rundomInt = (new Random()).nextInt(10);                         //загадываем случайное число
            System.out.println("Угадайте число от 0 до 9.\nВам дается три попытки.");
            for(int i=3;;){
                System.out.print("Введите число: ");
                int userInt = scanner.nextInt();                                        //получаем ответ пользователя
                if(rundomInt==userInt){                                                 //если пользователь угадал, выходим из вложенного цикла
                    System.out.println("Умница! Вы угадали!");
                    break;
                }
                else{                                                                   //если пользователь не угадал, выводим предупреждениеа
                    if((--i)<=0){
                        System.out.println("Вы исчерпали все попытки.");
                        break;
                    }
                    if (rundomInt>userInt) {
                        System.out.println("Загаданное число больше. У вас осталось " + i + " попыток.");
                    } else {
                        System.out.println("Загаданное число меньше. У вас осталось " + i + " попыток.");
                    }
                }
            }
        }
    }
}