package ru.mylife.worker;

import java.util.Random;

/*
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */

public class Main {

    public static void main(String[] args) {

        String[] fio = {"Иванов А.И.", "Сидоров Л.Н.","Петросян Д.А.","Кулешов Т.Р.","Волошин К.П."};
        String[] position = {"Уборщик", "Фасовщик", "Экономист", "Начальник", "Бухгалтер"};
        String[] email = {"worker1@mail.ru","worker2@mail.ru","worker3@mail.ru","worker4@mail.ru","worker5@mail.ru"};
        String[] phone = {"89101001010","89102001010","89103001010","89104001010","89105001010"};
        int[] salary = {10000,15000,10000,20000,15000};
        int[] age = {20,30,50,45,35};
        Random rand = new Random();
        Worker[] worker = new Worker[5];
        for (int i = 0; i < worker.length; i++) {
            worker[i] = new Worker(fio[rand.nextInt(5)],
                    position[rand.nextInt(5)],
                    email[rand.nextInt(5)],
                    phone[rand.nextInt(5)],
                    salary[rand.nextInt(5)],
                    age[rand.nextInt(5)]);
        }
        for (Worker t: worker) {
            if(t.getAge()>40){
                t.printWorker();
            }
        }
    }
}
